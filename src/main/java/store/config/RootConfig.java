package store.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import store.business.mappers.ItemMapper;

import javax.sql.DataSource;

/**
 * Created by 周鸿清 on 8/3/2017.
 * this is another context created by contextListener for business bean
 */

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"store"})
@ImportResource(value = "file:/Users/sher/Documents/workspace/storeApp/src/main/java/store/config/mybatis.xml")
@PropertySource(value = {"file:/Users/sher/Documents/workspace/storeApp/src/main/java/aa.properties"})
public class RootConfig {
//    @Autowired
//    private Environment env;

    /**
     * Initialize dataSource
     *
     * @return DataSource
     */

//    @Bean
//    public DataSource dataSource() {
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
//        dataSource.setUsername("root");
//        dataSource.setPassword("freedom");
//        return dataSource;
//    }
//
//
//
//    @Bean
//    public SqlSessionFactory sessionFactory() throws Exception {
//        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//        factoryBean.setDataSource(dataSource());
////        sessionFactory.setPackagesToScan("store.business.models");
////        sessionFactory.setHibernateProperties(getHibernateProperties());
//        SqlSessionFactory sessionFactory = factoryBean.getObject();
//        return sessionFactory;
//    }
//
//    @Bean
//    public MapperScannerConfigurer mapperScannerConfigurer() {
//        MapperScannerConfigurer mapperScanner = new MapperScannerConfigurer();
//        mapperScanner.setBasePackage("store.mappers");
//        return mapperScanner;
//    }
//
//
//    @Bean
//    public DataSourceTransactionManager transactionManager() {
//        DataSourceTransactionManager txManager = new DataSourceTransactionManager();
//        txManager.setDataSource(dataSource());
//        return txManager;
//    }
//
//    @Bean
//    public MapperFactoryBean userMapper() throws Exception {
//        MapperFactoryBean mfb = new MapperFactoryBean();
//        mfb.setMapperInterface(ItemMapper.class);
//        mfb.setSqlSessionFactory(sessionFactory());
//        return mfb;
//    }
}
