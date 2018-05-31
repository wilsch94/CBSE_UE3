package componentcustomerservice;

import java.util.ArrayList;
import java.util.List;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import componentcustomerservice.MyCustomerServiceImpl;
import componentcustomer.model.CustomerService;
import componentcustomer.model.Customer;

public class Activator implements BundleActivator {

	
	private BundleContext context;
    private CustomerService service;
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
        CustomerService service = new MyCustomerServiceImpl();
        context.registerService(CustomerService.class.getName(), service,
                null);
        
        List<Customer> customers = new ArrayList<>();
        customers = service.getCustomers();
        for(Customer customer : customers) {
        	System.out.println(customer.getName());
        }
    }
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
        System.out.println(service.getCustomers());
    }

}
