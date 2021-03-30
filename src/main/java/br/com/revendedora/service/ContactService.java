package br.com.revendedora.service;

import br.com.revendedora.repository.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ContactService implements Contact {

    private final ContactRepository repository;


    @Override
    public ContactRepository findAll() {
        repository.findAll();
        return repository;
    }
}
