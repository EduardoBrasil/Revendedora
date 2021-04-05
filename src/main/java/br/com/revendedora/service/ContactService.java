package br.com.revendedora.service;

import br.com.revendedora.dto.request.ContactRequestDto;
import br.com.revendedora.dto.response.ContactResponseDto;
import br.com.revendedora.model.Contact;

import java.util.List;

public interface ContactService {
    List<ContactResponseDto> getAllContacts();
    //ContactResponseDto getAllContact();
    ContactResponseDto getContactById(Long id);
    ContactResponseDto saveContact(ContactRequestDto contactRequestDto);
    ContactRequestDto updateContactById(Integer Id, ContactRequestDto contactRequestDto);
    void deleteContactById(Integer id);

    Contact getContactEntityById(Integer Id);
    Contact saveContactByEntity(Contact contact);
}
