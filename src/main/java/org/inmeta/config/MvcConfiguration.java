package org.inmeta.config;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import java.util.ArrayList;
import java.util.HashMap;

@Configuration
@ComponentScan(basePackages="org.inmeta")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{

	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
        resolver.setOrder(3);

		return resolver;
	}

    @Bean
    public ViewResolver getContentNegotiatingViewResolver() {
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setOrder(0);
        final HashMap<String, String> mediaTypes = new HashMap<String, String>();
        resolver.setMediaTypes(mediaTypes);
        mediaTypes.put("json", "application/json");
        mediaTypes.put("xml", "application/xml");

        final ArrayList<View> defaultViews = new ArrayList<View>();
        resolver.setDefaultViews(defaultViews);
        final MappingJacksonJsonView jacksonJsonView = new MappingJacksonJsonView();
        jacksonJsonView.setObjectMapper(new ObjectMapper());
        defaultViews.add(jacksonJsonView);

        return resolver;
    }


	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/img/**").addResourceLocations("/img/");
        registry.addResourceHandler("/javascript/**").addResourceLocations("/javascript/");
        registry.addResourceHandler("/docs/**").addResourceLocations("/docs/");
	}



}
