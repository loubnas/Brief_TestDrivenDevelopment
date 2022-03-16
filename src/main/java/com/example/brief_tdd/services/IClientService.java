package com.example.brief_tdd.services;

import com.example.brief_tdd.dto.model.ClientDto;

import java.util.List;

public interface IClientService {
    ClientDto AddClient(ClientDto client);
    List<ClientDto> getAllClients(int page, int limit);
    boolean deleteClient(long id);
    ClientDto updateClient(ClientDto client);

    //native query :-------------------------------------------------------
    ClientDto getClientByEmail(String email);
    List<ClientDto> getClientBySex(String sex);
    ClientDto getClientById(long id);



}
