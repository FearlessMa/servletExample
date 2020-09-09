<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
</head>

<body>
  <div>
    <%@ include file="/jsp/header.jsp" %>
  </div>
  <div>
    <div>test</div>
    <div>
      今天的日期是: <%= (new java.util.Date()).toLocaleString()%>
    </div>
    <div>
      sid :<%= session.getAttribute("sid") %>
    </div>
    <div>
      cookie :
      <pre>
        for(int i=0;i < request.getCookies().length;i++){}
      </pre>
      <% for(int i=0;i < request.getCookies().length;i++){ %>
      <div>
        key= <%= request.getCookies()[i].getName() %>,
        value = <%= request.getCookies()[i].getValue() %>
      </div>
      <% } %>
    </div>
    <div>
      <br />
      <pre>
        Cookie cookie [] = request.getCookies();
        for(Cookie ck :cookie){}
      </pre>
      <% 
        Cookie cookie [] = request.getCookies();
        for(Cookie ck :cookie){
      %>
      <div><%= ck.getName() %> = <%= ck.getValue() %></div>
      <%}%>
    </div>
  </div>
  <div>
    <%@ include file="/jsp/footer.jsp" %>
    </div>
    <script>
      console.log("test.jsp")
    </script>
</body>

</html>