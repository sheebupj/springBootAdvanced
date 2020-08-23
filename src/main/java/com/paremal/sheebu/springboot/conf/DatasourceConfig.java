package com.paremal.sheebu.springboot.conf;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

public class DatasourceConfig {
	@Bean
    public DataSource datasource() {
        return DataSourceBuilder.create()
          .driverClassName("oracle.jdbc.driver.OracleDrive")
          .url("jdbc:oracle:thin:@localhost:1521:orcl")
          .username("system")
          .password("password")
          .build();	
    }


}
