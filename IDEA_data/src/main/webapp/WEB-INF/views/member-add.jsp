<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   <%--注意：需要放一个jstl.jar包到Tomcat的WEB-INF/lib下--%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>货物进销存管理系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="/static/css/x-admin.css" media="all">
</head>

<body>
<div class="x-body">
    <form class="layui-form" action="/insert">
        <div class="layui-form-item">
            <label for="L_cname" class="layui-form-label"> <span class="x-red">*</span>仓库名称 </label>
            <div class="layui-input-inline">
                <input type="text" id="L_rname" name="rname" required lay-verify="cname"
                       autocomplete="off" readonly="readonly" class="layui-input" value="${rname}">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_cname" class="layui-form-label"> <span class="x-red">*</span>货物名称 </label>
            <div class="layui-input-inline">
                <input type="text" id="L_cname" name="cname" required lay-verify="cname"
                       autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux"> <span class="x-red">*</span>将会成为货物唯一的名称</div>
        </div>
        <div class="layui-form-item">
            <label for="L_color" class="layui-form-label"> <span class="x-red">*</span>颜色 </label>
            <div class="layui-input-inline">
                <input type="text" id="L_color" name="color" required lay-verify="color"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="L_samount" class="layui-form-label"> <span class="x-red">*</span>数量 </label>
            <div class="layui-input-inline">
                <input type="text" id="L_samount" name="samount" required lay-verify="samount"
                       autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux"> 请输入正整数！ </div>
        </div>

        <div class="layui-form-item">
            <label for="L_repass" class="layui-form-label"> </label>
            <button  class="layui-btn" type="submit" lay-filter="add" lay-submit=""> 添加 </button>
        </div>
    </form>
</div>
<script src="/static/lib/layui/layui.js" charset="utf-8">
</script>
<script src="/static/js/x-layui.js" charset="utf-8">
</script>
<script>
    layui.use(['form','layer'], function(){
        $ = layui.jquery;
        var form = layui.form()
            ,layer = layui.layer;

        //自定义验证规则
        /*    form.verify({
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

        //监听提交
        form.on('submit(add)', function(data){
            console.log(data);
            //发异步，把数据提交给php
            $.ajax({
                url:'/insert',
                data:data.field,
                type:"get",
                dataType:'JSON',
                success:function(msg){
                    if(msg=='1'){
                        console.log('添加成功');
                    }else{
                        console.log('添加失败')
                    }
                }

            })
            layer.alert("增加成功", {icon: 6},function () {
                // 获得frame索引
                var index = parent.layer.getFrameIndex(window.name);
                //关闭当前frame
                parent.layer.close(index);
            });
            return false;
        });


    });
</script>
</body>
</html>