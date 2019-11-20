package daolayer;

import java.util.List;

import pojos.Country;

public interface CountryDao 
{
	public List<Country> getAllCountries();
	
    public void removeCountry(String code);
    
    public int updateCountry(String name, String continent, String code);
    
    public void insertCountry(String code, String name, String continent);

}
