package com.xingqing.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

/**
 * @ProjectName: muldatasource
 * @Author: qinjiwei
 * @Description:
 * @Date: 2020/6/28 16:36
 * @Version: 1.0
 */
//@MapperScan({"com.mysiteforme.admin.dao","com.zipon.tpf.dao"})
@Configuration
@MapperScan(basePackages = "com.xingqing.buy.mapper.erp",sqlSessionTemplateRef ="erpSqlSessionTemplate")
public class ErpDataSourceConfig {
    @Autowired
    private ErpDataBaseProperties prop;
    /**本数据源扫描的mapper路径*/
    static final String MAPPER_LOCATION = "classpath:mapper/erp/*.xml";

    //    创建数据源
    @Bean(name = "erpDS")
    public DataSource getErpDataSource() {
        DataSource build =  DataSourceBuilder.create()
                .driverClassName(prop.driverClassName)
                .url(prop.url)
                .username(prop.username)
                .password(prop.password)
                .build();
        return build;
    }


    // 创建SessionFactory
    @Bean(name = "erpSqlSessionFactory")
    public SqlSessionFactory erpSqlSessionFactory(@Qualifier("erpDS") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        ResourcePatternResolver resolver=new PathMatchingResourcePatternResolver();
        try{
            bean.setMapperLocations(resolver.getResources(MAPPER_LOCATION));
//            bean.setConfigLocation(resolver.getResource("classpath:/mybatis-config.xml"));
            return bean.getObject();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResource("classpath*:/mapper/second/*.xml"));
//        return bean.getObject();
    }

    // 创建事务管理器

    @Bean("erpTransactionManger")
    public DataSourceTransactionManager erpTransactionManger(@Qualifier("erpDS") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    // 创建SqlSessionTemplate

    @Bean(name = "erpSqlSessionTemplate")
    public SqlSessionTemplate erpSqlSessionTemplate(@Qualifier("erpSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
