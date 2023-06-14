package com.bankapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
@Repository
@Primary
public class AccountDaoJdbcTemplateImpl implements AccountDao{
	
	private JdbcTemplate jdbcTemplate;
	
	RowMapper<Account> rowMapper=( rs,  rowNum) ->
	  new Account(rs.getInt(1), rs.getString(2), rs.getDouble(3));

	  
	@Autowired
	public AccountDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Account> getAll() {
		//i need to pass a call back
		return jdbcTemplate.query("select * from accounts", rowMapper);
	}

	@Override
	public Account getById(int id) {
		return jdbcTemplate.queryForObject
				("select * from accounts where id=?", new AccountRowMapper(), id);
	}

	@Override
	public void updateAccount(Account account) {
			jdbcTemplate.update("update accounts set balance=? where id=?", 
					new Object[] {account.getBalance(), account.getId()});
	}

	@Override
	public void addAccount(Account account) {
		jdbcTemplate.update("insert into accounts(id, name, balance) values(?,?,?)",
				new Object[] {account.getId(), account.getName(),account.getBalance()});
	}

	@Override
	public void deleteAccount(int id) {
		jdbcTemplate.update("delete from accounts where id=?", id);
	}


}
