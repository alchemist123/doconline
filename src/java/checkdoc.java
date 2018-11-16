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
public class checkdoc extends HttpServlet {

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
            out.println("<title>checkdoc</title>");            
            out.println("</head>");
             out.println("<head><title>weclome</title></head><body background=C:\\Users\\khsci5mca16125\\Documents\\NetBeansProjects\\DOCappoinmentsystem\\web\\photos\\di.jpg>");
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
                    out.println("<center>");
                    out.println("<form action=search method=post>");
                    out.println("<select id=ph name=special>"
                            + "<option>General Medicine</option>"
                            + "<option>Dental Medicine</option>"
                            + "<option>Internal Medicine</option>"
                            + "<option>Pediatrics</option>"
                            + "<option>Cardiologists</option>"
                            + "<option>Orthopaedic</option>"
                            + "<option>Dermatology</option>"
                                +"</select>");
                    out.println("<br>");
                  HttpSession session2=request.getSession(false);
                   if(session2!=null){
                        String name=(String)session2.getAttribute("name"); 
                       String ln=(String)session2.getAttribute("ln");
                        String em=(String)session2.getAttribute("em"); 
                        String ph=(String)session2.getAttribute("ph");
                        String ag=(String)session2.getAttribute("ag");
                        String gen=(String)session2.getAttribute("gen"); 
                   }
                    out.println("<input type=submit id=sub value=search");
                    out.println("</center>");
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
