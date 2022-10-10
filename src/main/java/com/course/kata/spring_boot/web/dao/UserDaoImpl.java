package com.course.kata.spring_boot.web.dao;

import org.springframework.stereotype.Repository;
import com.course.kata.spring_boot.web.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        if (user.getId() == 0) {
            entityManager.persist(user);
        } else {entityManager.merge(user);}

    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(int id) {
        if (id != 0) {
            Query query = entityManager.createQuery("delete from User where id = :ID");
            query.setParameter("ID", id);
            query.executeUpdate();
        }
    }
}
