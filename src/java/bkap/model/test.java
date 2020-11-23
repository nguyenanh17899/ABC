/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bkap.model;

import bkap.entity.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kieuq
 */
public class test {
    public static void main(String[] args) {
        List<Product> arr = null;
        ProductModel run = new ProductModel();
        arr = run.getAllProduct();
        for (Product x : arr) {
            System.out.println(x.toString());
        }
    }
}
