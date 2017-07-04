package io.pello.cleanbank.external.entityrepository;

import io.pello.cleanbank.entity.gateway.AccountEntityGateway;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.inject.Inject;

import io.pello.cleanbank.entity.Account;


public class AccountEntityDAO implements AccountEntityGateway {
	private DataSource dataSource;
	
	public Account find (String accountId) {
		Account account = null;
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement statement = conn
					.prepareStatement("SELECT * FROM account where accountId=?");
			statement.setString(1, accountId);
			ResultSet resultSet = statement.executeQuery();
	
				if (resultSet.next()) {
					account = new Account(accountId, resultSet.getFloat("balance"));
				} 
		} catch (Exception e) {
			System.out.println("Error en consulta " + e.getMessage());
		} finally {
			return account;
		}
	}
	
	public void update (Account account) {
		
	}

	@Inject
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
