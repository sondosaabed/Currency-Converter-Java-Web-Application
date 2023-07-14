package currencyConvert.dataAccess;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FetchCurrencyOptionsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Establish a connection to the MySQL database
        String url = "jdbc:mysql://localhost:3306/currencyconverter";
        String username = "root";
        String password = "0000";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);

            // Fetch currency options from the database
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM currency";
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.isBeforeFirst()) {
                // Populate the currency select options
                while (rs.next()) {
                    String currency = rs.getString("code");
                    String name = rs.getString("name");

                    out.println("<option value='" + currency + "'>" + currency + " - " + name + "</option>");
                }
            } else {
                out.println("No currency options found.");
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}