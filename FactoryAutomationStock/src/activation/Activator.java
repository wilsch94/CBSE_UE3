package activation;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import customer.service.StockService;
import serviceimpl.StockServiceImpl;

public class Activator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		context.registerService(CustomerService.class, new StockServiceImpl(), null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
