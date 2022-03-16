package com.example.brief_tdd.services;

import com.example.brief_tdd.dto.model.ClientDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest

class ClientServiceTest {

    List<ClientDto> client = new ArrayList<>();
    ClientDto clt = new ClientDto();

    @Autowired
    ClientService clientService;


    // ----- Test save client :
    @Test
    void addClient() {
        clt.setEmail("ahLgjhu@gmail.com");
        clt.setPhone("+212645345654");
        clt.setFullname("hana dlts");
        clt.setAge(12);
        clt.setSex("femme");
        clt.setIsActive(true);
        assertNotEquals(null,clientService.AddClient(clt));
    }


    // ----- Test get all :
    @Test
    void getAllClients() {
        assertNotEquals(client,clientService.getAllClients(0, 2));
    }


    @Test
    void getClientById() {
        assertNotNull(clientService.getClientById(1L));


    }

    @Test
    void getClientByEmail() {
        assertNotNull(clientService.getClientByEmail("loubna@gmail.com"));

    }

    @Test
    void getClientBySex() {
        assertNotEquals(client,clientService.getClientBySex("homme"));

    }

    @Test
    void deleteClient() {
        assertEquals(false,clientService.deleteClient(0L));
    }

    // -- test Update client :
    @Test
    void updateClient() {
        clt.setId(6L);
        clt.setEmail("hello@gmail.com");
        clt.setPhone("+212654657600");
        clt.setFullname("hello hello");
        clt.setAge(12);
        clt.setSex("homme");
        clt.setIsActive(true);
        assertNotEquals(null,clientService.updateClient(clt));
    }
}