package edu.keepeasy.moviemark;

import edu.keepeasy.moviemark.model.Person;
import edu.keepeasy.moviemark.model.Role;
import edu.keepeasy.moviemark.model.Sex;
import edu.keepeasy.moviemark.model.User;
import edu.keepeasy.moviemark.repository.PersonRepository;
import edu.keepeasy.moviemark.repository.UserRepository;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class MvcTest {
    private final User authUser = new User(
            10L,
            "admin",
            new BCryptPasswordEncoder(12).encode("admin"),
            Role.ADMIN,
            true,
            new ArrayList<>());
    @Autowired
    private MockMvc mvc;
    @MockBean
    private PersonRepository personRepository;
    @MockBean
    private UserRepository userRepository;

    @Test
    public void testAuthWithKnownCredentials() throws Exception {
        when(userRepository.getUserByUsername(authUser.getUsername()))
                .thenReturn(Optional.of(authUser));
        String body = "{\"password\": \"admin\",\"username\": \"admin\"}";
        mvc.perform(post("/api/auth/login")
                        .content(body)
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("username").value(authUser.getUsername()));
    }

    @Test
    public void testAuthWithUnknownCredentials() throws Exception {
        String body = "{\"password\": \"admin\",\"username\": \"admin\"}";
        mvc.perform(post("/api/auth/login")
                        .content(body)
                        .contentType("application/json"))
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void getPersonById() throws Exception {
        when(userRepository.getUserByUsername("admin"))
                .thenReturn(Optional.of(authUser));

        when(personRepository.findById(12L))
                .thenReturn(Optional.of(new Person(
                        12L,
                        "Сэмюэл Л. Джексон",
                        "Samuel L. Jackson",
                        Sex.MAN,
                        LocalDate.of(1948, 12, 21),
                        "Вашингтон, округ Колумбия, США")));

        String body = "{\"password\": \"admin\",\"username\": \"admin\"}";
        MvcResult result = mvc.perform(post("/api/auth/login")
                        .content(body)
                        .contentType("application/json"))
                .andExpect(status().isOk()).andReturn();
        String response = result.getResponse().getContentAsString();
        JSONObject json = new JSONObject(response);
        String token = json.getString("token");

        mvc.perform(
                        get("/persons/12")
                                .header("Authorization", token)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fullName").value("Сэмюэл Л. Джексон"))
                .andExpect(jsonPath("$.sex").value("MAN"));
    }
}
