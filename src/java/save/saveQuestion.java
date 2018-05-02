/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package save;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilePermission;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.security.AccessController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
@WebServlet(name = "saveQuestion", urlPatterns = {"/saveQuestion"})
public class saveQuestion extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet saveQuestion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet saveQuestion at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        // read questionset table and save to doc file
        PrintWriter out = response.getWriter();
        Connection con;        
        Statement stmt=null;  
        int count=0;
         String [] subquestion = null,question = null,year = null,subjectname=null;
         subquestion = new String[100];
         question = new String[100];
         year = new String[100];
        subjectname = new String[100];
        
        int[] mainquestion=null;
        int[] marks=null;
        
        mainquestion=new int[100];
        marks = new int[100];
        
        try {
        
            // JDBC driver n a m e a n d da t a ba s e URL
        String JDBC_DRIVER="com.mysql.jdbc.Driver";
        String DB_URL ="jdbc:mysql://localhost:3306/aqpg";
            //  Database credentials
        String USER = "root";
        String PASS = "";
        String sql=null;
             // Register JDBC driver
        Class.forName(JDBC_DRIVER);   
            // Open a connection
        con = DriverManager.getConnection(DB_URL, USER, PASS); 
            // Execute SQL query
        stmt = con.createStatement();
        sql="SELECT * FROM questionset;";
        //noofrow = Integer.parseInt(stmt.executeQuery("SELECT count(*) FROM questionset").toString());
        
        
        ResultSet rs = stmt.executeQuery(sql);
        String sq,q,y,subn;
        int mq,mk=0;
       
        while(rs.next()){
            
                mq=rs.getInt("mainquestion");
                mainquestion[count]=mq;
                
                sq=rs.getString("subquestion");
                subquestion[count]=sq;
                
                q=rs.getString("question");
                question[count]=q;
                
                mk=rs.getInt("marks");
                marks[count]=mk;
                
                y=rs.getString("year");
                year[count]=y;
                
                subn=rs.getString("subjectname");
                subjectname[count]=subn;
                
                //out.println(q);
              count++;  
            
           }
        
        }
        catch(Exception e){
            out.println(e);
            
        }
        
             // create new file
             String content0= ""; 
             String content1 = "\t\t\t\t\tPOKHARA UNIVERSITY ";
             String content2= "";
             String content3= "\t Level: Bachelor\t\t "+" "+" "+" "+" "+" Semester: \t\t\tYear: "+year[count-1];
             String content4= "\t Proramme: BE\t\t\t\t\t\t\t Full Marks: 100";
             String content5= "\t Course: "+subjectname[count-1]+"\t\t\t\t\t\t\t\tPass Marks: 45";
             String content6= "\t\t\t\t\t\t\t\t\t\t Time : 3 hrs.";
             String content7= ""; 
             String content8= "\t Candidate are required to give their answers in their own words as";
             String content81="\t far as possible";
             String content9= "\t The figures in the margin indicate full  marks.";
             String content10= "";
             String content11= "\t Attempt all the questions."; 
             
        
        try {
            //Whatever the file path is.
            File statText = new File("C:/Users/BS/Documents/NetBeansProjects/AQPG/build/web/questionpaper/"+subjectname[count-1]+".doc");
            FileOutputStream is = new FileOutputStream(statText);
            OutputStreamWriter osw = new OutputStreamWriter(is);    
            try (BufferedWriter w = new BufferedWriter(osw)) {
                
                 w.write(content0);
                 //w.newLine();
                  w.write(content1+"\n");
                  w.newLine();
                   w.write(content2+"\n"); 
                   w.newLine();
                   w.write(content3+"\n");
                   w.newLine();                   
                   w.write(content4+"\n");
                   w.newLine();
                   w.write(content5+"\n");
                   w.newLine();
                   w.write(content6+"\n");
                   w.newLine();
                   w.write(content7+"\n");
                   w.newLine();
                   w.write(content8+"\n");
                   w.newLine();
                   w.write(content81+"\n");
                   w.newLine();
                   w.write(content9+"\n");
                   w.newLine();
                   w.write(content10);
                   w.newLine();
                   w.write(content11);
                   w.newLine();
                   w.newLine();
                   
                   for(int j=0;j<count;j++){
                       if(j<=11){
                       if(j%2==0){
                        w.write("\t"+mainquestion[j]+"   "+subquestion[j]+"  "+question[j]+" "+marks[j]+" ");
                        w.newLine();
                       }
                       else{
                           w.write("\t    "+subquestion[j]+"  "+question[j]+" "+marks[j]+" ");
                         w.newLine();
                       
                       }
                       }
                        if(j==11){
                             w.write("\t7. write short note on any two");
                             w.newLine();
                             //mainquestion.toString();
                             
                             //w.write("\t\t"+""+subquestion[j]+" \t"+question[j]+" "+marks[j]+" ");
                            }
                        if(j>11){
                            w.write("\t    "+subquestion[j]+"  "+question[j]);
                            w.newLine();                 
                        }
                    }
                   
                   
                   
                   
            }
        } catch (IOException e) {
            System.err.println("Problem writing to the file statsTest.txt");
        }
        //out.println("generate successfylly");
        response.sendRedirect("adminhome.jsp?success=save sucessfully&parameter=enabled&sub="+subjectname[0]);
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
