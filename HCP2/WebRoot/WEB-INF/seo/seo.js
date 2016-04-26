$(document).ready(function(){
	
	$("#selector1").change(function(){
		var value1=$("#selector1").attr("value");
		obj=document.getElementById("selector2");
		if((value1<5)&&(obj.options.length!=4))
			{
				obj.options.add(new Option("所有人",4)); 
			}
		else if(value1>=5&&obj.options.length==4)
			{
				$("#selector2 option[value='4']").remove();
			}
	});
	
	
$("#search").click(function(){
		var value=$("#selector1").attr("value");
		var value2=$("#selector2").attr("value");
		if(value==1)
			{
				//根据selector2查询（缺）
				if(value2==4)
				{
					window.location.href='all_form/bg_form.jsp';
				}
				else
				window.location.href='index_patient/bg_patient.jsp';
			}
		else if(value==2)
			{
				if(value2==4)
				{
					window.location.href='all_form/bp_form.jsp';
				}
				else
				window.location.href='index_patient/bp_patient.jsp';
			}
		else if(value==3)
			{
				if(value2==4)
				{
					window.location.href='all_form/spo_form.jsp';
				}
				else
				window.location.href='index_patient/spo_patient.jsp';
			}
		else if(value==4)
		{
			if(value2==4)
			{
				window.location.href='interview_record/interview_form.jsp';
			}
			else
			window.location.href='interview_record/patient_iform.jsp';
		}
		else if(value==5)
			{
				window.location.href='chart/bg_ichart.jsp';
			}
		else if(value==6)
		{
			window.location.href='chart/bp_ichart.jsp';
		}
		else if(value==7)
		{
				window.location.href='chart/spo_ichart.jsp';
		}
		else if(value==9)
		{
			window.location.href='index_patient/med_record.jsp';
		}	
		else if(value==10)
		{
			window.location.href='index_doctor/dcase_history.jsp';
		}
		else if(value==11)
		{
			window.location.href='medical_manage/patient_iform.jsp';
		}

});


});

