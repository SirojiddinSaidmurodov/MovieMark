package edu.keepeasy.moviemark.security;

import edu.keepeasy.moviemark.model.User;
import edu.keepeasy.moviemark.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Couldn't find user with username " + username);
        }
        return new edu.keepeasy.moviemark.security.UserDetails(user);
    }
}
