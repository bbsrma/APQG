<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

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

            


<div class="row">
<nav class="navbar navbar-fixed-left navbar-defaults" style="padding-top: 85px;">
        <div class="col-md-3" style="border-style: transparent; border-right: thick double #181522; ">
            <!-- Left column 
            <a href="#" ><strong><i class="glyphicon glyphicon-wrench"></i>Tools</strong></a>
            
             
-->             <ul class="nav nav-fixed-left" >
                
                    <ul class="nav nav-fixed-top collapse in" id="userMenu" style="font-size: 18px; font-family: klavika; padding-left: 10px;">
                   
                            
                        <li class="active"> <a href="#"> <span class="glyphicon glyphicon-home"></span><i class="icon icon-home" ></i> Home</a></li>
                        <li> <a href="#"><i class="glyphicon glyphicon-user"></i> user</a></li>
                        <li class="active"> <a href="#"> <span class="glyphicon glyphicon-calendar"></span> Events</a></li>
                        <li class="active"> <a href="rulesRegulations.html"> <span class="glyphicon  glyphicon-registration-mark"></span> Rules & Regulations</a></li>
                        <li class="active"> <a href="registeredCollege.html"> <span class="glyphicon  glyphicon-list"></span> Registered Colleges</a></li>
						
						<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/aqpg"
     user="root"  password=""/>
 
<sql:query dataSource="${snapshot}" var="result">
SELECT * from user WHERE `verified`=0;
</sql:query>
<%int totalrow=0; %>
<c:forEach var="row" items="${result.rows}">
<% totalrow++; %>
</c:forEach>
						
						
                        <li><a href="userrequest.jsp"><span class="glyphicon glyphicon-info-sign"></span> User Request <span class="tori" style="border-radius: 20px; color:white; background:#4CAF50;padding:10px;border:1px #4CAF50 solid;"><%= totalrow %></span></a></li>
                        <li class="nav-header">
                        <a href="#" data-toggle="collapse" data-target="#menu1"><span class="glyphicon glyphicon-book"></span> Past Papers <i class="glyphicon glyphicon-pull-down"></i></a>
                        <ul class="nav nav-stacked collapse" id="menu1">
                        <li class="dropdown">
                        <a class="dropdown-toggle" role="button" data-toggle="dropdown" href="#"><i class="glyphicon glyphicon-book"></i> Subjects <span class="caret"></span></a>
                        <ul id="g-account-menu" class="dropdown-menu" role="menu">
                        <li><a href="C:\Users\user\Desktop\AQPG\OOSD">OOSD</a></li>
                        <li><a href="Ai_Syllabus.pdf">CN</a></li>
                        <li><a href="Ada_Syllabus.pdf">MMT</a></li></ul>
                        </li>   
                        </ul>
                        </li>
                        
                        <li class="nav-header">
                        <a href="#" data-toggle="collapse" data-target="#menu2"> <span class="glyphicon glyphicon-file"></span> Syllabus<i class="glyphicon glyphicon-pull-down"></i></a>
                        <ul class="nav nav-stacked collapse" id="menu2">
                        <li class="dropdown">
                        <a class="dropdown-toggle" role="button" data-toggle="dropdown" href="#"><i class="glyphicon glyphicon-book"></i> Subjects <span class="caret"></span></a>
                        <ul id="g-account-menu" class="dropdown-menu" role="menu">
                        <li><a href="#">OOSD</a></li>
                        <li><a href="Ai_Syllabus.pdf">CN</a></li>
                        <li><a href="Ada_Syllabus.pdf">MMT</a></li>
                        </ul>
                        </li>
                        </ul>
                        </li>  
                        <li class="nav-header">
                        <a href="#" data-toggle="collapse" data-target="#menu4"><span class="glyphicon glyphicon-download"></span> Generate Paper
                        </li>
                        <li class="active"> <a href="#"></a></li>

                        </ul>
                        </li>
                    </ul> 
                </ul>        
            </div>
		<div class="col-md-9">
					
					<div class="panel panel-default">
                        <div class="panel-heading">
                            <div class="panel-title">
                                <i class="glyphicon glyphicon-wrench pull-right"></i>
                                <h4>these user need to verify</h4>
                            </div>
                        </div>
                        <div class="panel-body">
                          
 
<table border="1" width="100%">
<tr>
   <th>name</th>
   <th>email</th>
   <th>username</th>
   <th>collegename</th>
   <th>verified</th>
</tr><%int trow=0; %>
<c:forEach var="row" items="${result.rows}">
<tr class="bg-danger">
   <td><c:out value="${row.name}"/></td>
   <td><c:out value="${row.email}"/></td>
   <td><c:out value="${row.username}"/></td>
   <td><c:out value="${row.collegename}"/></td>
   <td><c:out value="${row.verified} "/></td>
   <td><c:out value="${row.length} "/></td>
   <% trow++; %>
</tr>
</c:forEach>
</table>
                        
						</div>
                        <!--/panel content-->
						<div class="container">
  <h2>enter user name to verify</h2>
  <form class="form-horizontal" method="post" action="NewServlet">
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">username:</label>
      <div class="col-md-2">
        <input type="text" name="username"  class="form-control" placeholder="Enter username">
      </div>
    </div>
    
    <div class="form-group">
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-primary">Submit</button>
      </div>
    </div>
  </form>
</div>
                    </div>
		</div>
	   
	   
	</nav>
	</div>
<!-- /Header -->

<!-- Main -->
<div class="container-fluid">
    <div class="row">
        <nav class="navbar navbar-fixed-top navbar-inverse" style="background:#181522; min-height: 73px;">
            <div class="container-fluid">
<div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#" style="font-size: 40px; margin: -9px; padding-left: 0px; font-family: Klavika; color: #FFFFFF"><span><img src="logo-home.png"height="60px" width="70px" margin="-7px" > Automatic Questions Paper Generation System</span></a>
   
      </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav nav navbar-right" style="margin-top: 11px; padding-right: 20px;">
        <li class="dropdown">
                    <a class="dropdown-toggle" role="button" data-toggle="dropdown" href="#"><i class="glyphicon glyphicon-user"></i> user <span class="caret"></span></a>
                    <ul id="g-account-menu" class="dropdown-menu" role="menu">
                        <li><a href="#">My Profile</a></li>
                        <li><a href="userrequest.jsp">User Requests</a></li>
                    </ul>
                </li>
                <li><a href="logout.jsp"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
        </ul>
    </div>
  </div>
  </div>
</nav>
		
		
		
		</div>
		
	<!-- script references -->
		<script src="style/jquery/jquery-2.1.3.min.js"></script>
		<script src="style/js/bootstrap.min.js"></script>
		<script src="style/js/scripts.js"></script>
	</body>
</html>