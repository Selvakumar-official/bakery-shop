import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String product = request.getParameter("product");
        String price = request.getParameter("price");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bakeryshop", "root", "root");
            PreparedStatement ps = con.prepareStatement("INSERT INTO orders(name, email, product, price) VALUES(?,?,?,?)");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, product);
            ps.setString(4, price);
            ps.executeUpdate();

            response.sendRedirect("success.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
