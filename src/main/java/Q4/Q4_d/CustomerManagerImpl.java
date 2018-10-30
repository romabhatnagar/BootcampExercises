package Q4.Q4_d;

import Q4.Customer;
import Q4.CustomerDAO;
import Q4.Q4_d.CustomerManager;
import org.springframework.transaction.annotation.Transactional;

public class CustomerManagerImpl implements CustomerManager {

    private CustomerDAO customerDAO;

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    @Transactional
    public void createCustomer(Customer cust) {
        customerDAO.create(cust);
    }

}
