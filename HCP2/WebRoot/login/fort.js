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
		$("#usertype").attr("value",1);
		}
	else if($("#li2").is(".current"))
		{
		$("#usertype").attr("value",2);
		}
	else if($("#li3").is(".current"))
		{
		$("#usertype").attr("value",3);	
		}
	else if($("#li4").is(".current"))
		{
		$("#usertype").attr("value",4);
		}
});

$("#registered").click(function(){
	if($("#li1").is(".current"))
		{
			top.window.location.href='registered/registered.jsp?route=registered/registered_doctor.jsp';
		}
	else if($("#li2").is(".current"))
		{
			top.window.location.href='registered/registered.jsp?route=registered/registered_patient.jsp';
		}
	else if($("#li3").is(".current"))
		{
			top.window.location.href='main/main.jsp';
		}
	else if($("#li4").is(".current"))
		{
			top.window.location.href='main/main.jsp';
		}
});

});


