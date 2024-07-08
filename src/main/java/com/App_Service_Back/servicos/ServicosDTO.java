package com.App_Service_Back.servicos;

import com.App_Service_Back.agendamento.Agendamento;
import com.App_Service_Back.categoria.Categoria;
import com.App_Service_Back.prestador.Prestador;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicosDTO {
    private Long servico_id;

    @NotNull(message = "O campo NOME é requerido")
    private String servico_nome;

    private Double servico_preco;

    @NotNull(message = "O campo DESCRICAO é requerido")
    private String servico_descricao;

    private String servico_informacoesExtras;

    @NotNull(message = "O campo CATEGORIAS é requerido")
    private Categoria categorias;

    @NotNull(message = "O campo PRESTADORES é requerido")
    private Prestador prestadores;

    private List<Agendamento> agendamentos;

    private String servico_classificacao;

    public void setServico_id(Long id) {
    }
}