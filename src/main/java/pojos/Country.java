package pojos;

public class Country 
{

	private String Code;
	private String Name;
	private String Continent;
	
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getContinent() {
		return Continent;
	}
	public void setContinent(String continent) {
		Continent = continent;
	}
	@Override
	public String toString() {
		return "Country [Code=" + Code + ", Name=" + Name + ", Continent=" + Continent + "]";
	}
	
	
	

}
