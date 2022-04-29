package com.sciodev.blogoner.models.dao;

import com.sciodev.blogoner.models.entity.User;
import java.util.List;

public interface IUserDAO {
    public List<User> findAll();
    public User findOne(Long id);
    public void save(User user);
    public void update(User user);
    public void delete(Long id);
}
