<%--
  Created by IntelliJ IDEA.
  User: THINKPAD
  Date: 2017/9/18
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../../batic.jsp"/>
    <script type="text/javascript">
        $(function () {

           $("#studentDataGrid").datagrid({
               url:'${pageContext.request.contextPath}/student/queryAllStudents.controller',
               method:'GET',
               rownumbers:true,
               striped:true,
               pagination:true,
               pageSize:5,
               pageList:[2,5,9],
               columns:[[

                   {field:"sd",checkbox:true},
                   {field:'studentName',title:'学生姓名',width:80},
                   {field:'age',title:'学生年龄',width:80},
                   {field:'gender',title:'学生性别',width:80},
                   {field:'studentNum',title:'学生编号',width:200},
                   {field:'grade',title:'学生班级',width:80,formatter:gradeName},
                   {field:'id',title:'操作',width:200,formatter:operator}

               ]],
               toolbar:[
                   {
                       text:'添加',
                       iconCls:"icon-add",
                       handler:function () {

                           $("#addGradeName").combobox({
                               url:'${pageContext.request.contextPath}/grade/queryAllGrades.controller',
                               method:'GET',
                               valueField:'id',
                               textField:'gradeName'
                           })
                           $("#addGradeName").combobox("select", "--请选择--");
                           $("#addStudentWindow").window("open");
                       }
                   },
                   {
                       text:'删除',
                       iconCls:"icon-remove",
                       handler:function () {
                           var checkVal = $("#studentDataGrid").datagrid("getChecked");
                           if(checkVal==null||checkVal.length<=0) {
                               alert("请选择要删除的学生");
                               return;
                           }
                           if(confirm("确定要删除这些学生吗")) {
                               var array = [];
                               $.each(checkVal,function (index,value) {

                                   array.push(value.id)
                               })
                               var arrayJson = JSON.stringify(array);
                               $.get("${pageContext.request.contextPath}/student/deleteSomeStudent.controller",{"strIds":arrayJson},function (result) {
                                   alert(result.msg);
                                   $("#studentDataGrid").datagrid("reload");

                               })
                           }
                       }
                   }
               ],
               onLoadSuccess:function () {

                   $(".button_view").linkbutton();

               }
           })

               $("#addStudentButton").click(function () {


                   $("#addStudentForm").form({
                       url:'${pageContext.request.contextPath}/student/addStudent.controller',
                       success:function (result) {

                           alert(JSON.parse(result).msg);
                           $("#addStudentWindow").window("close");
                           $("#addStudentForm").form("clear");
                           $("#studentDataGrid").datagrid("reload");


                       }
                   })

               })

            $("#updateGradeName").combobox({
                url:'${pageContext.request.contextPath}/grade/queryAllGrades.controller',
                method:'GET',
                valueField:'id',
                textField:'gradeName'
            })

            $("#updateStudentButton").click(function () {


                   $("#updateStudentForm").form({
                       url:'${pageContext.request.contextPath}/student/updateStudentController.controller',
                       success:function (result) {
                           console.log(result);
                           alert(JSON.parse(result).msg);
                           $("#updateStudentWindow").window("close");
                           $("#updateStudentForm").form("clear");
                           $("#studentDataGrid").datagrid("reload");


                       }
                   })

               })

            $("#queryAllButton").click(function () {

                var studentId = $("#queryStudent").val();
                alert("studentId=" + studentId);
                var gradeId = $("#queryGrade").val();
                alert("gradeId=" + gradeId);
            })

            $("#queryGrade").combobox({
                url:'${pageContext.request.contextPath}/grade/queryAllGrades.controller',
                method:'GET',
                valueField:'id',
                textField:'gradeName',
                onLoadSuccess:function () {
                    
                    $("#queryGrade").combobox("select","--请选择--")

                },
                onSelect:function (result) {

                    var gradeId = result.id;
                    $("#queryStudent").combobox({
                        url:'${pageContext.request.contextPath}/student/queryStudentByGradeId.controller',
                        method:'GET',
                        valueField:'id',
                        textField:'studentName',
                        queryParams:{"gradeId":gradeId}
                    })
                }


            })




        })
       function gradeName(value) {
           return value.gradeName;
       }
       function operator(id) {
           var queryStudent="<button class='button_view' onclick='queryStudent("+id+")'>详情</button>";

           var updateStudent="<button class='button_view' onclick='updateStudent("+id+")'>修改</button>";

           var deleteStudent="<button class='button_view' onclick='deleteStudent("+id+")'>删除</button>";
           
           return queryStudent + updateStudent + deleteStudent;
       }
       function queryStudent(id) {
          $.get("${pageContext.request.contextPath}/student/queryStudentById.controller",{"id":id},function (result) {

              $("#queryStudentName").textbox("setValue", result.studentName);
              $("#queryAge").textbox("setValue", result.age);
              $("#queryGender").textbox("setValue", result.gender);
              $("#queryStudentNum").textbox("setValue", result.studentNum);
              $("#queryGradeName").textbox("setValue", result.grade.gradeName);
              $("#queryStudentWindow").window("open");
          })
       }
       function updateStudent(id) {
           $.get("${pageContext.request.contextPath}/student/queryStudentById.controller",{"id":id},function (result) {


               $("#updateStudentForm").form("load", result);
               $("#updateStudentName").textbox("setValue", result.studentName);
               $("#updateAge").textbox("setValue", result.age);
               $("#updateGender").textbox("setValue", result.gender);
               $("#updateStudentNum").textbox("setValue", result.studentNum);

//               $("#updateGradeName").combobox("select", result.grade.id);
               $("#updateStudentWindow").window("open");
           })
       }
       function deleteStudent(id) {
           if(confirm("确定删除该信息吗")) {
               $.get("${pageContext.request.contextPath}/student/deleteStudent.controller",{"id":id},function (result) {

                   alert(result.msg);
                   $("#studentDataGrid").datagrid("reload");

               })
           }
       }
        
    </script>
