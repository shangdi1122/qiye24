<%--
  Created by IntelliJ IDEA.
  User: THINKPAD
  Date: 2017/9/17
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../../batic.jsp"></jsp:include>
    <script type="text/javascript">
        $(function () {

            $("#gradeDataGrid").datagrid({
                url:'${pageContext.request.contextPath}/grade/queryAllGrade.controller',
                method:'GET',
                rownumbers:true,
                striped:true,
                pagination:true,
                pageSize:5,
                pageList:[2,5,8],
                columns:[[
                    {field:'sdf',checkbox:true},
                    {field:'gradeName',title:'班级名称',width:200},
                    {field:'createDate',title:'创建时间',width:200,formatter:dateFormatter},
                    {field:'details',title:'班级详情',width:200},
                    {field:'id',title:'操作',width:500,formatter:operator},
                ]],
                toolbar:[
                    {
                        text:'添加',
                        iconCls:'icon-add',
                        handler:function () {
                            $("#addGradeWindow").window("open");
                            
                        }
                    },
                    {
                        text:'删除',
                        iconCls:'icon-remove',
                        handler:function () {

                            var checkValue = $("#gradeDataGrid").datagrid("getChecked");
                            if(checkValue==null||checkValue.length<=0) {
                                alert("请选择要删除的班级");
                                return ;
                            }
                            if(confirm("确定删除这些信息吗")) {
                                var array = [];
                                $.each(checkValue,function (index,value) {
                                   array.push(value.id)
                                })
                                var arrayJson = JSON.stringify(array);
                                $.get("${pageContext.request.contextPath}/grade/deleteSomeGrade.controller",{"strIds":arrayJson},function (result) {
                                    alert(result.msg);
                                    $("#gradeDataGrid").datagrid("reload");
                                })


                            }

                        }
                    }


                ],
                onLoadSuccess:function () {

                    $(".button_view").linkbutton();

                }
            })


            $("#addGradeButton").click(function () {

                $("#addGradeForm").form({
                       url:'${pageContext.request.contextPath}/grade/addGrade.controller',
                       success:function (result) {
                           alert(JSON.parse(result).msg);
                           $("#addGradeWindow").window("close");
                           $("#addGradeForm").form("clear");
                           $("#gradeDataGrid").datagrid("reload");
                       }
                })

            })


            $("#updateGradeButton").click(function () {

                $("#updateGradeForm").form({
                       url:'${pageContext.request.contextPath}/grade/updateGrade.controller',
                       success:function (result) {
                           alert(JSON.parse(result).msg);
                           $("#updateGradeWindow").window("close");
                           $("#updateGradeForm").form("clear");
                           $("#gradeDataGrid").datagrid("reload");
                       }
                })

            })


        })
        function dateFormatter(date) {
            var date = new Date(date);
            var y = date.getFullYear();
            var m = date.getMonth() + 1;
            var d = date.getDate();
            return y + "-" + m + "-" + d;
        }
        function operator(id) {

            var queryGrade="<button class='button_view' onclick='queryGrade("+id+")'>详情</button>";

            var updateGrade="<button class='button_view' onclick='updateGrade("+id+")'>修改</button>";

            var deleteGrade="<button class='button_view' onclick='deleteGrade("+id+")'>删除</button>";

            return queryGrade + updateGrade + deleteGrade;
            
        }
        function queryGrade(id) {
           $.get("${pageContext.request.contextPath}/grade/queryGradeById.controller",{"gradeId":id},function (result) {

               $("#queryGradeName").textbox("setValue", result.gradeName);
               $("#queryCreateDate").textbox("setValue", result.createDate);
               $("#queryGradeDetails").textbox("setValue", result.details);

               $("#queryGradeWindow").window("open");

           })
            
        }
        function updateGrade(id) {
            $.get("${pageContext.request.contextPath}/grade/queryGradeById.controller",{"gradeId":id},function (result) {
                $("#updateGradeForm").form("load", result);
                $("#updateGradeName").textbox("setValue", result.gradeName);
                $("#updateCreateDate").textbox("setValue", result.createDate);
                $("#updateGradeDetails").textbox("setValue", result.details);

                $("#updateGradeWindow").window("open");

            })


        }
        function deleteGrade(id) {
            if(confirm("确定删除该班级吗")) {
                $.get("${pageContext.request.contextPath}/grade/deleteGradeById.controller",{"gradeId":id},function (result) {

                    alert(result.msg);
                    $("#gradeDataGrid").datagrid("reload");

                })
            }


        }
    </script>
</head>
<body>
<table id="gradeDataGrid"></table>
<%--新增window--%>
<div class="easyui-window" id="addGradeWindow" closed="true" style="left: 30% ;top: 30% ;width: 400px; height: 250px; padding:45px 60px">
    <form action="" method="post" id="addGradeForm">
        <table>
            <tr>
                <td>班级名称：</td>
                <td>
                    <input class="easyui-textbox" id="addGradeName" name="gradeName"/>
                </td>
            </tr>
            <tr>
                <td>班级详情：</td>
                <td>
                    <input class="easyui-textbox" id="addGradeDetails" name="details"/>
                </td>
            </tr>
            <tr>
                <td>
                    <button class="easyui-linkbutton" id="addGradeButton">保存</button>
                </td>
            </tr>
        </table>
    </form>

</div>
<%--详情window--%>
<div class="easyui-window" id="queryGradeWindow" closed="true" style="left: 30% ;top: 30% ;width: 400px; height: 250px; padding:45px 60px">

        <table>
            <tr>
                <td>班级名称：</td>
                <td>
                    <input class="easyui-textbox" id="queryGradeName"/>
                </td>
            </tr>
            <tr>
                <td>创建时间：</td>
                <td>
                    <input class="easyui-textbox" id="queryCreateDate"/>
                </td>
            </tr>
            <tr>
                <td>班级详情：</td>
                <td>
                    <input class="easyui-textbox" id="queryGradeDetails" />
                </td>
            </tr>

        </table>


</div>
<%--修改window--%>
<div class="easyui-window" id="updateGradeWindow" closed="true" style="left: 30% ;top: 30% ;width: 400px; height: 250px; padding:45px 60px">
    <form action="" method="post" id="updateGradeForm">
        <table>
            <tr>
                <td>班级名称：</td>
                <td>
                    <input class="easyui-textbox" id="updateGradeName" name="gradeName" readonly/>
                    <input  name="id" type="hidden"/>

                </td>
            </tr>
            <tr>
                <td>创建时间：</td>
                <td>
                    <input class="easyui-textbox" id="updateCreateDate" readonly/>
                </td>
            </tr>
            <tr>
                <td>班级详情：</td>
                <td>
                    <input class="easyui-textbox" id="updateGradeDetails" name="details"/>
                </td>
            </tr>
            <tr>
                <td>
                    <button class="easyui-linkbutton" id="updateGradeButton">保存</button>
                </td>
            </tr>
        </table>
    </form>

</div>
</body>
</html>
