package activation;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import customer.service.CustomerService;
import serviceimpl.MyCustomerServiceImpl;

public class Activator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		context.registerService(CustomerService.class, new MyCustomerServiceImpl(), null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
