/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racoon.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import racoon.dto.CartFoodingObject;
import racoon.dto.CartServiceObject;
import racoon.dto.FoodingDTO;
import racoon.dto.ServiceDTO;

/**
 *
 * @author Administrator
 */
public class ShowCartController extends HttpServlet {

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
        try {
            HttpSession session = request.getSession();
            CartFoodingObject cartFood = (CartFoodingObject) session.getAttribute("CARTFOOD");
            CartServiceObject cartService = (CartServiceObject) session.getAttribute("CARTSERVICE");
            List<FoodingDTO> fooddto = null;
            List<ServiceDTO> servicedto = null;

            if (cartFood != null) {
                //fooddto = cartFood.getCartDetail();
                session.setAttribute("LISTFCART", cartFood.getCartDetail());
                session.setAttribute("TOTALFOOD", cartFood.getTotal());
            }else{
                session.setAttribute("LISTCART", fooddto);
            }
            if (cartService != null) {
               // servicedto = cartService.getCartDetail();
                session.setAttribute("LISTSCART", cartService.getCartDetail());
                session.setAttribute("TOTALSERVICE", cartService.getTotal());
            }else {
                session.setAttribute("LISTSCART", servicedto);
            }
        } catch (Exception e) {
            log("Error at ShowCartController " + e.getMessage());
            e.printStackTrace();
        } finally {
            request.getRequestDispatcher("ViewCart.jsp").forward(request, response);
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
