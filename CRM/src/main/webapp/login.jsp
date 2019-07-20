<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html class="x-admin-sm">
<head>
<meta charset="UTF-8">
<title>后台登录-X-admin2.1</title>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="stylesheet" href="static/css/font.css">
<link rel="stylesheet" href="static/css/xadmin.css">
<script type="text/javascript" src="/static/js/jquery-3.3.1.js"></script>
<script src="static/lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="static/js/xadmin.js"></script>
<script type="text/javascript" src="static/js/cookie.js"></script>
<base href="${pageContext.request.contextPath }/" />

</head>
<body class="login-bg">

	<div class="login layui-anim layui-anim-up">
		<div class="message">客户管理系统登录</div>
		<div id="darkbannerwrap"></div>

		<form method="post" class="layui-form" id="form1">
			<input name="username" id="username" placeholder="用户名" type="text"
				lay-verify="required" class="layui-input">
			<hr class="hr15">
			<input name="password" id="password" lay-verify="required"
				placeholder="密码" type="password" class="layui-input">
			<hr class="hr15">
			<input value="登录" lay-submit lay-filter="login" style="width: 100%;"
				type="submit">
			<hr class="hr20">
		</form>
	</div>

	<script>
		$(function() {
			layui.use('form', function() {
				var form = layui.form;
				// layer.msg('玩命卖萌中', function(){
				//   //关闭后的操作
				//   });
				//监听提交
				form.on('submit(login)', function(data) {
					$.ajax({
						data : data.field,
						type : "post",
						url : "/login",
						dataType : "json",
						success : function(data) {
							//alert("123");
							// alert(data);
							if (data.success == true) {
								layer.msg('登录成功');
								location.href = "index.jsp"
							} else if(data.success == false){
								layer.msg('登录信息有误');
							}
							console.log(data);
						}
					});
					return false;
				});
			});
		})
	</script>


	<!-- 底部结束 -->
	<script>
		//百度统计可去掉
		var _hmt = _hmt || [];
		(function() {
			var hm = document.createElement("script");
			hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
			var s = document.getElementsByTagName("script")[0];
			s.parentNode.insertBefore(hm, s);
		})();
	</script>
</body>
</html>