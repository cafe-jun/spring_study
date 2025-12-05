package backup.config.autoconfig;


import backup.config.ConditionalMyOnClass;
import backup.config.MyAutoConfig;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@MyAutoConfig
@ConditionalMyOnClass("org.eclipse.jetty.server.Server")
public class JettyWebServerConfig {
    @Bean("jettyWebServerFactory")
    public ServletWebServerFactory servletContainer() {
        return new JettyServletWebServerFactory();
    }

}
