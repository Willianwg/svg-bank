package com.willian.svgbank.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.willian.model.User;
import com.willian.repository.IUserRepository;

public class inMemoryUserRepository implements IUserRepository {
    private List<User> users;

    public inMemoryUserRepository() {
        this.users = new ArrayList<>();
    }

    @Override
    public User findByEmail(String email) {
        Optional<User> user = this.users.stream()
                .filter(item -> item.getEmail().equals(email))
                .findFirst();

        return user.orElse(null);
    }

    @Override
    public User findById(Long id) {
        Optional<User> user = this.users.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();

        return user.orElse(null);
    }

    @Override
    public User save(User user) {
        if(user.getId() != null){
            User before = this.users.stream().filter(item -> user.getEmail() == item.getEmail()).findFirst().get();
            int index = this.users.indexOf(before);
            this.users.set(index, user);

            return user;
        }
        Long id = (long) this.users.size();
        user.setId(id);
        this.users.add(user);

        return user;
    }

    @Override
    public List<User> findAll() {
        return this.users;
    }

}
