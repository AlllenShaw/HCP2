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

<body onload="check_tg()">
	<h2>最新血脂列表</h2>
	<table class="bordered" id="tg_form">
		<thead>

			<tr>
				<th>ID</th>
				<th>姓名</th>
				<th>总胆固醇</th>
				<th>甘油三脂</th>
				<th>高密度脂蛋白</th>
				<th>低密度脂蛋白</th>
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
			
			for(int i=1;i<pagecount;i++)
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
