package com.tkd.net.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tkd.net.model.User;
import com.tkd.net.util.DBManager;

public class UserRepository {

	public User getUser(Long id){	
		User user = new User();
		String query = "SELECT * FROM users WHERE id=" + id;
		try(Statement stmt = DBManager.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(query);){
			while(rs.next()){
				user.setId(rs.getLong("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setCity(rs.getString("city"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public User addUser(User user){	
		String query = "INSERT INTO users(name, email, city) VALUES('"+ user.getName() +"', '"+ user.getEmail()+"', '"+ user.getCity() + "')";
		try(PreparedStatement stmt = DBManager.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);){
			stmt.executeUpdate();
			try(ResultSet rs = stmt.getGeneratedKeys();){
				while(rs.next()){
					user.setId(rs.getLong(1));
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}
