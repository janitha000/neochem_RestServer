package org.janitha.neochem.database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.janitha.neochem.entities.ItemEntity;
import org.janitha.neochem.model.Item;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DatabaseClass {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/neochem";

	static final String USER = "root";
	static final String PASS = "neochem";
	
	public DatabaseClass(){
		try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }
	}

	public List<Item> getAll() {
		List<Item> results = new ArrayList<>();
		try (Connection conn = (Connection) DriverManager.getConnection(DB_URL,
				USER, PASS);
				Statement stmt = (Statement) conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM items");) {

			while (rs.next()) {
				// Retrieve by column name
//				System.out.println(rs.getInt("ID"));
//				System.out.println(rs.getString("FormerCode"));
//				System.out.println(rs.getString("NewCode"));
				results.add(new Item(rs.getInt("ID"), 
						             rs.getString("ManeCode"), 
						             rs.getString("ManeName"),
						             rs.getString("Type"),
						             rs.getString("FlavourFormat"),
						             rs.getString("FlavourType"),
						             rs.getInt("Year"),
						             rs.getString("Country"),
						             rs.getString("NeoChemName"),
						             rs.getString("NeoChemCode")
						             
						));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return results;

	}

	public Item getItem(long id) {
		Item result = new Item();
		try (Connection conn = (Connection) DriverManager.getConnection(DB_URL,
				USER, PASS);
				Statement stmt = (Statement) conn.createStatement();
				ResultSet rs = stmt
						.executeQuery("SELECT * FROM items WHERE ID = " + id);) {

			while (rs.next()) {
				result.setId(rs.getInt("ID"));
				result.setManeCode(rs.getString("ManeCode"));
				result.setManeName(rs.getString("ManeName"));
				result.setType(rs.getString("Type"));
				result.setFlavorFormat(rs.getString("FlavourFormat"));
				result.setFlavorType(rs.getString("FlavourType"));
				result.setYear(rs.getInt("Year"));
				result.setCountry(rs.getString("Country"));
				result.setNeoChemName(rs.getString("NeoChemName"));
				result.setNeoChemCode(rs.getString("NeoChemCode"));
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		

		return result;

	}

	public String addItem(Item item) {
		String mCode = item.getManeCode();
		String mName = item.getManeName();
		String type = item.getType();
		String fFormat = item.getFlavorFormat();
		String fType = item.getFlavorType();
		int year = item.getYear();
		String country = item.getCountry();
		String neoName = item.getNeoChemName();
		String neoCode = item.getNeoChemCode();
		
		String sql = "INSERT INTO items (ManeCode, ManeName, Type, FlavourFormat, FlavourType,Year,Country, NeoChemName, NeoChemCode) VALUES ('"
				+ mCode + "', '" + mName + "', '" + type +"', '" + fFormat +"', '" + fType +"', '" + year +"', '" + country +"', '" + neoName +"', '" + neoCode +"')";
		try (Connection conn = (Connection) DriverManager.getConnection(DB_URL,
				USER, PASS);
				Statement stmt = (Statement) conn.createStatement();
				) {
			boolean rs = stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.toString();
		}
		return "SUCESS";

	}
	
	/*public void updateItem(Item item) {
		String formerCode = item.getFormerCode();
		String newCode = item.getNewCode();
		long ID = item.getId();
		String sql = "UPDATE items SET FormerCode = '" +formerCode + "' , NewCode ='" + newCode +"' WHERE ID = " + ID;
		try (Connection conn = (Connection) DriverManager.getConnection(DB_URL,
				USER, PASS);
				Statement stmt = (Statement) conn.createStatement();
				) {
			boolean rs = stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} */

	public void deleteItem(long id) {
;
		String sql = "DELETE FROM items  WHERE ID = " + id;
		try (Connection conn = (Connection) DriverManager.getConnection(DB_URL,
				USER, PASS);
				Statement stmt = (Statement) conn.createStatement();
				) {
			boolean rs = stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getCode(char C){
		String sql = "";
		String result = "";
		//ResultSet rs;
		switch(C){
		
		case 'R':
			 sql = "SELECT `NeoChemCode` FROM `items` WHERE `NeoChemCode`LIKE 'R%' ORDER BY `ID` DESC LIMIT 1";
			break;
			
		case 'L':
			 sql ="SELECT `NeoChemCode` FROM `items` WHERE `NeoChemCode`LIKE 'V%' ORDER BY `ID` DESC LIMIT 1";
			break;
		}
		
		try (Connection conn = (Connection) DriverManager.getConnection(DB_URL,
				USER, PASS);
				Statement stmt = (Statement) conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				) {
			 //rs = stmt.executeQuery(sql);
			rs.next();
			 result = rs.getString("NeoChemCode");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
		
	}
}
