package io.pello.cleanbank.external.entityrepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

	private String dbUrl;
	private String login;
	private String password;
	private String driver;
	private Connection connection;

	public DataSource() {
		this.dbUrl = "jdbc:sqlite:dirtybank.db";
		this.login = "";
		this.password = "";
		this.driver = "org.sqlite.JDBC";
		openDataSource();
	}

	public DataSource(String dbUrl, String login, String password, String driver) {
		this.dbUrl = dbUrl;
		this.login = login;
		this.password = password;
		this.driver = driver;
		openDataSource();
	}

	private void openDataSource() {
		try {
			Class.forName(this.driver);
			connection = DriverManager.getConnection(this.dbUrl, this.login, this.password);
		} catch (SQLException sqle) {
			System.err.println("Connection error: " + sqle.getMessage());
		} catch (Exception e) {
			System.err.println("Connection error: " + e.getMessage());
		}
	}


	public Connection getConnection() {
		return connection;
	}


	public void close() {
		try {
			connection.close();
		} catch (SQLException sqle) {
			System.err.println("Connection error: " + sqle.getMessage());
		} catch (Exception e) {
			System.err.println("Connection error: " + e.getMessage());
		}
	}

}