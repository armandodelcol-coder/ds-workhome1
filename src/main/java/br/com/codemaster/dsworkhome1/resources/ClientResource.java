package br.com.codemaster.dsworkhome1.resources;

import br.com.codemaster.dsworkhome1.entities.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientResource {
    @GetMapping
    public ResponseEntity<List<Client>> findAll() {
        Client client1 = new Client(1l, "Armando", "123654778954", 3500.00, Instant.now(), 0);
        List<Client> list = new ArrayList<>();
        list.add(client1);

        return ResponseEntity.ok().body(list);
    }
}
