package store.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by 周鸿清 on 8/3/2017.
 * this is another context created by contextListener for business bean
 */

@Configuration
@ComponentScan(basePackages = {"store"},
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.CUSTOM, value = EnableWebMvc.class)
        })


public class RootConfig {
}
