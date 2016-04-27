$(document).ready(function(){
$("#a1").click(function() {
	$("#li1").attr("class", "current");
	$("#li2").attr("class", "");
	$("#li3").attr("class", "");
	$("#li4").attr("class", "");
});
$("#a2").click(function() {
	$("#li1").attr("class", "");
	$("#li2").attr("class", "current");
	$("#li3").attr("class", "");
	$("#li4").attr("class", "");
});
$("#a3").click(function() {
	$("#li1").attr("class", "");
	$("#li2").attr("class", "");
	$("#li3").attr("class", "current");
	$("#li4").attr("class", "");
});
$("#a4").click(function() {
	$("#li1").attr("class", "");
	$("#li2").attr("class", "");
	$("#li3").attr("class", "");
	$("#li4").attr("class", "current");
});
$("#login").click(function(){
	if($("#li1").is(".current"))
		{
			if($("#username").attr("value")=="12qssong"&&$("#password").attr("value")=="123")
			{
				$("#usertype").attr("value",1);
			top.window.location.href='../index_doctor/index_doctor.jsp';
			}
		}
	else if($("#li2").is(".current"))
		{
		$("#usertype").attr("value",2);
			if($("#username").attr("value")=="12qssong"&&$("#password").attr("value")=="123")
			{
			top.window.location.href='../index_patient/index_patient.jsp';
			}
		}
	else if($("#li3").is(".current"))
		{
		$("#usertype").attr("value",3);
			if($("#username").attr("value")=="12qssong"&&$("#password").attr("value")=="123")
			{
			top.window.location.href='../index_hmanager/index_hmanager.jsp';
			}
		}
	else if($("#li4").is(".current"))
		{
		$("#usertype").attr("value",4);
			if($("#username").attr("value")=="12qssong"&&$("#password").attr("value")=="123")
			{
			top.window.location.href='../index_smanager/index_smanager.jsp';
			}
		}
});

$("#registered").click(function(){
	if($("#li1").is(".current"))
		{
			top.window.location.href='../registered/registered.jsp?route=registered/registered_doctor.jsp';
		}
	else if($("#li2").is(".current"))
		{
			top.window.location.href='../registered/registered.jsp?route=registered/registered_patient.jsp';
		}
	else if($("#li3").is(".current"))
		{
			top.window.location.href='../main/main.jsp';
		}
	else if($("#li4").is(".current"))
		{
			top.window.location.href='../main/main.jsp';
		}
});

});

