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
        <link rel="stylesheet" type="text/css" href="footer.css">
        </head>
    <body>
<!-- header -->

 <% String user = (String)session.getAttribute("user");%>
 <% String utyp = (String)session.getAttribute("userType");%>
 
 
<nav class="navbar navbar-fixed-left navbar-defaults" style="padding-top: 85px;">
        <div class="col-md-3" style="border-style: transparent; border-right: thick double #181522; ">
            <!-- Left column -->
            
            <ul class="nav nav-fixed-left" >
                
                    <ul class="nav nav-fixed-top collapse in" id="userMenu" style="font-size: 18px; font-family: klavika; padding-left: 10px;">
                   
						<li  ><a href="#"></a></li>
                        <li class="active"> <a href="#"> <span class="glyphicon glyphicon-home"></span><i class="icon icon-home" ></i> Home</a></li>
                        
                        <li  ><a href="#"><i class="glyphicon glyphicon-user"></i> teacher</a></li>
                        <li class="active"> <a href="#"> <span class="glyphicon glyphicon-calendar"></span> Events</a></li>
                        <li class="active"> <a href="rulesRegulations.html"> <span class="glyphicon  glyphicon-registration-mark"></span> Rules & Regulations</a></li>
                        <li class="active"> <a href="registeredCollege.html"> <span class="glyphicon  glyphicon-list"></span> Registered Colleges</a></li>
                        <li class="active"> <a href="#"><form><span class="glyphicon glyphicon-plus-sign"></span> Add questions
                        <select name="subject" required class="form-control" onchange="this.form.submit()" style="border: solid grey 2px; padding-right: 20px;">
                                <option value="">Choose Subject......</option>
                                <option value="oosd">OOSD</option>
                                <option value="mmt">MMT</option>
                                <option value="cn">CN</option>
                        </select>
                        </form>
                        </a>
                        </li>
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
						<li  ><a href="#"></a></li>
						  <li  ><a href="#"></a></li>
                        
						 </ul>
                        </li>
                    </ul> 
                </ul>        
            </div>
            <div class="col-md-9">
        
            
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <div class="panel-title">
                               
                                <h4><% String sub= request.getParameter("subject");  
                                        if(sub==null){
                                    %> <h4>choose subject first</h4><% } else{ %><h4> enter <%= sub %>
                                        questions </h4><% } %>
                                    
                                    
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
            </div>
            </div>
        </div>
        </div>
        </div>
        </div>



        </div>
        </div>
    </nav>




    <nav class="navbar navbar-fixed-top navbar-inverse" style="background:#181522; min-height: 73px;">
            <div class="container-fluid">
          <!--  <div class="navbar-header">

      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
                <a class="navbar-brand" href="#" style="font-size: 44px; margin:-9px; padding-left: 0px; font-family: Klavika; color:#E3B1B1"><span><img src="logo-home.png"height="70px" width="80px" margin="-7px"> Automatic Question Paper Generation System</span></a>
            </div>
            <ul class="nav navbar-nav navbar-right" style="margin-top: 11px;">
            
                <li class="dropdown">
                    <a class="dropdown-toggle" role="button" data-toggle="dropdown" href="#"><i class="glyphicon glyphicon-user"></i> Admin <span class="caret"></span></a>
                    <ul id="g-account-menu" class="dropdown-menu" role="menu">
                        <li><a href="#">My Profile</a></li>
                    </ul>
                </li>
                <li><a href="#"><i class="glyphicon glyphicon-lock"></i> Logout</a></li>
                <li><a href="#"></li>
            </ul>
            </div>
</nav>-->
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
                    <a class="dropdown-toggle" role="button" data-toggle="dropdown" href="#"><i class="glyphicon glyphicon-user"></i>teacher<span class="caret"></span></a>
                    <ul id="g-account-menu" class="dropdown-menu" role="menu">
                        <li><a href="#">My Profile</a></li>
                        <li><a href="userrequest.jsp">Teachers</a></li>
                    </ul>
                </li>
                <li><a href="logout.jsp"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
        </ul>
    </div>
  </div>
  </div>
