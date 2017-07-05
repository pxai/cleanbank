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
	
	public Account find (Integer customerId) {
		Account account = null;
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement statement = conn
					.prepareStatement("SELECT * FROM account where customerid=?");
			statement.setInt(1, customerId);
			ResultSet resultSet = statement.executeQuery();
	
				if (resultSet.next()) {
					account = new Account(resultSet.getString("account_no"), resultSet.getFloat("balance"));
				} 
				dataSource.close();
		} catch (Exception e) {
			System.out.println("Error en consulta " + e.getMessage());
		} finally {
			return account;
		}
	}
	
	public int update (Account account) {
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement statement = conn
					.prepareStatement("update account set balance=? where account_no=?");
			statement.setFloat(1, account.getBalance());
			statement.setString(2, account.getAccountNo());
			return statement.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en consulta " + e.getMessage());
		} 
			return 0;
	}

	@Inject
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
