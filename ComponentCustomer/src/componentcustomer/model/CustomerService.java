package componentcustomer.model;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public interface CustomerService {
	
	List<Customer> getCustomers();
	
	boolean saveCustomer(Customer customer);

    Optional<Customer> getCustomer(long id);

    boolean deleteCustomer(long id); 
}
