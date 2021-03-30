package br.com.revendedora.controller;

import br.com.revendedora.dto.response.ContactResponse;
import br.com.revendedora.model.Contact;
import br.com.revendedora.repository.ContactRepository;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;


import static br.com.revendedora.util.ApiConfig.Path.Contact.CONTACT;
import static br.com.revendedora.util.ApiConfig.Path.RESELLER;
import static br.com.revendedora.util.ApiConfig.Path.ROOT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping(value = ROOT + RESELLER, produces = APPLICATION_JSON_VALUE)
public class ContactController {

    private ContactRepository repository;


    ContactController(ContactRepository contactRepository) {
        this.repository = contactRepository;
    }

    @ApiOperation(value = "Busca por id do contato",
            produces = APPLICATION_JSON_VALUE)
    @ApiResponses(value = { @ApiResponse(code = 200,message = "Ok"),
                            @ApiResponse(code = 400,message = "Bad Request")
                          })
    @GetMapping (CONTACT)
    public ResponseEntity<?> findById(@PathVariable Long id){
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }


}
