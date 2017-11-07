package edu.iss.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbstractRepository {

    Connection connection;

    public void initialize(){
        connection = null;
        try
        {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost/lab4";
            connection = DriverManager.getConnection(url,"postgres", "postgres");
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM assign.student");
            List<String> studentNames = new ArrayList<String>();
            while ( rs.next() )
            {
                String name = rs.getString("name");
                studentNames.add(name);
            }
            rs.close();
            st.close();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.exit(2);
        }
    }

    public static void main(String[] args){
        AbstractRepository repository = new AbstractRepository();
        repository.initialize();
    }
}
