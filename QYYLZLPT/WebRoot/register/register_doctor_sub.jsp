<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>医生注册</title>
    <base href="<%=basePath%>">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<link href="css/register.css" rel="stylesheet" type="text/css" />

 </head>
  
  <body>
  <div id="outdoc">
  <div id="ti">注册-医生</div>
    <div id="doc">
    	<form id="register_doctor" name="register_doctor" action="user/doctor/register.do" method="post">
    		
    		<div class="as">
    		  <label>姓名:</label>
    		  <input class="ip" type="text" id="name" name="username">
    		</div>
    		<div class="as">
    		  <label>密码:</label>
    		  <input class="ip" type="password" id="passsword" name="password"/>
    		</div>
    	  	  <div class="as">
    	  	    <label>性别:</label>
    		    <select class="gen" id="gender" name="gender">
    			  <option value="0">男</option>
    			  <option value="1">女</option>
    		    </select>
    		</div>
    		<div class="as">
    		  <label>年龄:</label>
    		  <input class="ip" type="text" id="age" name="age"/>
    		</div>
    		<div class="as">
    		  <label>所属医院:</label>
    		  <input class="ip" type="text" id="hospitalid" name="hospital_id" size="80px"/>
    		</div>
    		<div class="as">
    		  <label>从医许可证:</label>
    		  <input class="ip" type="text" id="certificate" name="certificate"/>
    		</div>
			<div class="as">
			  <label>住址:</label>
    		  <input class="ip" type="text" id="address" name="address"/>
    		</div>
    		<div class="as">
    		  <label>联系电话:</label>
    		  <input class="ip" type="text" id="tele" name="tele"/>
    		</div>
    		<div class="fbl">
    		 <input class="fb" type="submit" value="提交"/>
      	     <input class="fb" type="reset" value="重置"/>
      	     <input class="fb" type="button" value="取消" onclick="location.href='login/login.jsp'"/>
      	     </div>
    	</form>

    </div> 
    </div>

  </body>
</html>
