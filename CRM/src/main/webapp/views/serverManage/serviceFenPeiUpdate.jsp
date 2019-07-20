<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	  @import url("/static/css/serverManageCss/newService.css");
	  @import url("css/163css.css");
	  @import url("css/style.css");
</style>
    <script type="text/javascript" src="/static/js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="/static/js/jquery.validate.js"></script>
	<script type="text/javascript" src="/static/kindeditor/kindeditor-all-min.js"></script>
	<script type="text/javascript" src="/static/kindeditor/lang/zh-CN.js"></script>
</head>
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
		
	<form action="/sercj/update" method="post" enctype="multipart/form-data" id="form1">
		  <div id="header" >
			<input id="input2" type="submit" value="提交" style="cursor:pointer">
			
		</div>
		  	 <table id="chuangjian" style="width:100%;height:100%">
		  	 	<tr>
		  	 		<td>编号</td>
		  	 		<td name="id" colspan="3">${sercj.id}</td>
		  	 		<input type="hidden" name="id" value="${sercj.id}"/>
		  	 	</tr>
		  	 	
		  	 	<tr>
		  	 		<td>概要</td>
		  	 		<td colspan="3">${sercj.description}</td>
		  	 	</tr>
		  	 	
		  	 	<tr>
		  	 		<td>客户:</td>
		  	 		<td>${sercj.custom}</td>
		  	 		<td>状态</td>
		  	 		<td><input class="input1" type="text" value="新创建" readonly="readonly" style="width:100%" /></td>
		  	 	</tr>
		  	 	
		  	 	<tr>
		  	 		<td>服务请求</td>
		  	 		<td colspan="3"><textarea id="editor_id" name="req" style="width:100%;height:300px" placeholder="请输入内容">
		  	 		    ${sercj.req}
		  	 		</textarea></td>
		  	 		
		  	 	</tr>
		  	 	<tr>
		  	 	<td>分配人</td>
		  	 	<td><input name="cname" class="input1" type="text" style="width:100%" value="<shiro:principal property="name" />" readonly="readonly"/></td>
		  	 	</tr>
		  	 	<tr>
		  	 		<td>分配给专人</td>
		  	 		<td>
		  	 			
		  	 			<select name="fname">
		  	 				<c:forEach items="${fenlist}" var="fen">
		  	 				<option value="${fen.id}">${fen.name}</option>
		  	 				</c:forEach>
		  	 			</select>
		  	 			
		  	 		</td>
		  	 		<td>分配时间</td>
		  	 		<td><input class="input1" type="text" value="${ctime}" name="ctime" style="width:100%" readonly="readonly"/></td>
		  	 	</tr>
		  	 </table>
		  	
		  </form>
	</body>
</html>