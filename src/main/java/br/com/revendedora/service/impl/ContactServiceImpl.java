package br.com.revendedora.service.impl;

import br.com.revendedora.dto.request.ContactRequestDto;
import br.com.revendedora.dto.response.ContactResponseDto;
import br.com.revendedora.mapper.ContactMapper;
import br.com.revendedora.model.Contact;
import br.com.revendedora.repository.ContactRepository;
import br.com.revendedora.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;


    public ContactServiceImpl(ContactMapper contactMapper, ContactRepository contactRepository) {
        this.contactMapper = contactMapper;
        this.contactRepository = contactRepository;

    }

    @Override
    public List<ContactResponseDto> getAllContacts() {
        return contactMapper.toResponseDtoList(contactRepository.findAll());
    }

    @Override
    public ContactResponseDto getContactById(Long id) {
        return contactRepository.findById(id)
                .map(k -> contactMapper.toResponseDto(k))
                .orElseThrow(()-> new RuntimeException());
    }

    @Override
    public ContactResponseDto saveContact(ContactRequestDto contactRequestDto) {
        return saveAndReturnDTO(contactMapper.toEntity(contactRequestDto));
    }

    @Override
    public ContactRequestDto updateContactById(Integer Id, ContactRequestDto contactRequestDto) {
        return null;
    }

    @Override
    public void deleteContactById(Integer id) {

    }

    private ContactResponseDto saveAndReturnDTO(Contact contact) {
        contact = contactRepository.save(contact);
        return contactMapper.toResponseDto(contact);
    }

    @Override
    public Contact getContactEntityById(Integer Id) {
        return null;
    }

    @Override
    public Contact saveContactByEntity(Contact contact) {
        return contactRepository.save(contact);
    }
}