</nav>


<footer class="footer1" style="background: #181522;">
<div class="container">
<div class="row"><!-- row -->
     <div class="col-lg-4 col-md-4" style="color: skyblue;padding-left: 40px; font-size: 18px; font-family: lucidia;"><!-- widgets column center -->
        <ul class="list-unstyled clear-margins" style="padding-top: -30px;"><!-- widgets -->
                         <li class="widget-container widget_recent_news"><!-- widgets list -->
                                <h2 class="title-widget"><b>Contact Details</b></h2>

                                <p ><li><span class="glyphicon glyphicon-map-marker"></span> Lamachaur-16</li>
                                <li style="padding-left: 30px;">Pokhara,Nepal</li></p>
                                <p><span class="glyphicon glyphicon-earphone"></span><b> +9779816674848</b></p>
                                <p><a href="mailto:info@aqpgSystem.com"><span class="glyphicon glyphicon-envelope"></span> info@aqpgSystem.com</a></p>
                                
                        </li>
        </ul>
     </div>

    <div class="container">
<div class="row"><!-- row -->
     <div class="col-lg-4 col-md-4" style="color: skyblue;padding-left: 40px; font-size: 24px; font-family: lucidia;"><!-- widgets column center -->
        <ul class="list-unstyled clear-margins" style="padding-top: -30px;"><!-- widgets -->
                         <!-- widgets list -->
                                <h2 class="title-widget"><b>Connect with us</b></h2>
            <a class="btn btn-default fb" href="https://facebook.com" aria-label="Settings">
                    <i class="fa fa-facebook fa-2x" aria-hidden="true"></i>
                </a>
                <a class="btn btn-default tw" href="https://twitter.com" aria-label="Settings">
                    <i class="fa fa-twitter fa-2x" aria-hidden="true"></i>
                </a>
                <a class="btn btn-default ins" href="https://instagram.com" aria-label="Settings">
                    <i class="fa fa-instagram fa-2x" aria-hidden="true"></i>
                </a>
                <a class="btn btn-default sky" href="https://skype.com" aria-label="Settings">
                    <i class="fa fa-skype fa-2x" aria-hidden="true"></i>
                </a>
                <a class="btn btn-default ggp" href="https://plus.google.com/" aria-label="Settings">
                    <i class="fa fa-google-plus fa-2x" aria-hidden="true"></i>
                </a>
            </div>
        

<div class="container">
<div class="row"><!-- row -->
     <div class="col-lg-4 col-md-4" style="color: skyblue;padding-left:18px; font-size: 20px; font-family: lucidia;"><!-- widgets column center -->
        <ul class="list-unstyled clear-margins" style="padding-top: -30px;"><!-- widgets -->
                         <li class="widget-container widget_recent_news"style="padding-left:90px; text-align: cenetr;"><!-- widgets list -->
                                <h2 class="title-widget" ><b>About us</b></h2>

                                <p ><li style="text-align: center;">Automatic Question Paper Generator is a system which makes use of shuffling to produce unduplicated questions paper using linear congruential method in java.</li>


                        </li>
        </ul>
     </div>
</footer>
        
<div class="footer-bottom">

    <div class="container">

        <div class="row">

            <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">

                <div class="copyright">

                   copyright © 2016, Aqpg System, All rights reserved

                </div>

            </div>

            <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6">

                <div class="design">

                     <a href="#">Lava Fraternity </a> |  <a target="_blank" href="http://www.aqpgSystem.com">Web Design & Development by Bhuwan,Bimal & Yuvraj </a>

                </div>

            </div>
    <!-- script references -->
        <script src="style/jquery/jquery-2.1.3.min.js"></script>
        <script src="style/js/bootstrap.min.js"></script>
        <script src="style/js/scripts.js"></script>
    </body>
</html>