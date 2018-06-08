package cbse.ue3.products.data;



public class PrintProduct extends Product {

	private PrintType type;

	public PrintProduct(String name, double price, PrintType type) {
		super(name, price);
		this.type = type;
	}

	public PrintType getType() {
		return type;
	}

	public void setType(PrintType type) {
		this.type = type;
	}	
}
