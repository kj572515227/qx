package com.xingqing.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

/**
 * @ProjectName: muldatasource
 * @Author: qinjiwei
 * @Description:
 * @Date: 2020/6/28 16:29
 * @Version: 1.0
 */
@Configuration
@MapperScan(basePackages = {"com.xingqing.buy.mapper.bi","com.xingqing.mapper" }, sqlSessionTemplateRef = "biSqlSessionTemplate")
public class BiDataSourceConfig {

    @Autowired
    private BiDataBaseProperties prop;
    /**
     * 本数据源扫描的mapper路径
     */
    static final String MAPPER_LOCATION = "classpath:mapper/bi/*.xml";

    //    创建数据源
    @Bean(name = "biDS")
    @Primary
    public DataSource getFirstDataSource() {
        DataSource build = DataSourceBuilder.create()
                .driverClassName(prop.driverClassName)
                .url(prop.url)
                .username(prop.username)
                .password(prop.password)
                .build();
        return build;
    }

    // 创建SessionFactory
    @Bean(name = "biSqlSessionFactory")
    @Primary
    public SqlSessionFactory biSqlSessionFactory(@Qualifier("biDS") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);

        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            bean.setMapperLocations(resolver.getResources(MAPPER_LOCATION));
//            bean.setConfigLocation(resolver.getResource("classpath:/mybatis-config.xml"));
            return bean.getObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 创建事务管理器

    @Bean("biTransactionManger")
    @Primary
    public DataSourceTransactionManager biTransactionManger(@Qualifier("biDS") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    // 创建SqlSessionTemplate

    @Bean(name = "biSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate biSqlSessionTemplate(@Qualifier("biSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
