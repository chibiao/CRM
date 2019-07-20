<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="UTF-8">
 <base href="<%=basePath%>">
    <title>欢迎页面-X-admin2.1</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="stylesheet" href="./static/css/font.css">
    <link rel="stylesheet" href="./static/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="./static/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./static/js/xadmin.js"></script>
    <script type="text/javascript" src="./static/js/cookie.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  
  <body>
    
    <div class="x-body">
      <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" method="post" action="/power/list">
          <input class="layui-input" type="text"   placeholder="请输入权限名" autocomplete="off" name="name" id="name" value="${name}">
          <button class="layui-btn"  lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
        </form>
      </div>
      <xblock>
        
        <button class="layui-btn" onclick="x_admin_show('添加角色','./power/toaddRole')"><i class="layui-icon"></i>添加</button>
        <span class="x-right" style="line-height:40px">共有数据：${pageInfo.total} 条</span>
      </xblock>
      <table class="layui-table">
        <thead>
          <tr>
            
            <th>ID</th>
            <th>角色名</th>
            <th>描述</th>
            <th>操作</th>
        </thead>
        <tbody>
          <c:forEach items="${roleList}" var ="role">
          <tr>
          
            <td>${role.id}</td>
            <td>${role.name}</td>
            <td>${role.des}</td>
            <td class="td-manage">
              <a title="编辑" class="layui-btn layui-btn-sm" onclick="x_admin_show('修改','./power/toRolePowerEdit?id='+${role.id})" href="javascript:;" >
 					
                <i class="layui-icon">&#xe642;</i>
              </a>
  
              <%--  <a title="删除" onclick="del(${role.id})"  class="layui-btn layui-btn-sm">
                  <i class="layui-icon">&#xe640;</i>
              </a> --%>
            </td>
          </tr>
          </c:forEach>
        </tbody>
      </table>
      <div class="page">
      	<button class="layui-btn layui-btn-sm" onclick="fenye(1)">首页</button>
	<button class="layui-btn layui-btn-sm" onclick='fenye(${pageInfo.prePage})'>上一页</button>
	
        <c:forEach begin="1" end="${pageInfo.pages}" var="s">
			<button class="layui-btn layui-btn-sm" onclick="fenye('${s}')">第${s}页</button>
		</c:forEach>
		<button class="layui-btn layui-btn-sm" onclick='fenye(${pageInfo.nextPage})'>下一页</button>
	<button  class="layui-btn layui-btn-sm" onclick='fenye(${pageInfo.navigateLastPage})'>尾页</button>
      </div>
      

    </div>
    <script>
      /*用户-删除*/
     function del(id) {
    	  if(confirm("是否确认删除 "+id+"的信息")){
  			location.href="power/"+id+"/deleteRole";
  		}
	}
      
   //分页跳转
     function fenye(curPage) {
     	var name = document.getElementById("name").value;
     	
     	 
     	location.href="/power/list?curpage="+curPage+"&name="+name;
     }

    </script>
    <!-- <script>var _hmt = _hmt || []; (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
      })();</script> --> 
  </body>

</html>