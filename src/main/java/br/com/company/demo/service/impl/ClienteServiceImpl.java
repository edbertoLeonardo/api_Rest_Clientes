package br.com.company.demo.service.impl;

import br.com.company.demo.model.Cliente;
import br.com.company.demo.model.ClienteRepository;
import br.com.company.demo.model.Endereco;
import br.com.company.demo.model.EnderecoRepository;
import br.com.company.demo.service.ClienteService;
import br.com.company.demo.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
      Optional<Cliente> cliente = clienteRepository.findById(id);
      return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
     /*   Endereco endereco = enderecoRepository.findById(Long.valueOf(cep)).orElseGet(() -> {
           Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setEndereco(endereco);*/
        clienteRepository.save(cliente);

    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBD = clienteRepository.findById(id);
        if (clienteBD.isPresent()){

        }
    }

    @Override
    public void deletar(Long cliente) {

    }
}
