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
import racoon.dao.UserDAO;
import racoon.dto.UserDTO;
import racoon.dto.UserErrorObject;

/**
 *
 * @author Administrator
 */
public class UpdateUserController extends HttpServlet {

    private static final String FAILED = "UpdateUser.jsp";
    private static final String SUCCESS = "LoadUserServlet";

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
        String url = FAILED;
        try {
            String username = request.getParameter("txtUsername");
            int age;
            try {
                age = Integer.parseInt(request.getParameter("txtAge"));
            } catch (Exception e) {
                age = 0;
            }

            String role = "user";
            String fullname = request.getParameter("txtFullname");
            String add = request.getParameter("txtAddress");

            UserErrorObject error = new UserErrorObject();
            boolean valid = true;

            if (age <= 0 || age >= 120) {
                valid = false;
                error.setAgeError("Age must in range (0-120) please and not be blank");
            }
            if (!fullname.matches("[A-Za-z ]{1,250}")) {
                valid = false;
                error.setFullnameError("This field must not be blank please");
            }
            UserDTO dto = new UserDTO(username, role, add, fullname, age);
            if (valid) {
                UserDAO dao = new UserDAO();
                boolean result = dao.update(dto);
                if (result) {
                    url = SUCCESS;
                } else {
                    request.setAttribute("ERROR", "Update failed");
                }
            } else {
                request.setAttribute("ERROR", error);
                request.setAttribute("DTO", dto);
            }

        } catch (Exception e) {
            log("Error at UpdateUserController: " + e.getMessage());
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
