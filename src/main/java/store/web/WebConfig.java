package store.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

/**
 * Created by 周鸿清 on 8/3/2017.
 *
 */

@Configuration
@EnableWebMvc
@ComponentScan("store.web")
// remember to set the web source directory in project setting
public class WebConfig extends WebMvcConfigurerAdapter {

    //tile3 configure
    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions("/WEB-INF/views/tiles/tiles.xml");
        tilesConfigurer.setCheckRefresh(true);
        tilesConfigurer.setTilesInitializer(new SpringCompleteAutoloadTilesInitializer());
        return tilesConfigurer;
    }

    // tiles3 view resolver
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        TilesViewResolver viewResolver = new TilesViewResolver();
        registry.viewResolver(viewResolver);
    }

    // after cofigure tiles, configure for freemarker no longer needed
//    // freemarker viewResolver
//    @Bean
//    public ViewResolver viewResolver() {
//        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
//        resolver.setCache(true);
//        resolver.setPrefix("");
//        resolver.setSuffix(".ftl");
//        return resolver;
//    }

//    @Bean
//    public FreeMarkerConfigurer freemarkerConfig() {
//        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
//        freeMarkerConfigurer.setTemplateLoaderPath("/WEB-INF/views/ftl/");
//        return freeMarkerConfigurer;
//    }


    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    // static content provide in /WEB-INF/public folder
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // map resource to public folder
        // fuck, there got to be a / at the end
        registry.addResourceHandler("/public/**")
                .addResourceLocations("/WEB-INF/public/");
    }


}
