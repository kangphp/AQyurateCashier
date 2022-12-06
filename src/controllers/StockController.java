package controllers;

import com.mysql.jdbc.PreparedStatement;
import utils.DatabaseUtil;
import java.sql.*;
import java.util.*;
import java.time.*;
import models.Stock;

public class StockController {
    private DatabaseUtil koneksi;
    private ResultSet rs;
    private PreparedStatement pre;
    
    public StockController(){
        koneksi = new DatabaseUtil();
    }
    
    public ArrayList<Stock> getAllItems(){
        ArrayList<Stock> result = new ArrayList<Stock>();
        rs = koneksi.executeSelect("SELECT * FROM items");
        if(rs != null){
            try{
                while(rs.next()){
                    java.sql.Date dbSqlDate = rs.getDate("date");
                    java.util.Date dbSqlDateConverted = new java.util.Date(dbSqlDate.getTime());
                    
                    Stock barang = new Stock(
                            rs.getString("idInvoice"),
                            rs.getString("item_id"),
                            rs.getString("code_sup"),
                            rs.getInt("quantity"),
                            rs.getInt("price"),
                            dbSqlDateConverted
                        );
                    result.add(barang);
                }
            } catch (Exception ex){
                
            }
        }
        return result;
    }
}
