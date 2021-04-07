package br.com.revendedora.mapper;

import br.com.revendedora.dto.request.ContactRequestDto;
import br.com.revendedora.dto.response.ContactResponseDto;
import br.com.revendedora.model.Contact;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    ContactResponseDto toResponseDto(Contact contact);
    List<ContactResponseDto> toResponseDtoList(List<Contact> contacts);
    Contact toEntity(ContactRequestDto contactRequestDto);
}
