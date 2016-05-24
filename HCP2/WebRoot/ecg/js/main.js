var sw=0;
var timelist=new Array();
function getlist(name){
    $.ajax({             //一个Ajax过程   
        url: 'php/getlist.php', //与此php页面沟通   
        dataType: 'json', //从php返回的值以 JSON方式 解释
        data: { "usename": name },
        type: "POST",
        async: false,
        cache: false,
        error: function () {
            alert('读取您的心电图列表时，发生了错误');
        },
        success: function (data) {  //如果调用php成功
            if (data[0] == "not found this people") {
                alert('无此用户，请重新输入')
            }
            else {
                if (data[0] == null) {
                    alert('此用户暂无心电图数据，请重新输入')
                }
                else {
                    for (var i = 0; i < (data.length); i++) {
                        timelist[i] = data[i];
                        
                    }
                    sw = 1
                    //alert('读取您的心电图列表成功，准备生成列表');
                    //alert(data);
                }
            }
        }
    });
    if (sw) {
        //var div_list = document.createElement("div");
        var div_list_html = "<label>请选择数据：</label><select id='gettime'>";
        //html
        for (var i = 0; i < (timelist.length); i++) {
            div_list_html += "<option>";
            div_list_html += timelist[i];
            div_list_html += "</option>";
        }
        div_list_html += "</select><input id='getlist2' value='确认' type='button' onclick='getdata(gettime.value);'/>";
        //div_list.id = "ecglist";
        //div_list.innerHTML = div_list_html;
        //document.body.appendChild(div_list);
        document.getElementById("thelist").innerHTML=div_list_html;
        sw = 0;
    }
//$("<label>请输入您的姓名：</label>").appendTo("body"); 
}
var sw0 = 0;
var sw1 = 0;
var hmapdata=new Array();
function getdata(thetime){
    $.ajax({             //一个Ajax过程   
        url: 'php/loadata.php', //与此php页面沟通   
        dataType: 'json', //从php返回的值以 JSON方式 解释
        data: { "thetime": thetime },
        type: "POST",
        async: false,
        cache: false,
        error: function () {
            alert('读取您的心电图时，发生了错误');
        },
        success: function (data) {  //如果调用php成功
            for (var i = 0; i < (data.length); i++) {
                hmapdata[i] = data[i]
            }
            sw0 = 1;
            //alert('读取您的心电图成功，准备生成心电图');
            //alert(hmapdata[0]);
        }
    });
    if (sw0) {
        var div_contrler_html = 
    "<input id='mgo' value='开始' type='button' onclick='getm();'/>"+
	"<input id='mstop' value='暂停' type='button' onclick='stopm();'/>"+
	"<input id='mgoon' value='继续' type='button' onclick='goonm();'/>"+
    "<input id='mclear' value='复位' type='button' onclick='clearm();'/>";
        document.getElementById("contrler").innerHTML=div_contrler_html;
        sw0 = 0;
        sw1 = 1;
    }
}

