package br.com.codemaster.dsworkhome1.services;

import br.com.codemaster.dsworkhome1.dto.ClientDTO;
import br.com.codemaster.dsworkhome1.entities.Client;
import br.com.codemaster.dsworkhome1.repositories.ClientRepository;
import br.com.codemaster.dsworkhome1.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAllPaged(PageRequest pageRequest) {
        Page<Client> list = clientRepository.findAll(pageRequest);
        Page<ClientDTO> listDto = list.map(client -> {
            return new ClientDTO(client);
        });

        return listDto;
    }

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Optional<Client> obj = clientRepository.findById(id);
        Client entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found."));

        return new ClientDTO(entity);
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto) {
        Client entity = new Client();
        copyDtoToEntity(dto, entity);
        entity = clientRepository.save(entity);

        return new ClientDTO(entity);
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO dto) {
        try {
            Client entity = clientRepository.getOne(id);
            copyDtoToEntity(dto, entity);
            entity = clientRepository.save(entity);

            return new ClientDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Entity not found");
        }
    }

    public void delete(Long id) {
        try {
            clientRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Entity Not Found");
        }
    }

    private void copyDtoToEntity(ClientDTO dto, Client entity) {
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());
    }
}
