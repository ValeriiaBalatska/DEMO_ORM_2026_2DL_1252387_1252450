package isep.eapli.demoorm.application;

import isep.eapli.demoorm.domain.Client;
import isep.eapli.demoorm.domain.CorporateClient;
import isep.eapli.demoorm.domain.IndividualClient;
import isep.eapli.demoorm.persistence.ClientRepository;
import isep.eapli.demoorm.persistence.ClientRepositoryJPAImpl;
import java.util.List;
import java.util.Optional;

public class ClientService {

    private final ClientRepository repository = new ClientRepositoryJPAImpl();

    public Client registerCorporateClient(String name, String address, String phone, String email,
                                          String remarks, String companyName, String taxId) {
        CorporateClient client = new CorporateClient(name, address, phone, email, remarks, companyName, taxId);
        return repository.save(client);
    }

    public Client registerIndividualClient(String name, String address, String phone, String email,
                                           String remarks, String citizenId, String dateOfBirth) {
        IndividualClient client = new IndividualClient(name, address, phone, email, remarks, citizenId, dateOfBirth);
        return repository.save(client);
    }

    public List<Client> listAllClients() {
        return repository.findAll();
    }

    public Optional<Client> findClientById(Long id) {
        return repository.findById(id);
    }
}
