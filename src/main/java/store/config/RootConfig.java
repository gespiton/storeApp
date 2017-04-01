package store.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 周鸿清 on 8/3/2017.
 * this is another context created by contextListener for business bean
 */

@Configuration
@ComponentScan(basePackages = {"store.business","store.config"})
//@PropertySource(value = {"classpath:hibernate.properties"})
public class RootConfig {

}
