/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signuppackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Calendar;
import java.util.TimeZone;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author BS
 */
@WebServlet(name = "question", urlPatterns = {"/question"})
public class question extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet question</title>");            
            out.println("</head>");
            out.println("<body>");
           out.println("<h1>Servlet question at " + request.getContextPath() + "</h1>");
            out.print("code here");
            int dayOfYear; 
            String subname;
            Calendar calendar;
            
            String [] question =new String[20];
            int [] marks =new int[20];
            String [] complexity =new String[20];
            
            
        calendar= Calendar.getInstance(TimeZone.getDefault());
        dayOfYear= calendar.get(Calendar.DAY_OF_YEAR); 
        subname=request.getParameter("subjectname");
            //dayOfYear=2016;
        try{
           for(int i=2; i<18;i++){
	
                marks[i]=Integer.parseInt(request.getParameter("marks"+i));
                complexity[i]=request.getParameter("complexity"+i);
                question[i]=request.getParameter("question"+i);
                
              }}
        catch(Exception e){
            String site="home.jsp?subject="+subname+"&& flag=invalid";
                    response.setStatus(response.SC_MOVED_TEMPORARILY);
                    response.setHeader("Location", site);
            
        }
           /*for(int i=2; i<18;i++){
               if((question[i]) == null){
                    String site="home.jsp?subject="+subname+"&& flag=invalid";
                    response.setStatus(response.SC_MOVED_TEMPORARILY);
                    response.setHeader("Location", site);
                }
           else 
                   response.sendRedirect("index.jsp");
           }*/
           out.println("<h5> subjectname:"+subname+"</h5>");
            
            
                 
        try  {
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
        out.println("<h4>database connection successfully</h4>");
         stmt = con.createStatement();
         String sql=null;    
      
      
      //database connection 
      
           int j;
           for(int i=2;i<18;i++){
               String sq;

	j=i/2;
	if(i%2==0){
		sq="a";
                   }
        else{
             sq="b";
            }
        if(i==16){
                sq="c";
                j=7;
                }
        if(i==17){
                sq="d";
                j=7;
                }
               out.println(j+" "+sq+"  \t");
               out.println(question[i]+"\t  ");
               out.println(marks[i]+"\t  ");
               out.println(complexity[i]+"\t  <br/>");
               sql="INSERT INTO questioncollection(`subjectname`, `year`, `mainquestion`, `subquestion`, `question`, `marks`, `complexity`)"
                +" VALUES ('"+subname+"',"+dayOfYear+","+j+",'"+ sq +"','"+question[i]+"',"+marks[i]+",'"+complexity[i]+"')";
                 
         stmt.executeUpdate(sql);
         out.println("question insert successfully");
           }
         }
   
      catch(Exception e){
          out.println(e);
      }
            
            
            
            
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
