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
public class StockServiceImpl implements StockService {
	
	private static AtomicInteger current = new AtomicInteger(1);
	private List<Product> products;
	
	public StockServiceImpl() {
		products = createInitialModel();
	}

	

	@Override
	public synchronized boolean saveProduct(Product newCustomer) {
		Optional<Product> ProductOptional = findById(newProduct.getId());

        // get the actual todo or create a new one
        Product product = productOptional.orElse(new product(current.getAndIncrement()));
        product.setProductId(newProduct.getProductId());
        product.setName(newProduct.getName());
        product.setPriceInEuro(newProduct.getPriceInEuro());
      

        if (!productOptional.isPresent()) {
        	products.add(product);
        }
        return true;
	}

	@Override
	public Optional<Product> getProduct(String name, double price) {
		return findByName(name).map(product -> product.copy());
	}

	@Override
	public boolean deleteProduct(String name, double price) {
		Optional<Product> deleteProduct = findByName(name);

        deleteProduct.ifPresent(product -> {
            products.remove(product);
        });

        return deleteProduct.isPresent();
	}
	
	private List<Product> createInitialModel() {
        List<Product> list = new ArrayList<>();
        list.add(createProduct("Eifelturm", "20.00"));
        list.add(createProduct("Roboter", "25.00"));
        list.add(createProduct("Auto", "20.00"));
        list.add(createProduct("Freiheitsstatue",));
        list.add(createProduct("Fussball", "15.00"));
               return list;
    }
	
	private Product createProduct(String name, double price) {
        return new Product(current.getAndIncrement(), name, price);
    }
	
	private Optional<Product> findByName(long id) {
        return getProductInternal().stream().filter(t -> t.getProductName() == Name).findAny();
    }

	@Override
	public List<Product> getProducts() {
		return this.products;
		
	}

}
