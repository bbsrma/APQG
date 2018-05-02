
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Calendar;
import java.util.TimeZone;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BS
 */
public class postQuestion {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
      // Set response content type
      
      
      PrintWriter out = response.getWriter();
      Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
      //getTime() returns the current date in default time zone
      Date date = (Date) calendar.getTime();
      int dayOfYear; 
      
      
      //database connection 
      String subname,subquestion,question[]=null,complexity[]=null;
      int mainquestion[]=null,marks[]=null;
            subname=request.getParameter("subjectname");
            dayOfYear= calendar.get(Calendar.DAY_OF_YEAR);
            for(int i=1; i<=16;i++){
                String sq;
                    if(i%2==0){
                        sq  ="b";
                    }
                    else{
                        sq="a";
                    }
                    int j=1;
                    if(i>2){
                    j=i/2;
                    }
                question[i]=request.getParameter("question"+j+sq);
                
                marks[i]=Integer.parseInt(request.getParameter("marks"+j+sq));
                
                complexity[i]=request.getParameter("complexity"+j+sq);
            }
            
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
         String sql=null;
         out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet signupServlet</title>");            
            out.println("</head>");
            out.println("<body>");
         out.println("<h4>database connection successfully</h4>");
         for(int i=1;i<=16;i++){
             
             String sq;
                    if(i%2==0){
                        sq  ="b";
                    }
                    else{
                        sq="a";
                    }
                    int j=1;
                    if(i>2){
                    j=i/2;
                    }
             
         sql = "INSERT INTO questioncollection (`subjectname`,`year`,`mainquestion`,`subquestion`,`question`,`marks`,`complexity`)"
              + " VALUES('"+subname+"',"+dayOfYear+","+j+",'"+sq+"',"+question+"+["+i+"],"+marks+"["+i+"],'"+complexity+"["+i+"]')";
         }
         stmt.executeUpdate(sql);
         out.println("question insert successfully");
         
    }
      catch(Exception e){
          out.println(e);
      }
    }
    
    
}
