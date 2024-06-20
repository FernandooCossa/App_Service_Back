package com.App_Service_Back.cliente;
import com.App_Service_Back.agendamento.Agendamento;
import com.App_Service_Back.endereco.Endereco;
import com.App_Service_Back.servicos.Servicos;
import com.App_Service_Back.telefone.Telefone;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cliente_id;
    private String cliente_nome;
    @CPF
    @Column(unique = true, nullable = false)
    private String cliente_cpf;
    @Column(unique = true)
    private String cliente_email;
    @Column(nullable = false)
    private String cliente_senha;
    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate cliente_dataNascimento;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_endereco_id")
    private Endereco endereco;
    @OneToMany( fetch = FetchType.EAGER)
    private List<Telefone> telefones;
    @OneToMany( fetch = FetchType.EAGER)
    private List<Agendamento> agendamentos;


    public Cliente() {
    }

    public Cliente(Long cliente_id, String cliente_nome, String cliente_cpf, String cliente_email, String cliente_senha, LocalDate cliente_dataNascimento, Endereco endereco) {
        this.cliente_id = cliente_id;
        this.cliente_nome = cliente_nome;
        this.cliente_cpf = cliente_cpf;
        this.cliente_email = cliente_email;
        this.cliente_senha = cliente_senha;
        this.cliente_dataNascimento = cliente_dataNascimento;
        this.endereco = endereco;
    }

    public Long getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(Long cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getCliente_nome() {
        return cliente_nome;
    }

    public void setCliente_nome(String cliente_nome) {
        this.cliente_nome = cliente_nome;
    }

    public String getCliente_cpf() {
        return cliente_cpf;
    }

    public void setCliente_cpf(String cliente_cpf) {
        this.cliente_cpf = cliente_cpf;
    }

    public String getCliente_email() {
        return cliente_email;
    }

    public void setCliente_email(String cliente_email) {
        this.cliente_email = cliente_email;
    }

    public String getCliente_senha() {
        return cliente_senha;
    }

    public void setCliente_senha(String cliente_senha) {
        this.cliente_senha = cliente_senha;
    }

    public LocalDate getCliente_dataNascimento() {
        return cliente_dataNascimento;
    }

    public void setCliente_dataNascimento(LocalDate cliente_dataNascimento) {
        this.cliente_dataNascimento = cliente_dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cliente_id, cliente.cliente_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cliente_id);
    }

}