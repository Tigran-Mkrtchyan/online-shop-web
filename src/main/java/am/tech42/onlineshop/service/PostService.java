package am.tech42.onlineshop.service;

import am.tech42.onlineshop.db.DatabaseHelper;
import am.tech42.onlineshop.model.PostHeader;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostService {

    private static final int TOTAL_COUNT_PER_PAGE = 2;

    public static int getTotalPages() throws SQLException {
        var sql = "select ceil(count(*)::float / ?) as total_pages from posts where published = true";
        var preparedStatement = DatabaseHelper.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, TOTAL_COUNT_PER_PAGE);

        var resultSet = preparedStatement.executeQuery();
        resultSet.next();

        return resultSet.getInt("total_pages");
    }

    public static List<PostHeader> getPostHeaders(int pageNumber) throws SQLException {
        var sql = "select p.id, p.header, p.price, (select path from images where post_id = p.id limit 1) from posts p limit ? offset ?";
        var preparedStatement = DatabaseHelper.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, TOTAL_COUNT_PER_PAGE);
        preparedStatement.setInt(2, (pageNumber - 1) * TOTAL_COUNT_PER_PAGE);

        var resultSet = preparedStatement.executeQuery();
        var postHeaders = new ArrayList<PostHeader>();

        while (resultSet.next()) {
            postHeaders.add(new PostHeader(
                    resultSet.getInt("id"),
                    resultSet.getString("path"),
                    resultSet.getString("header"),
                    resultSet.getFloat("price")
            ));
        }

        return postHeaders;
    }

}
