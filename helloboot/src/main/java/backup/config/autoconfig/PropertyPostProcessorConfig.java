package backup.config.autoconfig;

import backup.config.MyAutoConfig;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.env.Environment;

import java.util.Map;

@MyAutoConfig
public class PropertyPostProcessorConfig {
    @Bean BeanPostProcessor beanPostProcessor(Environment env) {
        return new BeanPostProcessor() {
            @Override
            public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                MyConfigProperty annotation = AnnotationUtils.findAnnotation(bean.getClass(), MyConfigProperty.class);

                if(annotation == null) return bean;

                Map<String, Object> attr = AnnotationUtils.getAnnotationAttributes(annotation);

                String prefix = attr.get("prefix").toString();

                return Binder.get(env).bindOrCreate(prefix,bean.getClass());
            }
        };
    }
}
