package reponsitory;



import connection.ConnectDB;
import model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepository implements IBookRepository {
    private static final String SELECT_BOOK = "SELECT * FROM sach";
    ConnectDB db = new ConnectDB();

    @Override
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ma_sach");
                String name = rs.getString("ten_sach");
                String author = rs.getString("tac_gia");
                String description = rs.getString("mo_ta");
                int quantity = rs.getInt("so_luong");
                Book book = new Book(id,name, author, description, quantity);
                books.add(book);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

}
