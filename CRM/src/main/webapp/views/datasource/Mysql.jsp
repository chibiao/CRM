<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="static/css/font.css">
	<link rel="stylesheet" href="static/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript"src="https://cdn.bootcss.com/blueimp-md5/2.10.0/js/md5.min.js"></script>
    <script src="static/lib/layui/layui.js" charset="utf-8"></script>

    <script type="text/javascript" src="static/js/xadmin.js"></script>
    <script type="text/javascript" src="static/js/cookie.js"></script>
    <script type="text/javascript">
   
    layui.use('element', function(){
      var $ = layui.jquery
      ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块    
      //触发事件
      var active = {
        setPercent: function(){
          //设置50%进度
          element.progress('demo', '50%')
        }
        ,loading: function(othis){
          var DISABLED = 'layui-btn-disabled';
          if(othis.hasClass(DISABLED)) return;         
          //模拟loading
          var n = 0, timer = setInterval(function(){
            n = n + Math.random()*10|0;  
            if(n>100){
              n = 100;
              clearInterval(timer);
              othis.removeClass(DISABLED);
            }
            element.progress('demo', n+'%');
          }, 200+Math.random()*1);          
          othis.addClass(DISABLED);
        }
      };
      
      $('.site-demo-active').on('click', function(){
        var othis = $(this), type = $(this).data('type');
        active[type] ? active[type].call(this, othis) : '';
      });
    });
    </script>
 
</head>
<body> 
 <!--  -->
  
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
  <legend>动态改变进度</legend>
</fieldset>
 
<div class="layui-progress layui-progress-big" lay-showpercent="true" lay-filter="demo">
  <div class="layui-progress-bar layui-bg-red" lay-percent="0%"></div>
</div>
 
<div class="site-demo-button" style="margin-top: 20px; margin-bottom: 0;">

  <button class="layui-btn site-demo-active" data-type="loading">恢复</button>
</div>
 
<!-- 示例-970 -->
<ins class="adsbygoogle" style="display:inline-block;width:970px;height:90px" data-ad-client="ca-pub-6111334333458862" data-ad-slot="3820120620"></ins>


</body>
</html>