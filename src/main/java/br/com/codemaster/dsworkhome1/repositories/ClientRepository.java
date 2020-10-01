package br.com.codemaster.dsworkhome1.repositories;

import br.com.codemaster.dsworkhome1.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
