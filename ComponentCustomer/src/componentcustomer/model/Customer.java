package componentcustomer.model;


public class Customer {
	
	private final long id;
	private String name;
	private String city;
	private String zipCode;
	private String street;
	private boolean approved;
	
	public Customer(long id, String name, String city, String zipCode, String street, boolean approved) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.zipCode = zipCode;
		this.street = street;
		this.approved = approved;
	}

	public Customer(long id) {
		super();
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	public Customer copy() {
		return new Customer(this.id, this.name, this.city, this.zipCode, this.street, this.approved);
	}
	
}
