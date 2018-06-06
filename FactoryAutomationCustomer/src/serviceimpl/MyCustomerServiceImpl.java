package serviceimpl;

import org.osgi.service.component.annotations.Component;

import customer.data.*;
import customer.service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Component
public class MyCustomerServiceImpl implements CustomerService {
	
	private static AtomicInteger current = new AtomicInteger(1);
	private List<Customer> customers;
	
	public MyCustomerServiceImpl() {
		customers = createInitialModel();
	}

	public List<Customer> getCustomersInternal() {
		return customers;
	}
	
	/*@Override
	public void getCustomers(Consumer<List<Customer>> CustomerConsumer) {
		CustomerConsumer.accept(customers.stream().map(t -> t.copy()).collect(Collectors.toList()));
	}*/
	
	

	@Override
	public synchronized boolean saveCustomer(Customer newCustomer) {
		Optional<Customer> customerOptional = findById(newCustomer.getId());

        // get the actual todo or create a new one
        Customer customer = customerOptional.orElse(new Customer(current.getAndIncrement()));
        customer.setCity(newCustomer.getCity());
        customer.setName(newCustomer.getName());
        customer.setStreet(newCustomer.getStreet());
        customer.setZipCode(newCustomer.getZipCode());
        customer.setApproved(newCustomer.isApproved());

        if (!customerOptional.isPresent()) {
        	customers.add(customer);
        }
        return true;
	}

	@Override
	public Optional<Customer> getCustomer(long id) {
		return findById(id).map(customer -> customer.copy());
	}

	@Override
	public boolean deleteCustomer(long id) {
		Optional<Customer> deleteCustomer = findById(id);

        deleteCustomer.ifPresent(customer -> {
            customers.remove(customer);
        });

        return deleteCustomer.isPresent();
	}
	
	private List<Customer> createInitialModel() {
        List<Customer> list = new ArrayList<>();
        list.add(createCustomer("Eric Meier", "Berlin", "10115", "Talstraße", true));
        list.add(createCustomer("Maria Berger", "Dresden", "01217", "Waldallee", true));
        list.add(createCustomer("Lisa Vogel", "Chemnitz", "09123", "An der alten Ziegelei", false));
        list.add(createCustomer("Manfred Fichtner", "München", "80331", "Am Stadion", true));
        list.add(createCustomer("Fritz Baumgärtner", "Köln", "50667", "Südstraße", false));
        list.add(createCustomer("Elisabeth Fischer", "Erfurt", "99084", "Beckerstraße", true));
        list.add(createCustomer("Karl Voigt", "Augsburg", "86150", "An der Vogelweide", false));
        list.add(createCustomer("Martina Sang", "Berlin", "10157", "Weststra0e", true));
        return list;
    }
	
	private Customer createCustomer(String name, String city, String zipCode, String street, boolean approved) {
        return new Customer(current.getAndIncrement(), name, city, zipCode, street, approved);
    }
	
	private Optional<Customer> findById(long id) {
        return getCustomersInternal().stream().filter(t -> t.getId() == id).findAny();
    }

	@Override
	public List<Customer> getCustomers() {
		return this.customers;
		
	}

}
