package dao;

import domain.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by john on 2016/3/14.
 */
public class UserDaoImpl extends JdbcDaoSupport implements IUserDao {

    class UserRowMapper implements RowMapper<User> {
        //实现ResultSet到User实体的转换
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User m = new User();
            m.setId(rs.getLong("id"));
            m.setName(rs.getString("name"));
            m.setAge(rs.getInt("age"));
            return m;
        }
    };

    public void save(User model) {
        getJdbcTemplate().update("insert into user(name,age) values(?,?)",
                model.getName(), model.getAge());
    }

    public List<User> query(String sql, Object[] args) {
        return getJdbcTemplate().query(sql, args, new UserRowMapper());
    }
}
