var timelag=1500;
/*
 * function check(){ $('#tip5').tipso('show');
 *  } $(function() { $('#tip3').tipso({ useTitle: false }); $('#username').on({
 * blur: function(e) { checkusername(); $('#tip3').tipso('show');
 * $('#tip3').tipso('show'); e.preventDefault(); } }); });
 */
// JavaScript Document
/*
 * $(function(){ $('#username').on({ blur:checkusername(),
 * //mouseout:checkusername(), });
 * 
 * });
 */
function patload(){
	
	
	hosload();
	docload();
}
function docload(){
	
}
function hosload() {
	//var id = document.getElementById("loginuserid").value;
	 var id = "999";
	$.ajax({
		type : "post",
		url : "servlet/requestServlet",
		//url : "admin/getAllHospital.do",
		async : false,
		data : {
			"fun" : "hosloadssss",
			"admin_id" : id,
		},
		success : function(data) {
			var obj = new Function("return" + data)();
			if (obj.result == "1") {
				var ins = "";
				var length = obj.list.length;
				ins = "<option value='nosechos' style='width:100%'></option>";

				for ( var i = 0; i < length; i++) {
					ins = ins + "<option" + " value='" + obj.list[i].id
							+ "' style='width:100%'>" + obj.list[i].name
							+ "</option>";
				}
				document.getElementById("sechos").innerHTML = ins;
			} else {
				alert("获取医院信息失败");
			}
		},
		error : function() {
			alert("error");
		},
	});
}
function secdoc(){
	
	
}
function showtips(id,info){
	// console.log("ssssss");
	/*
	 * $(id).tipso({ useTitle: false, background: bgcolor, });
	 */
	$(id).tipso('update', 'content', info);

	$(id).tipso('show');
	// console.log("false");
}
function hidetips(id){
	$(id).tipso({
		useTitle: false,
	});
	$(id).tipso('hide');
}
function checkusername(){
	var regname=/^\w{4,16}$/;
	var username=document.getElementById("username");
	console.log(username.value+"   "+username.value.length);
	/*
	 * <"√ 用户名可用 × 请输入4-16位用户名× 用户名格式输入错误
	 */
		
	if(username.value==""|| username.value.length<4||username.value.length>16){				
		showtips("#tipusername","请输入4-16位用户名");
		var t=setTimeout("hidetips('#tipusername')",timelag);
		return false;
	}
	else{
		if(username.value.match(regname)){
	// tipusername.innerHTML="√用户名可用!";
			showtips("#tipusername","用户名可用");
			var t=setTimeout("hidetips('#tipusername')",timelag);
			return true;
		}
		else{
			// 格式错误 "× 用户名格式输入错误"
			showtips("#tipusername","用户名格式输入错误");
			var t=setTimeout("hidetips('#tipusername')",timelag);
			return false;
		}
	}
}

function checkpassword(){
	
	var fp=document.getElementById("fpassword");
	
	if(fp.value==""||fp.value.length<4||fp.value.length>45){
		// ftpwd.innerHTML="× 请输入4-45位用户密码！";
		showtips("#tipfpassword","请输入4-45位用户密码");
		var t=setTimeout("hidetips('#tipfpassword')",timelag);
		return false;
	}
	else{
		// ftpwd.innerHTML="√密码可用！";
		showtips("#tipfpassword","密码可用!");
		var t=setTimeout("hidetips('#tipfpassword')",timelag);
		return true;
	}
	
}
function rcheckpassword(){
	tipspassword;
	var fp=document.getElementById("fpassword");
	var sp=document.getElementById("spassword");
	if(sp.value=="")
	{
		// ftrpwd.innerHTML="请输入您的重复密码！";
		showtips("#tipspassword","× 请输入您的重复密码！");
		var t=setTimeout("hidetips('#tipspassword')",timelag);
		return false;
	}
	else{
		if(sp.value!=fp.value)
		{
			// ftrpwd.innerHTML="俩次密码输入不一致，请重新输入！";
			showtips("#tipspassword","× 俩次密码输入不一致，请重新输入！");
			var t=setTimeout("hidetips('#tipspassword')",timelag);
			return false;
		}
		else
		{
			showtips("#tipspassword","√ 密码输入正确！");
			var t=setTimeout("hidetips('#tipspassword')",timelag);
			return true;
			// ftrpwd.innerHTML=" 密码输入正确！";
		}
	}
}
function checkrealname(){
	// id tiprealname
	var rname=document.getElementById("realname");
	if(rname.value==""){
		// ftemail.innerHTML="姓名不能为空！";
		showtips("#tiprealname","× 姓名不能为空！");
		var t=setTimeout("hidetips('#tiprealname')",timelag);
		return false;
	}
	else{if(!isChn(rname.value)){
		// ftemail.innerHTML="× 请输入中中文午名字！";
		showtips("#tiprealname","请输入中文名字！");
		var t=setTimeout("hidetips('#tiprealname')",timelag);
		return false;
	}
	else{
		// ftemail.innerHTML="√ 格式正确！";
		showtips("#tiprealname","格式正确！");
		var t=setTimeout("hidetips('#tiprealname')",timelag);
		return true;
	}}
}

