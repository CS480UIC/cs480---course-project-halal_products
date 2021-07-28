package product.domain;

public class Product {
	
	private int id;
	private String name;
	private int category_id;
	private int manufacturer_id;
	private int halal_status_id;
	private String certifications;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getCategory_id() {
		return category_id;
	}
	
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	
	public int getManufacturer_id() {
		return manufacturer_id;
	}
	
	public void setManufacturer_id(int manufacturer_id) {
		this.manufacturer_id = manufacturer_id;
	}
	
	public int getHalal_status_id() {
		return halal_status_id;
	}
	
	public void setHalal_status_id(int halal_status_id) {
		this.halal_status_id = halal_status_id;
	}
	
	public String getCertifications() {
		return certifications;
	}
	
	public void setCertifications(String certifications) {
		this.certifications = certifications;
	}

}
