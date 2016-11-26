package com.soccernetworkapi.dao;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class MyDataSource {
	private DriverManagerDataSource dataSource;
	
//	private MyDataSource() {
//		dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://127.8.108.2:3306/soccernetworkapi?useUnicode=true&characterEncoding=UTF-8");
//        dataSource.setUsername("admin25mQfES");
//        dataSource.setPassword("HEDZNTr6Muus");
//	}
	
	private MyDataSource() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1/soccer_network?useUnicode=true&characterEncoding=UTF-8");
        dataSource.setUsername("root");
        dataSource.setPassword("kjet");
	}
	
	private static MyDataSource instance;
	
	public static MyDataSource getInstance() {
		if (instance == null) {
			instance = new MyDataSource();
		}
		return instance;
	}
	
	public DriverManagerDataSource getDataSource() {
		return dataSource;
	}
}
