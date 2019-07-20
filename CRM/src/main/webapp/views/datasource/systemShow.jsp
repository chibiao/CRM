<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../../static/css/xadmin.css">
<link rel="stylesheet" type="text/css" href="../../static/css/font.css" />
<script src="../../static/js/jquery-3.3.1.js" type="text/javascript" charset="utf-8"></script>
<script src="../../static/lib/layui/layui.js" charset="utf-8"></script>
   <script type="text/javascript" src="../../static/js/xadmin.js"></script>
   <script type="text/javascript" src="../../static/js/cookie.js"></script>
<style type="text/css">
.tit{
font-size: 30px;
margin:2% auto 2% 8%;
color: #009688;
}
#tb{
 width:70%;
margin:auto;

}
#tb td{
padding-left:10px;
}
#tb input{
 width:40%;
 padding-left:10px;
height:30px;
color:#666;

}
</style>
<title>Insert title here</title>
</head>
<body>
<p class="tit">自定义设置</p>
  <table class="layui-table" id="tb" border=1 cellpadding="0" cellspacing="0">
  
<thead>
   <th>自定义项</th>
   <th>当前内容</th>
   <th>操作</th>
</thead>
<tbody>
 <tr>
   <td>系统名称</td>
   <td><input type="text" name="systemname" value="${ws.systemname}" readonly="readonly"></td>
   <td><button class="layui-btn layui-btn layui-btn-xs"  onclick="x_admin_show('编辑','../../websystem/show?m=update')" ><i class="layui-icon">&#xe642;</i>编辑</button></td>
 </tr>
 <tr>
   <td>系统logo</td>
   <td><img style="width:80px;height:80px;" src="../../${ws.syslogoip}">
   </td>
   <td><button class="layui-btn layui-btn layui-btn-xs"  onclick="x_admin_show('编辑','../../websystem/show?m=update')" ><i class="layui-icon">&#xe642;</i>编辑</button></td>
 </tr>
 <tr>
   <td>系统标题</td>
   <td><input type="text" name="title" value="${ws.title}" readonly="readonly"></td>
   <td><button class="layui-btn layui-btn layui-btn-xs"  onclick="x_admin_show('编辑','../../websystem/show?m=update')" ><i class="layui-icon">&#xe642;</i>编辑</button></td>
   
 </tr>
 <tr>
   <td>系统版权</td>
   <td><input type="text" name="copyright" value="${ws.copyright}" readonly="readonly"></td>
   <td><button class="layui-btn layui-btn layui-btn-xs"  onclick="x_admin_show('编辑','../../websystem/show?m=update')" ><i class="layui-icon">&#xe642;</i>编辑</button></td>
 </tr>
 </tbody>
</table>

</body>
</html>