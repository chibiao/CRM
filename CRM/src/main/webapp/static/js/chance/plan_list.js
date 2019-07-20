layui.use(['form', 'layedit','jquery', 'laydate','table','layer','rate'], function () {
    var form = layui.form
        ,layer = layui.layer
        ,layedit = layui.layedit
        ,laydate = layui.laydate
        ,layer = layui.layer,$=layui.jquery,rate = layui.rate;;
    var table = layui.table;
    var addCustomer="";
    var cuscredi=0;
    var cussati=0;
    table.render({
        elem: '#test'
        , url: '/plan/chanceList'
        , title: '用户数据表'
        , page: true
        , cols: [[
            {field: 'id', title: '编号', width: 150, unresize: true, sort: true}
            , {field: 'outline', title: '概要', width: 150, edit: 'text'}
            , {field: 'contacts', title: '联系人', width: 150, edit: 'text'}
            , {field: 'phone', title: '联系人电话', width: 180}
            , {field: 'creattime', title: '创建时间',width: 150}
            , {fixed: 'right', title: '操作', toolbar: '#barDemo'}
        ]]
    });
  //自定义验证规则
	form.verify({
		bankacounts : [ /^([0-9]{19})$/, '银行卡号19位' ],
		cuszips: [ /^([0-9]{6})$/, '邮政编码6位' ],
	 	cusfax: [ /^([0-9]{6})$/, '傳真6位' ]
	});
	//监听提交
	form.on('submit(addCustomer)', function(data) {
		data.field.cuscredi=cuscredi;
		data.field.cussati=cussati;
		//发异步，把数据提交给php
		$.ajax({
            data:data.field,
            type:"post",
            url:"/plan/addCustomer",
            dataType:"json",
            success:function (data) {
            	if(data){
            		layer.msg("添加成功");
            		layer.close(addCustomer);
            		table.reload('test');
            	}
            }
        });

		return false;
	});
	var laydate = layui.laydate;
	//基础效果
	rate.render({
		elem : '#test1',
		value : 3,
		choose : function(value) {
			cuscredi=value;
		}
	})
	rate.render({
		elem : '#test14',
		value : 3,
		theme : '#FE0000',
		choose : function(value) {
			cussati = value;
		}
	})
    //日期
    laydate.render({
        elem: '#assignedtime'
    });
    laydate.render({
        elem: '#creattime'
    });
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
        } else if (obj.event === 'add') {
        	var editFrame=layer.open({
                type: 1,
                content: $("#editForm"), //这里content是一个普通的String
                area: ['700px', '400px']
            });
        	form.val('example', {
                "cusid": data.id// "name": "value"
            });
        	form.on('submit(add)', function(data){
                $.ajax({
                    data:data.field,
                    type:"post",
                    url:"/plan/addPlan",
                    dataType:"json",
                    success:function (data) {
                        if(data.success){
                            layer.msg(data.msg);
                            //关闭指定的弹出层
                            layer.close(editFrame);
                        }else{
                            layer.msg(data.msg);
                        }
                        console.log(data);
                    }
                });
                return false;
            });
        } else if(obj.event === 'look'){
        	var list=layer.open({
                type: 1,
                content: "<table class='layui-hide' id='test2' lay-filter='test2'></table>", 
                area: ['900px', '400px']
            });
        	var id=obj.data.id;
        	table.render({
                elem: '#test2'
                , url: '/plan/planList/'+id
                , title: '用户数据表'
                , page: true
                , cols: [[
                    {field: 'id', title: '计划编号', width: 100, unresize: true, sort: true}
                    , {field: 'cusid', title: '客户编号', width: 100, edit: 'text'}
                    , {field: 'plan', title: '计划项', width: 100, edit: 'text'}
                    , {field: 'plantime', title: '计划时间', width: 100}
                    , {field: 'planback', title: '计划反馈'}
                    , {field: 'state', title: '状态', width: 120, sort: true,templet: function(res){
                        console.log(res);
                        if(res.state){
                        	return "<span class='layui-btn layui-btn-danger layui-btn-mini'>已开发</span>"
                        }
                    	return "<span class='layui-btn layui-btn-warm layui-btn-mini'>待开发</span>"}
                    }
                    , {fixed: 'right', title: '操作', toolbar: '#barDemo1', width: 200}
                ]]
            });
        }else if(obj.event === 'addCustomer'){
        	addCustomer=layer.open({
                type: 1,
                content: $("#addCustomer"), //这里content是一个普通的String
                area: ['1000px', '500px']
            });
        	form.val('addCustomer', {
                "cusname": data.cusname,
                "cuscreatetime": data.creattime,
                "chanceid":data.id
            });
        	console.log(data)
        }
        
    });
  //监听行工具事件
    table.on('tool(test2)', function (obj) {
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
    	            url:"/plan/deletePlan",
    	            dataType:"json",
    	            success:function (data) {
    	                if(data.success){
    	                    layer.msg(data.msg);
    	                    table.reload('test2'); //只重载数据
    	                }else{
    	                    layer.msg(data.msg);
    	                }
    	            }
        	     });
            });
        } else if (obj.event === 'edit') {
        	 layer.confirm('是否执行计划完毕', function (index) {
        		 var id=obj.data.id;
        		 $.ajax({
    	            data:{
    	            	"id":id
    	            },
    	            type:"post",
    	            url:"/plan/changeState",
    	            dataType:"json",
    	            success:function (data) {
    	                if(data.success){
    	                    layer.msg(data.msg);
    	                    //关闭指定的弹出层
    	                    table.reload('test2'); //只重载数据
    	                }else{
    	                    layer.msg(data.msg);
    	                }
    	            }
        	     });
             });
        }
    });
    laydate.render({
        elem: '#plantime'
    });
});
