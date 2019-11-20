package daolayerimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import daolayer.CountryDao;
import pojos.Country;

public class CountryDaoImpl implements CountryDao {

	Connection con;
	Statement stmt;
	ResultSet rs;
	PreparedStatement pStmt;
	public CountryDaoImpl() {
		super();
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "jaat");
			stmt = con.createStatement();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public List<Country> getAllCountries() 
	{
		List<Country> countries = new ArrayList<>();
		try {
			rs=stmt.executeQuery("select * from country");
			while(rs.next()){
				Country country = new Country();
				country.setCode(rs.getString(1));
				country.setName(rs.getString(2));
				country.setContinent(rs.getString(3));
				countries.add(country);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return countries;
	}

	@Override
	public void removeCountry(String code) 
	{
		String query = "delete from country where Code = ?";
		try {
			pStmt = con.prepareStatement(query);
			pStmt.setString(1, code);
			int result = pStmt.executeUpdate();
			if(result==1)
				System.out.println("Record Deleted..!");
			else
				System.out.println("Record Not found...!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public int updateCountry(String name, String continent, String code) {
         String query="update country set Name=?, Continent=? where Code= ?";
         try {
 			pStmt = con.prepareStatement(query);
 			pStmt.setString(1, name);
 			pStmt.setString(2, continent);
 			pStmt.setString(3, code);
 			int result = pStmt.executeUpdate();
 			if(result>0)
 				System.out.println("Number of rows updated=" + result);
 			else
 				System.out.println("No rows updated");
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
		return 0;
	}

	@Override
	public void insertCountry(String code, String name, String continent) 
	{
		String query="insert into country(Code, Name, Continent) values(?,?,?)";
		try {
 			pStmt = con.prepareStatement(query);
 			pStmt.setString(1, code);
 			pStmt.setString(2, name);
 			pStmt.setString(3, continent);
 			int result = pStmt.executeUpdate();
 			if(result>0)
 				System.out.println("Number of rows inserted=" + result);
 			else
 				System.out.println("No rows inserted");
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
		
	}

}
