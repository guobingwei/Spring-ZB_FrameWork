package dao;

import domain.User;

import java.util.List;

/**
 * Created by john on 2016/3/14.
 */
public interface IUserDao {
    public void save(User user);
    public List<User> query(String sql,Object[] args);
}
