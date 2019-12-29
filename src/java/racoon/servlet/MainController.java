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

/**
 *
 * @author Administrator
 */
public class MainController extends HttpServlet {

    private static final String LOGIN = "LoginController";
    private static final String USERMODIFY = "LoadUserServlet";
    private static final String SEARCHUSER = "SearchUserController";
    private static final String DELETEUSER = "DeleteUserController";
    private static final String EDITUSER = "EditUserController";
    private static final String UPDATEUSER = "UpdateUserController";
    private static final String SERVICEMOD = "LoadServiceController";
    private static final String SEARCHSERVICE = "SearchServiceController";
    private static final String INSERTSERVICE = "InsertServiceController";
    private static final String EDITSERVICE = "EditServiceController";
    private static final String UPDATESERVICE = "UpdateServiceController";
    private static final String GOTOINSERTSERVICEP = "InsertService.jsp";
    private static final String DELETESERVICE = "DeleteServiceController";
    private static final String FOODINGMOD = "LoadFoodController";
    private static final String DRINKINGLOAD = "LoadDrinkingController";
    private static final String LOADFOODING = "LoadFoodingController";
    private static final String SEARCHFOOD = "SearchFoodingController";
    private static final String INSERTMORE = "InsertFood.jsp";
    private static final String INSERTFOODY = "InsertFoodController";
    private static final String EDITFOODY = "EditFoodController";
    private static final String UPDATEFOODY = "UpdateFoodController";
    private static final String DELETEFOODY = "DeleteFoodController";
    private static final String ROOMMOD = "LoadRoomController";
    private static final String AVAILROOM = "LoadRoomAvailController";
    private static final String INUSEROOM = "LoadRoomInUseController";
    private static final String SINGLEROOM = "LoadRoomSingleController";
    private static final String DUOROOM = "LoadRoomDuoController";
    private static final String SEARCHROOM = "SearchRoomController";
    private static final String CHECKVAILROOM = "CheckAvailable";
    private static final String ROOMDETAILS = "RoomDetailController";
    private static final String LOADFOODUSER = "LoadFoodControllerUser";
    private static final String LOADDRINKUSER = "LoadDrinkControllerUser";
    private static final String LOADSERVICEUSER = "LoadServiceControllerUser";
    private static final String SHOWCART = "ShowCartController";
    private static final String ADDTOCARTFOOD = "AddToCartController";
    private static final String ADDTOCARTSERVICE = "AddServiceToCartController";
    private static final String INSERTCART = "InsertCartController";
    private static final String DELETECARTFOOD = "DeleteCartFoodController";
    private static final String UPDATECARTFOOD = "UpdateCartFoodController";
    private static final String DELETECARTSERVICE = "DeleteCartServiceController";
    private static final String UPDATECARTSERVICE = "UpdateCartServiceController";
    private static final String SIGNOUT = "SignOutController";
    private static final String ORDERMOD = "OrderModifyController";
    private static final String CHECKOUT = "CheckOutController";
    private static final String REGISTERPAGE = "Register.jsp";
    private static final String REGISTER = "RegisterController";
    private static final String INSERTROOMPAGE = "InsertRoom.jsp";
    private static final String INSERTROOM = "InsertRoomController";

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
        String url = "Welcome.jsp";

