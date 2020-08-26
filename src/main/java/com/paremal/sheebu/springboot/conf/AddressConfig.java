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

//@Configuration
//@EnableJpaRepositories(
//		basePackages = "com.paremal.sheebu.springboot.repository.h2",
//		entityManagerFactoryRef = "addressEntityManager", 
//		transactionManagerRef = "addressEntityManager"
//	)
public class AddressConfig {

	
//
//	@Bean
//	@Primary
//	public LocalContainerEntityManagerFactoryBean addressEntityManager() {
//
//		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
//		em.setDataSource(getDataSource());
//		em.setPackagesToScan(new String[] { "com.paremal.sheebu.springboot.entity.h2" });
//
//		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
//		em.setJpaVendorAdapter(jpaVendorAdapter);
//
//		Map<String, Object> props = new HashMap<String, Object>();
//		props.put("hibernate.hbm2ddl.auto", "create");
//		props.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
//
//		em.setJpaPropertyMap(props);
//
//		return em;
//	}
//
//	@Bean
//	@Primary
//	public DataSource getDataSource() {
//
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("org.h2.Driver");
//		dataSource.setUrl("jdbc:h2:mem:testdb");
//		dataSource.setUsername("sa");
//		dataSource.setPassword("password");
//
//		return dataSource;
//
//	}
//	@Primary
//    @Bean
//    public PlatformTransactionManager addressTransactionManager() {
// 
//		JpaTransactionManager transactionManager
//          = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(
//        		addressEntityManager().getObject());
//        return transactionManager;
//    }
//	

}
