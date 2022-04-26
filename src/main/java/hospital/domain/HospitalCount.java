package hospital.domain;

/**
 * User object
 * 
 * @author Amulya
 * 
 */
public class HospitalCount {
	
	
	private Integer count;
	private String name;
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "HospitalCount [count=" + count + ", name=" + name + "]";
	}
	
	
	
	
}