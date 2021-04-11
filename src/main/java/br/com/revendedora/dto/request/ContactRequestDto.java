package br.com.revendedora.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactRequestDto {

    @ApiModelProperty(value = "Nome do contato ", required = true, position = 1)
    private String name;

    @ApiModelProperty(value = "Email do contato ", required = true, position = 2)
    private String email;

    @ApiModelProperty(value = "Telefone do contato ", required = true, position = 3)
    private String phone;

}
