package com.github.mvp4g.server;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.github.mvp4g.server.filter.LoggingRequestFilter;
import com.github.mvp4g.server.filter.LoggingResponseFilter;
import org.glassfish.jersey.server.ServerProperties;

public class ServiceApplication
  extends Application {

  @Override
  public Set<Class<?>> getClasses() {
    final Set<Class<?>> classes = new HashSet<Class<?>>();
    classes.add(ServiceApplicationEventListener.class);
    classes.add(LoggingRequestFilter.class);
    classes.add(LoggingResponseFilter.class);
    return classes;
  }

  @Override
  public Map<String, Object> getProperties() {
    Map<String, Object> properties = new HashMap<String, Object>();
    properties.put(ServerProperties.MONITORING_STATISTICS_MBEANS_ENABLED,
                   true);
    return properties;
  }
}
