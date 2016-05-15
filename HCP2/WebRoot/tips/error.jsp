<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>失败</title>
<link rel="stylesheet" type="text/css" href="css/index_style.css" />
<link rel="stylesheet" href="css/register.css" type="text/css"></link>
<link rel="stylesheet" href="css/tipso.min.css" type="text/css"></link>
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<script src="js/register.js" type="text/javascript"></script>
</head>


<script type='text/javascript'>
  var i = 4;
  function ok(){
    if (i>0){
      i--;
    }else{
      window.history.back(-1);
    }
     document.getElementById('showtime').innerHTML="出错啦!<font color=red>"+i+"</font>秒后前一页";
  }
  setInterval("ok()",1000);
</script>

<body >

	<div id="wrap">
		<div class="top_corner"></div>
			<div id="main_container">
				
				
				<%@include file="../registered/top.jsp"%>
				
				<div class="center_content" align="center">
					<img align="middle" src="picture/failed.jpg"></img>
				</div>
				
				<div align="center" style="font-size:25px;font-family:微软雅黑;" id="showtime">
				</div>
				<%@include file="../registered/bottom.jsp"%>
				
			</div>
		</div>
</body>
</html>
