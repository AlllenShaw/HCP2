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
<title>平台帮助</title>
<meta http-equiv="pragma" content="no-cache">
<base href="<%=basePath%>"></base>

<link href="css/fundation.css" rel="stylesheet" type="text/css" />
<link href="css/submenu.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/testing.js"></script>

</head>
<body>
	<div id="all">
		<div id="top">
			<%@include file="../fundation/header_doctor.jsp"%>
			<script>
				document.getElementById("m7").style.backgroundImage = "url(picture/images/menu_over.png)";
			</script>
		</div>
		<div id="middle">
			<div id="left">
				<%@include file="submenu6.jsp"%>
				<script>
					document.getElementById("sm1").style.backgroundImage = "url(picture/images/submenu_over.png)";
				</script>
			</div>
			<div id="right">
				为克服医疗机构间数据互联共享的壁垒，基于区域医疗数据互联共享的业务协同诊治平台（以下简称平台）设计方案的目标概括为：整合申报单位的IT资源和医疗资源，与合作研发医院一起实现临床医疗数据互联共享、业务协同诊治；提高诊治水平与效率，让患者满意。
				平台互联主体：区域各级医疗机构；目标是实现对数据和人才等资源的共享，实现协同诊治业务：电子档案查询；区域统一挂号（均衡医疗资源、方便就医）；双向转诊（朝：小病进社区、大病转医院、康复回社区的格局努力，优化医疗资源配置，降低医疗成本，提高医疗效率）；检查检验一单通（是检验检查报告的共享与互认，避免过度检查，减低百姓就医费用，节省就医时间，提高效率）；远程医学影像会诊（远程重构影像，方便会诊）；专家辅助诊治（通过对医疗临床数据的挖掘分析，给出专家级的辅助诊治意见）。为避免协同诊治功能的研发、部署与实施（包括以后升级）对各互联机构的医疗信息系统（以下简称医疗系统）带来冲击，本平台提出采用SaaS应用模式作为平台研发、部署与推广的模式。
			</div>
		</div>
		<div id="bottom">
			<%@include file="../fundation/footer.jsp"%>
		</div>
	</div>
</body>
</html>
