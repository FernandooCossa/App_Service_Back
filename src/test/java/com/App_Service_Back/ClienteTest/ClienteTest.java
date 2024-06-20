package com.App_Service_Back.ClienteTest;

import com.App_Service_Back.cliente.Cliente;
import com.App_Service_Back.cliente.ClienteDTO;
import com.App_Service_Back.cliente.ClienteService;
import com.App_Service_Back.endereco.Endereco;
import com.App_Service_Back.endereco.EnderecoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.time.LocalDate;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class ClienteTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Valida se um CPF inválido está salvando no banco")
    void validaCpf() throws Exception{
        Cliente cliente = new Cliente();
        cliente.setCliente_cpf("111.111.111-11");
        cliente.setCliente_nome("Cliente");
        cliente.setCliente_email("CLiente@senai");
        cliente.setCliente_dataNascimento(LocalDate.now());

        String JsonRequest = objectMapper.writeValueAsString(cliente);

        mockMvc.perform(post("/cliente")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonRequest)).andExpect(status().isBadRequest());
    }

    @Test
    void create() throws Exception{
        Cliente cliente = new Cliente();
        cliente.setCliente_cpf("460.636.220-04");
        cliente.setCliente_nome("");
        cliente.setCliente_email("");
        cliente.setCliente_dataNascimento(LocalDate.now());
        cliente.setCliente_senha("1234");

        String JsonRequest = objectMapper.writeValueAsString(cliente);

        mockMvc.perform(post("/cliente")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonRequest)).andExpect(status().isBadRequest());
    }

    @Test
    void createCorreto() throws Exception{
        Cliente cliente = new Cliente();
        cliente.setCliente_cpf("179.315.890-84");
        cliente.setCliente_nome("Nome");
        cliente.setCliente_email("NOme@Nome");
        cliente.setCliente_dataNascimento(LocalDate.now());
        cliente.setCliente_senha("1234");

        String JsonRequest = objectMapper.writeValueAsString(cliente);

        mockMvc.perform(post("/cliente")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonRequest)).andExpect(status().isCreated());
    }

}
