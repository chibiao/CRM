<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>客户联系人</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<link rel="stylesheet" href="../../static/css/font.css">
<link rel="stylesheet" href="../../static/css/xadmin.css">
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="../../static/lib/layui/layui.js"
	charset="utf-8"></script>
<script type="text/javascript" src="../../static/js/xadmin.js"></script>
<script type="text/javascript" src="../../static/js/cookie.js"></script>
<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body class="">
	<div class="x-nav">
		<span class="layui-breadcrumb"> <a href="">首页</a> <a href="">演示</a>
			<a> <cite>导航元素</cite></a>
		</span> <a class="layui-btn layui-btn-small"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			href="javascript:location.replace(location.href);" title="刷新"> <i
			class="layui-icon" style="line-height: 30px">ဂ</i></a>
	</div>
	<div class="x-body">
		<div class="layui-row">
			<div class="layui-form layui-col-md12 x-so">
				<input type="text" name="username" id="lkmname" value="${lkmname}"
					placeholder="请输入用户名" autocomplete="off" class="layui-input">
				<input type="text" name="lkmphone" id="lkmphone" value="${lkmphone}"
					placeholder="请输入手机号" autocomplete="off" class="layui-input">
				<button class="layui-btn" id="doserch" lay-submit=""
					lay-filter="sreach">
					<i class="layui-icon">&#xe615;</i>
				</button>
				<a class="layui-btn" href="/CustomerController/getCusMore?cid=${id}">返回</a>
			</div>
		</div>
		<xblock>
		<button class="layui-btn"
			onclick="x_admin_show('添加联系人','/linkman/toAddLink?id=${id}')">
			<i class="layui-icon"></i>添加
		</button>

		</xblock>
		<table class="layui-table"
			lay-data="{url:'/linkman/list?id=${id }',page:true,toolbar: '#toolbarDemo',id:'test',request:{pageName:'page',limitName:'limit'}}"
			lay-filter="test">
			<thead>
				<tr>
					<th lay-data="{type:'checkbox'}">ID</th>
					<th lay-data="{field:'lkmid', width:80, sort: true}">ID</th>
					<th
						lay-data="{field:'lkmname', width:300, sort: true, edit: 'text'}">联系人姓名</th>
					<th
						lay-data="{field:'lkmphone', width:300,sort: true, edit: 'text'}">手机号</th>
					<th lay-data="{field:'lkmsex', width:300, sort: true,edit: 'text'}">性别</th>
					<th
						lay-data="{fixed: 'right', title:'操作', toolbar: '#barDemo', width:280}"></th>
				</tr>
			</thead>
		</table>

	</div>
	<script type="text/html" id="toolbarDemo">
      <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>
        <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
        <button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>
      </div>
    </script>
	<script type="text/html" id="switchTpl">
      <!-- 这里的 checked 的状态只是演示 -->
      <input type="checkbox" name="sex" value="{{d.id}}" lay-skin="switch" lay-text="女|男" lay-filter="sexDemo" {{ d.id == 10003 ? 'checked' : '' }}>
    </script>
	<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
	<script>
		layui.use('laydate', function() {
			var laydate = layui.laydate;

			//执行一个laydate实例
			laydate.render({
				elem : '#start' //指定元素
			});

			//执行一个laydate实例
			laydate.render({
				elem : '#end' //指定元素
			});

		});
	</script>
	<script>
		layui.use('table', function() {
			var table = layui.table, $ = layui.$;
			//监听行工具事件
			table.on('tool(test)', function(obj) {
				var data = obj.data;
				//console.log(obj)
				if (obj.event === 'del') {
					$.post("${pageContext.request.contextPath}/linkman/del", {
						lkmid : data.lkmid
					}, function(data) {
						if (data) {
							layer.confirm('真的删除行么', function(index) {
								obj.del();
								layer.close(index);
							});
						}
					}, "json");

				}
			});
			$('#doserch').on('click', function() {
				// 搜索条件
				var lkmname = $('#lkmname').val();
				var lkmphone = $('#lkmphone').val();
				table.reload('test', {
					method : 'post',
					where : {
						"lkmname" : lkmname,
						"lkmphone" : lkmphone
					},
					page : {
						curr : 1
					}
				});
			});

			//监听单元格编辑
			table.on('edit(test)', function(obj) {
				var value = obj.value //得到修改后的值
				, data = obj.data //得到所在行所有键值
				, field = obj.field; //得到字段
				$.post("${pageContext.request.contextPath}/linkman/update", {
					lkmid : data.lkmid,
					field : field,
					value : value
				}, function(date) {
					if (date) {
						layer.msg('[ID: ' + data.id + '] ' + field + ' 字段更改为：'
								+ value);
					} else {
						layer.msg("修改失败");
					}
				}, "json");

			});

			//头工具栏事件
			table.on('toolbar(test)', function(obj) {
				var checkStatus = table.checkStatus(obj.config.id);
				switch (obj.event) {
				case 'getCheckData':
					var data = checkStatus.data;
					layer.alert(JSON.stringify(data));
					break;
				case 'getCheckLength':
					var data = checkStatus.data;
					layer.msg('选中了：' + data.length + ' 个');
					break;
				case 'isAll':
					layer.msg(checkStatus.isAll ? '全选' : '未全选');
					break;
				}
				;
			});
		});
	</script>
	<script>
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