function checknation(){
	// id tipnation
	var rname=document.getElementById("nation");
	if(rname.value==""){
		// ftemail.innerHTML="× 民族不能为空！";
		showtips("#tipnation","民族不能为空！");
		var t=setTimeout("hidetips('#tipnation')",timelag);
		return false;
	}
	else{if(!isChn(rname.value)){
		// ftemail.innerHTML="× 请输入中中文午名字！";
		showtips("#tipnation","请输入中文！");
		var t=setTimeout("hidetips('#tipnation')",timelag);
		return false;
	}
	else{
		// ftemail.innerHTML="√ 格式正确！";
		showtips("#tipnation","格式正确！");
		var t=setTimeout("hidetips('#tipnation')",timelag);
		return true;
	}}
}


function checkage(){
	// id tipage
	var rname=document.getElementById("age");
	if(rname.value==""){
		// ftemail.innerHTML="× 民族不能为空！";
		showtips("#tipage","年龄不能为空！");
		var t=setTimeout("hidetips('#tipage')",timelag);
		return false;
	}
	else{if(isNaN(rname.value)){
		// ftemail.innerHTML="× 请输入中中文午名字！";
		showtips("#tipage","请输入数字！");
		var t=setTimeout("hidetips('#tipage')",timelag);
		return false;
	}
	else{
		// ftemail.innerHTML="√ 格式正确！";
		showtips("#tipage","格式正确！");
		var t=setTimeout("hidetips('#tipage')",timelag);
		return true;
	}}
	/*
	 * if(isNaN(x)) { alert(x+"不是数字"); }else { alert(x+"是数字"); }
	 */
}

function checkidcard()  
{  
   var id2=document.getElementById("id2");
   var reg=/^(\d{15}$|^\d{18}$|^\d{17}(\d|X|x))$/; 
   if(reg.test(id2.value)==false)  
   {  
       showtips("#tipidcard","身份证输入不合法");
	   var t=setTimeout("hidetips('#tipidcard')",timelag);
	   return false;
   }
   else
   {
	   showtips("#tipidcard","身份证输入合法");
	   var t=setTimeout("hidetips('#tipidcard')",timelag);
	   return true;
   }
} 

function checktele(){
	// id tiptele
	var rname=document.getElementById("tele");
	if(rname.value==""){
		// ftemail.innerHTML="× 联系电话不能为空！";
		showtips("#tiptele","× 联系电话不能为空！");
		var t=setTimeout("hidetips('#tiptele')",timelag);
		return false;
	}
	else{if(isNaN(rname.value)){
		// ftemail.innerHTML="× 请输入数字！";
		showtips("#tiptele","请输入数字！");
		var t=setTimeout("hidetips('#tiptele')",timelag);
		return false;
	}
	else{
		// ftemail.innerHTML="√ 格式正确！";
		showtips("#tiptele","格式正确");
		var t=setTimeout("hidetips('#tiptele')",timelag);
		return true;
	}}
}



