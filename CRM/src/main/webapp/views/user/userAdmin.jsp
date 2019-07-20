<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/static/layui/css/layui.css" media="all">
    <script type="text/javascript" src="/static/js/jquery-3.3.1.js"></script>

    <style type="text/css">
        body {
            margin: 20px;
        }

        img {
            height: 50px;
        }

        form {
            text-align: center;
        }

        .layui-table-cell {
            height: 50px;
            line-height: 50px;
            text-align: center;
        }
    </style>
</head>

<body>
    <div class="layui-form layui-card-header layuiadmin-card-header-auto" lay-filter="layadmin-userfront-formlist" >
        <div class="layui-form-item">
            <div class="layui-inline" >
                <label class="layui-form-label">ID</label>
                <div class="layui-input-block">
                    <input type="text" id="id" name="id" placeholder="请输入" autocomplete="off" class="layui-input" style="width: 100px">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">用户名</label>
                <div class="layui-input-block">
                    <input type="text" id="name" name="name" placeholder="请输入" autocomplete="off" class="layui-input" style="width: 150px">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">邮箱</label>
                <div class="layui-input-block">
                    <input type="text" id="email" name="email" placeholder="请输入" autocomplete="off" class="layui-input" style="width: 130px">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">性别</label>
                <div class="layui-input-block" style="width: 100px">
                    <select name="sex" id="sex">
                        <option value="">不限</option>
                        <option value="男">男</option>
                        <option value="女">女</option>
                    </select>
                    <div class="layui-unselect layui-form-select">
                        <div class="layui-select-title"><input type="text" placeholder="请选择" value="不限" readonly=""
                                class="layui-input layui-unselect"><i class="layui-edge"></i></div>
                        <dl class="layui-anim layui-anim-upbit">
                            <dd lay-value="0" class="layui-this">不限</dd>
                            <dd lay-value="1" class="">男</dd>
                            <dd lay-value="2" class="">女</dd>
                        </dl>
                    </div>
                </div>
            </div>
            <div class="layui-inline">
                <button class="layui-btn layuiadmin-btn-useradmin" lay-submit="" lay-filter="LAY-user-front-search"
                    id="search">
                    <i class="layui-icon layui-icon-search layuiadmin-button-btn"></i>
                </button>
            </div>
        </div>
    </div>

    <table class="layui-hide" id="test" lay-filter="test"></table>

    <form class="layui-form" action="" lay-filter="add"  style="display: none" id="addForm"
        method="post">

        <div class="layui-form-item" style="margin-top: 15px">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-inline">
                <input name="name" lay-verify="required" autocomplete="off" class="layui-input" type="text">
            </div>
        </div>
        <div class="layui-form-item" style="margin-top: 15px">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-inline">
                <input name="password" lay-verify="required" autocomplete="off" class="layui-input" type="text">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-inline">
                <input type="radio" name="sex" value="男" title="男" checked="">
                <input type="radio" name="sex" value="女" title="女">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">手机号码</label>
            <div class="layui-input-inline">
                <input name="phone" lay-verify="phone" autocomplete="off" class="layui-input" type="text">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">出生日期</label>
            <div class="layui-input-inline">
                <input name="birthday" lay-verify="required" autocomplete="off" id="test3" class="layui-input"
                    type="text" placeholder="yyyy年MM月dd日">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">加入时间</label>
            <div class="layui-input-inline">
                <input name="userdate" type="text" class="layui-input" autocomplete="off" lay-verify="required"
                    id="test4" placeholder="yyyy年MM月dd日">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">邮箱 </label>
            <div class="layui-input-inline">
                <input name="email" lay-verify="email" autocomplete="off" class="layui-input" type="text">
            </div>
        </div>

        <div class="layui-upload">
            <button type="button" class="layui-btn" id="demo2">上传头像</button>
            <div class="layui-upload-list">
                <img class="layui-upload-img" id="pic2">
                <p id="demoText2"></p>
            </div>
        </div> 

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="demo2" id="addSumbit">立即提交</button>
            </div>
        </div>
    </form>


    <form class="layui-form" action="" lay-filter="example" enctype="mutipart/form-data" style="display: none"
        id="editForm" method="post">

        <input name="id" autocomplete="off" class="layui-input" type="hidden">

        <div class="layui-form-item" style="margin-top: 15px">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-inline">
                <input name="name" lay-verify="required" autocomplete="off" class="layui-input" type="text">
            </div>
        </div>
        
        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-inline">
                <input type="radio" name="sex" value="男" title="男" checked="">
                <input type="radio" name="sex" value="女" title="女">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">手机号码</label>
            <div class="layui-input-inline">
                <input name="phone" lay-verify="phone" autocomplete="off" class="layui-input" type="text">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">出生日期</label>
            <div class="layui-input-inline">
                <input name="birthday" lay-verify="required" autocomplete="off" id="test1" class="layui-input"
                    type="text" placeholder="yyyy年MM月dd日">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">加入时间</label>
            <div class="layui-input-inline">
                <input name="userdate" type="text" class="layui-input" lay-verify="required" id="test2"
                    placeholder="yyyy年MM月dd日">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">邮箱 </label>
            <div class="layui-input-inline">
                <input name="email" lay-verify="email" autocomplete="off" class="layui-input" type="text">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="demo1" id="editSubmit">立即提交</button>
            </div>
        </div>
    </form>


    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>


    <script src="/static/layui/layui.js" charset="utf-8"></script>
    <!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->

    <script>
        layui.use(['upload', 'form', 'layedit', 'laydate', 'table'], function () {
            var $ = layui.jquery,
                upload = layui.upload;
            var table = layui.table;
            var form = layui.form,
                layer = layui.layer,
                layedit = layui.layedit,
                laydate = layui.laydate;

            //自定义格式
            laydate.render({
                elem: '#test1',
                format: 'yyyy年MM月dd日',
                trigger: 'click'
            });
            //自定义格式
            laydate.render({
                elem: '#test2',
                format: 'yyyy年MM月dd日',
                trigger: 'click'
            });
            laydate.render({
                elem: '#test3',
                format: 'yyyy年MM月dd日',
                trigger: 'click'
            });
            //自定义格式
            laydate.render({
                elem: '#test4',
                format: 'yyyy年MM月dd日',
                trigger: 'click'
            });

            var uploadInst = upload.render({
                elem: '#demo2',
                url: '/user/add',
                field: 'file2',
                auto: false,
                bindAction: '#addSubmit',
                done: function (res) {
                    //如果上传失败
                    if (res.code > 0) {
                        return layer.msg('上传失败');
                    }
                    //上传成功
                },
                choose: function (obj) {
                    obj.preview(function (index, file, result) {
                        $('#pic2').attr('src', result);
                    })
                },
                error: function () {
                    //演示失败状态，并实现重传
                    var demoText = $('#demoText2');
                    demoText.html(
                        '<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>'
                        );
                    demoText.find('.demo-reload').on('click', function () {
                        uploadInst.upload();
                    });
                }
            }); 
            

            table.render({
                elem: '#test',
                url: '/user/list',
                toolbar: 'default',
                title: '用户数据表',
                cols: [
                    [{
                        type: 'checkbox',
                        fixed: 'left'
                    }, {
                        field: 'id',
                        title: 'ID',
                        fixed: 'left',
                        unresize: true,
                        sort: true
                    }, {
                        field: 'name',
                        title: '姓名',
                    }, {
                        field: 'image',
                        title: '头像',
                        templet: '<div><img src="{{d.image}}"></div>'
                    }, {
                        field: 'sex',
                        title: '性别',
                        sort: true
                    }, {
                        field: 'phone',
                        title: '手机号码'
                    }, {
                        field: 'birthday',
                        title: '出生日期'
                    }, {
                        field: 'userdate',
                        title: '加入时间',
                        sort: true
                    }, {
                        field: 'email',
                        title: '邮箱',
                        templet: function (res) {
                            return '<em>' + res.email + '</em>'
                        }
                    }, {
                        fixed: 'right',
                        title: '操作',
                        toolbar: '#barDemo'
                    }]
                ],
                page: true
            });
            //头工具栏事件
            table.on('toolbar(test)', function (obj) {
                var checkStatus = table
                    .checkStatus(obj.config.id),
                    data = checkStatus.data; //获取选中的数据
                switch (obj.event) {
                    case 'add':
                        var editFrame = layer.open({
                            type: 1,
                            content: $("#addForm"), //这里content是一个普通的String
                            area: ['400px', '600px']
                        });
                        form.on('submit(demo2)', function (data) {
                            var fd = new FormData();
                            var formData = new FormData($("#addForm")[0]);
                            $.ajax({
                                cache: true,
                                type: "post",
                                url: "/user/add",
                                async: false,
                                data: formData, // 你的formid
                                contentType: false, //jax 中 contentType 设置为 false 是为了避免 JQuery 对其操作，从而失去分界符，而使服务器不能正常解析文件
                                processData: false, //当设置为true的时候,jquery ajax 提交的时候不会序列化 data，而是直接使用data
                                success: function (data) {
                                    if (data.success) {
                                        layer.msg(data.msg);
                                        //关闭指定的弹出层
                                        layer.close(editFrame);
                                        table.reload('test')
                                    } else {
                                        layer.msg(data.msg);
                                    }
                                    console.log(data);
                                }
                            });
                            return false;
                        });
                        break;
                    case 'update':
                        if (data.length === 0) {
                            layer.msg('请选择一行');
                        } else if (data.length > 1) {
                            layer.msg('只能同时编辑一个');
                        } else {
                            var editFrame = layer.open({
                                type: 1,
                                content: $("#editForm"), //这里content是一个普通的String
                                area: ['350px', '450px']
                            });
                            //表单初始赋值
                            form.val('example', {
                                "id": data[0].id,
                                "name": data[0].name, // "name": "value"
                                "sex": data[0].sex,
                                "old": data[0].image,
                                "phone": data[0].phone,
                                "birthday": data[0].birthday,
                                "userdate": data[0].userdate,
                                "email": data[0].email,
                            });
                            //监听提交
                            form.on('submit(demo1)', function (data) {
                                $.ajax({
                                    data: data.field,
                                    type: "post",
                                    url: "/user/update",
                                    dataType: "json",
                                    success: function (data) {
                                        if (data.success) {
                                            layer.msg(data.msg);
                                            //关闭指定的弹出层
                                            layer.close(editFrame);
                                            table.reload('test')
                                        } else {
                                            layer.msg(data.msg);
                                        }
                                        console.log(data);
                                    }
                                });
                                return false;
                            });
                        }
                        break;
                    case 'delete':
                        if (data.length === 0) {
                            layer.msg('请选择一行');
                        } else {
                            layer.confirm('真的删除行么', function (index) {
                                var ids = new Array();
                                $.each(data, function (index, value) {
                                    ids[index] = value.id;
                                })
                                layer.close(index);
                                $.ajax({
                                    url: "/user/delBySelect",
                                    dataType: "json",
                                    type: "post",
                                    contentType: "application/json",
                                    data: JSON.stringify(ids),
                                    success: function (data) {
                                        if (data.success) {
                                            layer.msg(data.msg);
                                            table.reload('test');
                                            //关闭指定的弹出层
                                        } else {
                                            layer.msg(data.msg);
                                        }
                                    }
                                });
                            });
                        }
                        break;
                };
            });

            $("#search").click(function () {
                console.log($('#sex').val())
                table.reload('test', {
                    where: { //设定异步数据接口的额外参数，任意设
                        id: $('#id').val(),
                        name: $('#name').val(),
                        email: $('#email').val(),
                        sex: $('#sex').val(),
                    },
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                });
            });

            //监听行工具事件
            table.on('tool(test)', function (obj) {
                //获取每行的数据
                var data = obj.data;
                if (obj.event === 'del') {
                    layer.confirm('真的删除行么', function (index) {
                        console.log(obj.data);
                        obj.del();
                        layer.close(index);
                        $.ajax({
                            data: {
                                'id': data.id
                            },
                            type: "post",
                            url: "/user/del",
                            dataType: "json",
                            success: function (data) {
                                if (data.success) {
                                    layer.msg(data.msg);
                                    //关闭指定的弹出层
                                } else {
                                    layer.msg(data.msg);
                                }
                                console.log(data);
                            }
                        });
                    });
                } else if (obj.event === 'edit') {

                    var editFrame = layer.open({
                        type: 1,
                        content: $("#editForm"), //这里content是一个普通的String
                        area: ['350px', '450px']
                    });
                    //表单初始赋值
                    form.val('example', {
                        "id": data.id,
                        "name": data.name, // "name": "value"
                        "old": data.image,
                        "sex": data.sex,
                        "phone": data.phone,
                        "birthday": data.birthday,
                        "userdate": data.userdate,
                        "email": data.email,
                    });
                    //监听提交
                    form.on('submit(demo1)', function (data) {
                        $.ajax({
                            data: data.field,
                            type: "post",
                            url: "/user/update",
                            dataType: "json",
                            success: function (data) {
                                if (data.success) {
                                    layer.msg(data.msg);
                                    //关闭指定的弹出层
                                    layer.close(editFrame);
                                    table.reload('test')
                                } else {
                                    layer.msg(data.msg);
                                }
                                console.log(data);
                            }
                        });
                        return false;
                    });
                }
            });
        });
    </script>
</body>

</html>