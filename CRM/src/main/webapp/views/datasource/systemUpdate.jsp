<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../static/css/xadmin.css">
<link rel="stylesheet" type="text/css" href="../../static/css/font.css" />
<script src="../../static/js/jquery-3.3.1.js" type="text/javascript" charset="utf-8"></script>
<script src="../../static/lib/layui/layui.js" charset="utf-8"></script>
<script src="../../static/lib/layui/layui.all.js" charset="utf-8"></script>
   <script type="text/javascript" src="../../static/js/xadmin.js"></script>
   <script type="text/javascript" src="../../static/js/cookie.js"></script>
<script type="text/javascript">
/*图片回显方法  */
	function preview(file) {
		var prevDiv = document.getElementById('preview');
		if (file.files && file.files[0]) {
			var reader = new FileReader();
			reader.onload = function(evt) {
				prevDiv.innerHTML = "<img style='width:80px;height:80px;padding:5px;' src="+ evt.target.result + " />";
			} 
			reader.readAsDataURL(file.files[0]);
		} else {
			prevDiv.innerHTML = '<div class="img" style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\'' + file.value + '\'"></div>';
		}
	}
	
</script>
</head>
<body>
<div class="x-body">
        <form class="layui-form" action="update" method="post" enctype="multipart/form-data">
          <input type="hidden" name="sysremid" value="${ws.sysremid}"/>
          <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>系统名称
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="username" name="systemname" required="" lay-verify="required"
                  autocomplete="off" value="${ws.systemname}" class="layui-input">
              </div>
              
          </div>
          <div class="layui-form-item">
              <label for="phone" class="layui-form-label">
                  		系统logo
              </label>
              <div class="layui-input-inline">&nbsp;
              <div id="preview"><img style="width:80px;height:80px;padding:5px;" src="../../${ws.syslogoip}"></div>
                  <input type="file" name="photo" onchange="preview(this)"
                  autocomplete="off" class="layui-input">
              </div>
              
          </div>
          <div class="layui-form-item">
              <label for="L_email" class="layui-form-label">
                  <span class="x-red">*</span>系统标题
              </label>
              <div class="layui-input-inline">
                  <input type="text" value="${ws.title}" name="title" required="" lay-verify="required"
                  autocomplete="off" class="layui-input">
              </div>
              
          </div>
          
          <div class="layui-form-item">
              <label for="L_pass" class="layui-form-label">
                  <span class="x-red">*</span>系统版权
              </label>
              <div class="layui-input-inline">
                  <input type="text"  name="copyright" required="" lay-verify="required"
                  autocomplete="off" value="${ws.copyright}" class="layui-input">
              </div>
              
          </div>
          
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
              </label>
            <button lay-submit lay-filter="formDemo" class="layui-btn" id="submitbtn">
                  保存
              </button>  
          </div>
      </form>
    </div>
  
    
  </body>

</html>