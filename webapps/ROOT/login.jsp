<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
</head>

<body>
  <form action="/result" method="POST">
    userName : <input name="userName" type="text">
    password : <input name="password" type="password">
    <button type="submit">submit</button>
  </form>
  <button onclick="submit()">submit</button>
  <script>
    // const form = document.forms;
    // console.log('form: ', form);
    function submit() {
      const userName = document.querySelector("[name='userName']")
      const password = document.querySelector("[name='password']")
      console.log('userName: ', userName.value);
      console.log('password: ', password.value);
      const data = { userName: userName.value, password: password.value };
      const formDate = new FormData();
      formDate.append("userName", userName.value);
      formDate.append("password", password.value);
      const queryStr = "userName=" + userName.value + "&password=" + password.value;
      fetch("/result", {
        method: "POST",
        body: queryStr,
        headers: {
          "Content-Type": "application/json"
        },
        credentials: "same-origin"
      }).then(function (response) {
        return response.text()
      }, function (error) {
        error.message //=> String
      }).then(res => {
        console.log('res: ', res);
      })
    }

  </script>
</body>

</html>