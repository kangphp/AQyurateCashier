package controllers;

import com.mysql.jdbc.PreparedStatement;
import utils.DatabaseUtil;
import java.sql.*;
import java.util.*;
import models.Item;

public class ItemController {
    private DatabaseUtil koneksi;
    private ResultSet rs;
    private PreparedStatement pre;
    
    public ItemController(){
        koneksi = new DatabaseUtil();
    }
    
    public ArrayList<Item> getAllItems(){
        ArrayList<Item> result = new ArrayList<Item>();
        rs = koneksi.executeSelect("SELECT * FROM items");
        if(rs != null){
            try{
                while(rs.next()){
                    Item barang = new Item(
                            rs.getString("item_id"),
                            rs.getString("code_cat"),
                            rs.getString("name"),
                            rs.getInt("price")
                        );
                    result.add(barang);
                }
            } catch (Exception ex){
                
            }
        }
        return result;
    }
    
    public void close(){
        koneksi.stop();
    }
}
