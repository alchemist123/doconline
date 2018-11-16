/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author KHSCI5MCA16125
 */
public class search extends HttpServlet {

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
            
            out.println("<html><head></head><body background=C:\\Users\\khsci5mca16125\\Documents\\NetBeansProjects\\DOCappoinmentsystem\\web\\photos\\di.jpg>");
            out.println("<script language=\"javascript\">"+
                  "function message()"+
                    "{alert(\'Thank you for your Request"
                    + "check your token status after 1 hour\');}"+            
                    "</script>"); 
           out.println("<style>"+
                    "body {font-family: Arial, Helvetica, sans-serif;\n" +
"                background-size: 100% 900px;\n" +
                          
"                background-repeat: no-repeat;}"+
                            "#ph{\n" +
"                width: 400px;\n" +
"                border-radius: 5px;\n" +
"                padding: 6px;\n" +
"                border: none;\n" +
"                outline: 0;\n" +
" }"+
                            "#sub{"+
                "opacity: 0.8;"+
                "width: 314px;"+
                "padding: 8px;"+
               " border-radius: 5px;"+
                "border: none;"+
            "}"+
       
                            "</style>");
            String spc=request.getParameter("special");
           try{  
Class.forName("com.mysql.jdbc.Driver");  
                try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/docrecord","root","")) {
                    PreparedStatement ps=con.prepareStatement("select * from docs where spe=?");
                    ps.setString(1,spc);
                    ResultSet rs=ps.executeQuery();
                    out.println("<h1 align=\"center\">Available Doctors</h1>");
                    while(rs.next()){
                        int i=0;
                        String name=rs.getString(1);
                        String ln=rs.getString(2);
                        String em=rs.getString(3);
                        String ph=rs.getString(4);
                        String ql=rs.getString(5);
                        String ag=rs.getString(6);
                        String gen=rs.getString(7);
                        String sp=rs.getString(8);
                         HttpSession session=request.getSession();  
                    session.setAttribute("de",name);
                   HttpSession session2=request.getSession(false);
                   if(session2!=null){
                        String nam=(String)session2.getAttribute("name"); 
                       String l=(String)session2.getAttribute("ln");
                        String ma=(String)session2.getAttribute("em"); 
                        String ph1=(String)session2.getAttribute("ph");
                        String ag1=(String)session2.getAttribute("ag");
                        String gen1=(String)session2.getAttribute("gen"); 
                        HttpSession session3=request.getSession();  
                    session3.setAttribute("name",nam);
                    session3.setAttribute("ln",l);
                    session3.setAttribute("em", ma);
                    session3.setAttribute("ph", ph1);
                    session3.setAttribute("ag", ag1);
                    session3.setAttribute("gen", gen1);
                   }
                        out.println("<center>");
                        out.println("<table border=\"5\" width=\"1000\" height=\"50\">");
                        out.println("<tr>");
                        out.println("<td><h4><font color=\"white\">"+name+"</h4></td>");
                        out.println("<td><h4><font color=\"white\">"+ln+"</h4></td>");
                        out.println("<td><h4><font color=\"white\">"+em+"</h4></td>");
                        out.println("<td><h4><font color=\"white\">"+ph+"</h4></td>");
                        out.println("<td><h4><font color=\"white\">"+ql+"</h4></td>");
                        out.println("<td><h4><font color=\"white\">"+ag+"</h4></td>");
                        out.println("<td><h4><font color=\"white\">"+gen+"</h4></td>");
                        out.println("<td><h4><font color=\"white\">"+sp+"</h4></td></font>");
                        out.println("<form method=\"post\" action=\"book\" onsubmit=\"return message()\">");
                        out.println("<td><h4><input type=\"text\" name=\"date\" id=sub ></h4></td>");
                        out.println("<td><h4><input type=\"submit\" value=\"book\" id=\"sub\"></form>"+"</td>");
                        out.println("</tr>");
                        out.println("</center>");
                        
                    }
                    
                }
                out.println("</body></html>");
           }catch(ClassNotFoundException | SQLException e){} 
          
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
        processRequest(request, response);
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
