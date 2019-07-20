<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
	@import url("/static/css/serverManageCss/serviecManageCss.css");
</style>
<script type="text/javascript">
function update(id) {
    location.href="/sercj/getById?id="+id;
}
function del(id) {
if(confirm("你确认删除吗?"))
    location.href="/sercj/del?id="+id;
}
function fenye(curPage) {
	  var custom=document.getElementById("custom").value;
location.href="/sercj/list?curPage="+curPage+"&custom="+custom;
}
function query(){
	   var custom=document.getElementById("custom").value;
	   var id=document.getElementById("id").value;
	   //var types=document.getElementById("types").value;
	   //拿到select对象： 
	   var t=document.getElementById("types");

	   //2：拿到选中项的索引：
	   var index=t.selectedIndex ; // selectedIndex代表的是你所选中项的index

	   //3:拿到选中项options的value： 
	   var types=t.options[index].value;
		location.href="/sercj/list?curPage=1&custom="+custom+"&id="+id+"&types="+types;
	}
</script>
<body>

	<input type="button" value="帮助" class="anNiu"/>
	<input type="button" value="查询" class="anNiu" onclick="query()"/>
	<table class="tab" id="tab_head">
		<tr>
			<td class="ziTd"><font class="biaoTi">编号</font></td>
			<td>
				<input type="text" placeholder="请输入要查询的服务编号" id="id" name="id"/>
			</td>
			<td class="ziTd"><font class="biaoTi">客户</font></td>
			<td>
				<input type="text" placeholder="请输入要查询的客户名称" id="custom" name="custom"/>
			</td>
			<td class="ziTd"><font class="biaoTi">服务类型</font></td>
			<td class="ziTd">
			<!-- <select name="cid">
	<c:forEach items="${list2}" var="b">
	
    <option value="${b.cid}" <c:if test="${t.cid==b.cid}">selected</c:if>>${b.cname}</option>
    </c:forEach>
       </select> -->
				<select id="types">
						<option value="0">全部</option>
					<c:forEach items="${listType}" var="type">
						<option value="${type.id}" <c:if test="${type.id==types}">selected</c:if>>${type.tname}</option>
					</c:forEach>
				</select>
			</td>
		</tr>
	</table>
	
	<table class="tab_bottom">
		<tr>
			<td><font class="biaoTi">编号</font></td>
			<td><font class="biaoTi">客户</font></td>
			<td><font class="biaoTi">概要</font></td>
			<td><font class="biaoTi">服务类型</font></td>
			<td><font class="biaoTi">创建人</font></td>
			<td><font class="biaoTi">创建日期</font></td>
			<td><font class="biaoTi">操作</font></td>
		</tr>
		<c:forEach items="${teaList1}" var="cj">
		<tr>
				<td>${cj.id}</td>
				<td>${cj.custom}</td>
				<td>${cj.description} </td>
				<td>
					<c:forEach items="${listType}" var="type">
						<c:if test="${type.id==cj.types}">
							${type.tname}
						</c:if>
					</c:forEach>
				</td>

				<td>${cj.cname}</td>
				<td>${cj.ctime}</td>
				<td onclick="update('${cj.id}')"><img src="/static/images/service/update.png" /><img src="/static/images/service/del.png" /></td>
		</tr>
		</c:forEach>
		<tr>
            <td colspan="7">
            <button onclick="fenye(1)">首页</button>
		
		<c:forEach begin="1" end="${page.pages}" var="YS" >
			<button onclick="fenye(${YS})" style="cursor: pointer">${YS}</button>
		</c:forEach>
		<%-- <button onclick="fenye(${pageInfo.prePage==0?1:pageInfo.prePage})">上一页</button>
		<button onclick="fenye(${pageInfo.nextPage==0?pageInfo.pages:pageInfo.nextPage})">下一页</button> --%>
		<button onclick="fenye(${page.pages})">尾页</button>
            </td>
        </tr>
	</table>
</body>
</html>