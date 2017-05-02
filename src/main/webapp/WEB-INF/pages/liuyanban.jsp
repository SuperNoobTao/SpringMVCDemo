<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %><meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>详细页</title>
<link type="text/css" rel="stylesheet" href="../../css/style.css" />
    <link href="../../style/main1.css" rel="stylesheet" type="text/css" />
    <style type="text/css">
        <!--
        .STYLE1 {
            color: #333333;
            font-weight: bold;
        }
        -->
    </style>
</head>

<body>
<div id="box">
    <div id="logo"></div>
    <div id="nav">
        <ul class="STYLE1">
            <li><a href="/">网站首页</a>　</li>
            <li><a href="#">直播</a> </li>
            <li><a href="#">分类</a> </li>
            <li><a href="#">游戏</a> </li>
            <li><a href="/liuyanban">留言板</a></li>
        </ul>
    </div>
</div>

<div id="content">


    <h3 >发表评论</h3>
    <div class="content_comment">
        <input type="text" />
        <br/>
    	<textarea class="Js_text"></textarea>
        <br/>
        <input class="loginReg_login Js_btn" type="button" value="提交" />
    </div>
    <h3 class="content_tit content_tit_comment Js_commentList">评论</h3>
</div>

<div id="footer">
    <div id="box_copyright">
        <p align="center">——版权所有：P60111418信息 王锋——</p>
        <p align="center">——学校：浙江经济职业技术学院 计算机信息管理——</p>
        <p align="center">&nbsp;</p>
        <p align="center">&nbsp;</p>
    </div>
</div>


<script src="js/jquery.min.js"></script>
<script>
    var submitObj={
        btnNode:$('.Js_btn'),
        textNode:$('.Js_text'),
        nameNode:$('.Js_name'),
        commentListNode:$('.Js_commentList'),
        init:function(){
            var _this=this;

            _this.btnNode.click(function(){
                var nameVal=$.trim(_this.nameNode.val());
                var textVal=$.trim(_this.textNode.val());
                $.ajax({
                    type:"post",//自己改成post
                    url:"/comment/add",//接口自己替换
                    data:{userName:nameVal,comment:textVal},
                    dataType:"json",//设置响应时数据的类型
                    success:function(json){//json响应的数据，接口返回的来的数据
                        /*
                         {
                         "userName":"匿名",
                         "comment":"挺好的",
                         "time":"2007-07-07 17:17:17"
                         }
                         */

                        var html='<dl class="content_talk">';
                        html+='<dt>'+json.userName+'网友<span>'+json.time+'</span>发表</dt>'
                        html+='<dd>'+json.comment+'</dd></dl>';
                        _this.commentListNode.after(html);

                    },
                    error:function(xmlhttp,status,error){
                        console.log(status,error);
                        alert("请稍后重试!");
                    }
                });
            });


            $.ajax({
                type:'get',
                url:'/comment',
                dataType:'json',
                success:function(arrJson){
                    /*
                     [
                     {
                     "name":"匿名",
                     "comment":"挺好的",
                     "time":"2007-07-07 17:17:17"
                     },
                     {
                     "name":"匿名",
                     "comment":"挺好的",
                     "time":"2007-07-07 17:17:17"
                     }
                     ]
                     */
                    //console.log(arrJson);
                    var html="";
                    for(var i=arrJson.length-1;i>=0;i--){
                        html+='<dl class="content_talk">';
                        html+='<dt>'+arrJson[i].userName+'网友<span>'+arrJson[i].time+'</span>发表</dt>'
                        html+='<dd>'+arrJson[i].comment+'</dd></dl>';
                    }
                    _this.commentListNode.after(html);

                },
                error:function(xmlhttp,status,error){
                    //console.log(status,error);
                    alert("请稍后重试!");
                }
            });
        }
    };
    submitObj.init();



    $('#shade span,a.loginReg_login').click(function(){
        $('#shade').slideToggle();
    });
</script>
</body>
</html>
