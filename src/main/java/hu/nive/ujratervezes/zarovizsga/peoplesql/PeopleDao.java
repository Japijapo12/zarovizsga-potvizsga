package hu.nive.ujratervezes.zarovizsga.peoplesql;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PeopleDao {

    DataSource dataSource;

    public PeopleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String findIpByName(String firstName, String lastName) {

        String ip = null;
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("select ip_address from people where first_name = ? and last_name = ?")) {

            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                ip = rs.getString("ip_address");

            }

        } catch (SQLException se) {
            throw new IllegalStateException("Wrong statement", se);
        }
        return ip;

    }


}
