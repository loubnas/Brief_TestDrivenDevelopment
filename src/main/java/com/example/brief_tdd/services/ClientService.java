package com.example.brief_tdd.services;


import com.example.brief_tdd.dto.model.ClientDto;
import com.example.brief_tdd.dto.services.IMapClassWithDto;
import com.example.brief_tdd.entities.ClientEntity;
import com.example.brief_tdd.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService  implements  IClientService{

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    IMapClassWithDto<ClientEntity, ClientDto> clientMapping;


    // ADD Client ____________________________________________________________________________________

    @Override
    public ClientDto AddClient(ClientDto clientDto) {

        ClientEntity clientEntity = clientMapping.convertToEntity(clientDto, ClientEntity.class);
        clientEntity = clientRepository.save(clientEntity);
        return clientMapping.convertToDto(clientEntity, ClientDto.class);

    }


    // Get All  Client ____________________________________________________________________________________

    @Override
    public List<ClientDto> getAllClients(int page, int limit) {
        Pageable pageableRequest = PageRequest.of(page, limit);

        Page<ClientEntity> clients =clientRepository.findAll(pageableRequest);
        return clientMapping.convertPageToListDto(clients,ClientDto.class);
    }


    // Get client By ID ____________________________________________________________________________________

    @Override
    public ClientDto getClientById(long id) {
        ClientEntity client = clientRepository.findById(id);
        return clientMapping.convertToDto(client, ClientDto.class);
    }



    // Get client By Email  ____________________________________________________________________________________

    @Override
    public ClientDto getClientByEmail(String email) {

        ClientEntity client = clientRepository.findByEmail(email);
        return clientMapping.convertToDto(client, ClientDto.class);
    }


    // Get client By Sex  ____________________________________________________________________________________

    @Override
    public List<ClientDto> getClientBySex(String sex) {
        List<ClientEntity> clients = clientRepository.findBySex(sex);
        return clientMapping.convertListToListDto(clients, ClientDto.class);
    }


    // delete client   ____________________________________________________________________________________

    @Override
    public boolean deleteClient(long id) {
        try {
            clientRepository.deleteById(id);
        }catch (Exception ex){
            return false;
        }
        return true;
    }


    // update client _______________________________________________________________________________

    @Override
    public ClientDto updateClient(ClientDto clientDto) {
        ClientEntity clientEntity = clientMapping.convertToEntity(clientDto, ClientEntity.class);
        clientEntity = clientRepository.save(clientEntity);

        return clientMapping.convertToDto(clientEntity, ClientDto.class);
    }


}
