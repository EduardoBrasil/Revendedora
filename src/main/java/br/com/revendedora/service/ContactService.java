package br.com.revendedora.service;

import br.com.revendedora.dto.request.ContactRequestDto;
import br.com.revendedora.dto.response.ContactResponseDto;

import java.util.List;

public interface ContactService {

    List<ContactResponseDto> getAllContacts();
    ContactResponseDto getContactById(Integer id);
    ContactResponseDto saveContact(ContactRequestDto contactRequestDto);

}
