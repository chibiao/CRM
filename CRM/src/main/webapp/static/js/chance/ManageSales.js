layui.use(['form', 'layedit','jquery', 'laydate','table'], function () {
	//用于关闭弹出层
	var editFrame="";
    var form = layui.form
        ,layer = layui.layer
        ,layedit = layui.layedit
        ,laydate = layui.laydate
        ,$=layui.jquery;
    var table = layui.table;
    table.render({
        elem: '#test'
        , url: '/sales/chanceList'
        , toolbar: '#toolbarDemo'
        , title: '用户数据表'
        , page: true
        , cols: [[
            {field: 'id', title: 'ID', width: 80, fixed: 'left', unresize: true, sort: true}
            , {field: 'cusname', title: '客户名称', width: 120, edit: 'text'}
            , {field: 'outline', title: '机会来源', width: 200, edit: 'text'}
            , {field: 'contacts', title: '联系人', width: 120}
            , {field: 'phone', title: '联系人电话'}
            , {field: 'creattime', title: '创建时间', width: 150, sort: true}
            , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: 150}
        ]]
    });
    //日期
    laydate.render({
        elem: '#assignedtime'
    });
    $(function(){
    	$.ajax({
            type:"post",
            url:"/sales/getUser",
            dataType:"json",
            success:function (data) {
            	for(i=0;i<data.length;i++){
            		$("#assigned").append("<option value='"+data[i].id+"'>"+data[i].name+"</option>")
            	}
            }
 	     });
	})
    //头工具栏事件
    table.on('toolbar(test)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id);
        switch (obj.event) {
            case 'getCheckData':
                var data = checkStatus.data;
                layer.alert(JSON.stringify(data));
                break;
            case 'getCheckLength':
                var data = checkStatus.data;
                layer.msg('选中了：' + data.length + ' 个');
                break;
            case 'isAll':
                layer.msg(checkStatus.isAll ? '全选' : '未全选');
                break;
            case 'addChance':
            	//表单初始赋值
                form.val('example', {
                    "id": "" ,// "name": "value"
                    "chancefrom": "" ,
                    "cusname": "" ,
                    "successpro": "" ,
                    "outline": "" ,
                    "contacts": "" ,
                    "phone": "" ,
                    "description": "" ,
                    "creattime": "" ,
                    "assignedid": "",
                    "assignedtime": "" ,
                });
                editFrame=layer.open({
                    type: 1,
                    content: $("#editForm"), //这里content是一个普通的String
                    area: ['700px', '400px'],
                });
            	break;
        }
    });
    //监听行工具事件
    table.on('tool(test)', function (obj) {
        //获取每行的数据
        var data = obj.data;
        if (obj.event === 'del') {
        	 layer.confirm('真的删除行么', function (index) {
             	var id=obj.data.id;
             	$.ajax({
     	            data:{
     	            	"id":id
     	            },
     	            type:"post",
     	            url:"/sales/deleteChance",
     	            dataType:"json",
     	            success:function (data) {
     	                if(data.success){
     	                    layer.msg(data.msg);
     	                    //关闭指定的弹出层
     	                    table.reload('test'); //只重载数据
     	                }else{
     	                    layer.msg(data.msg);
     	                }
     	            }
         	     });
             });
        } else if (obj.event === 'edit') {
            editFrame=layer.open({
                type: 1,
                content: $("#editForm"), //这里content是一个普通的String
                area: ['700px', '400px']
            });
            //表单初始赋值
            form.val('example', {
                "id": data.id ,// "name": "value"
                "chancefrom": data.chancefrom,
                "cusname": data.cusname,
                "successpro": data.successpro,
                "outline": data.outline,
                "contacts": data.contacts,
                "phone": data.phone,
                "description": data.description,
                "founder": data.founder,
                "creattime": data.creattime,
                "assignedid": data.assignedid,
                "assignedtime": data.assignedtime,
            });
        }
    });
    //监听提交
    form.on('submit(add)', function(data){
    	console.log(data.field);
    	var url="";
    	if(data.field.id){
    		url="/sales/updateChance";
    	}else{
    		url="/sales/addChance";
    	}
        $.ajax({
            data:data.field,
            type:"post",
            url:url,
            dataType:"json",
            success:function (data) {
                if(data.success){
                    layer.msg(data.msg);
                    //关闭指定的弹出层
                    layer.close(editFrame);
                    table.reload('test'); //只重载数据
                }else{
                    layer.msg(data.msg);
                }
                console.log(data);
            }
        });
        return false;
    });
    $(".search").click(function() {
    	table.reload('test', {
      	  where: { //设定异步数据接口的额外参数，任意设
      		  keyword:$("#keyword").val()
      	  }
      	  ,page: {
      	    curr: 1 //重新从第 1 页开始
      	  }
      	}); //只重载数据
	})
});