function checktele1(){
	// id tiptele
	var rname=document.getElementById("tele1");
	if(rname.value==""){
		// ftemail.innerHTML="× 家属电话不能为空！";
		showtips("#tiptele1","× 家属电话不能为空！");
		return false;
	}
	else{if(isNaN(rname.value)){
		// ftemail.innerHTML="× 请输入数字！";
		showtips("#tiptele1","× 请输入数字！");
		return false;
	}
	else{
		// ftemail.innerHTML="√ 格式正确！";
		showtips("#tiptele1","√ 格式正确！");
		var t=setTimeout("hidetips('#tiptele1')",timelag);
		return true;
	}}
}
function checktele2(){
	// id tiptele
	var rname=document.getElementById("tele2");
	if(rname.value==""){
		// ftemail.innerHTML="× 家属电话不能为空！";
		showtips("#tiptele2","× 家属电话不能为空！");
		return false;
	}
	else{if(isNaN(rname.value)){
		// ftemail.innerHTML="× 请输入数字！";
		showtips("#tiptele2","× 请输入数字！");
		return false;
	}
	else{
		// ftemail.innerHTML="√ 格式正确！";
		showtips("#tiptele2","√ 格式正确！");
		var t=setTimeout("hidetips('#tiptele2')",timelag);
		return true;
	}}
}
function checkemail(){
	// id=tipmail;
	var regemail=/^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*(;\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*)*$/;
	var femail=document.getElementById("mail");
	if(femail.value==""){
		// ftemail.innerHTML="× 电子邮箱不能为空！";
		showtips("#tipmail","× 电子邮箱不能为空！");
		return false;
	}
	else{
		if(femail.value.match(regemail)){
			// ftemail.innerHTML="√ 邮箱地址正确！";
			showtips("#tipmail","√ 邮箱地址正确！");
			var t=setTimeout("hidetips('#tipmail')",timelag);
			return true;
		}
		else{
			// ftemail.innerHTML="× 邮箱格式输入错误，请检查！";
			showtips("#tipmail","× 邮箱格式输入错误，请检查！");
			return false;
		}
	}
}
function checkhos(){
	// id=tiphos;
	
	var targetSlect = document.getElementById("sechos");
	var hosid = targetSlect.options[targetSlect.selectedIndex].value;
	var hosname = targetSlect.options[targetSlect.selectedIndex].innerHTML;
	
	//alert(hosid+ "---"+hosname);
	if(hosid=="nosechos"){
		// ftemail.innerHTML="× 不能为空！";
		showtips("#tiphos","× 请选择医院！");
		return false;
	}
	else{
		// ftemail.innerHTML="√ 邮箱地址正确！";
		showtips("#tiphos","√ 已选择！");
		var t=setTimeout("hidetips('#tiphos')",timelag);
		return true;
	}
}
function checkcer(){
	// id=tipcer;
	var fcer=document.getElementById("certificate");
	if(fcer.value==""){
		showtips("#tipcer","× 从医许可证不能为空！");
		return false;
	}
	else{
		showtips("#tipcer","格式正确！");
		var t=setTimeout("hidetips('#tipcer')",timelag);
		return true;
		
	}
}
function checkbel(){
	// id=tipbel;
	var fbel=document.getElementById("belongdepart");
	if(fbel.value==""){
		showtips("#tipbel","× 所属科不能为空！");
		return false;
	}
	else{
		// ftemail.innerHTML="√ 邮箱地址正确！";
		showtips("#tipbel","格式正确！");
		var t=setTimeout("hidetips('#tipbel')",timelag);
		return true;
	}
}



function checkdoc(){
	// id=tiphos;
	var fdoc=document.getElementById("doctor_id");
	if(fdoc.value==""){
		// ftemail.innerHTML="× 不能为空！";
		showtips("#tipdoc","× 所属医生不能为空！");
		return false;
	}
	else{
		if(isNaN(fdoc.value)){
			// ftemail.innerHTML="× 邮箱格式输入错误，请检查！";
			showtips("#tipdoc","× × 请输入医生ID！");
			return false;
		}
		else{
			// ftemail.innerHTML="√ 邮箱地址正确！";
			showtips("#tipdoc","√ 格式正确！");
			var t=setTimeout("hidetips('#tipdoc')",timelag);
			return true;
			
		}
	}
}
/*
 * function checkexp(){ //id=tipexp; var
 * fexp=document.getElementById("expdepart"); if(fexp.value==""){ //
 * ftemail.innerHTML="× 电子邮箱不能为空！"; showtips("#tipexp","× 所属科不能为空！"); return
 * false; } else{ // ftemail.innerHTML="√ 邮箱地址正确！"; showtips("#tipexp","√
 * 邮箱地址正确！"); var t=setTimeout("hidetips('#tipexp')",timelag); return true; } }
 */

