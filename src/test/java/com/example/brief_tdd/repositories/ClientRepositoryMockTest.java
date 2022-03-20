package com.example.brief_tdd.repositories;

import com.example.brief_tdd.entities.ClientEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.*;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static org.mockito.Mockito.when;


//@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

class ClientRepositoryMockTest {
    //Mock
    @Autowired
    ClientRepository clientRepository;

    //@BeforeEach
    /*void setUp() {
        MockitoAnnotations.initMocks(this);
    }*/


    // --- test find all :

    @Test
    void findAll() {

        List<ClientEntity> clts = new ArrayList<>();
        clts.add(new ClientEntity());
        clts.add(new ClientEntity());

        Pageable p = PageRequest.of(0, 2);
        Page<ClientEntity> page = new PageImpl<ClientEntity>(clts);

        //when(clientRepository.findAll(p)).thenReturn(page);

        Assertions.assertEquals(2, clientRepository.findAll(p).stream().count());


    }

    // --- test find by id :

    @Test
    void findById() {
        ClientEntity clt=new ClientEntity();
        clt.setId(1L);

        //when(clientRepository.findById(1L)).thenReturn(clt);

        Assertions.assertEquals(1L,clientRepository.findById(1L).getId());
    }


    // --- test find by email :

    @Test
    void findByEmail() {
        ClientEntity clt=new ClientEntity();
        clt.setEmail("dd@gmail.com");

        //when(clientRepository.findByEmail("dd@gmail.com")).thenReturn(clt);

        Assertions.assertEquals(null,clientRepository.findByEmail("dd@gmail.com"));
        Assertions.assertEquals("loubna@gmail.com",clientRepository.findByEmail("loubna@gmail.com").getEmail());
    }


    // --- test find by sex :

    @Test
    void findBySex() {
        List<ClientEntity> list= new ArrayList<>();
        ClientEntity clt=new ClientEntity();
        clt.setSex("homme");
        list.add(clt);

        //when(clientRepository.findBySex("homme")).thenReturn(list);

        //Assertions.assertEquals(1,clientRepository.findBySex("homme").size());
        Assertions.assertEquals("homme",clientRepository.findBySex("homme").get(0).getSex());
    }


    // --- test save :

    @Test
    void save() {

        ClientEntity clt = new ClientEntity();
        clt.setFullname("hola hola");
        clt.setSex("femme");
        clt.setAge(12);
        clt.setEmail("test@mail.com");
        clt.setPhone("0600000000");

        ClientEntity rclt = new ClientEntity();
        rclt.setId(new Random(100000).nextLong());
        rclt.setFullname("hola hola");
        rclt.setSex("femme");

        rclt.setAge(12);



        //when(clientRepository.save(clt)).thenReturn(rclt);

        Assertions.assertEquals("hola hola",clientRepository.save(clt).getFullname());
       // Assertions.assertNotEquals(clt.getId(),clientRepository.save(clt).getId());

    }



}


