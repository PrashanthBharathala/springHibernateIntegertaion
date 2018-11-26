package com.nt.cfg;

import java.util.Properties;

import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.nt.entity.Student;



@Configuration
@EnableWebMvc
@ComponentScan({"com.nt.springintegration","com.nt.dao"})
public class StudentDaoConfigurer {
	@Bean
	public DataSource getDataSource(){
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUsername("system");
		ds.setPassword("udayreddy");
		return ds;
}
	
	
	@Bean
	public LocalSessionFactoryBean getLocalSessionFactory(){
		
		LocalSessionFactoryBean factory=new LocalSessionFactoryBean();
		factory.setAnnotatedClasses(Student.class);
		factory.setAnnotatedPackages("com.nt.entity");
		factory.setDataSource(getDataSource());
		
		Properties p=new Properties();
		p.setProperty("hibernate.format_sql"," true");
		p.setProperty("hibernate.show_sql","true");
		p.setProperty("hibernate.hbm2ddl.auto", "update");
		p.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		
         factory.setHibernateProperties(p);	
         return factory;
		
	}
	@Bean
	public SessionFactory getSessionFactory(){
		return getLocalSessionFactory().getObject();
		
	}
	
	@Bean
	public HibernateTemplate getTemplate(){
		
		HibernateTemplate ht=new HibernateTemplate();
		ht.setSessionFactory(getSessionFactory());
		System.out.println("ht object created");
		return ht;
	}
	
	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}
