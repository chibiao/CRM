<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	@import url("/static/css/serverManageCss/serviecManageCss.css");
</style>
<script type="text/javascript">
function fanhui() {
    location.href="/service/list";
}
function baocun(id) {
    location.href="/service/save";
}
</script>
</head>
<body>
<form action="/service/save" method="post">
	<input type="button" value="帮助" class="anNiu"/>
	<button type="submit" class="anNiu">保存</button>
	<%-- <input onclick="baocun('${sercj.id}')" type="button" value="保存" class="anNiu"/> --%>
	<input onclick="fanhui()" type="button" value="返回" class="anNiu"/>
	
	<table class="tab_bottom">
		<tr>
			<td><font class="biaoTi">编号</font></td>
			<td>${sercj.id}</td>
			<input type="hidden" name="id" value="${sercj.id}"/>
			<td><font class="biaoTi">服务类型</font></td>
			<td>
				<c:forEach items="${listType}" var="type">
					<c:if test="${sercj.types==type.id}">
						${type.tname}
					</c:if>
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td><font class="biaoTi">概要</font></td>
			<td cosplan="3">${sercj.description}</td>
		</tr>
		<tr>
			<td><font class="biaoTi">客户</font></td>
			<td>${sercj.custom}</td>
			<td><font class="biaoTi">状态</font></td>
			<td>
				<c:if test="${sercj.state==0}">
					新创建
				</c:if>
				<c:if test="${sercj.state==1}">
					已分配
				</c:if>
				<c:if test="${sercj.state==2}">
					已处理
				</c:if>
				<c:if test="${sercj.state==3}">
					已归档
				</c:if>
			</td>
		</tr>
		<tr>
			<td><font class="biaoTi">服务请求</font></td>
			<td colspan="3">${sercj.req}</td>
		</tr>
		<tr>
			<td><font class="biaoTi">创建人</font></td>
			<td>${sercj.cname}</td>
			<td><font class="biaoTi">创建时间</font></td>
			<td>${sercj.ctime}</td>
		</tr>
		<tr>
			<td><font class="biaoTi">分配给</font></td>
			<td>${sercj.serfp.cname}</td>
			<td><font class="biaoTi">分配时间</font></td>
			<td>${sercj.serfp.ftime}</td>
		</tr>
		<tr>
			<td><font class="biaoTi">服务处理</font></td>
			<td colspan="3">${sercj.sercl.handle}</td>
		</tr>
		<tr>
			<td><font class="biaoTi">处理人</font></td>
			<td>${sercj.sercl.clname}</td>
			<td><font class="biaoTi">处理时间</font></td>
			<td>${sercj.sercl.cltime}</td>
		</tr>
		<tr>
			<td><font class="biaoTi">处理结果</font></td>
			<td>
				<input style="width:270px;height:30px;margin-left:2px;" id="kuang" type="text" name="result" value=""/>
			</td>
			<td><font class="biaoTi">满意度</font></td>
			<td>
				<select name="satisfied" style="height:30px;">
					<option value="1">★</option>
					<option value="2">★★</option>
					<option value="3">★★★</option>
					<option value="4">★★★★</option>
					<option value="5">★★★★★</option>
				</select>
			</td>
		</tr>
	</table>
	<p>  </p>
</form>
</body>
</html>