function isChn(str){
	var reg = /^[u4E00-u9FA5]+$/i;
	if(reg.test(str)){
		return false;
	}
	else{
		return true;
	}
}


function checkdoctor(){
	if(!checkusername())return false;
	if(!checkpassword())return false;
	if(!rcheckpassword())return false;
	if(!checkrealname())return false;
	if(!checknation())return false;
	if(!checkage())return false;
	if(!checktele())return false;
	if(!checkemail())return false;
	if(!checkcer())return false;
	if(!checkbel())return false;
	return true;
}


function checkpatient(){
	if(!checkusername())return false;
	if(!checkpassword())return false;
	if(!rcheckpassword())return false;
	if(!checkrealname())return false;
	if(!checknation())return false;
	if(!checkage())return false;
	if(!checktele())return false;
	return true;
}
/*
 * ! tipso - A Lightweight Responsive jQuery Tooltip Plugin v1.0.1 Copyright (c)
 * 2014 Bojan Petkovski http://tipso.object505.com Licensed under the MIT
 * license http://object505.mit-license.org/
 */
!function(t,o,s,e){
	function r(o,s){
		this.element=t(o),
		this.settings=t.extend({},l,s),
		this._defaults=l,
		this._name=d,
		this._title=this.element.attr("title"),
		this.mode="hide",this.init();
		}
	function i(){
		var t=o.navigator.msMaxTouchPoints,
		e="ontouchstart"in s.createElement("div");
		return t||e?!0:!1;
				}
	function n(o){
		var s=o.clone();
		s.css("visibility","hidden"),
		t("body").append(s);
		var e=s.outerHeight();
		return s.remove(),e;
		}function a(s){
			var e,r,i,a=s.tooltip(),
			d=s.element,l=s,f=t(o),p=10;
			switch(l.settings.position){
			case"top":r=d.offset().left+d.outerWidth()/2-a.outerWidth()/2,e=d.offset().top-n(a)-p,
			a.find(".tipso_arrow").css({marginLeft:-8}),
			e<f.scrollTop()?(e=d.offset().top+d.outerHeight()+p,a.find(".tipso_arrow").css({"border-bottom-color":l.settings.background,
				"border-top-color":"transparent"}),a.removeClass("top bottom left right"),
				a.addClass("bottom")):(a.find(".tipso_arrow").css({"border-top-color":l.settings.background,
					"border-bottom-color":"transparent"}),a.removeClass("top bottom left right"),a.addClass("top"));break;
			case"bottom":r=d.offset().left+d.outerWidth()/2-a.outerWidth()/2,
			e=d.offset().top+d.outerHeight()+p,a.find(".tipso_arrow").css({marginLeft:-8}),e+n(a)>f.scrollTop()+f.outerHeight()?(e=d.offset().top-n(a)-p,
					a.find(".tipso_arrow").css({"border-top-color":l.settings.background,"border-bottom-color":"transparent"}),a.removeClass("top bottom left right"),
					a.addClass("top")):(a.find(".tipso_arrow").css({"border-bottom-color":l.settings.background,"border-top-color":"transparent"}),a.removeClass("top bottom left right"),
					a.addClass(l.settings.position));break;
			case"left":r=d.offset().left-a.outerWidth()-p,e=d.offset().top+d.outerHeight()/2-n(a)/2,
			a.find(".tipso_arrow").css({marginTop:-8,marginLeft:""}),r<f.scrollLeft()?(r=d.offset().left+d.outerWidth()+p,
					a.find(".tipso_arrow").css({"border-right-color":l.settings.background,
						"border-left-color":"transparent","border-top-color":"transparent",
						"border-bottom-color":"transparent"}),a.removeClass("top bottom left right"),
						a.addClass("right")):(a.find(".tipso_arrow").css({"border-left-color":l.settings.background,
							"border-right-color":"transparent","border-top-color":"transparent",
							"border-bottom-color":"transparent"}),a.removeClass("top bottom left right"),
							a.addClass(l.settings.position));break;
			case"right":r=d.offset().left+d.outerWidth()+p,e=d.offset().top+d.outerHeight()/2-n(a)/2,
			a.find(".tipso_arrow").css({marginTop:-8,marginLeft:""}),
			r+p+l.settings.width>f.scrollLeft()+f.outerWidth()?(r=d.offset().left-a.outerWidth()-p,
			a.find(".tipso_arrow").css({"border-left-color":l.settings.background,
			"border-right-color":"transparent","border-top-color":"transparent",
			"border-bottom-color":"transparent"}),a.removeClass("top bottom left right"),
			a.addClass("left")):(a.find(".tipso_arrow").css({"border-right-color":l.settings.background,
			"border-left-color":"transparent","border-top-color":"transparent",
			"border-bottom-color":"transparent"}),a.removeClass("top bottom left right"),
							a.addClass(l.settings.position));
			}
							r<f.scrollLeft()&&("bottom"==l.settings.position||"top"==l.settings.position)&&(a.find(".tipso_arrow").css({marginLeft:r-8}),r=0),
							r+l.settings.width>f.outerWidth()&&("bottom"==l.settings.position||"top"==l.settings.position)&&(i=f.outerWidth()-(r+l.settings.width),
							a.find(".tipso_arrow").css({marginLeft:-i-8,marginTop:""}),r+=i),r<f.scrollLeft()&&("left"==l.settings.position||"right"==l.settings.position)&&(r=d.offset().left+d.outerWidth()/2-a.outerWidth()/2,
									a.find(".tipso_arrow").css({marginLeft:-8,marginTop:""}),e=d.offset().top-n(a)-p,e<f.scrollTop()?(e=d.offset().top+d.outerHeight()+p,a.find(".tipso_arrow").css({"border-bottom-color":l.settings.background,
										"border-top-color":"transparent","border-left-color":"transparent","border-right-color":"transparent"}),a.removeClass("top bottom left right"),a.addClass("bottom")):(a.find(".tipso_arrow").css({"border-top-color":l.settings.background,"border-bottom-color":"transparent","border-left-color":"transparent","border-right-color":"transparent"}),a.removeClass("top bottom left right"),a.addClass("top")),r+l.settings.width>f.outerWidth()&&(i=f.outerWidth()-(r+l.settings.width),a.find(".tipso_arrow").css({marginLeft:-i-8,marginTop:""}),r+=i),r<f.scrollLeft()&&(a.find(".tipso_arrow").css({marginLeft:r-8}),r=0)),r+l.settings.width>f.outerWidth()&&("left"==l.settings.position||"right"==l.settings.position)&&(r=d.offset().left+d.outerWidth()/2-a.outerWidth()/2,a.find(".tipso_arrow").css({marginLeft:-8,marginTop:""}),e=d.offset().top-n(a)-p,e<f.scrollTop()?(e=d.offset().top+d.outerHeight()+p,a.find(".tipso_arrow").css({"border-bottom-color":l.settings.background,"border-top-color":"transparent","border-left-color":"transparent","border-right-color":"transparent"}),a.removeClass("top bottom left right"),a.addClass("bottom")):(a.find(".tipso_arrow").css({"border-top-color":l.settings.background,"border-bottom-color":"transparent","border-left-color":"transparent","border-right-color":"transparent"}),a.removeClass("top bottom left right"),a.addClass("top")),r+l.settings.width>f.outerWidth()&&(i=f.outerWidth()-(r+l.settings.width),a.find(".tipso_arrow").css({marginLeft:-i-8,marginTop:""}),r+=i),r<f.scrollLeft()&&(a.find(".tipso_arrow").css({marginLeft:r-8}),r=0)),a.css({left:r+l.settings.offsetX,top:e+l.settings.offsetY
				});
			}
		var d="tipso",l={
				speed:400,background:"#55b555",color:"#ffffff",position:"top",
				width:200,delay:200,offsetX:0,offsetY:0,
				content:null,ajaxContentUrl:null,useTitle:!0,onBeforeShow:null,onShow:null,onHide:null
			};
		t.extend(
				r.prototype,{init:function(){var o=this,e=this.element;e.addClass("tipso_style").removeAttr("title"),i()?(e.on("click."+d,function(t){"hide"==o.mode?o.show():o.hide(),t.stopPropagation();
				}),t(s).on("click",function(){"show"==o.mode&&o.hide();
				})):(e.on("mouseover."+d,function(){o.show();
				}),e.on("mouseout."+d,function(){o.hide();
				}));
				},tooltip:function(){return this.tipso_bubble||(this.tipso_bubble=t('<div class="tipso_bubble"><div class="tipso_content"></div><div class="tipso_arrow"></div></div>')),this.tipso_bubble;
				},show:function(){var s=this.tooltip(),e=this,r=t(o);t.isFunction(e.settings.onBeforeShow)&&e.settings.onBeforeShow(t(this)),s.css({background:e.settings.background,color:e.settings.color,width:e.settings.width}).hide(),s.find(".tipso_content").html(e.content()),a(e),r.resize(function(){a(e);
				}),e.timeout=o.setTimeout(function(){s.appendTo("body").stop(!0,!0).fadeIn(e.settings.speed,function(){e.mode="show",t.isFunction(e.settings.onShow)&&e.settings.onShow(t(this));
				});
				},e.settings.delay);
				},hide:function(){var s=this,e=this.tooltip();o.clearTimeout(s.timeout),s.timeout=null,e.stop(!0,!0).fadeOut(s.settings.speed,function(){t(this).remove(),t.isFunction(s.settings.onHide)&&"show"==s.mode&&s.settings.onHide(t(this)),s.mode="hide";});
				},destroy:function(){var t=this.element;t.off("."+d),t.removeData(d),t.removeClass("tipso_style").attr("title",this._title);
				},content:function(){var o,s=this.element,e=this,r=this._title;return o=e.settings.ajaxContentUrl?t.ajax({type:"GET",url:e.settings.ajaxContentUrl,async:!1}).responseText:e.settings.content?e.settings.content:e.settings.useTitle===!0?r:s.data("tipso");
				},update:function(t,o){var s=this;return o?void(s.settings[t]=o):s.settings[t];
				}
				}),t[d]=t.fn[d]=function(o){var s=arguments;if(o===e||"object"==typeof o)return this instanceof t||t.extend(l,o),this.each(function(){t.data(this,"plugin_"+d)||t.data(this,"plugin_"+d,new r(this,o));
				});if("string"==typeof o&&"_"!==o[0]&&"init"!==o){var i;return this.each(function(){var e=t.data(this,"plugin_"+d);e||(e=t.data(this,"plugin_"+d,new r(this,o))),e instanceof r&&"function"==typeof e[o]&&(i=e[o].apply(e,Array.prototype.slice.call(s,1))),"destroy"===o&&t.data(this,"plugin_"+d,null);
				}),i!==e?i:this;
				}
				};
				}(jQuery,window,document);
				




