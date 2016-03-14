package service;

/**
 * Created by john on 2016/3/14.
 */
public interface IUserService {
    void saveUser();
    void saveUserThrowException() throws Exception;
    void findUsers();
}
