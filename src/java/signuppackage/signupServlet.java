package signuppackage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author BS
 */
@WebServlet(urlPatterns = {"/signupServlet"})
public class signupServlet extends HttpServlet {
    String name,email,username,password,collegename,repassword;
    //int id;
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      // Set response content type
      
       try (PrintWriter out = response.getWriter()) {
            name = request.getParameter("name");
            email=request.getParameter("email");
            username=request.getParameter("username");
            password = request.getParameter("password");
            repassword= request.getParameter("repassword");
            collegename=request.getParameter("collegename");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet signupServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
           if(password.equals(repassword)){
               String pass="success";
            
            }
           else{
            response.sendRedirect("signup.jsp?mispass=mismatch password");
           }
      //database connection and insert data in database 
            Connection con;        
            Statement stmt;  
      // JDBC driver n a m e a n d da t a ba s e URL
        String JDBC_DRIVER="com.mysql.jdbc.Driver";
        String DB_URL ="jdbc:mysql://localhost:3306/aqpg";
    //  Da t a ba s e creden t ia ls
     String USER = "root";
     String PASS = "";
     try{              
Class.forName(JDBC_DRIVER);              
con = DriverManager.getConnection(DB_URL, USER, PASS);              
stmt=con.createStatement();              
stmt.executeUpdate("insert into user(name,email,username,password,collegename) values('"+name+"', '"+email+"', '"+username+"','"+password+"','"+collegename+"')");       
}      
catch(Exception e)        
{
out.println(e);   
response.sendRedirect("signup.jsp?flag=false");
 } 
      
     out.println("<h2>sign up successfully you can log in using your account</h2>");
     out.println("<h3><a href=" + "index.html"+">log in here"+"</a></h3>");
     out.println("<h2>"+name+"</h2>");
     out.println("<h2>"+email+"</h2>");
     out.println("<h2>"+username+"</h2>");
     out.println("<h2>"+collegename+"</h2>");
     out.println("</body>");
     out.println("</html>");
     
       }
     }

    }    