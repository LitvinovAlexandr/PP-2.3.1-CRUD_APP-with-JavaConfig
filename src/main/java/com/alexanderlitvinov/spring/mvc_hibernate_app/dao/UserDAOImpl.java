package com.alexanderlitvinov.spring.mvc_hibernate_app.dao;

import com.alexanderlitvinov.spring.mvc_hibernate_app.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        Query query = (Query) entityManager.createQuery("from User ", User.class);
        return query.getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(int id) {
        Query query = (Query) entityManager.createQuery("delete from User " +
                                                        "where id =:userId");
        query.setParameter("userId", id);
        query.executeUpdate();
    }
}
