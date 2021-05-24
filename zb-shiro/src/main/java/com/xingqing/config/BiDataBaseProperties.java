package com.xingqing.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: muldatasource
 * @Author: qinjiwei
 * @Description:
 * @Date: 2020/6/28 16:26
 * @Version: 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "spring.datasource.bi")
public class BiDataBaseProperties {
    String url;
    String username;
    String password;
    String driverClassName;
}
