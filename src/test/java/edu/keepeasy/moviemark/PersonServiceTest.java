package edu.keepeasy.moviemark;

import edu.keepeasy.moviemark.dto.PersonDto;
import edu.keepeasy.moviemark.mapper.PersonMapper;
import edu.keepeasy.moviemark.model.Person;
import edu.keepeasy.moviemark.model.Sex;
import edu.keepeasy.moviemark.repository.PersonRepository;
import edu.keepeasy.moviemark.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PersonServiceTest {
    private static final Person person = new Person(
            12L,
            "Сэмюэл Л. Джексон",
            "Samuel L. Jackson",
            Sex.MAN,
            LocalDate.of(1948, 12, 21),
            "Вашингтон, округ Колумбия, США");
    private final PersonMapper mapper = PersonMapper.INSTANCE;
    @Autowired
    private PersonService service;
    @MockBean
    private PersonRepository repository;

    @Test
    public void testPersonGet() {
        when(repository.findById(12L))
                .thenReturn(Optional.of(person));
        PersonDto dto = service.findById(12L);
        assertEquals(person.getFullName(), dto.getFullName());
    }

    @Test
    public void personCreateTest() {
        when(repository.save(person))
                .thenReturn(person);
        PersonDto personSaved = service.save(mapper.toDto(person));
        assertEquals(person.getFullName(), personSaved.getFullName());
    }
}
