/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.model;

import bkap.entity.Product;
import bkap.util.ConnectionDB;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ProductModel {
    public List<Product> getAllProduct(){
        List<Product> listPro = null;
        //Khoi tao doi tuong Connection va CallableStatement
        Connection conn = null;
        CallableStatement callSt = null;
        try {
           conn = ConnectionDB.openConnection();
           callSt = conn.prepareCall("{call GetAllProduct()}");
           //Thuc hien goi proc
            ResultSet rs = callSt.executeQuery();
            //Khoi tao listPro
            listPro = new ArrayList<>();
           //xu ly rs va day du lieu ra listPro
            while (rs.next()) {                
                Product pro = new Product();
                pro.setProductId(rs.getString("ProductId"));
                pro.setProductName(rs.getString("ProductName"));
                pro.setPrice(rs.getFloat("Price"));
                pro.setTitle(rs.getString("Title"));
                pro.setDescription(rs.getString("Descriptions"));
                pro.setStatus(rs.getBoolean("ProductStatus"));
                listPro.add(pro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            ConnectionDB.closeConnection(conn, callSt);
        }        
        return listPro;
    }
    
    public boolean insertProduct(Product proNew){
        Connection conn = null;
        CallableStatement callSt = null;
        boolean check = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call InsertProduct(?,?,?,?,?,?,?)}");
            //Set gia tri cho cac tham so vao
            callSt.setString(1, proNew.getProductId());
            callSt.setString(2, proNew.getProductName());
            callSt.setFloat(3, proNew.getPrice());
            callSt.setString(4, proNew.getTitle());
            callSt.setString(5, proNew.getDescription());
            callSt.setBoolean(6, proNew.isStatus());
            //Dang ky kieu du lieu cho tham so tra ra
            callSt.registerOutParameter(7, Types.BIT);
            //Thuc hien goi procedure
            callSt.execute();
            //Lay gia tri tham so tra ra
            check = callSt.getBoolean(7);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            ConnectionDB.closeConnection(conn, callSt);
        }
        return check;
    }
    
    public boolean updateProduct(Product proUpdate){
        Connection conn = null;
        CallableStatement callSt = null;
        boolean check = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call UpdateProduct(?,?,?,?,?,?,?)}");
            //Set gia tri cho cac tham so vao
            callSt.setString(1, proUpdate.getProductId());
            callSt.setString(2, proUpdate.getProductName());
            callSt.setFloat(3, proUpdate.getPrice());
            callSt.setString(4, proUpdate.getTitle());
            callSt.setString(5, proUpdate.getDescription());
            callSt.setBoolean(6, proUpdate.isStatus());
            //Dang ky kieu du lieu cho tham so tra ra
            callSt.registerOutParameter(7, Types.BIT);
            //Thuc hien goi procedure
            callSt.execute();
            //Lay gia tri tham so tra ra
            check = callSt.getBoolean(7);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            ConnectionDB.closeConnection(conn, callSt);
        }
        return check;
    }
    
    public boolean delete(String productId){
        Connection conn = null;
        CallableStatement callSt = null;
        boolean check = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call DeleteProduct(?)}");
            //Set gia tri cho cac tham so vao
            callSt.setString(1, productId);           
            //Thuc hien goi procedure
            callSt.executeUpdate();
            
            check = true;
        } catch (Exception e) {            
            e.printStackTrace();
        }finally{
            ConnectionDB.closeConnection(conn, callSt);
        }
        return check;
    }
    
    public Product getProductById(String productId){
        Product pro = null;
        //Khoi tao doi tuong Connection va CallableStatement
        Connection conn = null;
        CallableStatement callSt = null;
        try {
           conn = ConnectionDB.openConnection();
           callSt = conn.prepareCall("{call getProductById(?)}");
           callSt.setString(1, productId);
           //Thuc hien goi proc
            ResultSet rs = callSt.executeQuery();
            //Khoi tao listPro
            pro = new Product();
           //xu ly rs va day du lieu ra listPro
            if (rs.next()) {
                pro.setProductId(rs.getString("ProductId"));
                pro.setProductName(rs.getString("ProductName"));
                pro.setPrice(rs.getFloat("Price"));
                pro.setTitle(rs.getString("Title"));
                pro.setDescription(rs.getString("Descriptions"));
                pro.setStatus(rs.getBoolean("ProductStatus"));                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            ConnectionDB.closeConnection(conn, callSt);
        }        
        return pro;
    }
}
