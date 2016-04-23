


function backtolist(show,hide){
	document.getElementById(show).style.display = "";	
	document.getElementById(hide).style.display = "none";
	
}

function showinfo(area,targetControl) {
	// console.log(area+" "+targetControl.value);
	if (document.getElementById(area).style.display == "none") {
		document.getElementById(area).style.display = "";
		
		targetControl.className ="foldlabeloff";
		//backgroundImage="url("+currentImage+")";
		//targetControl.value="隐藏";
	} else {
		document.getElementById(area).style.display = "none";
		//targetControl.value="显示";
		targetControl.className ="foldlabelon";
	}
}

function showhide(){
	
	
}


function searchFrame(){
	document.getElementById("searchinfo").value = "";
	//document.getElementById("searchinfo").value="输入病人信息查找";
}