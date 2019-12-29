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
import racoon.dao.FoodingDAO;
import racoon.dto.FoodingDTO;
import racoon.dto.FoodingErrorObject;

/**
 *
 * @author Administrator
 */
public class InsertFoodController extends HttpServlet {
    private static final String SUCCESS = "LoadFoodController";
    private static final String FAILED = "InsertFood.jsp";

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
            float pricec = Float.parseFloat(request.getParameter("txtPrice"));
            int quantity = Integer.parseInt(request.getParameter("txtQuantity"));
            String des = request.getParameter("txtDes");
            String type1 = request.getParameter("cboType");
            boolean type = true;
            if(type1.equals("Drinky")){
                type = false;
            }
            String img = request.getParameter("txtImg");
            System.out.println(img);
            FoodingErrorObject error = new FoodingErrorObject();
            boolean valid = true;
            if(id.length() == 0){
                valid = false;
                error.setIdError("This field must not be blank");
            }
            if(name.length() == 0){
                valid = false;
                error.setNameError("This field must not be blank");
            }
            if(pricec < 0){
                valid = false;
                error.setPriceError("This field must bigger than 0");
            }
            if(quantity <= 0){
                valid = false;
                error.setQuantityError("This field must bigger than 0");
            }
            FoodingDTO dto = new FoodingDTO(id, name, pricec, quantity, des, type, img);
            if(valid){
                FoodingDAO dao = new FoodingDAO();
                boolean result = dao.insertFooding(dto);
                if(result){
                    url = SUCCESS;
                }else{
                    request.setAttribute("ERROR", "This object cannot be inserted");
                }
            }else{
                request.setAttribute("ERROR", error);
                request.setAttribute("DTO", dto);
            }
            
        } catch (Exception e) {
            log("Error at InsertFoodController " + e.getMessage());
            if(e.getMessage().contains("duplicate")){
                FoodingErrorObject error = new FoodingErrorObject();
                error.setIdError("This ID already has existed, try another");
            }
        }finally{
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
