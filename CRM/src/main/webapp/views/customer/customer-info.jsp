<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html class="x-admin-sm">

<head>
<meta charset="UTF-8">
<title>customer-info</title>
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

<body>
	<div class="x-body">
		<form class="layui-form">
			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> 公司名称： </label>
				<div class="layui-input-inline">
					<label for="username" class="layui-form-label">
						${customer.cusname } </label>
				</div>
				<label for="username" class="layui-form-label"> 所在大区： </label>
				<div class="layui-input-inline">
					<label for="username" class="layui-form-label">
						${customer.cusregion } </label>
				</div>
				<label for="username" class="layui-form-label"> 详细地址： </label>
				<div class="layui-input-inline">
					<label for="username" class="layui-form-label">
						${customer.cusaddr } </label>
				</div>
				<%-- <img style="width:100px;height:200px;" src="${customer.logo }" alt=""/> --%>
			</div>
			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> 添加时间： </label>
				<div class="layui-input-inline">
					<label for="username" class="layui-form-label">
						${customer.cuscreatetime } </label>
				</div>
				<label for="username" class="layui-form-label"> 公司传真： </label>
				<div class="layui-input-inline">
					<label for="username" class="layui-form-label">
						${customer.cusfax } </label>
				</div>
				<label for="username" class="layui-form-label"> 公司邮编： </label>
				<div class="layui-input-inline">
					<label for="username" class="layui-form-label">
						${customer.cuszip } </label>
				</div>
			</div>
			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> 公司网站： </label>
				<div class="layui-input-inline">
					<label for="username" class="layui-form-label">
						${customer.cuswebsite } </label>
				</div>
				<label for="username" class="layui-form-label"> 法人代表： </label>
				<div class="layui-input-inline">
					<label for="username" class="layui-form-label">
						${customer.chieftain } </label>
				</div>
			</div>
			

			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> 公司银行： </label>
				<div class="layui-input-inline">
					<label for="username" class="layui-form-label">
						${customer.bank } </label>
				</div>
				<label for="username" class="layui-form-label"> 银行账户： </label>
				<div class="layui-input-inline">
					<label for="username" class="layui-form-label">
						${customer.bankacount } </label>
				</div>
			</div>
			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> 客户信誉： </label>
				<div class="layui-input-inline">
					<label for="username" class="layui-form-label">
						${customer.cuscredi }星 </label>
				</div>
				<label for="username" class="layui-form-label"> 满意度： </label>
				<div class="layui-input-inline">
					<label for="username" class="layui-form-label">
						${customer.cussati }星 </label>
				</div>
			</div>
			<hr class="layui-bg-orange">
			<label for="username" class="layui-form-label"> <span
				class="x-red">客户经理：</span>
			</label>
			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> 编号： </label>
				<div class="layui-input-inline">
					<label for="username" class="layui-form-label"> ${user.id }
					</label>
				</div>
				<label for="username" class="layui-form-label"> 姓名： </label>
				<div class="layui-input-inline">
					<label for="username" class="layui-form-label"> ${user.name }
					</label>
				</div>
			</div>
			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> 手机号： </label>
				<div class="layui-input-inline">
					<label for="username" class="layui-form-label">
						${user.phone } </label>
				</div>
				<label for="username" class="layui-form-label"> 邮箱： </label>
				<div class="layui-input-inline">
					<label for="username" class="layui-form-label">
						${user.email } </label>
				</div>
			</div>
			<hr class="layui-bg-green">
			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> <span
					class="x-red">联系人信息：</span>
				</label>
				<a class="layui-btn" href="/linkman/toLink?id=${customer.id }">操作</a>
				<table class="layui-table" lay-skin="nob" lay-even="">
					<colgroup>
						<col width="150">
						<col width="150">
						<col width="200">
						<col>
					</colgroup>
					<thead>
						<tr>
							<th>姓名</th>
							<th>性别</th>
							<th>电话</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${linklist }" var="m">
							<tr>
								<th>${m.lkmname }</th>
								<th>${m.lkmsex }</th>
								<th>${m.lkmphone }</th>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<hr class="layui-bg-cyan">
			<div class="layui-form-item">
				<label for="username" class="layui-form-label"><span
					class="x-red">交往记录：</span> </label>
					<a class="layui-btn" href="/contact/list?id=${customer.id }">操作</a>
				<table class="layui-table" lay-skin="nob" lay-even="">
					<colgroup>
						<col width="150">
						<col width="150">
						<col width="200">
						<col>
					</colgroup>
					<thead>
						<tr>
							<th>时间</th>
							<th>地点</th>
							<th>业务</th>
							<th>备注</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${conlist}" var="c">
							<tr>
								<th>${c.condate }</th>
								<th>${c.conAddr }</th>
								<th>${c.conIfno }</th>
								<th>${c.conRemark }</th>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

		</form>
	</div>


</body>

</html>