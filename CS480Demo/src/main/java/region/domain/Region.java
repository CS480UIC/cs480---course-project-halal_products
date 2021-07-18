package region.domain;

public class Region 
{
	/*
	 * Correspond to the user table
	 */
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Region = " + name;
	}
	

}
