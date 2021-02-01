package com.rendawei.mydropwizard;

import com.rendawei.mydropwizard.health.TemplateHealthCheck;
import com.rendawei.mydropwizard.resources.MyDropWizardResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

/*
*   打包：在当前目录下 mvn package
*   运行：在当前目录下 java -jar .\target\my_dropwizard-2.1.0-SNAPSHOT.jar server .\my_dropwizard.yml
*   访问测试：http://localhost:8080/my-drop-wizard/health，如果访问成功，说明运行正确
*
*
* */

public class MyDropWizardApplication extends Application<MyDropWizardConfiguration> {
  public static void main(String[] args) throws Exception {
    new MyDropWizardApplication().run(args);
  }

  @Override
  public String getName() {
    return "hello-world";
  }

  @Override
  public void initialize(Bootstrap<MyDropWizardConfiguration> bootstrap) {
    // nothing to do yet
  }

  @Override
  public void run(MyDropWizardConfiguration configuration, Environment environment) {
    // nothing to do yet
    final MyDropWizardResource resource = new MyDropWizardResource(
        configuration.getTemplate()
    );
    final TemplateHealthCheck healthCheck = new TemplateHealthCheck(
        configuration.getTemplate()
    );
    environment.healthChecks().register("template", healthCheck);
    environment.jersey().register(resource);

//    添加跨域支持
    environment.servlets().addFilter("CrossOriginFilter",
        new CrossOriginFilter()).addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST),
        true,
        "/*");
  }

}
