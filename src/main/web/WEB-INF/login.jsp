<%--
  Created by IntelliJ IDEA.
  User: THINKPAD
  Date: 2017/9/17
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <jsp:include page="batic.jsp"></jsp:include>
  </head>
  <body>
  <div class="easyui-window" id="loginWindow" style="left: 30% ;top: 30% ;width: 400px; height: 250px; padding:45px 60px">
    <form action="${pageContext.request.contextPath}/login/login.controller" id="loginForm" method="post">
      <table>
        <tr>
          <td>用户名：</td>
          <td>
            <input class="easyui-textbox" name="userName"/>
          </td>
        </tr>
        <tr>
          <td>密码：</td>
          <td>
            <input class="easyui-passwordbox" name="password"/>
          </td>
        </tr>
        <tr>
          <td>
            <button class="easyui-linkbutton" id="loginButton">登录</button>
          </td>
          <td></td>
        </tr>
      </table>
    </form>

  </div>
  ${msg}
  </body>
</html>
