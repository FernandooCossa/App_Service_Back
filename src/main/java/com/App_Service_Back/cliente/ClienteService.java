package com.App_Service_Back.cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteMapper clienteMapper;

    //buscando todos os clientes
    public List<ClienteDTO> findAll(){
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream().map(clienteMapper::toDTO).collect(Collectors.toList());
    }
    // buscar pelo id
    public ClienteDTO findById(Long id){
        Cliente cliente = clienteRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Cliente não encontrado"));
        return clienteMapper.toDTO(cliente);
    }
    //criando um novo cliente
    public ClienteDTO create(ClienteDTO clienteDTO){
        Cliente cliente = clienteMapper.toEntity(clienteDTO);
        cliente = clienteRepository.save(cliente);
        return clienteMapper.toDTO(cliente);
    }
    //update cliente
    public ClienteDTO update(Long id, ClienteDTO clienteDTO) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Cliente não encontrado"));
        clienteDTO.setCliente_id(id);
        cliente = clienteMapper.updateEntity(clienteDTO, cliente);
        cliente = clienteRepository.save(cliente);
        return clienteMapper.toDTO(cliente);
    }
    public void deleteById(Long id){
        clienteRepository.deleteById(id);
    }
}