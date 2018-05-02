/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signuppackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author BS
 */
public class verifyUser {
    String userName;
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      // Set response content type
        
      
       try (PrintWriter out = response.getWriter()) {
           
            userName=request.getParameter("username");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet signupServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            //database connection and insert data in database 
            Connection con;        
            Statement stmt;  
      // JDBC driver n a m e a n d da t a ba s e URL
        String JDBC_DRIVER="com.mysql.jdbc.Driver";
        String DB_URL ="jdbc:mysql://localhost:3306/aqpg";
    //  Da t a ba s e creden t ia ls
     String USER = "root";
     String PASS = "";
     String site="userrequest.jsp";
     try{              
Class.forName(JDBC_DRIVER);              
con = DriverManager.getConnection(DB_URL, USER, PASS);              
stmt=con.createStatement(); 
int a=0;
String userlist="select username from user";
ResultSet r = stmt.executeQuery(userlist);

while(r.next()){
    a++;
}

stmt.executeUpdate("update `user`  SET verified = 1 WHERE username='" + userName+"'"); 

out.print("total user request "+a);
if (stmt.equals("1"))
        {
        out.print(userName+"<p> user is verified</p>");
        
        site="userrequest.jsp?flag=true;";
       }
else{
    out.print(userName+"<p> invalid username</p>");
        
        site="userrequest.jsp?flag=false;";
}


//response.setStatus(response.SC_MOVED_TEMPORARILY);
//response.setHeader("Location", site); 
//stmt.executeUpdate("Select * from user WHERE verified = 1");  
}      
catch(Exception e)        
{          out.println(e);               
 }
            
    
                                }
       
                         }
}
