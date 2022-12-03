package controllers;

import com.mysql.jdbc.PreparedStatement;
import java.sql.*;
import java.util.*;
import utils.DatabaseUtil;
import models.Category;

/**
 *
 * @author User-PC
 */
public class CategoryController {
    private DatabaseUtil koneksi;
    private ResultSet rs;
    private PreparedStatement pre;
    
    public CategoryController(){
        koneksi = new DatabaseUtil();
    }
    
    public ArrayList<Category> getCategory ()
    {
        ArrayList<Category> cat= new ArrayList<Category>();
        rs = koneksi.executeSelect("SELECT * FROM categories");
        
        if(rs != null){
            try{
                while(rs.next()){
                    Category category = new Category(
                            rs.getString("code_cat"),
                            rs.getString("name")
                        );
                    cat.add(category);
                }
            } catch (Exception ex){
                
            }
        }
        return cat;
    }
}
