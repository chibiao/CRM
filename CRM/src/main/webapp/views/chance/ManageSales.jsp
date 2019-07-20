<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/static/layui/css/layui.css" media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<table class="layui-hide" id="test" lay-filter="test"></table>
<script type="text/html" id="toolbarDemo">
    <div class="layui-inline">
        <button class="layui-btn layui-btn-sm" lay-event="addChance">新增</button>
        <div class="layui-btn-group">
            <input type="text" class="layui-btn  layui-btn-primary" id="keyword"/>
            <button type="button" class="layui-btn search" id="search">搜索</button>
        </div>
    </div>
</script>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<!--修改内容的form-->
<form class="layui-form" action="" lay-filter="example" style="display: none" id="editForm" method="post">
    <div class="layui-form-item">
        <label  class="layui-form-label">
            <span class="x-red"></span>编号
        </label>
        <div class="layui-input-inline">
            <input type="text" id="id" name="id" required="" lay-verify=""
                   autocomplete="off" class="layui-input" readonly="readonly" placeholder="自动生成">
        </div>
        <div class="layui-form-mid layui-word-aux">
            <span class="x-red">*</span>
        </div>
        <label  class="layui-form-label">
            <span class="x-red">*</span>机会来源
        </label>
        <div class="layui-input-inline">
            <input type="text" id="chancefrom" name="chancefrom" required=""
                   autocomplete="off" class="layui-input" lay-verify="required">
        </div>
        <div class="layui-form-mid layui-word-aux">
            <span class="x-red">*</span>
        </div>
    </div>
    <div class="layui-form-item">
        <label  class="layui-form-label">
            <span class="x-red">*</span>客户名称
        </label>
        <div class="layui-input-inline">
            <input type="text" id="cusname" name="cusname" required="" lay-verify="required"
                   autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux">
            <span class="x-red">*</span>
        </div>
        <label  class="layui-form-label">
            <span class="x-red">*</span>成功几率
        </label>
        <div class="layui-input-inline">
            <input type="text" id="successpro" name="successpro" required="" lay-verify="required"
                   autocomplete="off" class="layui-input" placeholder="1~100的数字">
        </div>
        <div class="layui-form-mid layui-word-aux">
        </div>
    </div>
    <div class="layui-form-item">
        <label  class="layui-form-label">
            <span class="x-red">*</span>概要
        </label>
        <div class="layui-input-inline">
            <input type="text" id="outline" name="outline" required="" lay-verify="required"
                   autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label  class="layui-form-label">
            <span class="x-red">*</span>联系人
        </label>
        <div class="layui-input-inline">
            <input type="text" id="contacts" name="contacts" required="" lay-verify="required"
                   autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux">
            &nbsp;&nbsp;
        </div>
        <label  class="layui-form-label">
            <span class="x-red">*</span>联系电话
        </label>
        <div class="layui-input-inline">
            <input type="text" id="phone" name="phone" required="" lay-verify="phone" lay-verify="required"
                   autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux">
        </div>
    </div>
    <div class="layui-form-item">
        <label  class="layui-form-label">
            <span class="x-red">*</span>机会描述
        </label>
        <div class="layui-input-inline" style="width:515px">
            <textarea placeholder="请输入内容" class="layui-textarea" id="description" name="description" lay-verify="required"></textarea>
        </div>
        <div class="layui-form-mid layui-word-aux">
        </div>
    </div>
    <div class="layui-form-item">
        <label  class="layui-form-label">
            <span class="x-red"></span>创建人
        </label>
        <div class="layui-input-inline">
            <input type="text" id="founder" name="founder" required=""
                   autocomplete="off" class="layui-input" placeholder="当前登陆用户" readonly="readonly" value="<shiro:principal property="name"/>">
        </div>
        <div class="layui-form-mid layui-word-aux">
            &nbsp;
        </div>

        <label  class="layui-form-label">
            <span class="x-red">*</span>创建时间
        </label>
        <div class="layui-input-inline">
	        <input type="text" id="creattime" name="creattime" required=""
	                   autocomplete="off" class="layui-input" placeholder="系统时间" readonly="readonly">
        </div>
        <div class="layui-form-mid layui-word-aux">
        </div>
    </div>
    <div class="layui-form-item">
        <label  class="layui-form-label">
            <span class="x-red">*</span>指派给
        </label>
        <div class="layui-input-inline">
            <select name="assignedid" id="assigned" lay-filter="aihao" lay-verify="required">
                <option value=""></option>
            </select>
        </div>
        <div class="layui-form-mid layui-word-aux">
            &nbsp;
        </div>
        <label  class="layui-form-label">
            <span class="x-red">&nbsp;*</span>指派时间
        </label>
        <div class="layui-input-inline">
            <input type="text" class="layui-input" id="assignedtime" name="assignedtime" required="" lay-verify="required date"
                   autocomplete="off">
        </div>
        <div class="layui-form-mid layui-word-aux">
        </div>
    </div>
    <div class="layui-form-item">
        <label  class="layui-form-label">
        </label>
        <button  class="layui-btn" lay-filter="add" lay-submit="">
       		     增加
        </button>
    </div>
</form>
<script src="/static/layui/layui.js" charset="utf-8"></script>
<script src="/static/js/chance/ManageSales.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
</body>
</html>