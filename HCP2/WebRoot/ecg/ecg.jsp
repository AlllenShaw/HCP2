<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
 <head>
        <meta charset="utf-8" />
        <title>心电图波形查看</title>
        <script  src="../ecg/js/jquery-2.2.3.js" type="text/javascript"></script>
        <script  src="../ecg/js/wz_jsgraphics.js" type="text/javascript"></script>
        <link href="../ecg/css/Style.css" rel="stylesheet" type="text/css" />
        <link rel="shortcut icon" href="../ecg/images/favicon.ico"/>
        <link rel="bookmark" href="../ecg/images/favicon.ico"/>
</head>
<body>
        <p id="title1">心电图波形查看</p>
    <div id="mainbody">
        <div id="contbock">
             <div id="getid">
             		<form  method="post" id="formid">
					<input type="hidden" name="selector1" value="8" />
					<input type="hidden" name="selector2" value="1" />
					<input type="hidden" name="type" value="1" />
                     <label id="labgetname">请输入姓名：</label>
                     <input id="getlist1" type="text" name="text1"/>
                     <input id="getlist2" value="确认" type="submit"/>
                     </form>
             </div>
             <div id="thelist" ></div>
             <div id="contrler"></div>
        </div>
        <div id="displaybock">
                <div id="draw1a"  style="color:black; left: 5.75%;overflow:auto; width: 1209px; position:absolute;   top: 30%; height: 347px;  background-image :url('../ecg/images/background.png');float:left;"></div>
	            <div id="draw1b" style="color:blue; left: 5.75%;overflow: visible; width:   0px; position:absolute;   top: 30%; height: 347px;  float:left;"></div>
	            <div id="draw1c" style="color:blue; left: 5.75%;overflow: visible; width:   0px; position:absolute;   top:30%; height: 347px;  float:left; "></div>
                <div id="stabou">使用说明：输入姓名后生成心电图列表；选择心电数据后可按开始进行绘图；暂停，继续用于随时控制绘图；复位用于清空绘板，便于重选数据;</div>
        </div>
    </div>
        <script type="text/javascript">
            function DranClass(butdrawDiv, div1, div2) {
                var jgOne = new jsGraphics(div1); //画图对象1
                var jgTwo = new jsGraphics(div2); //画图对象2
                var oldX = 0; //旧X轴
                var oldY = 175; //旧Y轴
                var newX = 0; //新X轴
                var newY = 0; //新Y轴
                var cyc = 0; //回转控制变量
                var jgOneBool = true; //画图布切换开关
                var jgTwoBool = false; //画图布切换开关
                this.clearm = function () {
                    oldX = 0;
                    oldY = 175;
                    newX = 0;
                    newY = 0;
                    cyc = 0;
                    jgOne.clear();
                    jgTwo.clear();
                }
                this.dran = function (value) {
                    if (jgOneBool) {
                        newX = cyc;

                        //在没有数据时画直线
                        if (value != null) {
                            newY = value;
                        }

                        //橡皮檫 将前面显示的波形刷新
                        //jgOne.setColor("TRANSPARENT");
                        //jgOne.fillRect(cyc, 0, 20, 150);
                        jgTwo.clear();

                        //画线 用于画波形
                        jgOne.setColor("#000000");
                        jgOne.drawLine(oldX, oldY, newX, newY);
                        jgOne.paint();
                        oldX = newX;
                        oldY = newY;

                        //在波形走到最后时回转  重新开始画
                        if (cyc > 1209) {
                            //控制层之间的显示优先级
                            document.getElementById(butdrawDiv).style.zIndex = 1;
                            document.getElementById(div1).style.zIndex = 10;
                            document.getElementById(div2).style.zIndex = 20;
                            //清空画图桌布
                            jgTwo.clear();
                            //控制桌布切换
                            jgOneBool = false;
                            jgTwoBool = true;
                            //控制数值转换
                            oldX = 0;
                            newX = 0;
                            cyc = 0;
                        }
                    } else if (jgTwoBool) {
                        newX = cyc;
                        if (value != null) {
                            newY = value;
                        }
                        //jgTwo.setColor("TRANSPARENT");
                        //jgTwo.fillRect(cyc, 0, 20, 150);

                        jgOne.clear();
                        //jgOne.drawImage(img1,400,600);

                        jgTwo.setColor("#000000");
                        jgTwo.drawLine(oldX, oldY, newX, newY);
                        jgTwo.paint();
                        oldX = newX;
                        oldY = newY;
                        if (cyc > 1209) {
                            document.getElementById(butdrawDiv).style.zIndex = 1;
                            document.getElementById(div1).style.zIndex = 20;
                            document.getElementById(div2).style.zIndex = 10;
                            jgOne.clear();
                            jgOneBool = true;
                            jgTwoBool = false;
                            oldX = 0;
                            newX = 0;
                            cyc = 0;
                        }
                    }
                    cyc++;
                }
            }
            var i = 0;
            var k1 = 200;
            var k2 = 400;
            var time1 = 0;
            var a = new DranClass("draw1a", "draw1b", "draw1c");
            function getm() {
                if (sw1) {
                    if (i < hmapdata.length) {
                        a.dran((k1 - (hmapdata[i] - 2050)) / k2 * 349);
                        i++;
                    }
                    else {
                        i = 0;
                    }
                }
                time1 = setTimeout(getm, 3);

            }
            function stopm() {
                sw1 = 0;
            }
            function goonm() {
                sw1 = 1;
            }
            function clearm() {
                //sw1=0;
                 clearTimeout(time1);
                 i = 0;
                 a.clearm();
            }
	</script>
</body>
</html>
