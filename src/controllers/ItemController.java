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
    
    public Item getById(int itemID){
        ArrayList<String> data = new ArrayList<String>();
        data.add(String.valueOf(itemID));
        Item barang = null;
        
        rs = koneksi.executeSelect("SELECT * FROM items WHERE item_id = ?", data);
        if(rs != null){
            try{
                while(rs.next()){
                    Timestamp timestamp = rs.getTimestamp(5);
                    barang = new Item(rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            Integer.valueOf(rs.getString(4))
                        );
                    break;
                } 
            }catch (Exception ex){
                
            }
        }
        return barang;
    }
    
    public Boolean addItem (Item barang)
    {
        ArrayList<String> data = new ArrayList<String>();
        
        data.add(String.valueOf(barang.getItemID()));
        data.add(barang.getCodeCat());
        data.add(barang.getName());
        data.add(String.valueOf(barang.getPrice()));
        
        
        if (koneksi.execute("INSERT INTO items (item_id, code_cat, name, price) VALUES (?, ?, ?, ?)", data)){
            return true;
        } else {
            return false;
        }
    }
    public void close(){
        koneksi.stop();
    }
}
