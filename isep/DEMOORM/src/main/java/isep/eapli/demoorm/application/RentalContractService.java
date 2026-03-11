package isep.eapli.demoorm.application;

import isep.eapli.demoorm.domain.*;
import isep.eapli.demoorm.persistence.RentalContractRepository;
import isep.eapli.demoorm.persistence.RentalContractRepositoryJPAImpl;
import java.util.List;
import java.util.Optional;

public class RentalContractService {

    private final RentalContractRepository repository = new RentalContractRepositoryJPAImpl();

    public RentalContract registerRentalContract(String startDate, String endDate,
                                                  Car car, Client client,
                                                  List<AuthorizedDriver> drivers,
                                                  Payment payment) {
        RentalContract contract = new RentalContract(startDate, endDate, car, client);
        for (AuthorizedDriver driver : drivers) {
            contract.addAuthorizedDriver(driver);
        }
        if (payment != null) {
            contract.setPayment(payment);
        }
        return repository.save(contract);
    }

    public List<RentalContract> listAllContracts() {
        return repository.findAll();
    }

    public Optional<RentalContract> findContractById(Long id) {
        return repository.findById(id);
    }
}
