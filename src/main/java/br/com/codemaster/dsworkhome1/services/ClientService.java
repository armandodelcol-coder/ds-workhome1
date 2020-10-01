package br.com.codemaster.dsworkhome1.services;

import br.com.codemaster.dsworkhome1.dto.ClientDTO;
import br.com.codemaster.dsworkhome1.entities.Client;
import br.com.codemaster.dsworkhome1.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
