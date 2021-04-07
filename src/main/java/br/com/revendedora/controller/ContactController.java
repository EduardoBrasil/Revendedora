package br.com.revendedora.controller;

import br.com.revendedora.dto.request.ContactRequestDto;
import br.com.revendedora.dto.response.ContactResponseDto;
import br.com.revendedora.service.ContactService;
import br.com.revendedora.validation.ValidationSequenceCreate;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static br.com.revendedora.util.ApiConfig.Path.Contact.CONTACT;
import static br.com.revendedora.util.ApiConfig.Path.RESELLER;
import static br.com.revendedora.util.ApiConfig.Path.ROOT;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin
@RestController
@RequestMapping(value = ROOT + RESELLER, produces = APPLICATION_JSON_VALUE)
public class ContactController {


    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService){
        this.contactService = contactService;
    }

    @ApiOperation(value = "Create new contact", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(@ApiResponse(code = 201, message = "create new contact is successful", response = ContactResponseDto.class))
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContactResponseDto saveContact(@Validated(ValidationSequenceCreate.class)@RequestBody ContactRequestDto contactRequestDto) {
        return contactService.saveContact(contactRequestDto);
    }

    @ApiOperation(value = "Find contact by id",produces = APPLICATION_JSON_VALUE)
    @ApiResponses(value = { @ApiResponse(code = 200,message = "Ok"),
                            @ApiResponse(code = 400,message = "Bad Request")
                          })
    @GetMapping (CONTACT)
    @ResponseStatus(HttpStatus.OK)
    public ContactResponseDto getContactById(@PathVariable Integer id){
        return contactService.getContactById(id);
    }


}
