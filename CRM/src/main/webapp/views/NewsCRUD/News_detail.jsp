<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>用户增加</title>
<script type="text/javascript" src="../../static/layui/layui.all.js"></script>
<script type="text/javascript" src="../../static/js/JQuery-3.4.js"></script>
<link rel="stylesheet" type="text/css"
	href="../../static/layui/css/layui.css" />
<link rel="stylesheet" type="text/css"
	href="../../static/layui/css/layui.modbile.css" />


</head>
<body>
  <div style="padding: 20px; background-color: #F2F2F2;">
  <div class="layui-row layui-col-space15">
    <div class="layui-col-md6">
      <div class="layui-card">
        <div class="layui-card-header">新闻作者</div>
        <div class="layui-card-body">
         ${news.writer} 
        </div>
      </div>
    </div>
    <div class="layui-col-md6">
      <div class="layui-card">
        <div class="layui-card-header">发布时间</div>
        <div class="layui-card-body">
          ${news.birthday} 
        </div>
      </div>
    </div>
    <div class="layui-col-md12">
      <div class="layui-card">
        <div class="layui-card-header"> <strong>新闻标题</strong></div>
        <div class="layui-card-body">
          ${news.title}
        </div>
      </div>
    </div>
  </div>
  <div class="layui-col-md12">
      <div class="layui-card">
        <div class="layui-card-header"><strong>新闻内容</strong>  </div>
        <div class="layui-card-body">
          ${news.content}
        </div>
      </div>
    </div>
  </div>
  
  
  
</div> 
</body>
<script type="text/javascript">
layui.use(['element', 'layer'], function(){
  var element = layui.element;
  var layer = layui.layer;
 })
</script>
</html>
