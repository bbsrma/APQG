/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generateQuestion;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import static javafx.application.Platform.exit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author BS
 */
@WebServlet(name = "generate", urlPatterns = {"/generate"})
public class generate extends HttpServlet {
    

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
            out.println("<title>Servlet generate</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet generate at " + request.getContextPath() + "</h1>");
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
        int scount=0;
        int mcount=0;
        int hcount=0;
         // read form fields
      
        String subName = request.getParameter("sub");
        String [] questionPaper = new String[20];
        int [] questionMarks = new int[20];
        ArrayList list =new ArrayList();
        ArrayList marksList =new ArrayList();
 // get response writer
        PrintWriter writer = response.getWriter();
         
        writer.println("<html><body>subject : " + subName+"<br/><br/>");
        // database connection retrive question implements random no. and final question set save to database
         Connection con;        
        Statement stmt=null;  
        try {
        
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
         int j;
         int k=0;
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
         //call random number function for complexity
        int dl = rand_num(3);
        String cl=null;
        if(dl==0) {cl = "S"; scount++; }
        if(dl==1) {cl = "M"; mcount++; }
        if(dl==2) {cl = "H"; hcount++; }
        System.out.println("complexity for "+j+" "+sq+" ." + cl);
        
         String sql="Select * from questioncollection WHERE subjectname='"+subName+"' && mainquestion = "+j+" && subquestion='"+sq+"'"+"&& complexity='"+cl+"'";
         //String totalQuestion="Select count(*) from questioncollection WHERE subjectname='"+subName+"' && mainquestion = "+j+" && subquestion='"+sq+"'";;
         int size=0;
         
         
         ResultSet rs =  stmt.executeQuery(sql);
         //writer.println("total question:"+(stmt.executeQuery(totalQuestion)));
            
         
         while(rs.next()){
             //needed question save to q array  
             
             list.add(rs.getString("question"));
             marksList.add(rs.getInt("marks"));
              String p = list.get(k).toString();
              int q = Integer.parseInt(marksList.get(k).toString());
            writer.println(j+" "+ sq+"." +"question : " + p +"marks: "+q+"<br/>"); 
            k++;
           }
         //call random number for select question form q array
         
         Random rn = new Random();
         //int answer = rn.nextInt(k);
         int a = rand_num(k);
         writer.println("\n total no of question"+a);
         
         questionPaper[i] = list.get(a).toString();
         questionMarks[i]=Integer.parseInt(marksList.get(a).toString());
         writer.println("rndom question: "+list.get(a)+"<br/><br/>");
         writer.println("total question : "+k+"<br/>");
          writer.println("rndom no: "+a+"<br/><br/>");
         //call random number function to choose special one;
         //save special one o question database;
         }
           
        
        
        }
        catch(Exception e){
             writer.println(e);
             writer.println("generate again reload it");
             
             response.sendRedirect("adminhome.jsp?status=fail");
        }
        
        try{
            int j;
            int totalMarks=0;
            String sql;
            String reset="DELETE FROM questionset";
            stmt.executeUpdate(reset);
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
        int mks;
        mks=10;
         sql= "insert into questionset (mainquestion,subquestion,question,marks,year, subjectname) values("+j+",'"+sq+"','"
                 +questionPaper[i]+"',"+questionMarks[i]+",'2016','"+subName+"')";
        
        stmt.executeUpdate(sql);
        totalMarks += questionMarks[i];
            }
        writer.println("<h3>question insert into questionset table</h3>");
        writer.println("scount: "+scount+"<br/>");
        writer.println("mcount: "+mcount+"<br/>");
        writer.println("hcount: "+hcount+"<br/>");
        response.sendRedirect("adminhome.jsp?status=success&parameter=enabled&sub="+subName+"&param1="+scount+"&param2="+mcount+"&param3="+hcount+"&marks="+totalMarks);
        scount=0;mcount=0;hcount=0;
        }catch(Exception e){
            writer.println(e);
        }
        
        writer.println("<center><h2>question paper</h2>");
        for(int i=2;i<18;i++){
        writer.println("<center><h2>"+questionPaper[i]+"</h2></center>");
        }
        
        
        
        
        //htmlRespone += "<h2>Your username is: " + username + "<br/>";      
        writer.println("</body></html>");
         
        // return response
        
    }

   /* private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}*/
    private int rand_num(int m) {
        
        Random rnd = new Random();
        int x=10;
        int P1,P2;
        P1=rnd.nextInt(302);
        P2=rnd.nextInt(672);
        
        x = (P1*x + P2) % m;
        //writer.println("x= "+x);
        return x;
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

   // private int rand_num(int m) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    //int x;
    //int 
    
    //}

}
