<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/static/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="../../static/css/font.css">
	<link rel="stylesheet" href="../../static/css/xadmin.css">
	<script type="text/javascript"
		src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript" src="../../static/lib/layui/layui.js"
		charset="utf-8"></script>
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
    <script type="text/javascript" src="../../static/js/xadmin.js"></script>
	<script type="text/javascript" src="../../static/js/cookie.js"></script>
</head>
<body>
<table class="layui-hide" id="test" lay-filter="test">
</table>
<script type="text/html" id="barDemo1">
    <a class="layui-btn layui-btn-xs" lay-event="edit">执行计划</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script type="text/html" id="toolbarDemo">
    <span class="layui-btn layui-btn-warm layui-btn-mini">待开发</span>
</script>
<script type="text/html" id="barDemo">
	<a class="layui-btn	layui-btn-normal layui-btn-xs" lay-event="addCustomer">添加为客户</a>
    <a class="layui-btn layui-btn-xs" lay-event="add">添加计划</a>
    <a class="layui-btn layui-btn-xs" lay-event="look">查看计划</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<form class="layui-form" id="addCustomer"  lay-filter="addCustomer" style="display: none" method="post">
			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> <span
					class="x-red"></span>
				</label>
				<div class="layui-input-inline">
					<input type="hidden" id="chanceid" name="chanceid" required="" class="layui-input">
				</div>
				<label for="username" class="layui-form-label"> <span
					class="x-red">*</span>公司名称
				</label>
				<div class="layui-input-inline">
					<input type="text" id="cusname" name="cusname" required=""
						lay-verify="required" autocomplete="off" class="layui-input" readonly="readonly">
				</div>
				<label for="username" class="layui-form-label"> <span
					class="x-red">*</span>创建时间
				</label>

			     <div class="layui-input-inline">
			       <input class="layui-input" name="cuscreatetime" id="getdate" type="text" placeholder="年-月-日" readonly="readonly">
			     </div>

			</div>
			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> <span
					class="x-red">*</span>所在大区
				</label>
				<div class="layui-input-inline">
					<select name="cusregion" type="text" lay-verify="required">
						<option value="">请选择</option>
						<option value="华北地区">华北地区</option>
						<option value="华东地区">华东地区</option>
						<option value="华南地区">华南地区</option>
						<option value="华中地区">华中地区</option>
						<option value="西南地区">西南地区</option>
						<option value="西北西北">西北地区</option>
						<option value="东北地区">东北地区</option>
					</select>
				</div>
				<label for="phone" class="layui-form-label"> <span
					class="x-red">*</span>详细地址
				</label>
				<div class="layui-input-inline">
					<input type="text" id="cusaddr" name="cusaddr" required=""
						lay-verify="required" autocomplete="off" class="layui-input">
				</div>
			</div>

			<div class="layui-form-item">
				<label  class="layui-form-label"> <span
					class="x-red">*</span>选择经理
				</label>
				<div class="layui-input-inline">
					<select type="text" name="cusmanagerid" lay-verify="required" id="cusmanagerid">
						<option value="">请选择</option>
						<c:forEach items="${userlist }" var="u">
							<option value="${u.id }">${u.name }</option>
						</c:forEach>
					</select>
				</div>
				<label  class="layui-form-label"> <span
					class="x-red">*</span>客户等级
				</label>
				<div class="layui-input-inline">
					<select type="text" name="rid" lay-filter="aihao"
						lay-verify="required" id="rid">
						<option value="">请选择</option>
						<c:forEach items="${ranklist }" var="r">
							<option value="${r.rid }">${r.rname }</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> <span
					class="x-red">*</span>法人姓名
				</label>
				<div class="layui-input-inline">
					<input type="text" id="chieftain" name="chieftain" required=""
						lay-verify="required" autocomplete="off" class="layui-input">
				</div>
				<label for="username" class="layui-form-label"> <span
					class="x-red">*</span>银行账户
				</label>
				<div class="layui-input-inline">
					<input type="text" id="bank" name="bank" required=""
						lay-verify="required" autocomplete="off" class="layui-input">
				</div>
				<label for="L_email" class="layui-form-label"> <span
					class="x-red">*</span>开户号码
				</label>
				<div class="layui-input-inline">
					<input type="text" id="bankacount" name="bankacount" required=""
						lay-verify="bankacounts" autocomplete="off" class="layui-input">
				</div>

			</div>
			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> <span
					class="x-red">*</span>公司网址
				</label>
				<div class="layui-input-inline">
					<input type="text" id="cuswebsite" name="cuswebsite" required=""
						lay-verify="url" autocomplete="off" class="layui-input">
				</div>
				<label for="username" class="layui-form-label"> <span
					class="x-red">*</span>传真
				</label>
				<div class="layui-input-inline">
					<input type="text" id="cusfax" name="cusfax" required=""
						lay-verify="cusfax" autocomplete="off" class="layui-input">
				</div>
				<label for="L_email" class="layui-form-label"> <span
					class="x-red">*</span>邮政编码
				</label>
				<div class="layui-input-inline">
					<input type="text" id="cuszip" name="cuszip" required=""
						lay-verify=cuszips autocomplete="off" class="layui-input">
				</div>
			</div>

			<div class="layui-form-item layui-form-text">
				<label for="L_email" class="layui-form-label"> <span
					class="x-red">*</span>客户满意度
				</label>
				
				<div id="test14" class="layui-input-inline" name="cussati"></div>
				
				<label for="L_email" class="layui-form-label"> <span
					class="x-red">*</span>客户信用度
				</label>
				
				<div id="test1" class="layui-input-inline" name="cuscredi"></div>
				
				<label class="layui-form-label"> <span
					class="x-red">*</span>客户状态
				</label>
				<div class="layui-input-inline">
					<select type="text" name="cusstatus" lay-filter="aihao"
						lay-verify="required">
						<option value="">请选择</option>
						<option value="1">机会客户</option>
						<option value="2">标准客户</option>
					</select>
				</div>
			</div>
			<div class="layui-form-item">
				<label for="L_repass" class="layui-form-label"> </label>
				<button class="layui-btn" lay-filter="addCustomer" lay-submit="">
					增加</button>
			</div>
		</form>


<!--修改内容的form-->
<form class="layui-form" action="" lay-filter="example" style="display: none" id="editForm" method="post">
    <div class="layui-form-item">
              <label class="layui-form-label">
                  <span class="x-red"></span>计划编号
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="id" name="id" required="" placeholder="自动生成" readonly="readonly"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label class="layui-form-label">
                  <span class="x-red">*</span>客户编号
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="cusid" name="cusid" required="" lay-verify="required" readonly="readonly"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label class="layui-form-label">
                  <span class="x-red"></span>计划项
              </label>
             <div class="layui-input-inline" style="width:515px">
      			<textarea placeholder="计划内容" class="layui-textarea" id="plan" name="plan" ></textarea>
    		 </div>
          </div>
          <div class="layui-form-item">
              <label class="layui-form-label">
                  <span class="x-red"></span>计划时间
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="plantime" name="plantime" required=""
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label class="layui-form-label">
                  <span class="x-red"></span>计划反馈
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="planback" name="planback" required=""
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
              </label>
              <button  class="layui-btn" lay-filter="add" lay-submit="">
                  增加
              </button>
          </div>
</form>
<script src="/static/layui/layui.js" charset="utf-8"></script>
<script src="/static/js/chance/plan_list.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
</body>
</html>