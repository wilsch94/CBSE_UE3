package componentcustomer.model;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public interface CustomerService {
	
	//void getCustomers(Consumer <List<Customer>> CustomerConsumer);
	
	List<Customer> getCustomers();
	
	void addCustomer(Customer customer);
	
	boolean deleteCustomer(long id); 
}
