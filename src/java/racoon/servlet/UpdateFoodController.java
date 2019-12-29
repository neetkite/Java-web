/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racoon.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import racoon.dao.FoodingDAO;
import racoon.dto.FoodingDTO;
import racoon.dto.FoodingErrorObject;

/**
 *
 * @author Administrator
 */
public class UpdateFoodController extends HttpServlet {
    private static final String FAILED = "UpdateFood.jsp";
    private static final String SUCCESS = "LoadFoodController";

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
            
            int quantity = Integer.parseInt(request.getParameter("txtQuantity"));
            String des = request.getParameter("txtDes");
            boolean type1 = true;
            String type = request.getParameter("cboType");
            if(type.equals("Drinky")){
                type1 = false;
            }
            String img = request.getParameter("txtImg");

            FoodingErrorObject error = new FoodingErrorObject();
            boolean valid = true;
            if (id.length() == 0) {
                valid = false;
                error.setIdError("This field must not be blank");
            }
            if (name.length() == 0) {
                valid = false;
                error.setNameError("This field must not be blank");
            }
            if (price < 0) {
                valid = false;
                error.setPriceError("This field must bigger than 0");
            }
            if (quantity <= 0) {
                valid = false;
                error.setQuantityError("This field must bigger than 0");
            }
            FoodingDTO dto = new FoodingDTO(id, name, price, quantity, des, type1 , img);
            
            if(valid){
                FoodingDAO dao = new FoodingDAO();
                boolean result = dao.updateFooding(dto);
                if(result){
                    url = SUCCESS;
                }else{
                    request.setAttribute("ERROR", "This cannot be updated");
                }
            }else{
                request.setAttribute("ERROR", error);
                request.setAttribute("FOODDTO", dto);
            }
        } catch (Exception e) {
            log("Error at UpdateFoodController " + e.getMessage());
            e.printStackTrace();
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
