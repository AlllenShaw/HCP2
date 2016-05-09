$(document).ready(function(){
	

	
	$("#type").change(function(){
		var value1=$("#type").attr("value");
		obj=document.getElementById("selector2");
		if(value1==0)
			{
				$("#userId1").attr("class", "show");
				$("#userId2").attr("class", "hidden");
			}
			
		else if(value1==1)
			{
				$("#userId2").attr("class", "show");
				$("#userId1").attr("class", "hidden");
			}
	});
	
});