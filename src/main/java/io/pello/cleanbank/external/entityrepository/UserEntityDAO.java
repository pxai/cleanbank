package io.pello.cleanbank.external.entityrepository;

import io.pello.cleanbank.entity.gateway.UserEntityGateway;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.inject.Inject;

import io.pello.cleanbank.entity.Account;
import io.pello.cleanbank.entity.User;


public class UserEntityDAO implements UserEntityGateway {
	private DataSource dataSource;
	
	public boolean checkUser(String userName, String password) {
		Connection conn = null;
		boolean userExists = false;
		try {
			conn = dataSource.getConnection();
			PreparedStatement statement = conn
					.prepareStatement("select * from customer where login=? and password=?");
			statement.setString(1, userName);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();
			userExists = resultSet.next();
			resultSet.close();
			dataSource.close();
		} catch (Exception e) {
			System.out.println("Error en consulta " + e.getMessage());
		} 
			return userExists;
	}

	public User find(String userName) {
		Connection conn = null;
		User user = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement statement = conn
					.prepareStatement("select customer.*, account.* from customer inner join account on customer.id=account.customerid where customer.login=?");
			statement.setString(1, userName);
			ResultSet resultSet = statement.executeQuery();
	
				if (resultSet.next()) {
					user = new User(userName,"",
									resultSet.getString("name"),
										new Account(resultSet.getString("account_no"), 
												resultSet.getFloat("balance")));
				} 
				resultSet.close();
				dataSource.close();
		} catch (Exception e) {
			System.out.println("Error en consulta " + e.getMessage());
		} finally {
			return user;
		}
	}
	
	@Inject
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
