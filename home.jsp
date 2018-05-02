<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<title>AUTOMATIC QUESTION PAPER GENERATOR:: Teacher</title>
		<meta name="generator" content="Bootply" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link rel="stylesheet" href="style/css/bootstrap.min.css">
		<link href="style/css/styles.css" rel="stylesheet">
               
        </head>
	<body>
<!-- header -->
<div id="top-nav" class="navbar navbar-inverse navbar-static-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <b><a class="navbar-brand" href="#">AUTOMATIC QUESTION PAPER GENERATOR</a></b>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" role="button" data-toggle="dropdown" href="#"><i class="glyphicon glyphicon-user"></i> Admin <span class="caret"></span></a>
                    <ul id="g-account-menu" class="dropdown-menu" role="menu">
                        <li><a href="#">My Profile</a></li>
                    </ul>
                </li>
                <li><a href="#"><i class="glyphicon glyphicon-lock"></i> Logout</a></li>
            </ul>
        </div>
    </div>
    <!-- /container -->
</div>
<!-- /Header -->

<!-- Main -->
<div class="container-fluid">
    
    <div class="row">
        <div class="col-md-2">
            <!-- Left column -->
            <a href="#"><strong><i class="glyphicon glyphicon-wrench"></i> Tools</strong></a>

            <hr>

            <ul class="nav nav-stacked">
                <li class="nav-header"> <a href="#" data-toggle="collapse" data-target="#userMenu">Settings <i class="glyphicon glyphicon-chevron-down"></i></a>
                    <ul class="nav nav-stacked collapse in" id="userMenu">
                        <li class="active"> <a href="subject"><i class="icon icon-home"></i> Home</a></li>
                        <li><form>select subject
							<select name="subject" class="form-control" onchange="this.form.submit()">
								<option>choose subject</option>
								<option>OOSD</option>
								<option>MMT</option>
								<option>CN</option>
							</select>
                            </form>
			</li>
                        <li><a href="#"><i class="glyphicon glyphicon-cog"></i> Options</a></li>
                        <li><a href="#"><i class="glyphicon glyphicon-book"></i> past paper</a></li>
                        <li><a href="#"><i class="glyphicon glyphicon-flag"></i> Transactions</a></li>
                        <li><a href="#"><i class="glyphicon glyphicon-exclamation-sign"></i> Rules</a></li>
                        <li><a href="login.html"><i class="glyphicon glyphicon-off"></i> Logout</a></li>
                    </ul>
                </li>
                
                <li class="nav-header">
                    <a href="#" data-toggle="collapse" data-target="#menu3"> Social Media <i class="glyphicon glyphicon-chevron-right"></i></a>
                    <ul class="nav nav-stacked collapse" id="menu3">
                        <li><a href=""><i class="glyphicon glyphicon-circle"></i> Facebook</a></li>
                        <li><a href=""><i class="glyphicon glyphicon-circle"></i> Twitter</a></li>
                    </ul>
                </li>
            </ul>   
		</div>
        <!-- /col-3 -->
        <div class="col-md-9">
		
            
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <div class="panel-title">
                                <i class="glyphicon glyphicon-wrench pull-right"></i>
                                <h4><% String sub= request.getParameter("subject");  
                                        if(sub==null){
                                    %> <h4>choose subject first</h4><% } else{ %><h4> enter <%= sub %>
                                        question paper </h4><% } %>
                                    
                                    
                            </div>
                        
                        
                                        
                        <!--/panel content-->
                    </div>
                                        <div class="panel-body"><% if(sub==null){%>
                            <%@include  file="homescreen.html"%><% } else{ %>
                                <%@include  file="addQuestion.jsp"%> <% } %>
                        </div>

                    <hr>
                   
                </div>
                

            </div>
          

            
        </div>
        <!--/col-span-9-->
<!-- /Main -->

<footer class="text-center">your comments here <a href="http://www.AQPG.com/comments"><strong>AQPG.com</strong></a></footer>

<div class="modal" id="addWidgetModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title">Add Widget</h4>
            </div>
            <div class="modal-body">
                <p>Add a widget stuff here..</p>
            </div>
            <div class="modal-footer">
                <a href="#" data-dismiss="modal" class="btn">Close</a>
                <a href="#" class="btn btn-primary">Save changes</a>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dalog -->
</div>
<!-- /.modal -->
	<!-- script references -->
		<script src="style/jquery/jquery-2.1.3.min.js"></script>
		<script src="style/js/bootstrap.min.js"></script>
		<script src="style/js/scripts.js"></script>
	</body>
</html>