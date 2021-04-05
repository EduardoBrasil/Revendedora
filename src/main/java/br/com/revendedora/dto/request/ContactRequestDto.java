package br.com.revendedora.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiResponse;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactRequestDto {

    @ApiModelProperty(value = "Nome do contato ", required = true, position = 1)
    private String name;

    @ApiModelProperty(value = "Email do contato ", required = true, position = 2)
    private String email;

    @ApiModelProperty(value = "Telefone do contato ", required = true, position = 3)
    private String phone;

}
