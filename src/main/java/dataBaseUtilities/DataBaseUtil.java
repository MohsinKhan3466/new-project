package dataBaseUtilities;


import java.sql.*;

public class DataBaseUtil {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
      //Loading the required JDBC Driver class
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        String myUrl="jdbc:sqlserver://localhost:1433";
        //Creating a connection to the database
        Connection conn = DriverManager.getConnection(myUrl,"sa","myPassword@12345");

        //Executing SQL query and fetching the result
        Statement st = conn.createStatement();
        String sqlStr = "select * from testTable";
        ResultSet rs = st.executeQuery(sqlStr);
        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }
    }

}

