package de.gishmo.example.mvp4g2.springboot.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication( scanBasePackages = "de.gishmo.example.mvp4g2.springboot.server.resource")
public class ServerApplication {

  final static Logger logger = LoggerFactory.getLogger(ServerApplication.class);

  @Autowired
  Environment environment;

  public static void main(String[] args) {
    SpringApplication.run(ServerApplication.class, args);
  }
}
