package com.example.brief_tdd.controller;

import com.example.brief_tdd.dto.model.ClientDto;
import com.example.brief_tdd.services.IClientService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;

@RestController
@RequestMapping("/clients/")

@Api(tags = "Client", value = "Client Controller")

public class ClientController {

    @Autowired
    IClientService clientService;


    //  Save :   ---------------------------------------------------------

    @PostMapping("/save")

    public ResponseEntity<ClientDto> save(@RequestBody ClientDto clientDto ){
        ClientDto client = clientService.AddClient(clientDto);
        return new ResponseEntity<ClientDto>(client, HttpStatus.CREATED);
    }



    //  Get All clients :  -----------------------------------------------

    @GetMapping("/")
    public ResponseEntity<List<ClientDto>> GetAll(@RequestParam(value ="page" ,defaultValue = "0") int page ,
                                                  @RequestParam(value ="limit",defaultValue = "5")int limit) {

        List<ClientDto> clientDto = clientService.getAllClients(page, limit);
        return ResponseEntity.ok(clientDto);
    }



    //  By Id :   --------------------------------------------------------

    @GetMapping(value="/{id}")
    public ResponseEntity<ClientDto> getById(@PathVariable long id)  {
        ClientDto client = clientService.getClientById(id);
        //return new ResponseEntity<ClientDto>(client, HttpStatus.OK);
        System.out.println("id");
        return ResponseEntity.ok(client);
    }


    // By email : --------------------------------------------------------

    @GetMapping(value = "/{email}",params = "email")
    public ResponseEntity<ClientDto> getByEmail(@PathVariable("email") String email)  {
        ClientDto cltM = clientService.getClientByEmail(email);
        System.out.println("email");
        return ResponseEntity.ok(cltM);
    }

    // By sex :  -----------------------------------------------------------------

    @GetMapping("/all/{sex}")
    public ResponseEntity<List<ClientDto>> getBySex(@PathVariable("sex") String sex)  {
        List<ClientDto> clts = clientService.getClientBySex(sex);
        return ResponseEntity.ok(clts);
    }


    // Delete  : --------------------------------------------------------------

    @DeleteMapping("/{id}")

    public ResponseEntity<String> Delete(@PathVariable long id){
        boolean deleted = clientService.deleteClient(id);
        return new ResponseEntity<String>("{\"Client\":\"" + id + "\",\"deleted\":\"" + deleted + "\"}", HttpStatus.OK);
    }


    // update  : --------------------------------------------------------------

    @PutMapping("/{id}")

    public ResponseEntity<ClientDto> Update(@RequestBody ClientDto client,@PathVariable long id  ){
        ClientDto updatedclient= clientService.updateClient(client);
        return new ResponseEntity<ClientDto>(updatedclient, HttpStatus.CREATED);
    }
}
