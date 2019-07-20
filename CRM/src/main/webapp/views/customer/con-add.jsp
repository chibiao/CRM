<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="x-admin-sm">
  <head>
  <base href="${pageContext.request.contextPath}/"/>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.1</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="stylesheet" href="static/css/font.css">
    <link rel="stylesheet" href="static/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="static/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="static/js/xadmin.js"></script>
    <script type="text/javascript" src="static/js/cookie.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  
  <body>
    <div class="x-body">
        <form class="layui-form">
          <div class="layui-form-item">
          <input type="hidden" value="${cid }" name="cid" id="cid"/>
              <label for="L_email" class="layui-form-label">
                  <span class="x-red">*</span>交往时间
              </label>
              <div class="layui-input-inline">
                  <input type="date" id="condate" name="condate" required="" lay-verify="condate"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_username" class="layui-form-label">
                  <span class="x-red">*</span>交往地点
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="conAddr" name="conAddr" required="" lay-verify="conAddr"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_pass" class="layui-form-label">
                  <span class="x-red">*</span>交往信息
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="conIfno" name="conIfno" required="" lay-verify="conIfno"
                  autocomplete="off" class="layui-input">
              </div>    
          </div>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
                  <span class="x-red">*</span>备注
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="conRemark" name="conRemark" required="" lay-verify="conRemark"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
              </label>
              <button onclick="Add()" class="layui-btn" lay-filter="add" lay-submit="">
                  	增加
              </button>
          </div>
      </form>
    </div>
    <script>
        layui.use(['form','layer'], function(){
            $ = layui.jquery;
          var form = layui.form
          ,layer = layui.layer;
        
          //自定义验证规则
          form.verify({
            nikename: function(value){
              if(value.length < 5){
                return '昵称至少得5个字符啊';
              }
            }
            ,pass: [/(.+){6,12}$/, '密码必须6到12位']
            ,repass: function(value){
                if($('#L_pass').val()!=$('#L_repass').val()){
                    return '两次密码不一致';
                }
            }
          });

          //监听提交
          form.on('submit(add)', function(data){
            console.log(data);
            //发异步，把数据提交给php
            var cid=$("#cid").val();
            var condate=$("#condate").val();
			var conAddr=$("#conAddr").val();
			var conIfno=$("#conIfno").val();
			var conRemark=$("#conRemark").val();
			$.post(
            		"${pageContext.request.contextPath}/contact/add",
                	{
            			cid:cid,
            			condate:condate,
            			conAddr:conAddr,
            			conIfno:conIfno,
            			conRemark:conRemark
                	},
                	function(date){          
                		 if(date){            
            layer.alert("增加成功", {icon: 6},function () {
            	 // 获得frame索引
                var index = parent.layer.getFrameIndex(window.name);
                //关闭当前frame
                parent.layer.close(index);
                // 可以对父窗口进行刷新 
                x_admin_father_reload();
            });
          	 }
            },
            "json"
            );
            return false;
          }); 
        });
    </script>
    <script>var _hmt = _hmt || []; (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
      })();</script>
  </body>

</html>