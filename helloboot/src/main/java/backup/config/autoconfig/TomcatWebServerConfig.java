package backup.config.autoconfig;

import backup.config.ConditionalMyOnClass;
import backup.config.MyAutoConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.*;

@MyAutoConfig
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
// 무슨목적으로 import ?
@Import(ServerProperty.class)
@EnableMyConfigProperty(ServerProperty.class)
public class TomcatWebServerConfig {

//    @Value("${contextPath:}")
//    String contextPath;
//
//    @Value("${port:8080}")
//    int port;

    // 매번 정의해서 사용하는건 어렵다

    @Bean("tomcatWebServerFactory")
    @ConditionalOnMissingBean
    public ServletWebServerFactory servletWebServerFactory (ServerProperty serverProperty) {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();


//        factory.setContextPath(this.contextPath);
//        factory.setPort(port);

//        factory.setContextPath(serverProperty.getContextPath());
        factory.setPort(serverProperty.getPort());

        return factory;
    }



}
