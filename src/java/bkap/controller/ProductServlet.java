/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.controller;

import bkap.entity.Product;
import bkap.model.ProductModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
public class ProductServlet extends HttpServlet {

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
        //Lay gia tri tham so action trong request
        String action = request.getParameter("action");
        ProductModel proModel = new ProductModel();
        if (action.equals("GetAll")) {
            getAllProduct(proModel, request, response);
        } else if (action.equals("Create")) {
            //Them moi mot san pham
            //-Lay du lieu san pham can them moi - lay du lieu nhap vao tren form
            Product proNew = new Product();
            proNew.setProductId(request.getParameter("productId"));
            proNew.setProductName(request.getParameter("productName"));
            proNew.setPrice(Float.parseFloat(request.getParameter("price")));
            proNew.setTitle(request.getParameter("title"));
            proNew.setDescription(request.getParameter("description"));
            proNew.setStatus(Boolean.parseBoolean(request.getParameter("status")));
            //-Thuc hien goi sang model de them moi san pham
            boolean check = proModel.insertProduct(proNew);
            if (check) {
                //Them moi thanh cong--Goi lai getAll de hien thi du lieu
                getAllProduct(proModel, request, response);
            } else {
                //Them moi that bai
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        } else if (action.equals("initUpdate")) {
            //Lay tham so productId tu request
            String productId = request.getParameter("productId");
            //Goi sang model lay thong tin san pham can cap nhat tu productId
            Product pro = proModel.getProductById(productId);
            //add pro vao request
            request.setAttribute("pro", pro);
            //Goi sang trang UpdateProduct.jsp
            request.getRequestDispatcher("UpdateProduct.jsp").forward(request, response);

        }else if(action.equals("Update")){
            //Thuc hien cap nhat san pham
            //-Lay thong tin san pham can sua tu request
            Product proUpdate = new Product();
            proUpdate.setProductId(request.getParameter("productId"));
            proUpdate.setProductName(request.getParameter("productName"));
            proUpdate.setPrice(Float.parseFloat(request.getParameter("price")));
            proUpdate.setTitle(request.getParameter("title"));
            proUpdate.setDescription(request.getParameter("description"));
            proUpdate.setStatus(Boolean.parseBoolean(request.getParameter("status")));
            //-Goi sang model thuc hien update
            boolean check = proModel.updateProduct(proUpdate);
            if (check) {
                getAllProduct(proModel, request, response);
            }else{
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        }else if (action.equals("Delete")) {
            //Thuc hien xoa san pham
            //-Lay tham so productId tu request
            String productIdDelete = request.getParameter("productId");
            //-Goi sang model thuc hien xoa
            boolean check = proModel.delete(productIdDelete);
            if (check) {
                getAllProduct(proModel, request, response);
            }else{
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        }
    }

    public static void getAllProduct(ProductModel proModel, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Thuc hien goi sang model de lay tat ca cac thong tin cua product
        List<Product> listPro = proModel.getAllProduct();
        //add listPro vao request de chuyen sang trang Products.jsp
        request.setAttribute("listProduct", listPro);
        //Goi sang trang Products.jsp
        request.getRequestDispatcher("Products.jsp").forward(request, response);
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
