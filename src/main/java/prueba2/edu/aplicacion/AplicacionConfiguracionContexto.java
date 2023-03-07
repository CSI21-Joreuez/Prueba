package prueba2.edu.aplicacion;

import java.util.Properties;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import prueba2.edu.aplicacion.entidades.alumnos;




@ComponentScan
@Configuration
@PropertySource("classpath:aplicacion.properties")
@EnableJpaRepositories(basePackages ={"edu.vista.GestionAsignacion.Repositorios"})
public class AplicacionConfiguracionContexto {

	   @Autowired 
	    private Environment aplicacion;
	    
	    @Bean
	    public DataSource dataSource() {
	    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(aplicacion.getProperty("db.driver"));
	        dataSource.setUrl(aplicacion.getProperty("db.url"));
	        dataSource.setUsername(aplicacion.getProperty("db.username"));
	        dataSource.setPassword(aplicacion.getProperty("db.password"));
	        return dataSource;
	    }
	    
	    @Bean
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

	        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
	        emf.setDataSource(dataSource());
	        emf.setPackagesToScan(alumnos.class.getPackage().getName());
	        
	        HibernateJpaVendorAdapter hibernateJpa = new HibernateJpaVendorAdapter();
	        hibernateJpa.setDatabase(Database.POSTGRESQL);
	        hibernateJpa.setDatabasePlatform(aplicacion.getProperty("hibernate.dialect"));
	        hibernateJpa.setGenerateDdl(aplicacion.getProperty("hibernate.generateDdl", Boolean.class));
	        hibernateJpa.setShowSql(aplicacion.getProperty("hibernate.show_sql", Boolean.class));
	        emf.setJpaVendorAdapter(hibernateJpa);
	        
	        Properties jpaProperties = new Properties();
	        jpaProperties.put("hibernate.hbm2ddl.auto", aplicacion.getProperty("hibernate.hbm2ddl.auto"));
	        jpaProperties.put("hibernate.show_sql", aplicacion.getProperty("hibernate.show_sql"));
	        jpaProperties.put("hibernate.format_sql", aplicacion.getProperty("hibernate.format_sql"));
	        //jpaProperties.put("hibernate.bytecode.provider", contextoPropiedades.getProperty("hibernate.bytecode.provider"));
	        emf.setJpaProperties(jpaProperties);
	        
	        return emf;
	    }
	    
	    @Bean
	    public JpaTransactionManager transactionManager() {
	        JpaTransactionManager txnMgr = new JpaTransactionManager();
	        txnMgr.setEntityManagerFactory(entityManagerFactory().getObject());
	        return txnMgr;
	    }
}
