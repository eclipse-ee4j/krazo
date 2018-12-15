hello(user, mvc) ::= <<

<html>
    <head>
      <title>Hello</title>
      <link rel="stylesheet" type="text/css" href="$mvc.contextPath$/krazo.css" />
    </head>
    <body>
      <h1>Hello $user; format="xml-encode"$!</h1>
    </body>
</html>

>>