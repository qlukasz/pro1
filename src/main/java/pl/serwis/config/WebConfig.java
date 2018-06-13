package pl.serwis.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import pl.serwis.db.*;
import pl.serwis.serwis.Serwis;
import pl.serwis.serwis.SerwisImpl;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan("pl.serwis")
public class WebConfig {
    @Bean
    public InternalResourceViewResolver resolver() {
        InternalResourceViewResolver resolver;
        resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
    @Bean
    public DataSource dataSource() {
        System.out.println("---------------------------Creating dataSource");
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl("jdbc:postgresql://localhost:5432/test");
        ds.setUsername("postgres");
        ds.setPassword("rd");
        return ds;
    }
    @Bean
    public JdbcOperations JdbcOperations(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setShowSql(true);
        adapter.setGenerateDdl(false);
        adapter.setDatabasePlatform("org.hibernate.dialect.HSQLDialect");
        return adapter;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean emfb = new
                LocalContainerEntityManagerFactoryBean();
        emfb.setDataSource(dataSource());
        emfb.setJpaVendorAdapter(jpaVendorAdapter);
        return emfb;
    }






//    @Bean
//    public Database database(JdbcOperations jdbcOperations)  {
//        return new DatabaseJDBCTemplate(jdbcOperations);
//    }

//    @Bean
//    public Database database(SessionFactory factory)  {
//        return new DatabaseHibernate(factory);
//    }

    @Bean
    public Database database()  {
        return new JpaDeviceRepository();
    }

    @Bean
    public Serwis serwis(Database database)  {
        return new SerwisImpl(database);
    }

    @Bean
    public SessionFactory sessionFactory(){
        SessionFactory factory = null;
        try {
            factory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            System.out.println("---------------------------Creating SessionFactory");
            return factory;
        } catch (Throwable ex) {
            System.err.println("Failed to create SessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
}