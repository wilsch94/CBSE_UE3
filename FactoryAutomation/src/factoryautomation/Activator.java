package factoryautomation;

import java.util.ArrayList;
import java.util.List;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import customer.data.Customer;
import customer.service.CustomerService;
import order.data.Order;
import order.service.OrderService;
import stock.data.Stock;
import stock.service.StockService;

public class Activator implements BundleActivator {

	private CustomerService cust;
	private StockService sto;
	private OrderService ord;
	
	@Override
	public void start(BundleContext context) throws Exception {
		ServiceReference<CustomerService> custs= context.getServiceReference(CustomerService.class);
		if (custs!=null)
			cust = context.getService(custs);
		else
			System.out.println("Could not find CustorderService");
		ServiceReference<StockService> stos= context.getServiceReference(StockService.class);
		if (stos!=null)
			sto = context.getService(stos);
		else
			System.out.println("Could not find StockService");
		ServiceReference<OrderService> ords= context.getServiceReference(OrderService.class);
		if (ords!=null)
			ord = context.getService(ords);
		else
			System.out.println("Could not find OrderService");
		
		// add test code here (example for tutor)
		Customer c = cust.addCustorder("John", "Doe", new Address("S", "1", "12345", "Doetown", "Germany"));
		c.setApproved(true);
		if(c.isApproved())
			System.out.println("Custorder "+c+" has been approved!");
		PrintProduct pp = sto.getPrintProducts().get(0);
		List<FinishingProduct> products = sto.getFinishingProducts();
		List<String> finishingProductIds = new ArrayList<String>();
		
		for(FinishingProduct p : products)
			finishingProductIds.add(p.getProductId());
		
		Order o = ord.placeOrder(c.getCustorderId(), pp.getProductId(), finishingProductIds, "TU Logo");
		System.out.println("order placed");
		System.out.println("-----");
		System.out.println("Custorder: " + c);
		System.out.println("Product:" + o.getPrint());
		System.out.println("Finishings:");
		for(Product p : o.getFinishing())
			System.out.println("- " + p);
		System.out.println("Price:"+ord.calculatePriceInEuro(o));
		System.out.println("-----");
		System.out.println("Disapprove "+c);
		c.setApproved(false);
		try {
			o = ord.placeOrder(c.getCustorderId(), pp.getProductId(), finishingProductIds, "FOG Frog");
		}catch (Exception e) {
			System.out.println("["+e.getClass().getName()+"]:"+e.getMessage());
		}
		
		System.out.println();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub

	}

}

