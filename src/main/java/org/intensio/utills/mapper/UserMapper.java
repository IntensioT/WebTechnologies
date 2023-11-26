package org.intensio.utills.mapper;

import org.intensio.beans.Role;
import org.intensio.beans.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {

    /**
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    public static User mapperUser(ResultSet rs) throws SQLException {
        return User.builder()
                .id(rs.getInt("user_id"))
                .password(rs.getString("password"))
                .role(Role.valueOf(rs.getString("role")))
                .username(rs.getString("username"))
                .token(rs.getString("token"))
                .socialCredit(rs.getInt("socialcredit"))
                .login(rs.getString("login"))
                .build();
    }
}
