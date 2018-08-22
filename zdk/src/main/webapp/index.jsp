<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<%
		pageContext.setAttribute("APP_PATH", request.getContextPath());
	%>
	<link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" />
	<script type="text/javascript" src="${APP_PATH}/static/js/jquery-3.3.1.js"></script>
	<script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<style>
		footer{
			height:60px;
			text-align:center;
			background-color:#e7e7e7;
		}
	</style>
	<link rel="icon" href="${APP_PATH }/static/images/bitbug_favicon.ico" type="image/x-icon"/>
	<title>朱登奎的个人主页</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<div class="container">
		<div class="col-xs-12 col-sm-2 col-md-2 col-lg-2">
			<table>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td align="center">星期<span id="week"></span></td>
				</tr>
				<tr>
					<td align="center"><p style="font-weight:900;font-size:200%;"></p></td>
				</tr>
				<tr>
					<td><span id="year"></span>.<span id="month"></span></td>
				</tr>
			</table>
		</div>
		<div class="col-xs-12 col-sm-10 col-md-10 col-lg-10">
			
		</div>
	</div>
	<footer class="footer navbar-fixed-bottom">
		<div class="container">
			<p class="credits">zhelishiyejiao</p>
		</div>
	</footer>
	<script type="text/javascript">
		$(function(){
			var date = new Date();
			var week;
			switch(date.getDay()){
			case 0:week="日"
				break;
			case 1:week="一"
				break;
			case 2:week="二"
				break;
			case 3:week="三"
				break;
			case 4:week="四"
				break;
			case 5:week="五"
				break;
			case 6:week="六"
				break;
			}
			$("#week").text(week);
			$("table p").text(date.getDate());
			$("#year").text(date.getFullYear());
			$("#month").text(date.getMonth());
		})
		function addFavorite() {
	        var url = window.location;
	        var title = document.title;
	        var ua = navigator.userAgent.toLowerCase();
	        if (ua.indexOf("msie 8") > -1) {
	            external.AddToFavoritesBar(url, title, '');//IE8
	        } else {
	            try {
	                window.external.addFavorite(url, title);
	            } catch (e) {
	                try {
	                    window.sidebar.addPanel(title, url, "");//firefox
	                } catch (e) {
	                    alert("加入收藏失败，请使用Ctrl+D进行添加");
	                }
	            }
	        }
	    }
	</script>
</body>
</html>