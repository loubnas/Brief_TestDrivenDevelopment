package com.example.brief_tdd.repositories;

import com.example.brief_tdd.dto.model.ClientDto;
import com.example.brief_tdd.dto.services.IMapClassWithDto;
import com.example.brief_tdd.entities.ClientEntity;
import com.example.brief_tdd.services.ClientService;
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
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)

class ClientRepositoryTest {

        @InjectMocks
        ClientRepository clientRepository;

        @BeforeEach
        void setUp() {
            MockitoAnnotations.initMocks(this);
        }


    @Test
    void findAll(){
        List<ClientDto> clts = new ArrayList<>();
        /*when(clientRepository.findAll(new Pageable() {
            @Override
            public int getPageNumber() {
                return 0;
            }

            @Override
            public int getPageSize() {
                return 0;
            }

            @Override
            public long getOffset() {
                return 0;
            }

            @Override
            public Sort getSort() {
                return null;
            }

            @Override
            public Pageable next() {
                return null;
            }

            @Override
            public Pageable previousOrFirst() {
                return null;
            }

            @Override
            public Pageable first() {
                return null;
            }

            @Override
            public Pageable withPage(int pageNumber) {
                return null;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }
        })).thenReturn(new Page);
*/

    }
    @Test
    void findByEmail() {
    }

    @Test
    void findBySex() {
    }

    @Test
    void findById() {
    }
}