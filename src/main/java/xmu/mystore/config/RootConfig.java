package xmu.mystore.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 周鸿清 on 8/3/2017.
 * this is another context created by contextListener for business bean
 */

@Configuration
@ComponentScan(basePackages = {"xmu.mystore.goodsmgt", "xmu.mystore.config"})
//@PropertySource(value = {"classpath:app.properties"})
public class RootConfig {

}