function previewImage(file)
            {
                var MAXWIDTH  = 100;
                var MAXHEIGHT = 100;
                var div = document.getElementById('preview');
                if (file.files && file.files[0])
                {
                    div.innerHTML ='<img id=imghead>';
                    var img = document.getElementById('imghead');
                    img.onload = function(){
                        var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
                        img.width  =  rect.width;
                        img.height =  rect.height;
                        //                 img.style.marginLeft = rect.left+'px';
                        //img.style.marginTop = rect.top+'px';
                    }
                    var reader = new FileReader();
                    reader.onload = function(evt){img.src = evt.target.result;}
                    reader.readAsDataURL(file.files[0]);
                }
                else
                {
                    var sFilter='filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="';
                    file.select();
                    var src = document.selection.createRange().text;
                    div.innerHTML = '<img id=imghead>';
                    var img = document.getElementById('imghead');
                    img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
                    var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
                    status =('rect:'+rect.top+','+rect.left+','+rect.width+','+rect.height);
                    div.innerHTML = "<div id=divhead style='width:"+rect.width+"px;height:"+rect.height+"px;margin-top:"+rect.top+"px;"+sFilter+src+"\"'></div>";
                }
            }
            function clacImgZoomParam( maxWidth, maxHeight, width, height ){
                var param = {top:0, left:0, width:width, height:height};
                if( width>maxWidth || height>maxHeight )
                {
                    rateWidth = width / maxWidth;
                    rateHeight = height / maxHeight;
                 
                    if( rateWidth > rateHeight )
                    {
                        param.width =  maxWidth;
                        param.height = Math.round(height / rateWidth);
                    }else
                    {
                        param.width = Math.round(width / rateHeight);
                        param.height = maxHeight;
                    }
                }
             
                param.left = Math.round((maxWidth - param.width) / 2);
                param.top = Math.round((maxHeight - param.height) / 2);
                return param;
            }

