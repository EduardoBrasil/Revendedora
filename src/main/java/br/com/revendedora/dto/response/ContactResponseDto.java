package br.com.revendedora.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactResponseDto {

    private Integer id;

    @ApiModelProperty(value = "Nome do contato")
    private String name;

    @ApiModelProperty(value = "e-mail do contato")
    private String email;

    @ApiModelProperty(value = "telefone celular do contato")
    private String phone;
}
