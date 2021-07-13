package com.company;

import java.sql.*;

public class DbWorker {
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "postgres";
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void writeInColumn(String a, int maxLen){
        int b=maxLen+10-a.length();
        System.out.print(a);
        for (int i=0; i<b; i++) {
            System.out.print(" ");
        }
    }

    public int maxLen(String table, String row){
        int maxlen=0;
        try (Connection co=connect();){
            String sql="SELECT max(length("+row+")) FROM "+table+";";
            Statement st=co.createStatement();
            ResultSet rs=st.executeQuery(sql);
            rs.next();
            maxlen=rs.getInt(1);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return maxlen;
    }

    public int maxLenInt(String table, String row){
        int maxlen=0;
        try (Connection co=connect();){
            String sql="SELECT max("+row+") FROM "+table+";";
            Statement st=co.createStatement();
            ResultSet rs=st.executeQuery(sql);
            rs.next();
            maxlen=String.valueOf(rs.getInt(1)).length();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return maxlen;
    }

    public void selectAllProducts(){
        try (Connection co=connect();){
            writeInColumn("Id", maxLenInt("product", "id"));
            writeInColumn("Name of product", maxLen("product", "name_of_product"));
            writeInColumn("Price", maxLenInt("product", "price"));
            writeInColumn("Expiration date", 10);
            writeInColumn("Row id", maxLenInt("product", "row_id"));
            writeInColumn("Discount", maxLenInt("product", "discount"));
            System.out.println();
            writeInColumn("--", maxLenInt("product", "id"));
            writeInColumn("---------------", maxLen("product", "name_of_product"));
            writeInColumn("-----", maxLenInt("product", "price"));
            writeInColumn("---------------", 10);
            writeInColumn("------", maxLenInt("product", "row_id"));
            writeInColumn("--------", maxLenInt("product", "discount"));
            System.out.println();
            String sql="SELECT * FROM product;";
            Statement st=co.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()){
                writeInColumn(String.valueOf(rs.getInt(1)), maxLenInt("product", "id"));
                writeInColumn(rs.getString(2), maxLen("product", "name_of_product"));
                writeInColumn(String.valueOf(rs.getInt(3)), maxLenInt("product", "price"));
                writeInColumn(String.valueOf(rs.getDate(4)), 10);
                writeInColumn(String.valueOf(rs.getInt(5)), maxLenInt("product", "row_id"));
                writeInColumn(String.valueOf(rs.getInt(6)), maxLenInt("product", "discount"));
                System.out.println();
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    public void selectProducts(){
        try (Connection co=connect();){
            writeInColumn("Id", maxLenInt("product", "id"));
            writeInColumn("Name of product", maxLen("product", "name_of_product"));
            writeInColumn("Price", maxLenInt("product", "price"));
            writeInColumn("Expiration date", 10);
            writeInColumn("Row id", maxLenInt("product", "row_id"));
            writeInColumn("Discount", maxLenInt("product", "discount"));
            System.out.println();
            writeInColumn("--", maxLenInt("product", "id"));
            writeInColumn("---------------", maxLen("product", "name_of_product"));
            writeInColumn("-----", maxLenInt("product", "price"));
            writeInColumn("---------------", 10);
            writeInColumn("------", maxLenInt("product", "row_id"));
            writeInColumn("--------", maxLenInt("product", "discount"));
            System.out.println();
            String sql="SELECT * FROM product WHERE row_id=1;";
            Statement st=co.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()){
                writeInColumn(String.valueOf(rs.getInt(1)), maxLenInt("product", "id"));
                writeInColumn(rs.getString(2), maxLen("product", "name_of_product"));
                writeInColumn(String.valueOf(rs.getInt(3)), maxLenInt("product", "price"));
                writeInColumn(String.valueOf(rs.getDate(4)), 10);
                writeInColumn(String.valueOf(rs.getInt(5)), maxLenInt("product", "row_id"));
                writeInColumn(String.valueOf(rs.getInt(6)), maxLenInt("product", "discount"));
                System.out.println();
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void selectGadgets(){
        try (Connection co=connect();){
            writeInColumn("Id", maxLenInt("product", "id"));
            writeInColumn("Name of product", maxLen("product", "name_of_product"));
            writeInColumn("Price", maxLenInt("product", "price"));
            writeInColumn("Expiration date", 10);
            writeInColumn("Row id", maxLenInt("product", "row_id"));
            writeInColumn("Discount", maxLenInt("product", "discount"));
            System.out.println();
            writeInColumn("--", maxLenInt("product", "id"));
            writeInColumn("---------------", maxLen("product", "name_of_product"));
            writeInColumn("-----", maxLenInt("product", "price"));
            writeInColumn("---------------", 10);
            writeInColumn("------", maxLenInt("product", "row_id"));
            writeInColumn("--------", maxLenInt("product", "discount"));
            System.out.println();
            String sql="SELECT * FROM product WHERE row_id=2;";
            Statement st=co.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()){
                writeInColumn(String.valueOf(rs.getInt(1)), maxLenInt("product", "id"));
                writeInColumn(rs.getString(2), maxLen("product", "name_of_product"));
                writeInColumn(String.valueOf(rs.getInt(3)), maxLenInt("product", "price"));
                writeInColumn(String.valueOf(rs.getDate(4)), 10);
                writeInColumn(String.valueOf(rs.getInt(5)), maxLenInt("product", "row_id"));
                writeInColumn(String.valueOf(rs.getInt(6)), maxLenInt("product", "discount"));
                System.out.println();
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void selectTop5(){
        try (Connection co=connect();){
            writeInColumn("Id", maxLenInt("product", "id"));
            writeInColumn("Name of product", maxLen("product", "name_of_product"));
            writeInColumn("Price", maxLenInt("product", "price"));
            writeInColumn("Expiration date", 10);
            writeInColumn("Row id", maxLenInt("product", "row_id"));
            writeInColumn("Discount", maxLenInt("product", "discount"));
            System.out.println();
            writeInColumn("--", maxLenInt("product", "id"));
            writeInColumn("---------------", maxLen("product", "name_of_product"));
            writeInColumn("-----", maxLenInt("product", "price"));
            writeInColumn("---------------", 10);
            writeInColumn("------", maxLenInt("product", "row_id"));
            writeInColumn("--------", maxLenInt("product", "discount"));
            System.out.println();
            String sql="SELECT * FROM product ORDER BY price DESC;";
            Statement st=co.createStatement();
            ResultSet rs=st.executeQuery(sql);
            for (int i=0; i<5; i++){
                rs.next();
                writeInColumn(String.valueOf(rs.getInt(1)), maxLenInt("product", "id"));
                writeInColumn(rs.getString(2), maxLen("product", "name_of_product"));
                writeInColumn(String.valueOf(rs.getInt(3)), maxLenInt("product", "price"));
                writeInColumn(String.valueOf(rs.getDate(4)), 10);
                writeInColumn(String.valueOf(rs.getInt(5)), maxLenInt("product", "row_id"));
                writeInColumn(String.valueOf(rs.getInt(6)), maxLenInt("product", "discount"));
                System.out.println();
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public void selectDisc50(){
        try (Connection co=connect();){
            writeInColumn("Id", maxLenInt("product", "id"));
            writeInColumn("Name of product", maxLen("product", "name_of_product"));
            writeInColumn("Price", maxLenInt("product", "price"));
            writeInColumn("Expiration date", 10);
            writeInColumn("Row id", maxLenInt("product", "row_id"));
            writeInColumn("Discount", maxLenInt("product", "discount"));
            System.out.println();
            writeInColumn("--", maxLenInt("product", "id"));
            writeInColumn("---------------", maxLen("product", "name_of_product"));
            writeInColumn("-----", maxLenInt("product", "price"));
            writeInColumn("---------------", 10);
            writeInColumn("------", maxLenInt("product", "row_id"));
            writeInColumn("--------", maxLenInt("product", "discount"));
            System.out.println();
            String sql="SELECT * FROM product WHERE discount>=50;";
            Statement st=co.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()){
                writeInColumn(String.valueOf(rs.getInt(1)), maxLenInt("product", "id"));
                writeInColumn(rs.getString(2), maxLen("product", "name_of_product"));
                writeInColumn(String.valueOf(rs.getInt(3)), maxLenInt("product", "price"));
                writeInColumn(String.valueOf(rs.getDate(4)), 10);
                writeInColumn(String.valueOf(rs.getInt(5)), maxLenInt("product", "row_id"));
                writeInColumn(String.valueOf(rs.getInt(6)), maxLenInt("product", "discount"));
                System.out.println();
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
