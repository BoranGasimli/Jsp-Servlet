package az.azex.repository.implementation;

import az.azex.domain.*;
import az.azex.repository.CommonDao;
import az.azex.utility.JdbcUtility;

import javax.sql.DataSource;
import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CommonDaoImpl implements CommonDao {

    private DataSource dataSource;

    public CommonDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<FlexibleList> getAllFlexibleList() {
        List<FlexibleList> allFlexibleList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = DatabaseHelper.connect();
            ps = connection.prepareStatement(SqlQuery.GET_ALL_FLEXIBLE_LIST);
            rs = ps.executeQuery();
            while(rs.next()) {
               long id = rs.getLong("id");
               Optional<FlexibleList> optionalFlexibleList = getFlexibleListById(id);
                if(optionalFlexibleList.isPresent()) {
                    allFlexibleList.add(optionalFlexibleList.get());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(rs, ps, connection);
        }
        return allFlexibleList;
    }

    @Override
    public Optional<FlexibleList> getFlexibleListById(long id) {
        Optional<FlexibleList>  optionalFlexibleList = Optional.empty();

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = DatabaseHelper.connect();
            ps = connection.prepareStatement(SqlQuery.GET_FLEXIBLE_LIST_BY_ID);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            FlexibleList flexibleList = read(rs, ps, connection);
            if(flexibleList != null) {
                optionalFlexibleList = Optional.of(flexibleList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(rs, ps, connection);
        }

        return optionalFlexibleList;
    }

    private FlexibleList read(ResultSet rs, PreparedStatement ps, Connection connection) throws SQLException {
        FlexibleList flexibleList = null;
        if(rs.next()) {
            flexibleList = new FlexibleList();
            flexibleList.setId(rs.getLong("id"));
            flexibleList.setName(rs.getString("name"));
            flexibleList.setStatus(Status.ACTIVE);

            ps = connection.prepareStatement(SqlQuery.GET_FLEXIBLE_LIST_ITEMS_BY_LIST_ID);
            ps.setLong(1, flexibleList.getId());
            rs = ps.executeQuery();

            while(rs.next()) {
                FlexibleListItem item = new FlexibleListItem();
                item.setId(rs.getLong("id"));
                item.setListId(flexibleList.getId());
                item.setValueId(rs.getLong("value_id"));
                item.setValueName(rs.getString("value_name"));
                item.setInsertDate(rs.getTimestamp("insert_date").toLocalDateTime());
                flexibleList.add(item);
            }
        }

        return flexibleList;
    }

    @Override
    public Optional<FlexibleList> getFlexibleListByName(String name) {
        Optional<FlexibleList>  optionalFlexibleList = Optional.empty();

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = DatabaseHelper.connect();
            ps = connection.prepareStatement(SqlQuery.GET_FLEXIBLE_LIST_BY_NAME);
            ps.setString(1, name);
            rs = ps.executeQuery();
            FlexibleList flexibleList = read(rs, ps, connection);
            if(flexibleList != null) {
                optionalFlexibleList = Optional.of(flexibleList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(rs, ps, connection);
        }

        return optionalFlexibleList;
    }
}
