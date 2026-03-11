package isep.eapli.demoorm.persistence;

import isep.eapli.demoorm.domain.Client;
import java.util.List;
import java.util.Optional;

public interface ClientRepository {
    Client save(Client client);
    Optional<Client> findById(Long id);
    List<Client> findAll();
}
