package com.App_Service_Back.cliente;

import com.App_Service_Back.agendamento.AgendamentoDTO;
import com.App_Service_Back.endereco.Endereco;
import com.App_Service_Back.telefone.TelefoneDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long cliente_id;

    @NotBlank(message = "O campo NOME é requerido")
    private String cliente_nome;

    @CPF
    @NotBlank(message = "O campo CPF é requerido")
    private String cliente_cpf;

    @NotBlank(message = "O campo EMAIL é requerido")
    private String cliente_email;

    private String cliente_senha;

    @NotNull(message = "O campo DATA DE NASCIMENTO é requerido")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate cliente_dataNascimento;

    private Endereco endereco;

    private List<TelefoneDTO> telefones;

    private List<AgendamentoDTO> agendamentos;
}