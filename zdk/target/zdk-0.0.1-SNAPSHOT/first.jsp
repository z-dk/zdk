<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>粒子星空</title>
<style>
	html, body {
		margin: 0;
		overflow: hidden;
		width: 100%;
		height: 100%;
		cursor: none;
		background: black;
		background: linear-gradient(to bottom, #000000 0%, #5788fe 100%);
	}
	
	.filter {
		width: 100%;
		height: 100%;
		position: absolute;
		top: 0;
		left: 0;
		background: #fe5757;
		animation: colorChange 30s ease-in-out infinite;
		animation-fill-mode: both;
		mix-blend-mode: overlay;
	}
	
	@keyframes colorChange { 
		0%,100% {
			opacity: 0;
		}
	
		50%{
			opacity:.9;
		}
	}
	.landscape {
		position: absolute;
		bottom: 0px;
		left: 0;
		width: 100%;
		height: 100%;
		background-image: url('static/images/xkbg.png');
		background-size: 1000px 250px;
		background-repeat: repeat-x;
		background-position: center bottom;
	}
	
</style>
</head>
<body>
	<div class="landscape"></div>
	<div class="filter"></div>
	<div id="center">
	</div>
	<canvas id="canvas"></canvas>
	<!-- <audio autoplay="autoplay">
		<source src="http://m2.music.126.net/z5t-DBv6ugHWN8BCGynjSw==/7715273092477776.mp3" type="audio/mpeg">
	</audio> -->
	<script>
		function Star(id, x, y){
			this.id = id;
			this.x = x;
			this.y = y;
			this.r = Math.floor(Math.random()*2)+1;
			var alpha = (Math.floor(Math.random()*10)+1)/10/2;
			this.color = "rgba(255,255,255,"+alpha+")";
		}
		
		Star.prototype.draw = function() {
			ctx.fillStyle = this.color;
			ctx.shadowBlur = this.r * 2;
			ctx.beginPath();
			ctx.arc(this.x, this.y, this.r, 0, 2 * Math.PI, false);
			ctx.closePath();
			ctx.fill();
		}
		
		Star.prototype.move = function() {
			this.y -= .15;
			if (this.y <= -10) this.y = HEIGHT + 10;
			this.draw();
		}
		
		Star.prototype.die = function() {
		    stars[this.id] = null;
		    delete stars[this.id];
		}
		
		
		function Dot(id, x, y, r) {
			this.id = id;
			this.x = x;
			this.y = y;
			this.r = Math.floor(Math.random()*5)+1;
			this.maxLinks = 2;
			this.speed = .5;
			this.a = .5;
			this.aReduction = .005;
			this.color = "rgba(255,255,255,"+this.a+")";
			this.linkColor = "rgba(255,255,255,"+this.a/4+")";
		
			this.dir = Math.floor(Math.random()*140)+200;
		}
		
		Dot.prototype.draw = function() {
			ctx.fillStyle = this.color;
			ctx.shadowBlur = this.r * 2;
			ctx.beginPath();
			ctx.arc(this.x, this.y, this.r, 0, 2 * Math.PI, false);
			ctx.closePath();
			ctx.fill();
		}
		
		Dot.prototype.link = function() {
			if (this.id == 0) return;
			var previousDot1 = getPreviousDot(this.id, 1);
			var previousDot2 = getPreviousDot(this.id, 2);
			var previousDot3 = getPreviousDot(this.id, 3);
			if (!previousDot1) return;
			ctx.strokeStyle = this.linkColor;
			ctx.moveTo(previousDot1.x, previousDot1.y);
			ctx.beginPath();
			ctx.lineTo(this.x, this.y);
			if (previousDot2 != false) ctx.lineTo(previousDot2.x, previousDot2.y);
			if (previousDot3 != false) ctx.lineTo(previousDot3.x, previousDot3.y);
			ctx.stroke();
			ctx.closePath();
		}
		
		function getPreviousDot(id, stepback) {
			if (id == 0 || id - stepback < 0) return false;
			if (typeof dots[id - stepback] != "undefined") return dots[id - stepback];
			else return false;//getPreviousDot(id - stepback);
		}
		
		Dot.prototype.move = function() {
			this.a -= this.aReduction;
			if (this.a <= 0) {
				this.die();
				return
			}
			this.color = "rgba(255,255,255,"+this.a+")";
			this.linkColor = "rgba(255,255,255,"+this.a/4+")";
			this.x = this.x + Math.cos(degToRad(this.dir))*this.speed,
			this.y = this.y + Math.sin(degToRad(this.dir))*this.speed;
		
			this.draw();
			this.link();
		}
		
		Dot.prototype.die = function() {
		    dots[this.id] = null;
		    delete dots[this.id];
		}
		
		
		var canvas  = document.getElementById('canvas'),
			ctx = canvas.getContext('2d'),
			WIDTH,
			HEIGHT,
			mouseMoving = false,
			mouseMoveChecker,
			mouseX,
			mouseY,
			stars = [],
			initStarsPopulation = 80,
			dots = [],
			dotsMinDist = 2,
			maxDistFromCursor = 50;
		
		setCanvasSize();
		init();
		
		function setCanvasSize() {
			WIDTH = document.documentElement.clientWidth,
		    HEIGHT = document.documentElement.clientHeight;                      
		
			canvas.setAttribute("width", WIDTH);
			canvas.setAttribute("height", HEIGHT);
		}
		
		function init() {
			ctx.strokeStyle = "white";
			ctx.shadowColor = "white";
			for (var i = 0; i < initStarsPopulation; i++) {
				stars[i] = new Star(i, Math.floor(Math.random()*WIDTH), Math.floor(Math.random()*HEIGHT));
				//stars[i].draw();
			}
			ctx.shadowBlur = 0;
			animate();
		}
		
		function animate() {
		    ctx.clearRect(0, 0, WIDTH, HEIGHT);
		
		    for (var i in stars) {
		    	stars[i].move();
		    }
		    for (var i in dots) {
		    	dots[i].move();
		    }
		    drawIfMouseMoving();
		    requestAnimationFrame(animate);
		}
		
		window.onmousemove = function(e){
			mouseMoving = true;
			mouseX = e.clientX;
			mouseY = e.clientY;
			clearInterval(mouseMoveChecker);
			mouseMoveChecker = setTimeout(function() {
				mouseMoving = false;
			}, 100);
		}
		
		
		function drawIfMouseMoving(){
			if (!mouseMoving) return;
		
			if (dots.length == 0) {
				dots[0] = new Dot(0, mouseX, mouseY);
				dots[0].draw();
				return;
			}
		
			var previousDot = getPreviousDot(dots.length, 1);
			var prevX = previousDot.x; 
			var prevY = previousDot.y; 
		
			var diffX = Math.abs(prevX - mouseX);
			var diffY = Math.abs(prevY - mouseY);
		
			if (diffX < dotsMinDist || diffY < dotsMinDist) return;
		
			var xVariation = Math.random() > .5 ? -1 : 1;
			xVariation = xVariation*Math.floor(Math.random()*maxDistFromCursor)+1;
			var yVariation = Math.random() > .5 ? -1 : 1;
			yVariation = yVariation*Math.floor(Math.random()*maxDistFromCursor)+1;
			dots[dots.length] = new Dot(dots.length, mouseX+xVariation, mouseY+yVariation);
			dots[dots.length-1].draw();
			dots[dots.length-1].link();
		}
		//setInterval(drawIfMouseMoving, 17);
		
		function degToRad(deg) {
			return deg * (Math.PI / 180);
		}
		</script>
</body>
</html>