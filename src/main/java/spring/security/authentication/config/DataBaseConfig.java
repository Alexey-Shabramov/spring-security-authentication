package spring.security.authentication.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@PropertySource("classpath:/project.properties")
public class DataBaseConfig {
    private static final String PROPERTY_NAME_DATABASE_DRIVER = "jdbc.hsqldb.driverClass";
    private static final String PROPERTY_NAME_DATABASE_URL = "jdbc.hsqldb.url";
    private static final String PROPERTY_NAME_DATABASE_USERNAME = "jdbc.hsqldb.username";
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "jdbc.hsqldb.password";

    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String PROPERTY_NAME_ENABLE_LAZY_LOAD_NO_TRANS = "hibernate.enable_lazy_load_no_trans";
    private static final String PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
    private static final String PROPERTY_NAME_CONNECTION_POOL_SIZE = "connection.pool_size";
    private static final String PROPERTY_NAME_SHOW_SQL = "hibernate.show_sql";
    private static final String PROPERTY_NAME_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";


    @Resource
    private Environment env;

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("spring.security.authentication.entity");
        sessionFactory.setHibernateProperties(getHibernateProperties());
        return sessionFactory;
    }

    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("classpath:/database/database_schema.sql")
                .build();
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
        hibernateTransactionManager.setSessionFactory(sessionFactory);
        return hibernateTransactionManager;
    }

    private Properties getHibernateProperties() {
        return new Properties() {
            {
                setProperty(PROPERTY_NAME_HIBERNATE_DIALECT, env.getProperty(PROPERTY_NAME_HIBERNATE_DIALECT));
                setProperty(PROPERTY_NAME_ENABLE_LAZY_LOAD_NO_TRANS, env.getProperty(PROPERTY_NAME_ENABLE_LAZY_LOAD_NO_TRANS));
                setProperty(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO, env.getProperty(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO));
                setProperty(PROPERTY_NAME_HIBERNATE_FORMAT_SQL, env.getProperty(PROPERTY_NAME_HIBERNATE_FORMAT_SQL));
                setProperty(PROPERTY_NAME_SHOW_SQL, env.getProperty(PROPERTY_NAME_SHOW_SQL));
                setProperty(PROPERTY_NAME_CONNECTION_POOL_SIZE, env.getProperty(PROPERTY_NAME_CONNECTION_POOL_SIZE));
                setProperty(PROPERTY_NAME_DATABASE_DRIVER, env.getProperty(PROPERTY_NAME_DATABASE_DRIVER));
                setProperty(PROPERTY_NAME_DATABASE_URL, env.getProperty(PROPERTY_NAME_DATABASE_URL));
                setProperty(PROPERTY_NAME_DATABASE_USERNAME, env.getProperty(PROPERTY_NAME_DATABASE_USERNAME));
                setProperty(PROPERTY_NAME_DATABASE_PASSWORD, env.getProperty(PROPERTY_NAME_DATABASE_PASSWORD));
            }
        };
    }
}
