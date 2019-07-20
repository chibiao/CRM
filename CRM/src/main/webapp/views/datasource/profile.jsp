<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath}/" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="stylesheet" href="static/css/font.css">
<link rel="stylesheet" href="static/css/xadmin.css">
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="static/lib/layui/layui.js" charset="utf-8"></script>
<script src="static/layui/css/layui.css" charset="utf-8"></script>
<script type="text/javascript" src="static/js/xadmin.js"></script>
<script type="text/javascript" src="static/js/cookie.js"></script>

</head>
<body>
	<form class="layui-form">
		<div style="margin-top: 25px;">
				<font style="font-size: 30px; color: #009688; padding-left: 50px;">数据库连接设置</font>
				<div style="float: right; padding-right: 250px;">
					<button  class="layui-btn" lay-filter="aaa" lay-submit="">
							帮助
							<button>
						<button style="margin-left: 0px;" class="layui-btn" lay-filter="update" lay-submit="">
							保存
							<button>
								<!-- <button style="margin-left: 1px;"
						 class="layui-btn" lay-submit="" lay-filter="update"  >保存</button> -->
					
				</div>
				<div style="padding-left: 80px; margin-top: 20px;">
					<table class="layui-table" style="width: 900px;">
						<input type="hidden" name="id" id="id" value="${p.id }" />
						<tr>
							<td>数据库连接用户名:</td>
							<td><input type="text" name="name" id="name"
								class="layui-input" style="width: 300px;" required=""
								lay-verify="required" autocomplete="off" value="${p.name }" /></td>

						</tr>
						<tr>
							<td>数据库连接密码:</td>
							<td><input type="text" name="password" id="password"
								class="layui-input" style="width: 300px;" required=""
								lay-verify="required" autocomplete="off" value="${p.password }" /></td>
						</tr>
						<tr>
							<td>数据库名:</td>
							<td><input type="text" name="url" id="url"
								class="layui-input" style="width: 300px;" required=""
								lay-verify="required" autocomplete="off" value="${p.url }" /></td>
						</tr>
						<tr>
							<td>IP地址:</td>
							<td><input type="text" name="driver" id="driver"
								class="layui-input" style="width: 300px;" value="${p.driver }"
								required="" lay-verify="required" autocomplete="off" /></td>
						</tr>
					</table>
				</div>
			</div>
	</form>

	<script>
		//监听提交
		layui.use([ 'form', 'layer' ], function() {

			$ = layui.jquery;
			var form = layui.form, layer = layui.layer;

			form.on('submit(update)', function(data) {

				console.log(data);
				//发异步，把数据提交给php
				var name = $("#name").val();
				var password = $("#password").val();
				var url = $("#url").val();
				var driver = $("#driver").val();

				$.post("/client/profile", {
					name : name,
					password : password,
					url : url,
					driver : driver
				}, function(date) {
					if (date) {
						layer.msg('保存成功',
						/* layer.alert("增加成功", {
							icon : 6
						}, */
								function() {
									// 获得frame索引
									var index = parent.layer
											.getFrameIndex(window.name);
									// 关闭当前frame
									parent.layer.close(index);
									// 可以对父窗口进行刷新 
									x_admin_father_reload();
								});
					}
				}, "json");
				return false;
			});
		});
	</script>

</body>
</html>