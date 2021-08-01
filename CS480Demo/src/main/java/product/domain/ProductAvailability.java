package product.domain;

public class ProductAvailability {
	private String store_name;
	private String availability;
	private String product_name;
	private String manufacturer_name;
	private String region_name;

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getManufacturer_name() {
		return manufacturer_name;
	}

	public void setManufacturer_name(String manufacturer_name) {
		this.manufacturer_name = manufacturer_name;
	}

	public String getRegion_name() {
		return region_name;
	}

	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}

	@Override
	public String toString() {
		return "ProductAvailability [store_name=" + store_name + ", availability=" + availability + ", product_name="
				+ product_name + ", manufacturer_name=" + manufacturer_name + ", region_name=" + region_name + "]";
	}
}
