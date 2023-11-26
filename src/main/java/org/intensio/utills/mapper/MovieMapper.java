package org.intensio.utills.mapper;

import org.intensio.beans.Movie;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieMapper {

    /**
     *
     * @param rs
     * @return
     * @throws SQLException
     */

    public static Movie mapperMovie(ResultSet rs) throws SQLException {
        return Movie.builder()
                .id(rs.getInt("movie_id"))
                .name(rs.getString("name"))
                .author(rs.getString("author"))
                .averageMark(rs.getDouble("averageMark"))
                .description(rs.getString("description"))
                .shortDescription(rs.getString("short_description"))
                .build();
    }
}
