package isep.eapli.demoorm.persistence;

import isep.eapli.demoorm.domain.RentalContract;
import java.util.List;
import java.util.Optional;

public interface RentalContractRepository {
    RentalContract save(RentalContract contract);
    Optional<RentalContract> findById(Long id);
    List<RentalContract> findAll();
}
