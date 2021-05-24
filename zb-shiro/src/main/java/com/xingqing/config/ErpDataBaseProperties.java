package com.xingqing.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.sql.DataSourceDefinition;

/**
 * @ProjectName: muldatasource
 * @Author: qinjiwei
 * @Description:
 * @Date: 2020/6/28 16:28
 * @Version: 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "spring.datasource.erp")
public class ErpDataBaseProperties {
    String url;
    String username;
    String password;
    String driverClassName;
}
