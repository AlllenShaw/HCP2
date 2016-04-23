<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>My JSP 'testing.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="css/header.css" />

<!-- script type="text/javascript" src="js/headereffect.js"></script-->
<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
<script type="text/javascript">
$(function(){
$(".list li").click(function(){
$(".list li").eq($(this).index()).addClass("cur").siblings().removeClass("cur");
});
});

</script>
<script>

   function myalert(){
     alert("mysuccess");
     this.style.display="";
   }
   function myonchange()
{
  var targetSlect=document.getElementById("ssssd");
  var targetHref=targetSlect.options[targetSlect.selectedIndex].value;
  alert(targetHref);
}
function isChn(){
	str=document.getElementById("chn").value;
console.log(str); 
     var reg = /^[u4E00-u9FA5]+$/i;
      if(reg.test(str)){
       console.log("not chinese");
       return;
      }else{
       console.log("chinese");
       
       }
}

   </script>
</head>

</head>
<body>
	<input id="chn" type="text" onblur="isChn()">
	<div id="persionbe">
		<select id="ssssd" onchange="myonchange()">
			<option value="00" selected="selected"></option>
			<option value="12">12</option>
			<option value="34">34</option>
			<option value="56">56</option>

		</select>
	</div>
</body>

</html>
