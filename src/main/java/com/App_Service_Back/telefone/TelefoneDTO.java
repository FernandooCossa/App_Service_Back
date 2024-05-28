package com.App_Service_Back.telefone;

import com.App_Service_Back.cliente.Cliente;
import com.App_Service_Back.prestador.Prestador;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TelefoneDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long telefone_id;

    @NotNull(message = "O campo NUMERO é requerido")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "(XX) XXXXX-XXXX")
    private String telefone_numero;

    @NotNull(message = "O campo CLIENTE é requerido")
    private Cliente cliente;

    @NotNull(message = "O campo PRESTADOR é requerido")
    private Prestador prestador;

}
