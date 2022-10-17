package com.mycompany.jdbc.operations;

import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author turker
 */
public class JDBCOperations {
     
    static DbHelper helper = new DbHelper();

    public static void main(String[] args) throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet;
        Connection connection = null;
        
        try {
              connection = helper.connection();
            String sql = "update city set population = 1300000 where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, 3070);
            int result = statement.executeUpdate();
            System.out.println("Record updated.");
        } catch (SQLException e) {
            helper.showErrorMessage(e);
        }
        finally{
            statement.close();
            connection.close();
        }
        
        
    }
     public static void selectDemo() throws SQLException {

        Statement statement = null;
        ResultSet resultSet;
        Connection connection = null;
        try {
            connection = helper.connection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select code,name,continent,region from country");
            ArrayList<Country> countries = new ArrayList<Country>();
            while (resultSet.next()) {
                countries.add(new Country(
                        resultSet.getString("code"),
                        resultSet.getString("name"),
                        resultSet.getString("continent"),
                        resultSet.getString("region")));
            }
            System.out.println(countries.size());
        } catch (SQLException e) {
            helper.showErrorMessage(e);
        } finally {
            connection.close();
        }
    }

    public static void insertDemo() throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet;
        Connection connection = null;
        try {
            connection = helper.connection();
            String sql = "insert into city (name,countrycode,district,population) values(?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, "Düzce 2");
            statement.setString(2, "TUR");
            statement.setString(3, "Turkey");
            statement.setInt(4, 600000);
            int result = statement.executeUpdate();
            System.out.println("Record added.");
        } catch (SQLException e) {
            helper.showErrorMessage(e);
        } finally {
            statement.close();
            connection.close();
        }
    }
    public static void updateDemo() throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet;
        Connection connection = null;
        try {
            connection = helper.connection();
            String sql = "update city set population = 1300000 where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, 3070);
            int result = statement.executeUpdate();
            System.out.println("Record updated.");
        } catch (SQLException e) {
            helper.showErrorMessage(e);
        } finally {
            statement.close();
            connection.close();
        }

    }
}
