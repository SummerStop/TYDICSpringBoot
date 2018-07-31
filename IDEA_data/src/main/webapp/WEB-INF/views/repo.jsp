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
            <span class="x-right" style="line-height:40px">共有数据：20 条</span></xblock>
            <table class="layui-table">
                <thead>
                    <tr>
                        <th>
                            <input type="checkbox" name="" value="">
                        </th>
                        <th>仓库ID</th>
                        <th>缩略图</th>
                        <th>仓库名称</th>
                        <th>仓库地址</th>
                        <th>仓库信息查询</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody id="x-img">
                <c:forEach items="${repoList}" var="list">
                    <tr>

                        <td>
                            <input type="checkbox" value="1" name="">
                        </td>
                        <td>${list.rid}</td>
                        <td>
                            <img  src="/static/images/anhui.jpg" width="200" alt="">点击图片试试
                        </td>
                        <td >${list.rname}</td>
                        <td >${list.rplace}
                        </td>
                        <td class="td-status">
                            
                            <a href="/getCargo?rid=${list.rid}" class="layui-btn layui-btn-normal layui-btn-mini"
                            target="view_window">查看信息</a>

                        </td>
                        <td class="td-manage">
                            <a style="text-decoration:none" onclick="banner_stop(this,'10001')" href="javascript:;" title="不显示">
                                <i class="layui-icon">&#xe601;</i>
                            </a>
                            <button class="layui-btn" onclick="member_add('添加货物信息','/member_add?rname=${list.rname}','600','500')">
                                <i class="layui-icon">&#xe608;</i>添加</button>
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

                layer.ready(function(){ //为了layer.ext.js加载完毕再执行
                  layer.photos({
                    photos: '#x-img'
                    //,shift: 5 //0-6的选择，指定弹出图片动画类型，默认随机
                  });
                }); 
              
            });

            function member_add(title,url,w,h){
                x_admin_show(title,url,w,h);
            }

            //批量删除提交
             function delAll () {
                layer.confirm('确认要删除吗？',function(index){
                    //捉到所有被选中的，发异步进行删除
                    layer.msg('删除成功', {icon: 1});
                });
             }
           
             /*停用*/
            function banner_stop(obj,id){
                layer.confirm('确认不显示吗？',function(index){
                    //发异步把用户状态进行更改
                    $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="banner_start(this,id)" href="javascript:;" title="显示"><i class="layui-icon">&#xe62f;</i></a>');
                    $(obj).parents("tr").find(".td-status").html('<span class="layui-btn layui-btn-disabled layui-btn-mini">不显示</span>');
                    $(obj).remove();
                    layer.msg('不显示!',{icon: 5,time:1000});
                });
            }

            /*启用*/
            function banner_start(obj,id){
                layer.confirm('确认要显示吗？',function(index){
                    //发异步把用户状态进行更改
                    $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="banner_stop(this,id)" href="javascript:;" title="不显示"><i class="layui-icon">&#xe601;</i></a>');
                    $(obj).parents("tr").find(".td-status").html('<a href="/views/cargo.jsp" class="layui-btn layui-btn-normal layui-btn-mini"target="view_window">查看信息</a>');
                    $(obj).remove();
                    layer.msg('已显示!',{icon: 6,time:1000});
                });
            }
           
            </script>
            
    </body>
</html>