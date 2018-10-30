package Q4;

import Q4.Customer;
import Q4.CustomerDAO;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class UserServicePlatformTransaction {

    private PlatformTransactionManager platformTransactionManager;

    public UserServicePlatformTransaction(PlatformTransactionManager platformTransactionManager) {
        this.platformTransactionManager = platformTransactionManager;
    }


    public void doInTransaction(CustomerDAO customerDAO, Customer customer) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = platformTransactionManager.getTransaction(def);
        try {
            customerDAO.create(customer);
            platformTransactionManager.commit(status);
        } catch (Exception ex) {
            platformTransactionManager.rollback(status);
        }
    }
}
