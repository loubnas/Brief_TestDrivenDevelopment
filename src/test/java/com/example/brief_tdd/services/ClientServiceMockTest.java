package com.example.brief_tdd.services;

import com.example.brief_tdd.dto.model.ClientDto;
import com.example.brief_tdd.dto.services.IMapClassWithDto;
import com.example.brief_tdd.entities.ClientEntity;
import com.example.brief_tdd.repositories.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;


//@WebMvcTest(ClientServiceTest.class)
@ExtendWith(MockitoExtension.class)
//@SpringBootTest
public class ClientServiceMockTest {


    @InjectMocks
    ClientService clientService;
    @Mock
    IMapClassWithDto<ClientEntity, ClientDto> clientMapping;
    @Mock
    ClientRepository clientRepository;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    // ----- Test save client :
    @Test
    void addClient() {
        ClientDto clt = new ClientDto();
        clt.setId(7L);
        clt.setEmail("oscar@gmail.com");
        clt.setFullname("oscar oscar");
        clt.setAge(1);
        clt.setSex("homme");
        clt.setIsActive(true);


        when(clientService.AddClient(clt)).thenReturn(clt);
        ClientDto client=clientService.AddClient(clt);
        System.out.println(clt);

    }


    // ----- Test get all :
    @Test
    void getAllClients() {
        List<ClientDto> list=new ArrayList<>();
        ClientDto c=new ClientDto();
        c.setId(8L);
        c.setEmail("loh@gmail.com");
        c.setPhone("+2125646399");
        c.setFullname("ds concept");
        c.setAge(12);
        c.setSex("homme");
        c.setIsActive(true);

        list.add(c);

        ClientDto l=new ClientDto();
        l.setId(9L);
        l.setEmail("haha@gmail.com");
        l.setPhone("+2120046399");
        l.setFullname("WALO HAHA");
        l.setAge(1);
        l.setSex("femme");
        l.setIsActive(true);

        list.add(l);

        when(clientService.getAllClients(0,2)).thenReturn(list);
        List<ClientDto> clt=clientService.getAllClients(0,2);
        System.out.println(clt);
    }


    // ----- Test get by id :
    @Test
    void getClientById() {
        ClientDto c=new ClientDto();
        c.setId(1L);
        c.setEmail("loubna@gmail.com");
        when(clientService.getClientById(anyLong())).thenReturn(c);
        System.out.println(clientService.getClientById(1L));

    }

    // ---- Test get by email :
    @Test
    void getClientByEmail() {
        ClientDto c=new ClientDto();
        c.setEmail("loubna@gmail.com");
        when(clientService.getClientByEmail("loubna@gmail.com")).thenReturn(c);
        System.out.println(clientService.getClientByEmail("loubna@gmail.com"));
    }


    // ---- Test get by sex :
    @Test
    void getClientBySex() {
        List<ClientDto> l=new ArrayList<>();
        ClientDto c=new ClientDto();
        c.setSex("homme");
        l.add(c);
        when(clientService.getClientBySex("homme")).thenReturn(l);
        List<ClientDto> clt=clientService.getClientBySex("homme");
        System.out.println(clt);

    }


    // -- test Update client :
    @Test
    void updateClient() {
        ClientDto l = new ClientDto();
        l.setId(2L);
        l.setEmail("abc@gmail.com");
        l.setPhone("+2120046399");
        l.setFullname("HAHA");
        l.setAge(1);
        l.setSex("femme");
        l.setIsActive(true);


        ClientEntity cl=clientMapping.convertToEntity(l,ClientEntity.class);

        when(clientMapping.convertToDto(cl,ClientDto.class)).thenReturn(l);
        when(clientService.updateClient(l)).thenReturn(l);
        ClientDto clt=clientService.updateClient(l);
        System.out.println(clt);
    }

    // -- test delete

    @Test
    void deleteClient()  throws  Exception{
        ClientDto c=new ClientDto();
        c.setId(2L);
        c.setEmail("abc@gmail.com");
        c.setPhone("+2120046399");
        c.setFullname("HAHA");
        clientService.deleteClient(c.getId());

    }





}

