// JavaScript Document

function changePic(id, st) {
	document.getElementById("imgtext").innerHTML = st;

	document.getElementById("img" + id).style.display = "block";
	document.getElementById(id).style.backgroundColor = "#87CEFA";

	var num = id.substring(3);
	 console.log("id= " + id +  " num= " + num );

	for ( var i = 1; i <= 4; i++) {
		if (i != num) {
			document.getElementById("imgbj_"+i).style.display = "none";
			document.getElementById("bj_"+i).style.backgroundColor = "";
		}

	}
}

function recePic() {
	var i = 1;

	for (i = 1; i <= 4; i++) {
		var ob = document.getElementById("imgbj_" + i).style.display;
		if (ob == "block" || ob == "") {
			i++;
			break;
		}
	}
	if (i == 5)
		i = 1;
	document.getElementById("imgbj_" + i).style.display = "block";
	st = document.getElementById("tbj_" + i).value;

	document.getElementById("imgtext").innerHTML = st;

	for ( var j = 1; j < 5; j++) {
		if (j != i) {
			document.getElementById("imgbj_" + j).style.display = "none";
		}
	}
	setTimeout("recePic()", 3000);
}
