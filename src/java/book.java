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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author KHSCI5MCA16125
 */
public class book extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String date=request.getParameter("date");
                  HttpSession session3=request.getSession(false);
                   if(session3!=null){
                        String name=(String)session3.getAttribute("name"); 
                        String ln=(String)session3.getAttribute("ln");
                        String em=(String)session3.getAttribute("em"); 
                        String ph=(String)session3.getAttribute("ph");
                        String ag=(String)session3.getAttribute("ag");
                        String gen=(String)session3.getAttribute("gen");
                         HttpSession session2=request.getSession(false);
                   if(session2!=null){
                        String nam=(String)session2.getAttribute("de"); 
                        try{  
                Class.forName("com.mysql.jdbc.Driver");  
                try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/doctoronline","root","")) {
                     
                    try (PreparedStatement ps = con.prepareStatement("insert into app (fname,lname,email,gender,phone,age,doctorname,dateofapp,token)values(?,?,?,?,?,?,?,?,?)")) {
                        
                        ps.setString(1, name);
                        ps.setString(2, ln);
                        ps.setString(3, em);
                        ps.setString(4, gen);
                        ps.setString(5, ph);
                        ps.setString(6, ag);
                        ps.setString(7, nam);
                        ps.setString(8, date);
                        ps.setString(9,"0");
                        
                        ps.executeUpdate();
                          
                    }
                }
                }   catch (SQLException ex) {
                Logger.getLogger(docdata.class.getName()).log(Level.SEVERE, null, ex);
            }
                   }
                    RequestDispatcher rd=request.getRequestDispatcher("patientprofile");  
        rd.forward(request, response);
        }
    
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(book.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(book.class.getName()).log(Level.SEVERE, null, ex);
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
