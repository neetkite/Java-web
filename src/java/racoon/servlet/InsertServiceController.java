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
import racoon.dao.ServiceDAO;
import racoon.dto.ServiceDTO;
import racoon.dto.ServiceErrorObject;

/**
 *
 * @author Administrator
 */
public class InsertServiceController extends HttpServlet {

    private static final String SUCCESS = "LoadServiceController";
    private static final String FAILED = "InsertService.jsp";

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
            String id = request.getParameter("txtID");
            String name = request.getParameter("txtName");
            float price = Float.parseFloat(request.getParameter("txtPrice"));
            String des = request.getParameter("txtDes");
            String img = request.getParameter("txtImg");

            ServiceErrorObject error = new ServiceErrorObject();
            boolean valid = true;

            if (id.length() == 0) {
                valid = false;
                error.setIdError("This field must not be empty");
            }
            if (name.length() == 0) {
                valid = false;
                error.setNameError("This field must not be empty");
            }
            if (price <= 0) {
                valid = false;
                error.setPriceError("This field must bigger than 0");
            }

            ServiceDTO dto = new ServiceDTO(id, name, price, des, img);
            if (valid) {
                ServiceDAO dao = new  ServiceDAO();
                boolean result = dao.insert(dto);
                if(result){
                    url = SUCCESS;
                }else{
                    request.setAttribute("ERROR", "Cannot Insert this Object");
                }
            }else{
            request.setAttribute("ERROR", error);
            request.setAttribute("DTO", dto);
        }

        } catch (Exception e) {
            log("Error at InsertServiceController " + e.getMessage());
            if(e.getMessage().contains("duplicate")){
                ServiceErrorObject error = new ServiceErrorObject();
                error.setIdError("This id already existed, try another");
                request.setAttribute("ERROR", error);
            }
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
