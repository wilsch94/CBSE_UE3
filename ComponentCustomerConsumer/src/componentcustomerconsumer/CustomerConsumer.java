package componentcustomerconsumer;

import componentcustomer.model.CustomerService;


public class CustomerConsumer {
	
	private CustomerService service;
	
	public void customer() {
		System.out.println(service.getCustomers());
	}
	
	public synchronized void setCustomer(CustomerService service) {
		this.service = service;
	}

	public synchronized void deleteCustomer(CustomerService service) {
		if (this.service == service)
			this.service = null;
	}
}
