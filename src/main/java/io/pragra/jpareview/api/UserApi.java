package io.pragra.jpareview.api;

import io.pragra.jpareview.entity.User;
import io.pragra.jpareview.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserApi {
    private final UserService service;

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return this.service.createUser(user);
    }

    @PutMapping("/user")
    public User update(@RequestBody User user) {
        return this.service.createUser(user);
    }

    @GetMapping("/user")
    public List<User> getALL() {
        return this.service.getAll();
    }
    @GetMapping("/user/{id}")
    public Optional<User> getOne(@PathVariable long id) {
        return this.service.getById(id);
    }

    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable long id) {
        this.service.deleteById(id);
    }


}
