
  <html>

  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>TODO app - Login</title>
  </head>

  <body>

    <div align=center>
      <h1>User Login</h1>
    </div>
    <pre>${errorMessage}</pre>
    <form method=post>
      <table>
        <tr>
          <td>Enter Name:</td>
          <td><input type=text name=username></td>
        </tr>
        <tr>
          <td>Enter Password:</td>
          <td><input type=password name=password></td>
        </tr>
        <tr>
          <td><input type=submit></td>
          <td><input type=reset></td>
        </tr>
      </table>
    </form>

    <style>
      .center-table {
        margin-left: auto;
        margin-right: auto;
        width: 50%;
      }
    </style>


  </body>

  </html>