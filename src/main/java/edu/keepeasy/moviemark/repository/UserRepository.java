package edu.keepeasy.moviemark.repository;

import edu.keepeasy.moviemark.model.User;
import io.swagger.annotations.Api;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Api(tags = "Address entity")
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> getUserByUsername(String username);
}
