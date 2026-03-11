package isep.eapli.demoorm.persistence;

import isep.eapli.demoorm.domain.RentalContract;

public class RentalContractRepositoryJPAImpl extends JpaRepository<RentalContract, Long> implements RentalContractRepository {

    @Override
    protected Class<RentalContract> entityClass() {
        return RentalContract.class;
    }
}
