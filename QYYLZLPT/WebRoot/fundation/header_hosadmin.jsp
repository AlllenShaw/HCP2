<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<link href="css/header.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/testing.js"></script>
<!-- script type="text/javascript" src="js/jquery-1.11.2.min.js"></script-->

<div id="header">
	<div id="tall">
		<div id="t1">互联医疗资源协同诊治平台</div>
		<div id="t2">Connected health resources collaborative platform</div>
	</div>

	<div id="persion">
		<!-- <label class="pb" onclick="mainmenu('login/login.jsp')">注销</label>  -->
		<label id="pb">${username}</label> <input type="hidden"
			id="loginuserid" value="${userid}">
	</div>
<!--
	<div class="menu">
		<ul class="list">
			<li><a id="m1" href="javascript:void(0)"
				onclick="mainmenu('index/index_hosadmin.jsp')">首&nbsp;&nbsp;页</a></li>
			<li><a id="m5" href="javascript:void(0)"
				onclick="mainmenu('xietongzhenzhiziyuan/xietongzhenzhiziyuan.jsp')">资源管理</a>
			</li>
			<li><a id="m6" href="javascript:void(0)"
				onclick="mainmenu('xietongzhenzhianquan/xietongzhenzhianquan.jsp')">安全管理
			</a></li>
			<li><a id="m7" href="javascript:void(0)"
				onclick="mainmenu('pingtaizhicheng/pingtaizhicheng.jsp')">平台支撑</a>
			</li>
			<li><a id="m8" href="javascript:void(0)"
				onclick="mainmenu('login/login.jsp')">注销</a></li>
		</ul>
	</div>-->
	 <div class="menu">
		<ul class="list">
			<li><a id="m1" href="javascript:void(0)"
				onclick="mainmenu('hosadmin/index.do')">首&nbsp;&nbsp;页</a>
			</li>
			<li><a id="m5" href="javascript:void(0)"
				onclick="mainmenu('hosadmin/xietongzhenzhiziyuan.do')">资源管理</a>
			</li>
			<li><a id="m6" href="javascript:void(0)"
				onclick="mainmenu('hosadmin/xietongzhenzhianquan.do')">安全管理
			</a>
			</li>
			<li><a id="m7" href="javascript:void(0)"
				onclick="mainmenu('hosadmin/pingtaizhicheng.do')">平台支撑</a>
			</li>
			<li><a id="m8" href="javascript:void(0)"
				onclick="mainmenu('user/logout.do')">注销</a>
			</li>
		</ul>
	</div> 
</div>
