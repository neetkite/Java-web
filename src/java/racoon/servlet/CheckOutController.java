/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racoon.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import racoon.dao.CustomerDAO;
import racoon.dao.RoomBillDAO;
import racoon.dto.RoomBillDTO;
import racoon.dao.OderDAO;
import racoon.dto.OrderDTO;

/**
 *
 * @author Administrator
 */
public class CheckOutController extends HttpServlet {

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
            String id = request.getParameter("id");
            int idBill = Integer.parseInt(id);
            System.out.println(idBill);
            RoomBillDAO dao = new RoomBillDAO();
            OderDAO ordao = new OderDAO();
            String orderid = ordao.findByRoombill(idBill);
            ordao.delete(orderid);
            CustomerDAO daoCu = new CustomerDAO();
            String cusid = daoCu.findByRoombill(idBill);
            daoCu.delete(cusid);
           if(dao.delete(idBill)){
               System.out.println("lalala");
           } 

            
        } catch (Exception e) {
            log("Error at CheckOutController " + e.getMessage());
            e.printStackTrace();
        } finally {
            request.getRequestDispatcher("OrderModifyController").forward(request, response);
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
