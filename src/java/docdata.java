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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author KHSCI5MCA16125
 */
@WebServlet(urlPatterns = {"/docdata"})
public class docdata extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String na=request.getParameter("fname");
            String la=request.getParameter("lname");
            String ma=request.getParameter("mail");
            String num=request.getParameter("mnum");
            String quli=request.getParameter("qui");
            String age=request.getParameter("ag");
            String gen=request.getParameter("gend");
            String sp=request.getParameter("special");
            String pas=request.getParameter("pass");
            try{  
                Class.forName("com.mysql.jdbc.Driver");  
                try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/docrecord","root","")) {
                    String insert = "INSERT INTO docs(fname,lname,mail,gender,phone,age,quli,spe,pass) VALUES (?,?,?,?,?,?,?,?,?)";
                    try (PreparedStatement ps = con.prepareStatement(insert)) {
                        ps.setString(1, na);
                        ps.setString(2, la);
                        ps.setString(3, ma);
                        ps.setString(4, gen);
                        ps.setString(5, num);
                        ps.setString(6, age);
                        ps.setString(7,quli);
                        ps.setString(8, sp);
                        ps.setString(9, pas);
                        ps.executeUpdate();
                        RequestDispatcher rd=request.getRequestDispatcher("index.html");  
        rd.forward(request, response);  
                    }
                }
                }   catch (SQLException ex) {
                Logger.getLogger(docdata.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(docdata.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(docdata.class.getName()).log(Level.SEVERE, null, ex);
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
