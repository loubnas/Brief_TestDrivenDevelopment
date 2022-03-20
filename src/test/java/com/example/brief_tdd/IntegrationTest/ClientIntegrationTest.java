package com.example.brief_tdd.IntegrationTest;

import com.example.brief_tdd.dto.model.ClientDto;
import com.example.brief_tdd.repositories.ClientRepository;
import com.mysql.cj.xdevapi.Client;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.webservices.server.MockWebServiceClientAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class ClientIntegrationTest {
    @Autowired
    private MockMvc mockMvc;


    @Test
    void save() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/clients/save")
                        .contentType(MediaType.ALL.APPLICATION_JSON)
                        .content("{\"fullname\": \"azertyu\",\"sex\": \"femme\",\"email\": \"hit1@gmail.com\",\"phone\": \"0600000000\",\"age\":15}"))
                .andExpect(status().isCreated())
                .andDo(MockMvcResultHandlers.print()).andReturn();
    }

    @Test
    void getAll() throws Exception {

        mockMvc.perform(get("/clients/")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .content("page=0&limit=5"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$" ,hasSize(5)))
                .andDo(MockMvcResultHandlers.print()).andReturn();
    }


    // Test get by id : ---------------------------------------------

    @Test
    void getById() throws Exception {
        mockMvc.perform(get("/clients/1"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print()).andReturn();
    }


    // Test get by email  : ---------------------------------------------

    @Test
    void getByEmail() throws Exception {

        mockMvc.perform(get("/clients/loubna@gmail.com/?email"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print()).andReturn();
    }

    // Test get by sex  : ---------------------------------------------

    @Test
    void getBySex() throws Exception {

        mockMvc.perform(get("/clients/all/homme"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print()).andReturn();
    }


    // Test delete  : ---------------------------------------------

    @Test
    void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/clients/1"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print()).andReturn();
    }


    // Test update : ---------------------------------------------

    @Test
    void update() throws Exception {

        mockMvc.perform(put("/clients/1")
                        .contentType(MediaType.ALL.APPLICATION_JSON)
                        .content("{\"id\":2,\"fullname\": \"HHHHHH\",\"sex\": \"femme\",\"email\": \"hit1@gmail.com\",\"phone\": \"0600000000\",\"age\":15}"))
                .andExpect(status().isCreated())
                .andDo(MockMvcResultHandlers.print()).andReturn();
    }
}
