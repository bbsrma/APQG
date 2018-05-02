<!DOCTYPE html>
<html>
<head>
<title>AUTOMATIC QUESTION PAPER GENERATOR</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" href="style/css/bootstrap.min.css">
<link rel="stylesheet" href="style/css/bootstrap.css" >
</head>
<body>
<h3>welcome to AUTOMATIC QUESTION PAPER GENERATOR</h3>

<script src="css/bootstrap-3.3.0/dist/js/bootstrap.js"></script>
<script src="css/bootstrap-3.3.0/dist/js/bootstrap.min.js"></script>

<form class="form-horizontal" role="form" action="Servlet" method="post">
   
<div class="form-group">
<label for="username" class="col-md-2 control-label"></label>
<div class="col-md-3">
<p style="color:red; text-align:center;"> <%
    String check = request.getParameter( "flag" );
    %><%= check.toString() %>! </p>
</div>
</div>
<div class="form-group">
<label for="username" class="col-md-2 control-label">user name</label>
<div class="col-md-3">
<input class="form-control" type="text"  name="username" id="username" placeholder="username">
</div>
</div>
<div class="form-group">
<label for="password" class="col-md-2 control-label">password</label>
<div class="col-md-3">
<input type="password" name="password" class="form-control" id="password"
placeholder="password">
</div>
</div>
<div class="form-group">
<div class="col-sm-offset-2 col-sm-10">
<div class="checkbox">
<label>
<input type="checkbox" class=""> Remember me
</label>
</div>
</div>
</div>
<div class="form-group">
<div class="col-sm-offset-2 col-sm-10">
<button type="submit" class="btn btn-primary">log in</button>
<a class="btn btn-link"> forget password</a>
</div>
</div>
<div class="form-group">
<div class="col-sm-offset-2 col-sm-10">
<a class="btn btn-link" href="signup.html">create new account</a>
</div>
</div>
</form>
</body>
</html>