        try {
            HttpSession session = request.getSession(false);
            if (session.getAttribute("ADMIN") != null && session.getAttribute("FULLNAME") != null) {
                session.invalidate();
                response.sendRedirect("Welcome.jsp");
                return;
            } else if (session.getAttribute("ADMIN") != null) {
                String button = request.getParameter("btnAction");
                System.out.println(session.getAttribute("ADMIN").toString());
                if (button.equals("Login")) {
                    url = LOGIN;
                } else if (button.equals("CustomerModify")) {
                    url = USERMODIFY;
                } else if (button.equals("Search")) {
                    url = SEARCHUSER;
                } else if (button.equals("x")) {
                    url = DELETEUSER;
                } else if (button.equals("Edit")) {
                    url = EDITUSER;
                } else if (button.equals("Update")) {
                    url = UPDATEUSER;
                } else if (button.equals("ServiceModify")) {
                    url = SERVICEMOD;
                } else if (button.equals("Search Service")) {
                    url = SEARCHSERVICE;
                } else if (button.equals("Insert Service")) {
                    url = INSERTSERVICE;
                } else if (button.equals("Edit this Service")) {
                    url = EDITSERVICE;
                } else if (button.equals("Update Service")) {
                    url = UPDATESERVICE;
                } else if (button.equals("Insert more service")) {
                    url = GOTOINSERTSERVICEP;
                } else if (button.equals("Delete this Service")) {
                    url = DELETESERVICE;
                } else if (button.equals("Drinking")) {
                    url = DRINKINGLOAD;
                } else if (button.equals("Fooding")) {
                    url = LOADFOODING;
                } else if (button.equals("FoodingModify")) {
                    url = FOODINGMOD;
                } else if (button.equals("Search Fooding")) {
                    url = SEARCHFOOD;
                } else if (button.equals("Insert more Food")) {
                    url = INSERTMORE;
                } else if (button.equals("Insert Foody")) {
                    url = INSERTFOODY;
                } else if (button.equals("Edit Food")) {
                    url = EDITFOODY;
                } else if (button.equals("Update Food")) {
                    url = UPDATEFOODY;
                } else if (button.equals("Delete Food")) {
                    url = DELETEFOODY;
                } else if (button.equals("RoomModify")) {
                    url = ROOMMOD;
                } else if (button.equals("Available Room")) {
                    url = AVAILROOM;
                } else if (button.equals("In-use")) {
                    url = INUSEROOM;
                } else if (button.equals("Single Room")) {
                    url = SINGLEROOM;
                } else if (button.equals("Duo Room")) {
                    url = DUOROOM;
                } else if (button.equals("Search Room")) {
                    url = SEARCHROOM;
                } else if (button.equals("Logout")) {
                    url = SIGNOUT;
                } else if (button.equals("OrderModify")) {
                    url = ORDERMOD;
                } else if (button.equals("Check out")) {
                    url = CHECKOUT;
                } else if (button.equals("Insert more Room")) {
                    url = INSERTROOMPAGE;
                } else if (button.equals("Insert Room")) {
                    url = INSERTROOM;
                } else {
                    response.sendRedirect("PAGENOTFOUND.jsp");
                }

            } else if (session.getAttribute("FULLNAME") != null) {
                String button = request.getParameter("btnAction");
                System.out.println(session.getAttribute("FULLNAME").toString());
                if (button.equals("Login")) {
                    url = LOGIN;
                } else if (button.equals("Check this room")) {
                    url = CHECKVAILROOM;
                } else if (button.equals("RoomDetails")) {

                    url = ROOMDETAILS;
                } else if (button.equals("FoodyUser")) {
                    url = LOADFOODUSER;
                } else if (button.equals("DrinkyUser")) {
                    url = LOADDRINKUSER;
                } else if (button.equals("ServiceUser")) {
                    url = LOADSERVICEUSER;
                } else if (button.equals("ShowCart")) {
                    url = SHOWCART;
                } else if (button.equals("Get this Food")) {
                    url = ADDTOCARTFOOD;
                } else if (button.equals("Get this Service")) {
                    url = ADDTOCARTSERVICE;
                } else if (button.equals("Take Order")) {
                    url = INSERTCART;
                } else if (button.equals("New service Quantity")) {
                    url = UPDATECARTSERVICE;
                } else if (button.equals("Delete Service From Cart")) {
                    url = DELETECARTSERVICE;
                } else if (button.equals("New Food Quantity")) {
                    url = UPDATECARTFOOD;
                } else if (button.equals("Delete Food from Cart")) {
                    url = DELETECARTFOOD;
                } else if (button.equals("Logout")) {
                    url = SIGNOUT;
                }
            } else if (session.getAttribute("ADMIN") == null && session.getAttribute("FULLNAME") == null) {
                String button = request.getParameter("btnAction");
                if (button.equals("Login")) {
                    url = LOGIN;
                } else if (button.equals("Register for more offer")) {
                    url = REGISTERPAGE;
                } else if (button.equals("Register")) {
                    url = REGISTER;
                } else {
                    response.sendRedirect("PAGENOTFOUND.jsp");
                }
            }
            System.out.println(url);
            System.out.println(session.getAttribute("ADMIN").toString() + "-" + session.getAttribute("ADMIN").toString());
        } catch (Exception e) {
            log("Error at MainController " + e.getMessage());
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
