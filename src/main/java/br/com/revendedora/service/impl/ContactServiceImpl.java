package br.com.revendedora.service.impl;

import br.com.revendedora.dto.request.ContactRequestDto;
import br.com.revendedora.dto.response.ContactResponseDto;
import br.com.revendedora.mapper.ContactMapper;
import br.com.revendedora.model.Contact;
import br.com.revendedora.repository.ContactRepository;
import br.com.revendedora.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository, ContactMapper contactMapper) {
        this.contactRepository = contactRepository;
        this.contactMapper = contactMapper;
    }

    @Override
    public List<ContactResponseDto> getAllContacts() {
        return contactMapper.toResponseDtoList(contactRepository.findAll());
    }

    @Override
    public ContactResponseDto getContactById(Integer id) {
        return contactRepository.findById(id)
                .map(contactMapper::toResponseDto)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public ContactResponseDto saveContact(ContactRequestDto contactRequestDto) {
        return saveAndReturnDTO(contactMapper.toEntity(contactRequestDto));
    }


    private ContactResponseDto saveAndReturnDTO(Contact contactEntity) {
        Contact contact = contactRepository.save(contactEntity);
        return contactMapper.toResponseDto(contact);
    }
}