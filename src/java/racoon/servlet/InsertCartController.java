/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racoon.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import racoon.dao.CartDAO;
import racoon.dao.CartFoodingDAO;
import racoon.dao.CartServiceDAO;
import racoon.dao.CustomerDAO;
import racoon.dao.OderDAO;
import racoon.dao.RoomBillDAO;
import racoon.dao.RoomDAO;
import racoon.dao.UserDAO;
import racoon.dto.CartDTO;
import racoon.dto.CartFoodingDTO;
import racoon.dto.CartFoodingObject;
import racoon.dto.CartServiceDTO;
import racoon.dto.CartServiceObject;
import racoon.dto.CustomerDTO;
import racoon.dto.OrderDTO;
import racoon.dto.RoomBillDTO;
import racoon.dto.RoomDTO;
import racoon.dto.UserDTO;

/**
 *
 * @author Administrator
 */
public class InsertCartController extends HttpServlet {

    private static final String SUCCESS = "Service.jsp";
    private static final String FAILED = "ShowCartController";

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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        String url = FAILED;
        try {

            HttpSession session = request.getSession();
            Random rd = new Random();
            boolean check1 = false;
            boolean check2 = false;
            CartServiceDAO daoS = new CartServiceDAO();
            CartFoodingDAO daoF = new CartFoodingDAO();
            String foodID = "CartF" + rd.nextInt(999);
            String serID = "CartS" + rd.nextInt(999);
            String ioder = "Ord." + rd.nextInt(999);
            String cusID = "Cus." + rd.nextInt(999);
            CartFoodingObject cartf = (CartFoodingObject) session.getAttribute("CARTFOOD");
            CartServiceObject carts = (CartServiceObject) session.getAttribute("CARTSERVICE");
            float priceF = 0;
            float prices = 0;

            if (cartf != null) {
                priceF = cartf.getTotal();
            }
            if (carts != null) {
                prices = carts.getTotal();
            }

            CartFoodingDTO cartFdto = new CartFoodingDTO(foodID, priceF);
            check1 = daoF.insertCartFooding(cartFdto);

            CartServiceDTO cartSdto = new CartServiceDTO(serID, prices);
            check2 = daoS.insertCartService(cartSdto);

            CartDAO dao = new CartDAO();

            String cartID = "Ca." + rd.nextInt(999);
            CartDTO dto = new CartDTO(cartID, foodID, serID, prices + priceF);
            boolean check3 = dao.insertCart(dto);
            if (check3) {
                CartDTO dtoSearch = dao.FindByPK(cartID);
                int room = (int) session.getAttribute("MSG");
                RoomDAO rdao = new RoomDAO();
                RoomDTO rdto = rdao.findByNumberObject(room);
                String datein = (String) session.getAttribute("DATEIN");
                String dateout = (String) session.getAttribute("DATEOUT");
                RoomBillDAO roombdao = new RoomBillDAO();
                int day = roombdao.dayCal(datein, dateout);
                float priceRoom = day * rdto.getPrice();
                String idCart = dtoSearch.getId();
                float total = priceRoom + prices + priceF;
                String customer = (String) session.getAttribute("FULLNAME");
                UserDAO cusdao = new UserDAO();
                UserDTO cusdto = cusdao.findByFullname(customer);
                RoomBillDTO rombdto = new RoomBillDTO(room, idCart, datein, dateout, priceRoom, total);
                boolean result = roombdao.insertR(rombdto);
                int idresult = roombdao.findPK(room);
                rombdto.setId(idresult);
                if (result) {
                    
                        int lvl = cusdao.getLv(cusdto.getUsername());
                        CustomerDTO dtoCu = new CustomerDTO(cusID, customer, cusdto.getAddress(), rombdto.getId(), cusdto.getUsername(), lvl);
                        CustomerDAO daoCu = new CustomerDAO();
                        boolean insertC = daoCu.insert(dtoCu);
                        if(insertC){
                            float discount = (float) (lvl * 3.14 / 100);
                            OrderDTO order = new OrderDTO(ioder, rombdto.getId(), discount, rombdto.getPrice() - discount, datein);
                            OderDAO orderdao = new OderDAO();
                            if(orderdao.insert(order)){
                                url = SUCCESS;
                                request.setAttribute("ORDERSUC", "Thanks for using our service, please wait for staff");
                            }
                        }
                    
                    
                }
            }

            System.out.println(url);
        } catch (Exception e) {
            log("Error at InserCartController " + e.getMessage());
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(InsertCartController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsertCartController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(InsertCartController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsertCartController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
