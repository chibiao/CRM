<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<!-- <link rel="stylesheet" href="static/css/serverManageCss/newService.css" type="text/css"/> -->
	    <style type="text/css">
	  @import url("/static/css/serverManageCss/newService.css");
	  @import url("css/163css.css");
	  @import url("css/style.css");
</style>
	</head>
	<script type="text/javascript" src="/static/js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="/static/js/jquery.validate.js"></script>
	<script type="text/javascript" src="/static/kindeditor/kindeditor-all-min.js"></script>
	<script type="text/javascript" src="/static/kindeditor/lang/zh-CN.js"></script>
	<script type="text/javascript">
	$(function(){
		$("#form1").validate({
			rules:{
				description:{required:true},
				custom:"required",
			},
			messages:{
				 
			}
		});
	});	
	</script>
	<script type="text/javascript">
	KindEditor.ready(function(K) {
		window.editor = K.create('#editor_id', {
			resizeType : 0,
			allowPreviewEmoticons : false,
			allowImageUpload : false,
			uploadJson : 'kindeditor/jsp/upload_json.jsp',
			//uploadJson : "ajax/uploadImg.do",//需要加上basePath, 不然批量上传调用action时会出现路径问题 
			fileManagerJson : 'kindeditor/jsp/file_manager_json.jsp',
			allowImageUpload : true,
			allowFileManager : true,
			afterChange : function() {
				this.sync();
			}
		});
	});	
</script>
	<body>
		
	<form action="/sercj/add" method="post" enctype="multipart/form-data" id="form1">
		  <div id="header" >
			<input  class="chuangjian" type="submit" value="保存" style="color:white;background-color:#009688;width:70px;height:30px;border: 0px; cursor: pointer;float:right;margin-right:1px;margin-top:17px;margin-bottom:17px;">
		</div>
		  	 <table id="chuangjian" style="width:100%;height:100%">
		  	 	<tr>
		  	 		<td>编号</td>
		  	 		<td><input class="input1" type="text" name="id" value="${uid}" style="width:100%" readonly="readonly"/></td>
		  	 		<td>服务类型</td>
		  	 		<td>
		  	 	    <select id="select1" name="types">
		  	 			<c:forEach items="${listType}" var="type">
						<option value="${type.id}">${type.tname}</option>
					    </c:forEach>

		  	 		</select>
		  	 		</td>
		  	 	</tr>
		  	 	
		  	 	<tr>
		  	 		<td>概要</td>
		  	 		<td colspan="3"><input class="input1" type="text" value="" name="description" style="width:100%"/></td>
		  	 	</tr>
		  	 	
		  	 	<tr>
		  	 		<td>客户:</td>
		  	 		<td><input class="input1" type="text" value="" name="custom" style="width:100%" id="custom" /></td>
		  	 		<td>状态</td>
		  	 		<td><input class="input1" type="text" value="新创建" readonly="readonly" style="width:100%" /></td>
		  	 	</tr>
		  	 	
		  	 	<tr>
		  	 		<td>服务请求</td>
		  	 		<td colspan="3"><textarea id="editor_id" name="req" style="width:100%;height:300px" placeholder="请输入内容">
		  	 		    
		  	 		</textarea></td>
		  	 		
		  	 	</tr>
		  	 	
		  	 	<tr>
		  	 		<td>创建人</td>
		  	 		<td><input type="text" value="<shiro:principal property="name"/>" class="input1" name="cname" style="width:100%" readonly="readonly"/></td>
		  	 		<td>创建时间</td>
		  	 		<td><input class="input1" type="text" value="${ctime}" name="ctime" style="width:100%" readonly="readonly"/></td>
		  	 	</tr>
		  	 	
		  	 	
		  	 </table>
		  	
		  </form>
	</body>
</html>
