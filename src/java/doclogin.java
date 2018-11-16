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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *wwwww
 * @author KHSCI5MCA16125
 */
@WebServlet(urlPatterns = {"/doclogin"})
public class doclogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          
        String name=request.getParameter("uname");  
        String password=request.getParameter("psw");  
        if(name.equals("")&&password.equals(""))
        {
            out.println("<h1>user name or password is incorrect</h1>");
            request.getRequestDispatcher("doctor.html").include(request, response);
        }
        else
        {
          try{  
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/docrecord","root","");
                
                PreparedStatement ps=con.prepareStatement("select * from docs where fname=? and pass=?");  
                ps.setString(1,name);
                ps.setString(2,password);
                ResultSet rs=ps.executeQuery();
                if(rs.next())
                {
                   String em=rs.getString(3);
                   String ph=rs.getString(4);
                   String qu=rs.getString(5);
                   String sp=rs.getString(8);
                   HttpSession session=request.getSession();  
                    session.setAttribute("name",name);
                    session.setAttribute("em", em);
                    session.setAttribute("ph", ph);
                    session.setAttribute("qu", qu);
                    session.setAttribute("sp", sp);
                      request.getRequestDispatcher("docprofile").include(request, response);
                }
                else
                {
                    out.println("<h1>user name or password is incorrect</h1>");
                    request.getRequestDispatcher("doctor.html").include(request, response);
                }
                
           } catch (ClassNotFoundException ex) {
                Logger.getLogger(docprofile.class.getName()).log(Level.SEVERE, null, ex);
        out.close();  
        }
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
        } catch (SQLException ex) {
            Logger.getLogger(doclogin.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(doclogin.class.getName()).log(Level.SEVERE, null, ex);
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
