package customer.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import customer.data.Customer;

public interface CustomerService {
	
	List<Customer> getCustomers();
	
	boolean saveCustomer(Customer customer);

    Optional<Customer> getCustomer(long id);

    boolean deleteCustomer(long id); 
}
