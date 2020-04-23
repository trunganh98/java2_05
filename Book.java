package Java2_05;

import java.sql.*;
import java.util.Scanner;

class Book{
    public String viewTop10NewBook(){
        String strSelect = "Select * from books Order By BookID DESC LIMIT 10;";
        return strSelect;
    }
    public String viewTop100Sale(){
        String strSelect = "SELECT book.BookName, book.Author, book.Category, book.Price, book.Status " +
                "FROM orderdetail " +
                "INNER JOIN books ON book.Bookcode = orderdetail.Bookcode " +
                "INNER JOIN order ON orderdetail.IDOrder = order.IDOder " +
                "WHERE orders.CustomerID = 1 " +
                "LIMIT 100;";
        return strSelect;
    }
    public String findCategories(String Categories){
        String strSelect = "SELECT * FROM book WHERE Categories = '" + Categories + "';";
        return strSelect;
    }
    public String findAuthor(String Author){
        String strSelect = "SELECT * FROM book WHERE AuthorName = '" + Author + "';";
        return strSelect;
    }
    public String viewBook(int Bookcode){
        String strSelect = "SELECT * FROM book WHERE BookID = '" + Bookcode + "';";
        return strSelect;
    }
    public String view30OrderBySTT1(){
        String strSelect = "SELECT * FROM orderdetail " +
                "INNER JOIN orderstatus ON orderdetail.OrderID = orderstatu.OrderID " +
                "WHERE orderstatu.status = 1 LIMIT 30";
        return strSelect;
    }
    public  String viewOrderByCustomerID(){
        String strSelect = "SELECT * FROM orderdetail ORDER BY CustomerID ASC";
        return strSelect;
    }
    public String viewSTTByIDOder(){
        String strSelect = "SELECT * FROM orders ORDER BY IDOder ASC";
        return strSelect;
    }
    public String viewOrderdetailbyOrderID(int IDOder){
        String strSelect = "SELECT * FROM orderdetail WHERE OrderID = '" + IDOder + "'";
        return strSelect;
    }
    public String viewOrderBySTT2(){
        String strSelect = "SELECT * FROM orderdetail INNER JOIN orders ON orderdetail.IDOder = orders.OrderID WHERE orders.CustomerID = 2";
        return strSelect;
    }
    public String viewOrderBySTT3(){
        String strSelect = "SELECT * FROM orderdetail INNER JOIN orders ON orderdetail.IDOder = orders.OrderID WHERE orders.CustomerID = 3";
        return strSelect;
    }
    public String viewOrderBySTT4(){
        String strSelect = "SELECT * FROM orderdetail INNER JOIN orders ON orderdetail.IDOder = orders.OrderID WHERE orders.CustomerID = 4";
        return strSelect;
    }
    public String viewOrderBySTT5(){
        String strSelect = "SELECT * FROM orderdetail INNER JOIN orders ON orderdetail.IDOder = orders.OrderID WHERE orders.CustomerID = 5";
        return strSelect;
    }
    public String viewOrderBySTT0(){
        String strSelect = "SELECT * FROM orderdetails INNER JOIN orderstatu ON orderdetail.IDOder = orderstatu.OrderID WHERE orders.CustomerID = 0";
        return strSelect;
    }
}
class bookstore {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/bookstore?" +
                                "&serverTimezone=UTC" +
                                "&useSSL=false" +
                                "&allowPublicKeyRetrieval=true",
                        "root","");
                Statement stmt = conn.createStatement();
        ){
            Book u1 = new Book();
            ResultSet rset = stmt.executeQuery(u1.viewTop10NewBook());
            while (rset.next()){
                int Bookcode = rset.getInt("Bookcode");
                String Bookname = rset.getString("Bookname");
                String Author = rset.getString("Author");
                String Category = rset.getString("Category");
                Float Price = rset.getFloat("Price");
                String Status = rset.getString("Status");
                System.out.println(Bookcode + ", " + Bookname + ", " + Author + ", " + Category + ", " + Price + ", " + Status);
            }

            ResultSet rset2 = stmt.executeQuery(u1.viewTop100Sale());
            while (rset2.next()){
                String Bookname = rset2.getString("Bookname");
                String Author = rset2.getString("Author");
                String Category = rset2.getString("Category");
                Float Price = rset2.getFloat("Price");
                String Status = rset2.getString("Status");

                System.out.println(Bookname + ", " + Author+ ", " + Category + ", " + Price + ", " + Status);
            }

            Scanner input = new Scanner(System.in);
            System.out.println("Input book's author name !");
            String author = input.nextLine();
            ResultSet rset5 = stmt.executeQuery(u1.findAuthor(author));
            while (rset5.next()){
                String Bookname = rset5.getString("Bookname");
                String Category = rset5.getString("Category");
                Float Price = rset5.getFloat("Price");
                String Status = rset5.getString("Status");

                System.out.println(Bookname + ", " + Category + ", " + Price + ", " + Status );
            }

            System.out.println("Input book's categories !");
            String categoies = input.nextLine();
            ResultSet rset3 = stmt.executeQuery(u1.findCategories(categoies));
            while (rset3.next()){
                String Bookname = rset3.getString("BookName");
                String Author = rset3.getString("Author");
                Float Price = rset3.getFloat("Price");
                String Status = rset3.getString("Status");

                System.out.println(Bookname + ", " + Author  + ", " + Price + ", " + Status );
            }

            System.out.println("Input BookID");
            int bookID = input.nextInt();
            ResultSet rset4 = stmt.executeQuery(u1.viewBook(bookID));
            while (rset4.next()){
                String Bookname = rset4.getString("Bookname");
                String Author = rset4.getString("Author");
                String Category = rset4.getString("Category");
                Float Price = rset4.getFloat("Price");
                String Status = rset4.getString("Status");

                System.out.println(Bookname + ", " + Author + ", " + Category + ", " + Price + ", " + Status );
            }

            ResultSet rset6 = stmt.executeQuery(u1.view30OrderBySTT1());
            while (rset6.next()) {
                String IDOrder = rset6.getString("IDOrder");
                String CustomerID = rset6.getString("CustomerID");
                String Bookcode = rset6.getString("Bookcode");
                Float Price = rset6.getFloat("Price");
                int Amount = rset6.getInt("Amount");
                System.out.println(IDOrder + ", " + CustomerID + ", " + Bookcode + ", " + Price + ", " + Amount);
            }
            ResultSet rset7 = stmt.executeQuery(u1.viewOrderByCustomerID());
            while (rset7.next()){
                String IDOrder = rset6.getString("IDOrder");
                String CustomerID = rset6.getString("CustomerID");
                String Bookcode = rset6.getString("Bookcode");
                Float Price = rset6.getFloat("Price");
                int Amount = rset6.getInt("Amount");
                System.out.println(IDOrder + ", " + CustomerID + ", " + Bookcode + ", " + Price + ", " + Amount);
            }
            ResultSet rset8 = stmt.executeQuery(u1.viewSTTByIDOder());
            while (rset8.next()){
                int IDOderDetail = rset8.getInt("IDOderDetail");
                int TotalPrice = rset8.getInt("TotalPrice");
                System.out.println(IDOderDetail + ", " + TotalPrice);
            }
            System.out.println("Input OrderID");
            int orderID = input.nextInt();
            ResultSet rset9 = stmt.executeQuery(u1.viewOrderdetailbyOrderID(orderID));
            while (rset9.next()){
                String CustomerID = rset6.getString("CustomerID");
                String Bookcode = rset6.getString("Bookcode");
                Float Price = rset6.getFloat("Price");
                int Amount = rset6.getInt("Amount");
                System.out.println(CustomerID + ", " + Bookcode + ", " + Price + ", " + Amount);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
};