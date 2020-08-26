package com.paremal.sheebu.springboot.conf;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
		basePackages = "com.paremal.sheebu.springboot.repository.oracle",
		entityManagerFactoryRef = "userEntityManager", 
		transactionManagerRef = "userTransactionManager"
	)
public class UserConfig {

	

	@Bean

	public LocalContainerEntityManagerFactoryBean userEntityManager() {

		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(getOracleDataSource());
		em.setPackagesToScan(new String[] { "com.paremal.sheebu.springboot.entity.oracle" });

		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(jpaVendorAdapter);

		Map<String, Object> props = new HashMap<String, Object>();
		props.put("hibernate.hbm2ddl.auto", "update");
		props.put("hibernate.dialect", "org.hibernate.dialect.Oracle12cDialect");

		em.setJpaPropertyMap(props);

		return em;
	}

	@Bean
	
	public DataSource getOracleDataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		dataSource.setUsername("system");
		dataSource.setPassword("password");

		return dataSource;

	}
	
	
    @Bean
    public PlatformTransactionManager userTransactionManager() {
 
		JpaTransactionManager transactionManager
          = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
          userEntityManager().getObject());
        return transactionManager;
    }

}
