<%--
  Created by IntelliJ IDEA.
  User: danik
  Date: 1/22/19
  Time: 9:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <title>Status</title>
      <script src="static/jQuery.js"
              type="text/javascript"></script>
      <script type="text/javascript" src="static/listDisplayer.js"></script>
  </head>
  <body>
    Click it!
    <input type = "button" onclick = "onClick()" value = "Refresh" />
    <div id="ajaxGetUserServletResponse"></div>
  </body>
</html>
