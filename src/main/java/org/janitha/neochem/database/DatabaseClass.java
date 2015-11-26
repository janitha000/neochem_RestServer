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
	static final String PASS = "root";
	
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
				System.out.println(rs.getInt("ID"));
				System.out.println(rs.getString("FormerCode"));
				System.out.println(rs.getString("NewCode"));
				results.add(new Item(rs.getInt("ID"), rs
						.getString("FormerCode"), rs.getString("NewCode")));

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
				result.setFormerCode(rs.getString("FormerCode"));
				result.setNewCode(rs.getString("NewCode"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		

		return result;

	}

	public String addItem(Item item) {
		String formerCode = item.getFormerCode();
		String newCode = item.getNewCode();
		String sql = "INSERT INTO items (FormerCode, NewCode) VALUES ('"
				+ formerCode + "', '" + newCode + "')";
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
	
	public void updateItem(Item item) {
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
	}

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
}
