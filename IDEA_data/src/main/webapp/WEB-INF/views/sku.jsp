<%-- 每个jsp文件中都加入下面两句 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   <%--注意：需要放一个jstl.jar包到Tomcat的WEB-INF/lib下--%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>
             	货物进销存管理系统
        </title>
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="format-detection" content="telephone=no">
        <link rel="stylesheet" href="/static/css/x-admin.css" media="all">
    </head>
    <body>
        <div class="x-nav">
            <span class="layui-breadcrumb">
            <a href="/" target="view_window">仓库信息查询</a>
              <a href="" target="view_window">货物信息查询</a>
              <a href="" target="view_window">sku信息查询</a>
            </span>
            <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right"  href="javascript:location.replace(location.href);" title="刷新"><i class="layui-icon" style="line-height:30px">ဂ</i></a>
        </div>
        <div class="x-body">
            <form class="layui-form x-center" action="/Search" style="width:800px">
                <div class="layui-form-pane" style="margin-top: 15px;">
                  <div class="layui-form-item">
                    <label class="layui-form-label">日期范围</label>
                    <div class="layui-input-inline">
                      <input class="layui-input" placeholder="开始日期" id="LAY_demorange_s">
                    </div>
                    <div class="layui-input-inline">
                      <input class="layui-input" placeholder="截止日期" id="LAY_demorange_e">
                    </div>
                    <div class="layui-input-inline">
                      <input type="text" name="username"  placeholder="请输入搜索内容：" autocomplete="off" class="layui-input">
                    </div>
                    <div class="layui-input-inline" style="width:80px">
                        <button class="layui-btn"  type="submit" lay-submit="" lay-filter="sreach"><i class="layui-icon">&#xe615;</i></button>
                    </div>
                  </div>
                </div> 
            </form>
            <xblock><button class="layui-btn layui-btn-danger" onclick="delAll()">
            <i class="layui-icon">&#xe640;</i>批量删除</button>
            <button class="layui-btn" onclick="member_add('添加货物信息','/member_add?rname=${repoName.rname}','600','500')">
            <i class="layui-icon">&#xe608;</i>添加</button><span class="x-right" style="line-height:40px">共有数据：20 条</span></xblock>
            <table class="layui-table">
                <thead>
                    <tr>
                        <th>
                            <input type="checkbox" name="" value="">
                        </th>
                        <th>ID</th>
                        <th>货物ID</th>
                        <th>颜色</th>
                        <th>货物数量</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${skuList}" var="list">
                    <tr>
                        <td>
                            <input type="checkbox" value="1" name="">
                        </td>
                        <td>${list.sid}</td>
                        <td>${list.cid}</td>
                        <td >${list.color}</td>
                        <td >${list.samount}</td>
                        
                        <td class="td-manage">
                            
                            <a title="编辑" href="javascript:;" onclick="member_edit('编辑','/getSkuBySid?sid=${list.sid}&cid=${list.cid}','4','','510')"
                            class="ml-5" style="text-decoration:none">
                                <i class="layui-icon">&#xe642;</i>
                            </a>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <a title="删除" href="javascript:;" onclick="member_del(this,'${list.sid}')"
                            style="text-decoration:none">
                                <i class="layui-icon">&#xe640;</i>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <div id="page"></div>
        </div>
        <script src="/static/lib/layui/layui.js" charset="utf-8"></script>
        <script src="/static/js/x-layui.js" charset="utf-8"></script>
        <script>
            layui.use(['laydate','element','laypage','layer'], function(){
                $ = layui.jquery;//jquery
              laydate = layui.laydate;//日期插件
              lement = layui.element();//面包导航
              laypage = layui.laypage;//分页
              layer = layui.layer;//弹出层

              //以上模块根据需要引入

              laypage({
                cont: 'page'
                ,pages: 10
                ,first: 1
                ,last: 10
                ,prev: '<em><</em>'
                ,next: '<em>></em>'
              }); 
              
              var start = {
                min: laydate.now()
                ,max: '2099-06-16 23:59:59'
                ,istoday: false
                ,choose: function(datas){
                  end.min = datas; //开始日选好后，重置结束日的最小日期
                  end.start = datas //将结束日的初始值设定为开始日
                }
              };
              
              var end = {
                min: laydate.now()
                ,max: '2099-06-16 23:59:59'
                ,istoday: false
                ,choose: function(datas){
                  start.max = datas; //结束日选好后，重置开始日的最大日期
                }
              };
              
              document.getElementById('LAY_demorange_s').onclick = function(){
                start.elem = this;
                laydate(start);
              }
              document.getElementById('LAY_demorange_e').onclick = function(){
                end.elem = this
                laydate(end);
              }
              
            });

            //批量删除提交
             function delAll () {
                layer.confirm('确认要删除吗？',function(index){
                    //捉到所有被选中的，发异步进行删除
                    layer.msg('删除成功', {icon: 1});
                });
             }
             /*用户-添加*/
            function member_add(title,url,w,h){
                x_admin_show(title,url,w,h);
            }
            /*用户-查看*/
            function member_show(title,url,id,w,h){
                x_admin_show(title,url,w,h);
            }
	
            // 用户-编辑
            function member_edit (title,url,id,w,h) {
                x_admin_show(title,url,w,h); 
            }
            /*密码-修改*/
            function member_password(title,url,id,w,h){
                x_admin_show(title,url,w,h);  
            }
            /*用户-删除*/
            function member_del(obj,sid){

                console.log(sid)
                layer.confirm('确认要删除吗？',function(index){
                    //发异步删除数据
                    console.log(sid)
                    $.ajax({
                        url:'/delete',
                        data:{"sid":sid},
                        type:"get",
                        dataType:'json',
                        success:function(msg){
                            if(msg=='1'){
                                console.log('添加成功');
                            }else{
                                console.log('添加失败')
                            }
                        }

                    })
                    $(obj).parents("tr").remove();
                    layer.msg('已删除!',{icon:1,time:1000});
                });
            }
            </script>
            
    </body>
</html>