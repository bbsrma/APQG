<!DOCTYPE html>
<html>
<head>
<title>teacher</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" href="style/css/bootstrap.min.css">
<link rel="stylesheet" href="style/css/bootstrap.css" >
</head>
<body style="background-color: #202028">
<nav class="navbar navbar-inverse" style="background: #343446; min-height: 85px;">
            <div class="container-fluid">
                            <div class="navbar-header">
				<a class="navbar-brand" href="#" style="font-size: 40px; margin: -10px; padding-left: 0px; font-family:klavika; color:#E3B1B1"><span><img src="logo-home.png"height="70px" width="80px" margin="-7px"> Automatic Question Paper Generation System</span></a>
    		</div>
    		<ul class="nav navbar-nav">
      			
			</ul>
    		</div>
</nav>

<form action="Servlet" method="post" class=" form form-horizontal" role="form" >

<div class="form-group">
<label for="username" class="col-md-2 control-label"></label>
<div class="col-md-3">
<p style="color:red; text-align:center;">
    <%String invalidnp= request.getParameter( "flag");
	if(invalidnp.equals(null)){
    %> <%} else{%> <%= invalidnp %><%}%></p>
</div>
</div>

<div class="form-group">
<label for="username" class="col-md-2 control-label" style="color: #B29D9D; margin-top: 10px;">User name</label>
<div class="col-md-3" style="margin-top: 10px;" >
<input class="form-control" type="text"  name="username" id="username" placeholder="username">
</div>
</div>
<div class="form-group">
<label for="password" class="col-md-2 control-label"style="color: #B29D9D"></style>Password</label>
<div class="col-md-3">
<input type="password" name="password" class="form-control" id="password"placeholder="password">
</div>
</div>
<div class="form-group">
<div class="col-sm-offset-2 col-sm-10">
<div class="checkbox">
<span style="padding-right: 4em"><label style="color: #98CBCB">
<input type="checkbox" class=""> Remember me
</label></span>
<span><a class="btn btn-link"style="color: #98CBCB; padding-left: 38px;"> Forget account?</a></span>
</div>
</div>
    </div>
<div class="form-group">
<div class="col-sm-offset-2 col-sm-10"style="color: #B29D9D">
<span style="padding-left:8px"><button type="submit"class="btn btn-primary"> log in</button></span>

</div>
</div>
<div class="form-group">
<div class="col-sm-offset-2 col-sm-10"style="color: #B29D9D">
<span style="padding-left:8px"></span>

</div>
</div>
<div class="form-group">
<div class="col-sm-offset-2 col-sm-10">
<button class="btn btn-link"  style="font-size: 26px; font-family: Georgia; font-weight: bold;padding-left:60px; "><a href="signup.jsp"/>Sign Up Here</button>
</div>
</div>
</form>
<script src="style/js/bootstrap.js"></script>
<script src="style/js/bootstrap.min.js"></script>
</body>
</html>