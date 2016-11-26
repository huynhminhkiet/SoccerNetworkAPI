package com.soccernetworkapi.dao.impl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public abstract class BaseDaoImpl {
	protected JdbcTemplate jdbcTemplate;
	public BaseDaoImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
}
