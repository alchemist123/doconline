/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author KHSCI5MCA16125
 */
public class patientprofile extends HttpServlet {

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
             HttpSession session=request.getSession(false);
                   if(session!=null){
                        String name=(String)session.getAttribute("name"); 
                       String ln=(String)session.getAttribute("ln");
                        String em=(String)session.getAttribute("em"); 
                        String ph=(String)session.getAttribute("ph");
                        String ag=(String)session.getAttribute("ag");
                        String gen=(String)session.getAttribute("gen"); 
                        HttpSession session2=request.getSession();  
                    session2.setAttribute("name",name);
                    session2.setAttribute("ln",ln);
                    session2.setAttribute("em", em);
                    session2.setAttribute("ph", ph);
                    session2.setAttribute("ag", ag);
                    session2.setAttribute("gen", gen);
                     HttpSession session3=request.getSession();  
                    session3.setAttribute("fname",name);
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
                            
                                " border-radius: 100px;"+


                            "}"
                            + "body {font-family: Arial, Helvetica, sans-serif;\n" +
"                background-size: 100% 900px;\n" +
"                background-repeat: no-repeat;}</style>");
                    out.println("<center><img src=C:\\Users\\khsci5mca16125\\Documents\\NetBeansProjects\\DOCappoinmentsystem\\web\\photos\\welcome.gif class=\"avatar\"></center>");
                    out.println("<font  size=\"50\" face=\"verdana\"><center><u> "+name+"</font> </center></u> ");
                    out.println("<font   face=\"verdana\"><center> Email :"+em+"</font> </center> ");
                    out.println("<font   face=\"verdana\"><center> Phone no :"+ph+"</font> </center> ");
                    out.println("<font  face=\"verdana\"><center> Age :"+ag+"</font> </center> ");
                    out.println("<font   face=\"verdana\"><center> Gender :"+gen+"</font> </center> ");
                    out.println("<br>");
                    out.println("<center><form action=\"checkdoc\" ><input type=\"submit\" value=\"Check Doctors\" id=\"sub\"></form></center>");
                    out.println("<form action=\"status\" > <center><input type=\"submit\" value=\"Status\" id=\"sub\"></form></center>");
                    out.println("<form action=\"logoutpa\" > <center><input type=\"submit\" value=\"Log Out\" id=\"sub\"></center></form>");
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