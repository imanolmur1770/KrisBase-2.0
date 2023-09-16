package Data;

import Tools.Book;

import java.sql.*;
import java.util.ArrayList;

public class getData {
    private static ArrayList<Book> bookList;  // Class-level variable
    public static Connection connect() throws SQLException {
        String Password = "<APPDEV123appdev!!!>";
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/sql_books", "root", Password);
    }
    public static ArrayList<Book> gettingBooks() {
        bookList = new ArrayList<>();
        try(Connection connection = connect()) {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from books");

            while (resultSet.next()) {
                Book book = new Book(resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6));
                bookList.add(book);
            }
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return bookList;
    }
    public static boolean addingBooks(Book newBook){
        String SQL = "INSERT INTO books VALUES(?,?,?,?,?,?)";
        boolean result = false;
        String bn = newBook.getBookName();
        String au = newBook.getAuthor();
        String ge = newBook.getGenre();
        String re = newBook.getRead();
        int ra = Integer.parseInt(newBook.getRating());
        String ba = newBook.getBarcode();
        try(Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, bn);
            pstmt.setString(2, au);
            pstmt.setString(3, ge);
            pstmt.setString(4, re);
            pstmt.setInt(5, ra);
            pstmt.setString(6, ba);

            pstmt.executeUpdate();
            connect().close();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public static void deleteBooks(String Barcode){
        String SQL = "delete from books WHERE book_barcode = ?";
        try(Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, Barcode);
            pstmt.executeUpdate();
            connect().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateBooks(String bn, String au, String ge, String re, String ra, String ba){
        int ra1 = Integer.parseInt(ra);
        String SQL = "UPDATE books " +
                " SET book_name = ?," +
                "book_author = ?," +
                "book_genre = ?," +
                "book_read = ?," +
                "book_rating = ? " +
                " WHERE book_barcode = ? ";
        try(Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, bn);
            pstmt.setString(2, au);
            pstmt.setString(3, ge);
            pstmt.setString(4, re);
            pstmt.setInt(5, ra1);
            pstmt.setString(6, ba);
            pstmt.executeUpdate();
            connect().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