</head>
<body>
<div>
    <form action="">
        <table>
            <tr>
                <td>班级名称：</td>
                <td>
                    <input class="easyui-combobox" id="queryGrade"/>
                </td>
                <td>学生姓名：</td>
                <td>
                    <input class="easyui-combobox" id="queryStudent"/>
                </td>
                <td>
                    <button id="queryAllButton" class="easyui-linkbutton">查询</button>
                </td>
            </tr>
        </table>
    </form>
</div>
<table id="studentDataGrid"></table>
<%--详情window--%>
<div class="easyui-window" id="queryStudentWindow" closed="true" style="left: 30% ;top: 30% ;width: 400px; height: 250px; padding:45px 60px">
    <table>
        <tr>
            <td>学生姓名：</td>
            <td>
                <input class="easyui-textbox" id="queryStudentName" />
            </td>
        </tr>
        <tr>
            <td>学生年龄：</td>
            <td>
                <input class="easyui-textbox" id="queryAge"/>
            </td>
        </tr>
        <tr>
            <td>学生性别：</td>
            <td>
                <input class="easyui-textbox" id="queryGender"/>
            </td>
        </tr>
        <tr>
            <td>班级名称：</td>
            <td>
                <input class="easyui-textbox" id="queryGradeName"/>
            </td>
        </tr>
        <tr>
            <td>学生学号:</td>
            <td>
                <input class="easyui-textbox" id="queryStudentNum"/>
            </td>
        </tr>
    </table>
</div>
<%--新增window--%>
<div class="easyui-window" id="addStudentWindow" closed="true" style="left: 30% ;top: 30% ;width: 400px; height: 250px; padding:45px 60px">
    <form action="" method="post" id="addStudentForm">
    <table>
        <tr>
            <td>学生姓名：</td>
            <td>
                <input class="easyui-textbox" id="addStudentName" name="studentName"/>
            </td>
        </tr>
        <tr>
            <td>学生年龄：</td>
            <td>
                <input class="easyui-textbox" id="addAge" name="age"/>
            </td>
        </tr>
        <tr>
            <td>学生性别：</td>
            <td>
                <input class="easyui-textbox" id="addGender" name="gender"/>
            </td>
        </tr>
        <tr>
            <td>班级名称：</td>
            <td>
                <input class="easyui-combobox" id="addGradeName" name="grade.id"/>
            </td>
        </tr>
        <tr>
            <td>学生学号:</td>
            <td>
                <input class="easyui-textbox" id="addStudentNum" name="studentNum"/>
            </td>
        </tr>
        <tr>
            <td>
                <button class="easyui-linkbutton" id="addStudentButton">保存</button>
            </td>
        </tr>
    </table>
    </form>
</div>
<%--修改window--%>
<div class="easyui-window" id="updateStudentWindow" closed="true" style="left: 30% ;top: 30% ;width: 400px; height: 250px; padding:45px 60px">
    <form action="" method="post" id="updateStudentForm">
        <table>
            <tr>
                <td>学生姓名：</td>
                <td>
                    <input class="easyui-textbox" id="updateStudentName" name="studentName"/>
                    <input  type="hidden" name="id"/>
                </td>
            </tr>
            <tr>
                <td>学生年龄：</td>
                <td>
                    <input class="easyui-textbox" id="updateAge" name="age"/>
                </td>
            </tr>
            <tr>
                <td>学生性别：</td>
                <td>
                    <input class="easyui-textbox" id="updateGender" name="gender"/>
                </td>
            </tr>
            <tr>
                <td>班级名称：</td>
                <td>
                    <input class="easyui-combobox" id="updateGradeName" name="grade.id"/>
                </td>
            </tr>
            <tr>
                <td>学生学号:</td>
                <td>
                    <input class="easyui-textbox" id="updateStudentNum" name="studentNum"/>
                </td>
            </tr>
            <tr>
                <td>
                    <button class="easyui-linkbutton" id="updateStudentButton">保存</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
