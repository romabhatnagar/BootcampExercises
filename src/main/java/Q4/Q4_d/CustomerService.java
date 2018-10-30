package Q4.Q4_d;

import Q4.Customer;
import Q4.CustomerDAO;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class CustomerService {
    private TransactionTemplate transactionTemplate;

    public CustomerService(PlatformTransactionManager platformTransactionManager) {
        this.transactionTemplate = new TransactionTemplate(platformTransactionManager);
        transactionTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_READ_UNCOMMITTED);
    }

    public Customer inTransactionWithReturn(CustomerDAO customerDAO, Customer customer) {
        return transactionTemplate.execute(new TransactionCallback<Customer>() {
            @Override
            public Customer doInTransaction(TransactionStatus status) {
                customerDAO.create(customer);
                return null;
            }
        });
    }

    public void inTransactionWithoutReturn(CustomerDAO customerDAO, Customer customer) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                customerDAO.create(customer);
            }
        });
    }
}
