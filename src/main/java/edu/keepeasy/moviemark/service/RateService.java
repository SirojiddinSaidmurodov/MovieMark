package edu.keepeasy.moviemark.service;

import edu.keepeasy.moviemark.dto.RateDto;
import edu.keepeasy.moviemark.mapper.RateMapper;
import edu.keepeasy.moviemark.model.Rate;
import edu.keepeasy.moviemark.repository.RateRepository;
import edu.keepeasy.moviemark.repository.UserRepository;
import edu.keepeasy.moviemark.security.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class RateService implements EntityService<RateDto, Long> {
    private final RateMapper mapper = RateMapper.INSTANCE;
    @Autowired
    private final RateRepository repository;
    @Autowired
    private final UserRepository userRepository;

    public RateService(RateRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }


    @Override
    public RateDto save(RateDto dto) {
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Rate rate = mapper.toEntity(dto);
        rate.setUser(userRepository.getUserByUsername(principal.getUsername()).get());
        return mapper.toDto(
                repository.save(
                        rate
                )
        );
    }

    @Override
    public RateDto findById(Long id) {
        return mapper.toDto(repository.getById(id));
    }

    @Override
    public RateDto updateById(RateDto dto) {
        return mapper.toDto(
                repository.save(
                        mapper.toEntity(dto)
                )
        );
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public boolean isPresent(Long id) {
        return repository.existsById(id);
    }
}
