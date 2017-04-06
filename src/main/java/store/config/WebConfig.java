package store.config;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.evaluator.AttributeEvaluatorFactory;
import org.apache.tiles.extras.complete.CompleteAutoloadTilesContainerFactory;
import org.apache.tiles.extras.complete.CompleteAutoloadTilesInitializer;
import org.apache.tiles.factory.AbstractTilesContainerFactory;
import org.apache.tiles.request.ApplicationContext;
import org.apache.tiles.request.freemarker.render.FreemarkerRendererBuilder;
import org.apache.tiles.request.render.BasicRendererFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import java.io.File;

/**
 * Created by 周鸿清 on 8/3/2017.
 */

@Configuration
@EnableWebMvc
@ComponentScan("store.web")
@PropertySource(value = {"classpath:app.properties"})
// remember to set the web source directory in project setting
public class WebConfig extends WebMvcConfigurerAdapter {

//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
////        stringConverter.setSupportedMediaTypes(Arrays.asList(new MediaType("UTF-8")));
//        stringConverter.setDefaultCharset(Charset.forName("UTF-8"));
//        converters.add(stringConverter);
//    }

    //    @Bean
//    public CharacterEncodingFilter characterEncodingFilter() {
//        final CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
//        characterEncodingFilter.setEncoding("UTF-8");
//        characterEncodingFilter.setForceEncoding(true);
//        return characterEncodingFilter;
//


    // bean to get properties
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    //tile3 configure
    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions("/WEB-INF/views/tiles.xml");
        tilesConfigurer.setCheckRefresh(true);
        tilesConfigurer.setTilesInitializer(new CompleteAutoloadTilesInitializer() {
            @Override
            protected AbstractTilesContainerFactory createContainerFactory(ApplicationContext context) {
                return new CompleteAutoloadTilesContainerFactory() {
                    @Override
                    protected void registerAttributeRenderers(BasicRendererFactory rendererFactory, ApplicationContext applicationContext, TilesContainer container, AttributeEvaluatorFactory attributeEvaluatorFactory) {
                        super.registerAttributeRenderers(rendererFactory, applicationContext, container, attributeEvaluatorFactory);
                        //FreemarkerRenderer freemarkerRenderer = new FreemarkerRenderer(new AttributeValueFreemarkerServlet());
                        FreemarkerRendererBuilder freemarkerRenderer = FreemarkerRendererBuilder.createInstance();
                        freemarkerRenderer.setApplicationContext(applicationContext);
                        //freemarkerRenderer.setParameter("TemplatePath", "/");
                        //freemarkerRenderer.setParameter("NoCache", "true");
                        freemarkerRenderer.setParameter("ContentType", "text/html;Charset=UTF-8");
                        freemarkerRenderer.setParameter("default_encoding", "utf8");
                        //freemarkerRenderer.setParameter("template_update_delay", "0");
                        //freemarkerRenderer.setParameter("number_format", "0.##########");
                        rendererFactory.registerRenderer("freemarker", freemarkerRenderer.build());
                    }
                };
            }
        });

        return tilesConfigurer;
    }

    // file upload handler
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//        multipartResolver.
        return multipartResolver;
    }

    //     tiles3 view resolver
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        TilesViewResolver viewResolver = new TilesViewResolver();
//        viewResolver.setContentType("text/html;charset=UTF-8");
        registry.viewResolver(viewResolver);
    }


    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    // static content provide in /WEB-INF/public folder
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // map resource to public folder
        // fuck, there got to be a / at the end
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");

        String imagePath = System.getProperty("catalina.home") + File.separator + "tempFiles/";
        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:"+ imagePath);

    }


}
