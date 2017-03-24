// author: 周鸿清
package store.web;
import org.apache.tiles.TilesContainer;
import org.apache.tiles.evaluator.AttributeEvaluatorFactory;
import org.apache.tiles.extras.complete.CompleteAutoloadTilesContainerFactory;
import org.apache.tiles.request.ApplicationContext;
import org.apache.tiles.request.freemarker.render.FreemarkerRendererBuilder;
import org.apache.tiles.request.render.BasicRendererFactory;

/**
 * @author Bright Interactive
 */
public class SpringCompleteAutoloadTilesContainerFactory extends CompleteAutoloadTilesContainerFactory {
    @Override
    protected void registerAttributeRenderers(BasicRendererFactory rendererFactory, ApplicationContext applicationContext, TilesContainer container, AttributeEvaluatorFactory attributeEvaluatorFactory) {
        {
            super.registerAttributeRenderers(rendererFactory, applicationContext, container, attributeEvaluatorFactory);
//            FreemarkerRenderer freemarkerRenderer = new FreemarkerRenderer(new AttributeValueFreemarkerServlet());
            FreemarkerRendererBuilder freemarkerRenderer = FreemarkerRendererBuilder.createInstance();
            freemarkerRenderer.setApplicationContext(applicationContext);
//            freemarkerRenderer.setParameter("TemplatePath", "/");
//            freemarkerRenderer.setParameter("NoCache", "true");
//            freemarkerRenderer.setParameter("default_encoding", "");
//            freemarkerRenderer.setParameter("ContentType", "text/html");
//            freemarkerRenderer.setParameter("template_update_delay", "0");
//            freemarkerRenderer.setParameter("number_format", "0.##########");
            rendererFactory.registerRenderer("freemarker", freemarkerRenderer.build());
        }
    }

//    @Override
//    protected LocaleResolver createLocaleResolver(ApplicationContext applicationContext) {
//        return new SpringLocaleResolver();
//    }
}
