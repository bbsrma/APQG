/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.servlet.*;
import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author BS
 */
@WebServlet(urlPatterns = {"/Servlet"})

public class Servlet extends HttpServlet{
    String userName,password;
    
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      // Set response content type
      
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      userName = request.getParameter("username");
      password = request.getParameter("password");
      //database connection 
      try {
        Connection con;        
        Statement stmt;  
            // JDBC driver n a m e a n d da t a ba s e URL
        String JDBC_DRIVER="com.mysql.jdbc.Driver";
        String DB_URL ="jdbc:mysql://localhost:3306/aqpg";
            //  Database credentials
        String USER = "root";
        String PASS = "";
          
             // Register JDBC driver
        Class.forName(JDBC_DRIVER);   
            // Open a connection
        con = DriverManager.getConnection(DB_URL, USER, PASS); 
            // Execute SQL query
         stmt = con.createStatement();
         String sql;
         sql = "SELECT * FROM user where username = '"+userName+"'";
         String site = site = "index.jsp?flag=invalid account";
         ResultSet rs =  stmt.executeQuery(sql);
         if(rs.next())
         {
             String psw = rs.getString("password");
             String utype = rs.getString("usertype");
             String type="admin";
             int verify =rs.getInt("verified");
            if(password.equals(psw)){
                if(verify == 1){
                site = new String("home.jsp");
                }
                else{
                    site = "index.jsp?flag=not verifed";
                    //request.setAttribute("error",verify);
                }
                if(utype.equals(type)){
                site = new String("adminhome.jsp");
                }
                
            }
            
         }
         response.setStatus(response.SC_MOVED_TEMPORARILY);
         response.setHeader("Location", site); 
         
         rs.close();
         stmt.close();
         con.close();
      
     
     }
     catch(Exception e){
         out.println(e);
     }      
}
}