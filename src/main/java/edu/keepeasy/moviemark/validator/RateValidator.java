package edu.keepeasy.moviemark.validator;

import edu.keepeasy.moviemark.model.Rate;
import edu.keepeasy.moviemark.model.User;
import edu.keepeasy.moviemark.repository.UserRepository;
import edu.keepeasy.moviemark.security.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("beforeCreateRateValidator")
public class RateValidator implements Validator {
    @Autowired
    public UserRepository repository;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Rate.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Rate rate = (Rate) target;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails principal = (UserDetails) authentication.getPrincipal();
        User user = repository.getUserByUsername(principal.getUsername()).get();
        rate.setUser(user);
        if (rate.getValue() > 10 || rate.getValue() < 1) {
            errors.rejectValue("value", "wrong value");
        }
    }
}
