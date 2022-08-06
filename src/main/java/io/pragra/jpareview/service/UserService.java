package io.pragra.jpareview.service;

import io.pragra.jpareview.entity.User;
import io.pragra.jpareview.exceptions.BasUserAgrumentException;
import io.pragra.jpareview.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User createUser(User user) {
       return this.userRepo.save(user);
    }

    public User updateUser(User user) {
        return this.userRepo.save(user);
    }

    public List<User> getAll() {
        return this.userRepo.findAll();
    }

    public Optional<User> getById(long id) {
        return this.userRepo.findById(id);
    }
    public void deleteById(long id) {
         this.userRepo.deleteById(id);
    }
}
