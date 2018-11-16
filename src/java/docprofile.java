/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
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
 *
 * @author KHSCI5MCA16125
 */
@WebServlet(urlPatterns = {"/docprofile"})
public class docprofile extends HttpServlet {

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
                   HttpSession session=request.getSession(false);
                   if(session!=null){
                        String sname=(String)session.getAttribute("name"); 
                        String em=(String)session.getAttribute("em"); 
                        String ph=(String)session.getAttribute("ph");
                        String qu=(String)session.getAttribute("qu");
                        String sp=(String)session.getAttribute("sp"); 
                        HttpSession session3=request.getSession();  
                    session3.setAttribute("name",sname);
                    out.println("<html>");
                    out.println("<head><title>weclome</title></head><body background=C:\\Users\\khsci5mca16125\\Documents\\NetBeansProjects\\DOCappoinmentsystem\\web\\photos\\why.jpg>");
                    out.println("<style>"
                            + "img.avatar {\n" +
                            "    width: 40%;\n" +
                            "    height: 20%;\n" +
                            "    \n" +
                            "}"
                            + "button {\n" +
                                "    background-color: #4CAF50;\n" +
                                "    color: white;\n" +
                                "    padding: 14px 20px;\n" +
                                "    margin: 8px 0;\n" +
                                "    border: none;\n" +
                                "    cursor: pointer;\n" +
                                "    width: 30%;\n" +
                                "}"
                            + "#sub{\n" +
                                "    background-color: #4CAF50;\n" +
                                "    color: white;\n" +
                                "    padding: 14px 20px;\n" +
                                "    margin: 8px 0;\n" +
                                "    border: none;\n" +
                                "    cursor: pointer;\n" +
                                "    width: 30%;\n" +
                            "}"
                            + "body {font-family: Arial, Helvetica, sans-serif;\n" +
"                background-size: 100% 900px;\n" +
"                background-repeat: no-repeat;}"
                            + "#num{\n" +
"                width: 233px;\n" +
"                padding: 8px;\n" +
"                border-radius: 5px;\n" +
"                border: 5px;\n" +
"                outline: 0;\n" +
"            }</style>");
                    out.println("<center><img src=C:\\Users\\khsci5mca16125\\Documents\\NetBeansProjects\\DOCappoinmentsystem\\web\\photos\\Desktop\\welcome.gif class=\"avatar\"></center>");
                    out.println("<font  size=\"50\" face=\"verdana\"><center><u> Dr."+sname+"</font> </center></u> ");
                    out.println("<br>");
                    out.println("<font   face=\"verdana\"><center> "+em+"</font> </center> ");
                    out.println("<font   face=\"verdana\"><center> "+ph+"</font> </center> ");
                    out.println("<font  face=\"verdana\"><center> "+qu+"</font> </center> ");
                    out.println("<font   face=\"verdana\"><center> "+sp+"</font> </center> ");
                    out.println("<br>");
                    HttpSession session6=request.getSession();  
                    session6.setAttribute("s",sname);
                    out.println("<center><form action=\"appointment\" >"
                               +"<b>DATE:</b><input type=\"text\" id=\"num\" name=\"date\"><br>"
                            + "<input type=\"submit\"value=\"View Appointments\"id=\"sub\"></form></center>");
                    
                    out.println("<form action=\"logoutdoc\" > <center><input type=\"submit\" value=\"Log Out\" id=\"sub\"></center></form>");
                    out.println("</body>");
                   out.println("</html>");
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
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(docprofile.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(docprofile.class.getName()).log(Level.SEVERE, null, ex);
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
