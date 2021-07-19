package store.domain;

public class Store {
	
	private int id;
	private int region_id;
	private String name;
	private String address;
	private int zipcode;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRegion_id() {
		return region_id;
	}
	public void setRegion_id(int region_id) {
		this.region_id = region_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	
	@Override
	public String toString() {
		return "Store [ id =" + id + ", region_id ="
				+ region_id + ", name = " + name + ", "
						+ "address =" + address + ",zipcode =" + zipcode +"]";
		}
}
