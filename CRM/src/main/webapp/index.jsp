<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!doctype html>
<html  class="x-admin-sm">
<head>
	<meta charset="UTF-8">
	<title id="tit">客户管理系统</title>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="stylesheet" href="static/css/font.css">
	<link rel="stylesheet" href="static/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript"src="https://cdn.bootcss.com/blueimp-md5/2.10.0/js/md5.min.js"></script>
    <script src="static/lib/layui/layui.js" charset="utf-8"></script>

    <script type="text/javascript" src="static/js/xadmin.js"></script>
    <script type="text/javascript" src="static/js/cookie.js"></script>
    <script>
        $(function(){
        	$.get(
    				"websystem/message",
    				{},
    				function(d){
    					$("#tit").html(d.title);
    					$("#name").html("<img style='width:30px;height:30px;padding:5px;' src='../../"+d.syslogoip+"'>"+d.systemname);
    					$("#copyright").html(d.copyright);
    					
    				},
    				"json"
    			)
        })
    </script>
</head>
<body>
    <!-- 顶部开始 -->
    <div class="container">
        <div class="logo"><a href="./index.html"><span id="name">客户管理系统</span></a></div>
        <div class="left_open">
            <i title="展开左侧栏" class="iconfont">&#xe699;</i>
        </div>
        <ul class="layui-nav left fast-add" lay-filter="">
          <li class="layui-nav-item">
            <a href="javascript:;">+新增</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
              <dd><a onclick="x_admin_show('资讯','https://www.baidu.com')"><i class="iconfont">&#xe6a2;</i>资讯</a></dd>
              <dd><a onclick="x_admin_show('图片','https://www.baidu.com')"><i class="iconfont">&#xe6a8;</i>图片</a></dd>
               <dd><a onclick="x_admin_show('用户 最大化','https://www.baidu.com','','',true)"><i class="iconfont">&#xe6b8;</i>用户最大化</a></dd>
               <dd><a onclick="x_admin_add_to_tab('在tab打开','https://www.baidu.com',true)"><i class="iconfont">&#xe6b8;</i>在tab打开</a></dd>
            </dl>
          </li>
        </ul>
        <ul class="layui-nav right" lay-filter="">
          <li class="layui-nav-item">
            <a href="javascript:;"><shiro:principal property="name" /></a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
              <dd><a onclick="x_admin_show('个人信息','http://www.baidu.com')">个人信息</a></dd>
              <dd><a onclick="x_admin_show('切换帐号','http://www.baidu.com')">切换帐号</a></dd>
              <dd><a href="/logout">退出</a></dd>
            </dl>
          </li>
          <li class="layui-nav-item to-index"><a href="/">前台首页</a></li>
        </ul>
        
    </div>
    <!-- 顶部结束 -->
    <!-- 中部开始 -->
     <!-- 左侧菜单开始 -->
    <div class="left-nav">
      <div id="side-nav">
        <ul id="nav">
        <shiro:hasPermission name="marketing:index">
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6b8;</i>
                    <cite>营销管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li date-refresh="1">
                        <a _href="/views/chance/ManageSales.jsp">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>营销机会管理</cite>
                            
                        </a>
                    </li >
                    <li>
                        <a _href="/plan/getManager">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>客户开发计划</cite>
                            
                        </a>
                    </li >
                </ul>
            </li>
            </shiro:hasPermission>
            <shiro:hasPermission name="customer:index">
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe723;</i>
                    <cite>客户管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="/CustomerController/list?page=1&limit=5">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>客户信息管理</cite>
                        </a>
                    </li >
                    <shiro:hasRole name="3">
                    <li>
                        <a _href="views/customer/lostlist.jsp">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>客户流失管理</cite>
                        </a>
                    </li >
                    </shiro:hasRole>
                </ul>
            </li>
            </shiro:hasPermission>
            <shiro:hasPermission name="server:index">
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe723;</i>
                    <cite>服务管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                 <shiro:hasPermission name="service:create">
                    <li>
                        <a _href="sercj/save">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>服务创建</cite>
                        </a>
                    </li >
                    </shiro:hasPermission>
                    <shiro:hasPermission name="service:give">
                    <li>
                        <a _href="sercj/list">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>服务分配</cite>
                        </a>
                    </li >
                    </shiro:hasPermission>
                    <shiro:hasPermission name="service:handle">
                    <li>
                        <a _href="sercj/fplist">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>服务处理</cite>
                        </a>
                    </li >
                    </shiro:hasPermission>
                     <shiro:hasPermission name="service:feedback">
                    <li>
                        <a _href="service/list">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>服务反馈</cite>
                        </a>
                    </li >
                    </shiro:hasPermission>
                     <shiro:hasPermission name="service:file">
                    <li>
                        <a _href="service/listGuidang">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>服务归档</cite>
                        </a>
                    </li >
                    </shiro:hasPermission>
                </ul>
            </li>
            </shiro:hasPermission>
            <shiro:hasPermission name="offer:index">
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe723;</i>
                    <cite>报价管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                	<shiro:hasRole name="3">
                    <li>
                        <!-- <a _href="views/offer/offerAdd.jsp"> -->
                        <a _href="http://localhost:8080/offer/gotoAddOffer">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>报价创建</cite>
                        </a>
                    </li>
                    </shiro:hasRole>
                    <li>
                        <a _href="views/offer/offerList.jsp">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>报价列表</cite>
                        </a>
                    </li>
                </ul>
            </li>
           	</shiro:hasPermission>
           	<shiro:hasPermission name="forms:index">
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe723;</i>
                    <cite>统计报表</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="views/Count-table/CustomerOrders.jsp">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>客户贡献分析</cite>
                        </a>
                    </li >
                    <li>
                       <a _href="views/Count-table/customer-constitute.jsp">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>客户构成分析</cite>
                       </a>
                    </li>
                    <li>
                        <a _href="views/Count-table/SS.jsp">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>客户服务分析</cite>
                        </a>
                    </li >
                    <li>
                         <a _href="views/Count-table/table_userlost.jsp">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>客户流失分析</cite>
                        </a>
                    </li >
                   
                </ul>
            </li>
            </shiro:hasPermission>
            <shiro:hasPermission name="data:index">
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe726;</i>
                    <cite>基础数据</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                     <li>
                        <a _href="views/Goods.jsp">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>查询产品信息</cite>
                        </a>
                    </li >
                </ul>
            </li>
            </shiro:hasPermission>
            <shiro:hasPermission name="power:index">
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6ce;</i>
                    <cite>权限管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="/views/user/userAdmin.jsp">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>用户管理</cite>
                        </a>
                    </li >
                    <li>
                        <a _href="/views/role/user-list.jsp">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>角色管理</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="/power/list">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>权限分配</cite>
                        </a>
                    </li>
                </ul>
            </li>
             </shiro:hasPermission>
             <shiro:hasPermission name="news:index">
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6b4;</i>
                    <cite>新闻管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="/views/newsType/img-list.jsp">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>轮播管理</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="/views/newsType/typeone-list.jsp">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>新闻分类管理</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="views/news.jsp">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>新闻管理</cite>
                        </a>
                    </li>
                </ul>
            </li>
             </shiro:hasPermission>
             <shiro:hasPermission name="system:index">
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6b4;</i>
                    <cite>系统管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="websystem/show?m=show" target="_blank">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>自定义设置</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="views/datasource/dataSourceManager.jsp">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>数据库管理</cite>
                        </a>
                    </li>
                    <li>
                        <a _href="client/proshow">
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>数据库连接设置</cite>
                        </a>
                    </li>
                </ul>
            </li>
            </shiro:hasPermission>
        </ul>
      </div>
    </div>
    <!-- <div class="x-slide_left"></div> -->
    <!-- 左侧菜单结束 -->
    <!-- 右侧主体开始 -->
    <div class="page-content">
        <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
          <ul class="layui-tab-title">
            <li class="home"><i class="layui-icon">&#xe68e;</i>我的桌面</li>
          </ul>
          <div class="layui-unselect layui-form-select layui-form-selected" id="tab_right">
                <dl>
                    <dd data-type="this">关闭当前</dd>
                    <dd data-type="other">关闭其它</dd>
                    <dd data-type="all">关闭全部</dd>
                </dl>
          </div>
          <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <iframe src='views/welcome.html' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
            </div>
          </div>
          <div id="tab_show"></div>
        </div>
    </div>
    <div class="page-content-bg"></div>
    <!-- 右侧主体结束 -->
    <!-- 中部结束 -->
    <!-- 底部开始 -->
    <div class="footer">
        <div class="copyright"><span id="copyright">Copyright ©2017 x-admin</span><!-- Copyright ©2017 x-admin --> v2.3 All Rights Reserved</div>  
    </div>
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