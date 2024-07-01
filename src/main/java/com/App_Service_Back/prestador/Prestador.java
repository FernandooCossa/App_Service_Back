package com.App_Service_Back.prestador;

import com.App_Service_Back.endereco.Endereco;
import com.App_Service_Back.servicos.Servicos;
import com.App_Service_Back.telefone.Telefone;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "prestador")
public class Prestador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long prestador_id;
    private  String prestador_nome;
    @Column(unique = true)
    private  String prestador_cnpj;
    @Column(unique = true)
    private  String prestador_cpf;
    private  String prestador_razaoSocial;
    @Column(unique = true)
    private  String prestador_email;
    private String prestador_senha;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Servicos> servicos;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "prestador_endereco_id")
    private Endereco endereco;

    @OneToMany( fetch = FetchType.EAGER)
    private List<Telefone> telefones;

}