package com.hyhg.config;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;

/**
 * EnableTransactionManagement注解启用了事务管理功能
 * @author yangningning
 *
 */
@Configuration
@MapperScan("com.hyhg.dal.mapper")
@EnableTransactionManagement
public class DalConfig {

	@Value(value = "classpath:mybatis/sqlmap/*.xml")
    private Resource[] mapperLocations;

    @Value(value = "classpath:mybatis/mybatis-config.xml")
    private Resource configLocation;
    
	@Bean(autowire = Autowire.BY_NAME)
	public SqlSessionFactoryBean sqlSessionFactory(){
		SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
		ssfb.setConfigLocation(configLocation);
		ssfb.setMapperLocations(mapperLocations);
		ssfb.setTypeAliasesPackage("com.hyhg.domain");
		return ssfb;
	}
	
	@Bean(initMethod = "init", destroyMethod = "close")
	@Autowired
	public DruidDataSource dataSource(@Value("${web.db.url}")String url,
			@Value("${web.db.username}") String username,
			@Value("${web.db.password}") String password,
			@Value("${web.db.driverClassName}") String driverClassName) throws SQLException{
		DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setMaxActive(60);
        druidDataSource.setInitialSize(1);
        druidDataSource.setMaxWait(60000);//60s
        druidDataSource.setMinIdle(1);
        druidDataSource.setTimeBetweenEvictionRunsMillis(3000);
        druidDataSource.setMinEvictableIdleTimeMillis(300000);
        druidDataSource.setValidationQuery("select 1");
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setTestOnBorrow(false);
        druidDataSource.setTestOnReturn(false);
        druidDataSource.setPoolPreparedStatements(true);
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
        druidDataSource.setFilters("config");
        Properties properties = new Properties();
        properties.put("config.decrypt", "true");
        druidDataSource.setConnectProperties(properties);

        StatFilter statFilter = new StatFilter();
        statFilter.setSlowSqlMillis(10000);//10s。。慢
        statFilter.setMergeSql(true);
        statFilter.setLogSlowSql(true);

        List<Filter> filterList = new ArrayList<Filter>();
        filterList.add(statFilter);
        druidDataSource.setProxyFilters(filterList);

        return druidDataSource;
	}
	
	@Bean(autowire = Autowire.BY_NAME)
    public TransactionTemplate transactionTemplate() {
        return new TransactionTemplate();
    }

    @Bean(autowire = Autowire.BY_NAME)
    public TransactionTemplate transactionTemplateNew(){
        TransactionTemplate template = new TransactionTemplate();
        template.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        return template;
    }
    
    @Bean(autowire = Autowire.BY_NAME)
    public TransactionTemplate transactionTemplateNested(){
        TransactionTemplate template = new TransactionTemplate();
        template.setPropagationBehavior(TransactionDefinition.PROPAGATION_NESTED);
        return template;
    }
	
	
}
