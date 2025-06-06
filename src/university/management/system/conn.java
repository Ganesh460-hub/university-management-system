package university.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {
    Connection connection;

    Statement Statement;

    conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/universitymanagementsystem","root","Ganesh@460");
            Statement = connection.createStatement();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
