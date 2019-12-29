/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racoon.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import racoon.dao.UserDAO;
import racoon.dto.UserDTO;

/**
 *
 * @author Administrator
 */
public class LoginController extends HttpServlet {

    private static final String ERROR = "Welcome.html";
    private static final String ADMIN = "admin.jsp";
    private static final String USER = "ShowRoomController";

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
        String url = ERROR;
        try {
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            HttpSession session = request.getSession();

            UserDAO dao = new UserDAO();
            String role = dao.checkLogin(username, password);
            
            if (role.equals("failed")) {
                url = ERROR;
            } else if (role.equals("Administrator")) {
                url = ADMIN;
                UserDTO dto = dao.findByUser(username);
                String fullname = dto.getFullname();
                System.out.println(fullname);
                
                session.setAttribute("ADMIN", fullname);

            } else if (role.equals("user")) {
                url = USER;
                UserDTO dto = dao.findByUser(username);
                String fullname = dto.getFullname();
                
                session.setAttribute("FULLNAME", fullname);
            } else {
                request.setAttribute("ERROR", "You don't have permission to Login this");
            }

        } catch (Exception e) {
            log("Error at LoginController: " + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
