package com.example.demo.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

//import oracle.jdbc.pool.OracleDataSource;

@Configuration
public class DatabaseConfiguration {

	// Oracle Database
	/*@Bean
    DataSource oraDataSource() throws SQLException {
        OracleDataSource dataSource = new OracleDataSource();
        dataSource.setUser("hl7");
        dataSource.setPassword("hl7");
        dataSource.setURL("jdbc:oracle:thin:@100.43.0.16:1521:xe");
        dataSource.setImplicitCachingEnabled(true);
        dataSource.setFastConnectionFailoverEnabled(true);
        return dataSource;
    }*/
	
	// MySql Database
		@Bean
	    DataSource mySqlDataSource() throws SQLException {
	        MysqlDataSource dataSource = new MysqlDataSource();
	        dataSource.setUser("springdb");
	        dataSource.setPassword("12345");
	        dataSource.setURL("jdbc:mysql://mysql:3306/springdb");
	        return dataSource;
	    }
}
