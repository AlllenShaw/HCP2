

function showJSON() {    
    
	document.getElementById("idnumber").value="123";
	document.getElementById("username").value="hello";
	document.getElementById("gender").value="男";
	document.getElementById("race").value="汉";
	document.getElementById("age").value="24";
	document.getElementById("marriage").value="未婚";
	document.getElementById("job").value="学生";
	document.getElementById("address").value="汕头大学";
	document.getElementById("occupation").value="汕头大学";
	document.getElementById("tel_1").value="1234567";
	document.getElementById("tel_2").value="7896541";
	document.getElementById("tel_3").value="5467891";
	document.getElementById("history_1").value="无";
	document.getElementById("history_2").value="无";
	document.getElementById("history_3").value="无";
	
}
function judge(type){
	if(type='patient'){
		parent.location.href="xietongzhenzhi/dianzidangan.jsp";
	}
	else{
		parent.location.href="xietongzhenzhi/bingrenliebiao.jsp";
	}

}
function mainmenu(r){
	
	parent.location.href=r;
	/*document.getElementById();*/
}
function mainmenu1(r){
	
	document.getElementById("bd").src=r;
	/*document.getElementById();*/
}

function test(){
$.ajax({
	type: "post",
    url: "helloservlet",
    data: {username:$("#username").val(), id:$("#id").val()},
    dataType: "json",
    success: function(){
    	alert("success");
    },
    error: function(){
    	alert("error");
    }
    });
}

function test2(){
  $("#userName").keyup(function(){
    $.ajax({
          type: "post",
          url: "helloservlet?userName="+$(this).val(),
          dataType: "json",
          success: function(data){
                $("#showMsg").html(data.msg);//修改id为showMsg标签的html
          }, 
          error: function(){
                alert("请求出错");
          }
    });
});
}






