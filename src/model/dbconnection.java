/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author davidespino
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbconnection {

    /**
     * @param args
     */
    public static void main(String args[]) {
        try {

            String dbServer = "jdbc:mysql://apontejaj.com:3306/David_2019140?useSSL=false";
            String user = "David_2019140";
            String password = "2019140";
            String query = "SELECT * FROM moviesXtraVision";

            // Get a connection to the database
            Connection conn = DriverManager.getConnection(dbServer, user, password);

            // Get a statement from the connection
            Statement stmt = conn.createStatement();

            // Execute the query
            ResultSet rs = stmt.executeQuery(query);

            // Loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("idmovies") + "\t" + rs.getString("title") + "\t" + rs.getString("duration")+ "\t" + rs.getString("genre"));
            }

            // Close the result set, statement and the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            System.out.println("SQL Exception:");

            // Loop through the SQL Exceptions
            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());

                se = se.getNextException();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
