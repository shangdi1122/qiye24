<%--
  Created by IntelliJ IDEA.
  User: THINKPAD
  Date: 2017/9/17
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../../batic.jsp"></jsp:include>
    <script type="text/javascript">
        $(function () {

             $("#tree").tree({
                 url:'${pageContext.request.contextPath}/login/queryMenuByRoleId.controller',
                 method:'GET',
                 queryParams:{'parentId':0},
                 onSelect:function (node) {
                     if(node.children!=null) {
                         return ;
                     }
                     if(node.menuUrl!=-1) {
                         addTabs(node.text, node.menuUrl);
                     }

                     var select = $("#tree").tree("getSelected");
                     var parentId = node.id;
                     $.get("${pageContext.request.contextPath}/login/queryMenuByRoleId.controller",{"parentId":parentId},function (result) {

                         $("#tree").tree("append",{
                             parent:select.target,
                             data:result
                         })

                     })
                     
                 }
             })

        })
        function addTabs(title,url) {
            var url = '${pageContext.request.contextPath}/' + url;
            var content="<iframe scrolling='auto' frameborder='0' style='width: 100%;height: 100%' src='"+url+"'/>";
            if($("#tt").tabs("exists",title)) {
                $("#tt").tabs("select", title);
            }else {
                $("#tt").tabs("add",{
                    title:title,
                    content:content,
                    closable:true
                })
            }

        }
    </script>
</head>
<body>
<div class="easyui-layout" style="height: 100%; width: 100%">
    <div region="north" style="width: 100%;height: 15%">
        <div align="center">
            <h2>北大青鸟</h2>
        </div>
        <div align="right" width="80%">
            <h3>角色为： ${roleUser.role.roleName},昵称为：${roleUser.user.nickName}</h3>
        </div>
    </div>
    <div region="west" style="width: 20%" title="菜单栏">
      <ul id="tree"></ul>
    </div>
    <div region="center">
        <div id="tt" class="easyui-tabs" style="height: 100%;width: 100%">
            <div title="欢迎">
                <h3 align="center">欢迎使用</h3>
            </div>
        </div>
    </div>
    <div region="south" style="height: 10%">
        <div align="center">
            <h3>版权///@@@</h3>
        </div>
    </div>
</div>
</body>
</html>
