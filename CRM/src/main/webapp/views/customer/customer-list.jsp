<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html>
<html class="x-admin-sm">
<head>
<meta charset="UTF-8">
<title>客户信息列表</title>
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
<%-- <base href="${pageContext.request.contextPath}"/> --%>
<script>
function query(curPage) {
		location.href="/CustomerController/list?page="+curPage+"&limit=5";
	}
</script>
</head>

<body>
	<div class="x-nav">
		<span class="layui-breadcrumb"> <a href="">首页</a> <a href="">客户管理</a>
			<a> <cite>客户信息管理</cite></a>
		</span> <a class="layui-btn layui-btn-small"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			href="javascript:location.replace(location.href);" title="刷新"> <i
			class="layui-icon" style="line-height: 30px">ဂ</i></a>
	</div>
	<div class="x-body">
		<!-- <div class="layui-row">
			<form class="layui-form layui-col-md12 x-so">
				<input class="layui-input" autocomplete="off" placeholder="开始日"
					name="start" id="start"> <input class="layui-input"
					autocomplete="off" placeholder="截止日" name="end" id="end"> <input
					type="text" name="username" placeholder="请输入用户名" autocomplete="off"
					class="layui-input">
				<button class="layui-btn" lay-submit="" lay-filter="sreach" >
					<i class="layui-icon">&#xe615;</i>
				</button>
				<a href="">d</a>
			</form>
		</div> -->
		<!-- 		<xblock> -->
		<!-- <button class="layui-btn layui-btn-danger" onclick="delAll()">
			<i class="layui-icon"></i>批量删除
		</button> -->
		<shiro:hasPermission name="customer:add">
		<button class="layui-btn" onclick="x_admin_show('添加客户','/CustomerController/addPage',1000,500)">
			添加
		</button>
		</shiro:hasPermission>
		<span class="x-right" style="line-height: 40px">共有数据：${count }条</span>
		</xblock>
		<table class="layui-table x-admin">
			<thead>
				<tr>
					<th>
						<div class="layui-unselect header layui-form-checkbox"
							lay-skin="primary">
							<i class="layui-icon">&#xe605;</i>
						</div>
					</th>
					<th style="text-align: center;">客户编号</th>
					<th style="text-align: center;">公司名称</th>
					<th style="text-align: center;">所在大区</th>
					<th style="text-align: center;">公司地址</th>
					<th style="text-align: center;">公司传真</th>
					<th style="text-align: center;">添加时间</th>
					<th style="text-align: center;">公司网站</th>
					<th style="text-align: center;">法人名称</th>
					<th style="text-align: center;">机会状态</th>
					<th style="text-align: center;">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${cusList }" var="c">
					<tr>
						<td>
							<div class="layui-unselect layui-form-checkbox"
								lay-skin="primary" data-id='2'>
								<i class="layui-icon">&#xe605;</i>
							</div>
						</td>
						<td style="text-align: center;">${c.cusid }</td>
						<td style="text-align: center;">${c.cusname }</td>
						<td style="text-align: center;">${c.cusregion }</td>
						<td style="text-align: center;">${c.cusaddr }</td>
						<td style="text-align: center;">${c.cusfax }</td>
						<td style="text-align: center;">${c.cuscreatetime }</td>
						<td style="text-align: center;">${c.cuswebsite }</td>
						<td style="text-align: center;">${c.chieftain }</td>
						<td style="text-align: center;" class="td-status"><span
							title="${c.cusstatus }"
							class="layui-btn layui-btn-normal layui-btn-mini"
							onclick="member_stop(this,'${c.id}')"> 
							<c:if test="${c.cusstatus == 1}">标准客户</c:if> 
							<c:if test="${c.cusstatus == 2}">机会客户</c:if>
						</span></td>
						<td style="text-align: center;" class="td-manage"><span
							class="layui-btn"
							onclick="x_admin_show('客户详细信息','/CustomerController/getCusMore?cid=${c.id}',1200,600)">
								详情 </span> 
								<shiro:hasPermission name="customer:update">
								<span class="layui-btn"
							onclick="x_admin_show('修改客户信息','/CustomerController/editCus?cid=${c.id}',1200,600)">
								修改 </span>
								</shiro:hasPermission> 
								<shiro:hasPermission name="customer:delete">
								<span class="layui-btn" onclick="member_del(this,${c.id})">
								删除 </span>
								</shiro:hasPermission>
								</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="page">
			
			<div>
				<table>
				<tr>
					<td colspan="4">
					<span>${pageInfo.pageNum}/${pageInfo.pages }</span>
						<button class="layui-btn" onclick="query(1)">首页</button>
						<button class="layui-btn"  onclick="query(${pageInfo.prePage})">上一页</button> <c:forEach
							items="${pageInfo.navigatepageNums }" var="p">
							<button class="layui-btn" onclick="query(${p})">${p }</button>
						</c:forEach>
						<button class="layui-btn" onclick="query(${pageInfo.nextPage})">下一页</button>
						<button class="layui-btn" onclick="query(${pageInfo.pages})">尾页</button>
					</td>
				</tr>
			</table>
			</div>
		</div>

	</div>
	<script>
	function to(i) {
		location.href="${pageContext.request.contextPath}/CustomerController/list"
	}
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


		/*用户-停用*/
		function member_stop(obj, id) {
			layer.confirm('确认要更改客户状态吗？', function(index) {

				if ($(obj).attr('title') == 1) {
					
					//发异步把用户状态进行更改
					 $.post(
						"/CustomerController/changeStatu",
						{
							cid:id
						},
						function(date){},
						"json"
					); 
					$(obj).attr('title', '2');
					$(obj).find('i').html('&#xe62f;');

					$(obj).parents("tr").find(".td-status").find('span').html('机会客户');
					layer.msg('已完成!', {
						icon : 5,
						time : 1000
					});

				} else {
					
					$.post(
							"/CustomerController/changeStatu",
							{
								cid:id
							},
							function(date){},
							"json"
						); 
					$(obj).attr('title', '1')
					$(obj).find('i').html('&#xe601;');

					$(obj).parents("tr").find(".td-status").find('span').html('标准客户');
					layer.msg('已完成!', {
						icon : 5,
						time : 1000
					});
				}

			});
		}
		function member_selectById(obj, id){
			alert(obj);
			location.href="/CustomerController/getById";
		}
		/*用户-删除*/
		function member_del(obj, id) {
			layer.confirm('确认要删除吗？', function(index) {
				//发异步删除数据
				$.post(
					"/CustomerController/del",
					{
						cid:id
					},
					function(data){
					},
					"json"
				);
				$(obj).parents("tr").remove();
				layer.msg('已删除!', {
					icon : 1,
					time : 1000
				});
				
			});
		}

		function delAll(argument) {

			var data = tableCheck.getData();

			layer.confirm('确认要删除吗？' + data, function(index) {
				//捉到所有被选中的，发异步进行删除
				layer.msg('删除成功', {
					icon : 1
				});
				$(".layui-form-checked").not('.header').parents('tr').remove();
			});
		}
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