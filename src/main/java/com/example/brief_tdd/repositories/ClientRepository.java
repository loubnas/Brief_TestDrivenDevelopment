package com.example.brief_tdd.repositories;

import com.example.brief_tdd.entities.ClientEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  ClientRepository extends PagingAndSortingRepository<ClientEntity,Long> {
    ClientEntity findByEmail(String email);
    List<ClientEntity> findBySex(String sex);
    ClientEntity findById(long id);

}





