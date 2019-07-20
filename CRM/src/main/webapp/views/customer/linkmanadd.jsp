<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../static/css/font.css">
<link rel="stylesheet" href="../../static/css/xadmin.css">
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="../../static/lib/layui/layui.js"
	charset="utf-8"></script>
<script type="text/javascript" src="../../static/js/xadmin.js"></script>
<script type="text/javascript" src="../../static/js/cookie.js"></script>
<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
</head>
<body>
	<div class="x-body">
		<form class="layui-form" >
			<div class="layui-form-item">
				<input type="hidden" value="${id }" name="cid" id="cid"/>
				<label for="username" class="layui-form-label"> <span
					class="x-red">*</span>联系人姓名
				</label>
				<div class="layui-input-inline">
					<input type="text" id="username" name="lkmname" required=""
						lay-verify="required" autocomplete="off" class="layui-input">
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red">*</span>将会成为您的联系人
				</div>
			</div>
			<div class="layui-form-item">
				<label for="phone" class="layui-form-label"> <span
					class="x-red">*</span>联系人手机
				</label>
				<div class="layui-input-inline">
					<input type="text" id="phone" name="lkmphone" required=""
						lay-verify="phone" autocomplete="off" class="layui-input">
				</div>
				<div class="layui-form-mid layui-word-aux">
					<span class="x-red">*</span>将会成为您联系人的手机号
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label"><span class="x-red">*</span>角色</label>
				<div class="layui-input-block">
					<input type="radio" name="lkmsex" lay-skin="primary" title="男"
						checked="" value="男"> 
						<input type="radio" name="lkmsex"
						lay-skin="primary" title="女" value="女">
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_repass" class="layui-form-label"> </label>
				<button onclick="linkManAdd()" class="layui-btn" lay-filter="add" lay-submit="">
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
            var linkManName=$("#username").val();
			var linkManPhone=$("#phone").val();
			var linkManSex=$('input:radio:checked').val();
			
			$.post(
            		"${pageContext.request.contextPath}/linkman/add",
                	{
            			linkManName:linkManName,
            			cid:cid,
            			linkManPhone:linkManPhone,
            			linkManSex:linkManSex
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
      })();
	</script>
</body>
</html>