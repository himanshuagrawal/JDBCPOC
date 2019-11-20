package testmain;

import java.util.List;

import daolayer.CountryDao;
import daolayerimpl.CountryDaoImpl;
import pojos.Country;

public class Test
{
	    public static void main(String[] args){
	    	CountryDao country = new CountryDaoImpl();    	
	    	country.insertCountry("ABC","XYZ","Asia");
	    	List<Country> countriesNameChangedBcozOfDumbnessOfJaat = country.getAllCountries();
	    	for(Country c:countriesNameChangedBcozOfDumbnessOfJaat){
	    		System.out.println(c.toString());
	    	}
	}
}


