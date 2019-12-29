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
import racoon.dao.RoomBillDAO;
import racoon.dao.RoomDAO;
import racoon.dto.RoomDTO;

/**
 *
 * @author Administrator
 */
public class CheckAvailable extends HttpServlet {

    private static final String ORDERSUCCESS = "Service.jsp";
    private static final String ORDERFAILED = "RoomDetailController";

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
        String url = ORDERFAILED;
        try {
            HttpSession session = request.getSession();
            int id = Integer.parseInt(request.getParameter("txtID"));
            String date1 = request.getParameter("dateIn");
            String date2 = request.getParameter("dateOut");

            RoomBillDAO dao = new RoomBillDAO();
            int check = dao.dayCal(date1, date2);
            if (check >= 0) {
                boolean result = dao.checkAvailable(date1, date2, id);
                if (result) {
                    request.setAttribute("MSG", "This already booked please choose another day/room");
                } else {
                    url = ORDERSUCCESS;
                    session.setAttribute("MSG", id);
                    session.setAttribute("DATEIN", date1);
                    session.setAttribute("DATEOUT", date2);
                }
            }else{
                request.setAttribute("MSG", "The Invalid Checkin and Checkout, please try again");
            }
        } catch (Exception e) {
            log("Error at CheckAvailable " + e.getMessage());
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
