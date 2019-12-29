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
import racoon.dto.CartFoodingObject;

/**
 *
 * @author Administrator
 */
public class EditCartFoodController extends HttpServlet {

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
          String action = request.getParameter("btnAction");
          try{
            HttpSession session = request.getSession();
            
            CartFoodingObject shoppingCart = (CartFoodingObject) session.getAttribute("CARTFOOD");
            
            if(action.equals("Delete Food from Cart")){
                String id = request.getParameter("txtID");
                shoppingCart.removeCart(id);
                
            }else if(action.equals("Get Price Food")){
                String id = request.getParameter("txtID");
                int quanti = Integer.parseInt(request.getParameter("txtQuantity"));
                shoppingCart.updateCart(id, quanti);
            }else{
                System.out.println("System is not supported");
            }
            session.setAttribute("CARTFOOD", shoppingCart);
          }catch(Exception e){
              log("Error at EditCartFoodController" + e.getMessage());
          }finally{
              request.getRequestDispatcher("ShowCartController").forward(request, response);
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
