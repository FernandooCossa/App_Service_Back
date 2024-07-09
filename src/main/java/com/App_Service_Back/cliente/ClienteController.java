package com.App_Service_Back.cliente;

import com.App_Service_Back.telefone.TelefoneDTO;
import com.App_Service_Back.telefone.TelefoneService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController //habilitar o REST
@RequestMapping("/cliente") // localhost:8080/cliente
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private TelefoneService telefoneService;

    @Autowired
    private ClienteMapper clienteMapper;

    @GetMapping //retorna uma lista de clientes
    public ResponseEntity<List<ClienteDTO>> getAllClientes(){
        List<ClienteDTO> clienteDTO = clienteService.findAll();
        return ResponseEntity.ok(clienteDTO);
    }
    @GetMapping("/{id}") //localhost:8080/clientes/1 pegar por id
    public ResponseEntity<ClienteDTO> getClienteById(@PathVariable Long id){
        ClienteDTO clienteDTO = clienteService.findById(id);
        return ResponseEntity.ok(clienteDTO);
    }
    @PostMapping //salvar um cliente no banco de dados
    public ResponseEntity<ClienteDTO> createCliente(@RequestBody ClienteDTO clienteDTO){
        ClienteDTO createClienteDTO = clienteService.create(clienteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createClienteDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> updateCliente(@PathVariable Long id, @Valid @RequestBody ClienteDTO clienteDTO){
        ClienteDTO updateClienteDTO = clienteService.update(id, clienteDTO);
        return ResponseEntity.ok(updateClienteDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id){
        clienteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}