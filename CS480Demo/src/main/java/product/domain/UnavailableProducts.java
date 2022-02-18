package product.domain;

public class UnavailableProducts {
	
	private String product_name;
	private String manufacturer_name;
	private String category_name;
	private String halal_status;
	
	public String getManufacturer_name() {
		return manufacturer_name;
	}
	public void setManufacturer_name(String manufacturer_name) {
		this.manufacturer_name = manufacturer_name;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public String getHalal_status() {
		return halal_status;
	}
	public void setHalal_status(String halal_status) {
		this.halal_status = halal_status;
	}
	
	@Override
	public String toString() {
		return "Unavailabe Products [manufacturer_name=" + manufacturer_name + ", category_name=" + category_name + ", halal_status=" + halal_status + "]";
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

}
