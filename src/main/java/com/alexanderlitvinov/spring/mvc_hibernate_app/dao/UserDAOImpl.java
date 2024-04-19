package com.alexanderlitvinov.spring.mvc_hibernate_app.dao;

import com.alexanderlitvinov.spring.mvc_hibernate_app.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getAllUsers() {
        Session session=  sessionFactory.getCurrentSession();
//        List<User> allUsers =session.createQuery("from User"
//                        , User.class).getResultList();

        Query<User> query = session.createQuery("from User"
                        , User.class);
        List<User> allUsers = query.getResultList();
        return allUsers;
    }

    @Override
    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }

    @Override
    public User getUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        return user;
    }

    @Override
    public void deleteUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("delete from User " +
                                                "where id =:userId");
        query.setParameter("userId", id);
        query.executeUpdate();
    }
}
