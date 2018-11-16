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
public class accpetdoc extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             HttpSession session=request.getSession(false);
            if(session!=null){
                        String name=(String)session.getAttribute("na");
                     
            
            try{  
Class.forName("com.mysql.jdbc.Driver");  
                try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reqdoc","root","")) {
                    PreparedStatement ps=con.prepareStatement("select * from reqdocs where fname=?");
                   ps.setString(1,name);
                    ResultSet rs=ps.executeQuery();
                    while(rs.next()){
                        String nam=rs.getString(1);
                        String nl=rs.getString(2);
                        String ma=rs.getString(3);
                        String gen=rs.getString(4);
                        String num=rs.getString(5);
                        String age=rs.getString(6);
                        String quli=rs.getString(7);
                        String sp=rs.getString(8);
                        String pas=rs.getString(9);
                        HttpSession sessio=request.getSession();  
                    sessio.setAttribute("fn",nam); 
                    sessio.setAttribute("ln",nl);
                    sessio.setAttribute("ge",gen); 
                    sessio.setAttribute("nu",num);
                    sessio.setAttribute("ae",age); 
                    sessio.setAttribute("qul",quli);
                    sessio.setAttribute("sp",sp); 
                    sessio.setAttribute("pas",pas);
                    request.getRequestDispatcher("passdata").include(request, response);
                    
                   
                    }
                }
                    }catch(Exception e){}
             HttpSession sessio=request.getSession(false);
                   if(session!=null){
                        String nam=(String)sessio.getAttribute("fn"); 
                        String em=(String)sessio.getAttribute("ln"); 
                        String ph=(String)sessio.getAttribute("ma");
                        String qu=(String)sessio.getAttribute("ge");
                        String nu=(String)sessio.getAttribute("nu"); 
                        String age=(String)sessio.getAttribute("ae");
                        String quli=(String)sessio.getAttribute("qul");
                        String sp=(String)sessio.getAttribute("sp");
                        String pas=(String)sessio.getAttribute("pas");
                        out.println(name);
                         try{
                        Class.forName("com.mysql.jdbc.Driver");
                        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reqdoc","root","")) {
                            String cmd ="delete from reqdocs where fname=?";
                            PreparedStatement ps = con.prepareStatement(cmd);
                            ps.setString(1, name);
                            ps.executeUpdate();
                            request.getRequestDispatcher("requestdoc").include(request, response);
                                    
                        }
                        }catch(SQLException e){}
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(accpetdoc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(accpetdoc.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(accpetdoc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(accpetdoc.class.getName()).log(Level.SEVERE, null, ex);
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
    
