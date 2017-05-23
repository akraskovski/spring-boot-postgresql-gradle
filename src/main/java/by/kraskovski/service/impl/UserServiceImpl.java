package by.kraskovski.service.impl;

import by.kraskovski.model.User;
import by.kraskovski.repository.UserRepository;
import by.kraskovski.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User find(int id) {
        return userRepository.findOne(id);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(int id, User user) {
        user.setId(id);
        return userRepository.save(user);
    }

    @Override
    public boolean delete(int id) {
        try {
            userRepository.delete(id);
            return true;
        } catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteAll() {
        try {
            userRepository.deleteAll();
            return true;
        } catch (DataAccessException e) {
            LOGGER.info(e.getMessage());
            return false;
        }
    }
}
