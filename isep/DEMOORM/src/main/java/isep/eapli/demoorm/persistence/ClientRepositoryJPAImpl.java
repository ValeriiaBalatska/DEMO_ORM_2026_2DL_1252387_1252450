package isep.eapli.demoorm.persistence;

import isep.eapli.demoorm.domain.Client;

public class ClientRepositoryJPAImpl extends JpaRepository<Client, Long> implements ClientRepository {

    @Override
    protected Class<Client> entityClass() {
        return Client.class;
    }
}
