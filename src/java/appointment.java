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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author KHSCI5MCA16125
 */
public class appointment extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<html>");
            out.println("<head><title>weclome</title></head><body background=C:\\Users\\khsci5mca16125\\Documents\\NetBeansProjects\\DOCappoinmentsystem\\web\\photos\\doctorgirl.jpg>");
           out.println("<style> body {font-family: Arial, Helvetica, sans-serif;\n" +
"                background-size: 100% 900px;\n" +
"                background-repeat: no-repeat;}"+
                   
                   "#re{ln"+
                   "    background-color: #4CAF50;\n"+
                   "    color: red;\n"+
                   "    margin: 8px 0;\n" +
                   "    border: none;\n" +
                   "    cursor: pointer;\n" +
                   "    width: 100%;\n" +
                   "}"+
                   "#sub{ln"+
                   "    background-color: #4CAF50;\n"+
                   "    color: green;\n"+
                   "    margin: 8px 0;\n" +
                   "    border: none;\n" +
                   "    cursor: pointer;\n" +
                   "    width: 100%;\n" +
                   "}"+
                   
                  ""
                   + "input[type=text]\n" +
"            {\n" +
"                \n" +
"                width: 50px;\n" +
"                border: none;\n" +
"                border-radius: 5px;\n" +
"                outline: 0;\n" +
"                padding: 8px;\n" +
"}</style>");
           String date=request.getParameter("date");
         if(date.equals(""))
        {
            out.println("<h1>Enter date to check </h1>");
            request.getRequestDispatcher("docprofile").include(request, response);
        }
         else{
              HttpSession session3=request.getSession(false);
                   if(session3!=null){
                        String sname=(String)session3.getAttribute("name"); 
       
           try{  
Class.forName("com.mysql.jdbc.Driver");  
                try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/doctoronline","root","")) {
                    PreparedStatement ps=con.prepareStatement("select * from app where dateofapp=? && doctorname=?");
                    ps.setString(1,date);
                    ps.setString(2,sname);
                    ResultSet rs=ps.executeQuery();
                    out.println("<h1 align=\"center\">View Appointments</h1>");
                    while(rs.next()){
                        int i=0;
                        String name=rs.getString(1);
                        String d=rs.getString(8);
                         HttpSession session1=request.getSession();  
                    session1.setAttribute("f",name);
                    session1.setAttribute("date", d);
                    i++;
                        out.println("<center>");
                        out.println("<table border=\"5\" width=\"1000\" height=\"50\">");
                        out.println("<tr>");
                        out.println("<td>"+name+"</td>");
                        out.println("<td>"+rs.getString(2)+"</td>");
                        out.println("<td>"+rs.getString(3)+"</td>");
                        out.println("<td>"+rs.getString(4)+"</td>");
                        out.println("<td>"+rs.getString(5)+"</td>");
                        out.println("<td>"+rs.getString(6)+"</td>");
                        
                        out.println("<td>"+d+"</td>");
                        out.println("<td>"+"<form method=\"post\" action=\"approv\"><input type=\"text\" value=\"give token No:\" name=\"token\">"+"</td>");
                        out.println("<td>"+"<input type=\"submit\" value=\"approve\" id=\"sub\"></form>"+"</td>");
                        out.println("<td>"+"<form method=\"post\" action=\"reject\"><input type=\"submit\" value=\"Reject\" id=\"re\"></form>"+"</td>");
                        out.println("</tr>");
                        out.println("</table>");
                        
                        out.println("</center>");
                    out.println("<img src=\"C:\\Users\\khsci5mca16125\\Documents\\NetBeansProjects\\DOCappoinmentsystem\\web\\photos\\back.png\">");
                    }    
                }
           }catch(ClassNotFoundException | SQLException e){} }
        }}
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
        try {
            processRequest(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(appointment.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(appointment.class.getName()).log(Level.SEVERE, null, ex);
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
