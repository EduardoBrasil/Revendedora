package br.com.revendedora.repository;

import br.com.revendedora.dto.request.ContactRequestDto;
import br.com.revendedora.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long >{
}


