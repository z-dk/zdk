<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<link rel="icon" href="${APP_PATH }/static/images/bitbug_favicon.ico" type="image/x-icon"/>
<title>留言板</title>
<style type="text/css">
	
</style>
</head>
<body>
	<%@ include file="../../header.jsp" %>
	
	留言区回复功能还在<br />
	开发中。。。
	<div class="container">
		<!-- 表格 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover" id="message_table">
					<tbody>
						<c:forEach items="${msgs }" var="item">
							<tr class="row">
								<td class="col-sm-2">${item.visitor }：</td>
								<td class="col-sm-8">${item.mInfo }</td>
								<td class="col-sm-2">
									<fmt:formatDate value="${item.dateTime }" pattern="yyyy-MM-dd HH:mm:ss" />
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<!-- 分页条 -->
		<div class="row">
			<div class="col-md-6" id="page_info_area"></div>
			<div class="col-md-6" id="nav_info_area"></div>
		</div>
		<div>
			<form class="form-horizontal" id="msg">
				<div class="form-group">
					<div class="col-sm-2">
						<input type="text" id="name" class="form-control" placeholder="昵称" name="visitor"/>
					</div>
					<div class="col-sm-8">
						<input type="text" id="info" class="form-control" placeholder="留言消息" name="mInfo"/>
					</div>
				</div>
				<br></br>
				<div class="col-sm-2 col-sm-offset-10">
					<button type="button" class="btn btn-default btn-block" onclick="commit()">提交</button>
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		
		function commit(){
			if($("#name").val().length<1){
				alert("昵称不能为空！");
			}else if($("#info").val().length<1){
				alert("消息不能为空！");
			}else{
				$.ajax({
					url:"${APP_PATH}/commitmsg",
					data:$("#msg").serialize(),
					type:"POST",
					success:function(result){
						alert(result.msg);
						window.location.href="${APP_PATH}/tomessage";
					}
				})
				
			}
		}
	</script>
</body>
</html>