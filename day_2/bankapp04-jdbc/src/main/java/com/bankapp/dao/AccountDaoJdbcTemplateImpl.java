package com.bankapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository
@Primary
public class AccountDaoJdbcTemplateImpl implements AccountDao{

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public AccountDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Account> getAll() {
		return null;
	}

	@Override
	public Account getById(int id) {
		return null;
	}

	@Override
	public void updateAccount(Account account) {
		jdbcTemplate
		.update("update account set balance =? where id=?", 
				new Object[] {account.getBalance(),account.getId()});
	}

	@Override
	public void addAccount(Account account) {
		jdbcTemplate
		.update("insert into account(id, name, balance) values(?,?,?)", 
				new Object[] {account.getId(), account.getName(), account.getBalance()});
	}

	@Override
	public void deleteAccount(int id) {
		jdbcTemplate
		.update("delete from account where id=?", id);
	}

}
