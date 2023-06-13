package com.bankapp.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoJdbcImpl implements AccountDao {

	private DataSource dataSource;

	@Autowired
	public AccountDaoJdbcImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Account> getAll() {
		List<Account> accounts = new ArrayList<Account>();

		Connection connection = null;
		try {
			connection = dataSource.getConnection();

			PreparedStatement pstmt = connection.prepareStatement("select * from account");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Account account = new Account(rs.getInt(1), rs.getString(2), rs.getDouble(3));
				accounts.add(account);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return accounts;
	}

	@Override
	public Account getById(int id) {
		return null;
	}

	@Override
	public void updateAccount(Account account) {

	}

	@Override
	public void addAccount(Account account) {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();

			PreparedStatement pstmt = connection
					.prepareStatement("insert into account(id, name, balance) values(?,?,?)");
			pstmt.setInt(1, account.getId());
			pstmt.setString(2, account.getName());
			pstmt.setDouble(3, account.getBalance());
			
			pstmt.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void deleteAccount(int id) {

	}

}
