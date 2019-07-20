<%@page import="java.util.function.Function"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.1</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="stylesheet" href="../static/css/font.css">
    <link rel="stylesheet" href="../static/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="../static/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="../static/js/xadmin.js"></script>
    <script type="text/javascript" src="../static/js/cookie.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  
  <body>
    <div class="x-body">
        <form action="/power/RolePowerEdit" method="post" class="layui-form layui-form-pane">
        <input type="hidden" name="id" value="${role.id}">
                <div class="layui-form-item">
                    <label  class="layui-form-label">
                    <!-- lable 中的for="name" -->
                        <span class="x-red">*</span>角色名
                    </label>
                    <div class="layui-input-inline">
                        <input type="text" readonly="readonly" id="name" name="name" class="layui-input" value="${role.name}">
                        <!-- 在上方text  中的name 与 class 之间
                         required="" lay-verify="required"
                        autocomplete="off" --> 
                    </div>
                </div>
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">
                        	拥有权限
                    </label>
                    <table  class="layui-table layui-input-block">
                        <tbody>
                                <c:forEach items="${powerList}" var="power">
                                <tr>
                                <td>
                               <%-- <c:forEach items="${idList}" var="idList">
                                	 <c:if test="${power.id == idList.id}"> 
                                	 <c:set var="b" value="${false}"/> 
                                	<input type="checkbox"   name="powers" lay-skin="primary" lay-filter="father" title="${idList.name}" value="${idList.name}"  />
                                	 </c:if> 
                                </c:forEach> --%>
                               <input type="checkbox" name="powers" lay-skin="primary" lay-filter="father" title="${power.name}"  value="${power.name}"
                              <c:forEach items="${idList}" var="idList">
                              <c:if test="${power.id == idList.id}"> 
                              checked="checked"
                              </c:if> 
                              </c:forEach>
                              > 
                              
                              
                               
                                </td>
                                
                                
                                <td>
                                    <div class="layui-input-block">
                                    	<c:forEach items="${sonList}" var="sonPower">
                                    	<c:if test="${sonPower.parent_id == power.id}">
                                        <input name="powers" lay-skin="primary" type="checkbox" title="${sonPower.name}" value="${sonPower.name}"
                                         <c:forEach items="${idList}" var="idList">
                                          <c:if test="${sonPower.id == idList.id}">
                                          checked="checked"
                                          </c:if> 
                                          </c:forEach>
                                        >
                                        </c:if>
                                        </c:forEach>
                                    </div>
                                </td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="layui-form-item layui-form-text">
                    <label for="des" class="layui-form-label">
                        描述
                    </label>
                    <div class="layui-input-block">
                        <textarea placeholder="请输入内容" id="des" readonly="readonly" name="des" class="layui-textarea">${role.des}</textarea>
                    </div>
                </div>
                <div class="layui-form-item">
                <button class="layui-btn" lay-submit="" lay-filter="add">修改</button>
              </div>
            </form>
    </div>
    
   
    <script>
    //全选
        layui.use(['form','layer'], function(){
            $ = layui.jquery;
          var form = layui.form
          ,layer = layui.layer;
        
        /*    //自定义验证规则
           form.verify({
            nikename: function(value){
              if(value.length < 5){
                return '昵称至少得5个字符啊';
              }
            }
            ,pass: [/(.+){6,12}$/, '密码必须6到12位']
            ,repass: function(value){
                if($('#L_pass').val()!=$('#L_repass').val()){
                    return '两次密码不一致';
                }
            }
          }); */  
 
          /*  //监听提交
          form.on('submit(add)', function(data){
            console.log(data);
            //发异步，把数据提交给php
            layer.alert("增加成功", {icon: 6},function () {
                // 获得frame索引
                var index = parent.layer.getFrameIndex(window.name);
                //关闭当前frame
                parent.layer.close(index);
            });
            return false;
          });   */


          //全选规则
         form.on('checkbox(father)', function(data){

            if(data.elem.checked){
                $(data.elem).parent().siblings('td').find('input').prop("checked", true);
                form.render(); 
            }else{
               $(data.elem).parent().siblings('td').find('input').prop("checked", false);
                form.render();  
            }
        });
          
          
        }); 
    </script>
     <script>var _hmt = _hmt || []; (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
      })();</script> 
  </body>

</html>