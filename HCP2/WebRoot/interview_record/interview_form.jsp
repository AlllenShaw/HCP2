<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
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


<link rel="stylesheet" type="text/css" href="css/form_style.css">

</head>

<body onload="check_allnewv()">
	<h2>最新访谈记录列表</h2>
	<table class="bordered" id="interview_form">
		<thead>

			<tr>
				<th>ID</th>
				<th>姓名</th>
				<th>访谈时间</th>
				<th>下次访谈时间</th>
			</tr>
		</thead>
	</table>
	<br/>
	<div class="paging">
	<input type="button" value="上一页" onclick="" >
	<%
			int pagesize=3;//一页显示几条记录
			int pagenow=1;//希望显示第几页
			int rowcount=0;//共有几条记录
			int pagecount=5;//共有几页(计算)
			
			for(int i=pagenow;i<pagenow+pagecount;i++)
			{
				%>
				<input class="fb" type="button" value="<%=i%>" onclick="">
				<% 
			} 
	 %>
	 <input class="fb" type="button" value="下一页" onclick="">
	 </div>
	 
	 <script src="js/all_form.js"></script>
</body>
</html>
