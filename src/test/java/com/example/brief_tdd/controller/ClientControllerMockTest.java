package com.example.brief_tdd.controller;

import com.example.brief_tdd.dto.model.ClientDto;
import com.example.brief_tdd.dto.services.IMapClassWithDto;
import com.example.brief_tdd.entities.ClientEntity;
import com.example.brief_tdd.repositories.ClientRepository;
import com.example.brief_tdd.services.ClientService;
import com.example.brief_tdd.services.IClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(ClientControllerMockTest.class)
@Import(ClientController.class)
class ClientControllerMockTest {

    @Autowired
    MockMvc mockMvc;


    @MockBean
    ClientService clientService;
    @Mock
    IMapClassWithDto<ClientEntity, ClientDto> clientMapping;
    @Mock
    ClientRepository clientRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    // Test ajouter : ---------------------------------------------
    @Test
    void save() throws Exception {
        ClientDto clt= new ClientDto();
        clt.setEmail("hit@gmail.com");
        clt.setAge(15);

        when(clientService.AddClient(clt)).thenReturn(clt);

        mockMvc.perform(post("/clients/save")
                .contentType(MediaType.ALL.APPLICATION_JSON)
                .content("{\"email\": \"hit@gmail.com\",\"age\":15}"))
                .andExpect(status().isCreated())
                .andDo(MockMvcResultHandlers.print()).andReturn();
    }



    // Test get all : ---------------------------------------------

    @Test
    void getAll() throws Exception {
        List<ClientDto> clts = new ArrayList<>();
        clts.add(new ClientDto());
        clts.add(new ClientDto());

        when(clientService.getAllClients(0,1)).thenReturn(clts);

        mockMvc.perform(get("/clients/")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .content("page=0&limit=1"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print()).andReturn();
    }


    // Test get by id : ---------------------------------------------

    @Test
    void getById() throws Exception {
        ClientDto clt= new ClientDto();
        clt.setId(1L);
        clt.setFullname("loubna soussi");
        when(clientService.getClientById(1L)).thenReturn(clt);

        mockMvc.perform(get("/clients/1"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print()).andReturn();
    }


    // Test get by email  : ---------------------------------------------

    @Test
    void getByEmail() throws Exception {
        ClientDto clt= new ClientDto();
        clt.setEmail("loubna@gmail.com");
        when(clientService.getClientByEmail("loubna@gmail.com")).thenReturn(clt);

        mockMvc.perform(get("/clients/loubna@gmail.com/?email"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print()).andReturn();
    }

    // Test get by sex  : ---------------------------------------------

    @Test
    void getBySex() throws Exception {
        List<ClientDto> list= new ArrayList<>();
        ClientDto c= new ClientDto();
        c.setSex("homme");
        list.add(c);

        when(clientService.getClientBySex("homme")).thenReturn(list);

        mockMvc.perform(get("/clients/all/homme"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print()).andReturn();
    }


    // Test delete  : ---------------------------------------------

    @Test
    void delete() throws Exception {
        when(clientService.deleteClient(1L)).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.delete("/clients/1"))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print()).andReturn();
    }


    // Test update : ---------------------------------------------

    @Test
    void update() throws Exception {
        ClientDto clt= new ClientDto();
        clt.setId(1L);
        clt.setEmail("hit@gmail.com");
        clt.setAge(15);

        when(clientService.updateClient(clt)).thenReturn(clt);

        mockMvc.perform(put("/clients/1")
                        .contentType(MediaType.ALL.APPLICATION_JSON)
                        .content("{\"id\":1,\"email\": \"hit@gmail.com\",\"age\":15}"))
                .andExpect(status().isCreated())
                .andDo(MockMvcResultHandlers.print()).andReturn();
    }
}