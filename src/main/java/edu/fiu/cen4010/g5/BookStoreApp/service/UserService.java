package edu.fiu.cen4010.g5.BookStoreApp.service;

import edu.fiu.cen4010.g5.BookStoreApp.model.User;
import edu.fiu.cen4010.g5.BookStoreApp.repository.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(@NotNull User user) {

        // query the database for users with this id
        List<User> repositoryResults = userRepository.findByUserId(user.getId()).get();

        // if no user with this id is found, add the new user
        if (repositoryResults.size() == 0) {
            userRepository.insert(user);
        }

        // throw error because a record exists with this user id already
        // use PUT to update user, not POST
        else {
            throw new RuntimeException(String.format("Found Existing User with ID %s", user.getId()));
        }

    }

    public void updateUser(@NotNull User user) {

        // query the database for users with this id
        List<User> repositoryResults = userRepository.findByUserId(user.getId()).get();

        // if no user with this id is found, throw an error
        // use POST to create new user, not PUT
        if (repositoryResults.size() == 0) {
            throw new RuntimeException(String.format("Cannot find User with ID %s", user.getId()));
        }

        // the database will not allow duplicate IDs in a collection, so update the only document returned
        else {
            User savedUser = repositoryResults.get(0);

            savedUser.setFirstname(user.getFirstname());
            savedUser.setLastname(user.getLastname());
            savedUser.setAddress1(user.getAddress1());
            savedUser.setAddress2(user.getAddress2());
            savedUser.setCity(user.getCity());
            savedUser.setState(user.getState());
            savedUser.setZipcode(user.getZipcode());

            userRepository.save(savedUser);
        }

    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException(
                String.format("Cannot find User with email address %s", email)));
    }

    public boolean validateUser(String id) {
        // query the database for users with this id
        List<User> repositoryResults = userRepository.findByUserId(id).get();

        // return true if there is a user with this id, and false if not
        return !repositoryResults.isEmpty();
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

}
