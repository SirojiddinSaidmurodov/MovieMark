package edu.keepeasy.moviemark.repository;

import edu.keepeasy.moviemark.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByUsername(String username);
}
