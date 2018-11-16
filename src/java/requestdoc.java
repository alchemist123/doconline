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
public class requestdoc extends HttpServlet {

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

           try{  
Class.forName("com.mysql.jdbc.Driver");  
                try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/docrecord","root","")) {
                    PreparedStatement ps=con.prepareStatement("select * from docs");
                  
                    ResultSet rs=ps.executeQuery();
                    out.println("<h1 align=\"center\">REQUESTS</h1>");
                    while(rs.next()){
                        int i=0;
                         
                        String name=rs.getString(1);
                         HttpSession session=request.getSession();  
                    session.setAttribute("na",name);
                    session.setAttribute("id", i);
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
                        out.println("<td>"+rs.getString(7)+"</td>");
                        out.println("<td>"+rs.getString(8)+"</td>");
                        out.println("<td>"+"<form method=\"post\" action=\"accpetdoc\"><input type=\"submit\" value=\"accept\" id=\"sub\"></form>"+"</td>");
                        out.println("<td>"+"<form method=\"post\" action=\"rejectdoc\"><input type=\"submit\" value=\"Reject\" id=\"re\"></form>"+"</td>");
                        out.println("</tr>");
                        out.println("</center>");
                    }    
                }
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
