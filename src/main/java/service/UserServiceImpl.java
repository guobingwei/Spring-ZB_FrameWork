package service;

import dao.IUserDao;
import domain.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by john on 2016/3/14.
 */
public class UserServiceImpl implements IUserService {
    private IUserDao userDao;

    public void saveUser() {
        User u1=new User();
        u1.setName("��");
        u1.setAge(24);
        userDao.save(u1);

        if(1+1>1){
            throw new RuntimeException("Runtime error...");//�׳�����ʱ�쳣��RuntimeException
        }

        User u2=new User();
        u2.setName("��");
        u2.setAge(20);
        userDao.save(u2);
    }

    public void saveUserThrowException() throws Exception {
        User u1=new User();
        u1.setName("��");
        u1.setAge(24);
        userDao.save(u1);

        if(1+1>1){
            throw new Exception("Runtime error...");//�׳�һ����쳣��Exception
        }

        User u2=new User();
        u2.setName("��");
        u2.setAge(20);
        userDao.save(u2);
    }

    @Transactional(propagation= Propagation.NOT_SUPPORTED,readOnly=true)
    public void findUsers() {
        List<User> users=userDao.query("select * from user where age>?", new Object[]{17});
        for (User user : users) {
            System.out.println(user);
        }

    }

}
