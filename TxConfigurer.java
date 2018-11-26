package com.nt.cfg;



import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class TxConfigurer {
	@Autowired
	@Qualifier("sfactory")
	private SessionFactory factory;
	
	
	@Bean(name="hbtxmgr")
	public HibernateTransactionManager createTxManager(){
		
		return new HibernateTransactionManager(factory);
		
	}
	
	
	

}
