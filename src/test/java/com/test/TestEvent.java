package com.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestEvent {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext config = new AnnotationConfigApplicationContext(EventConfig.class);
    DemoPublish pub = config.getBean(DemoPublish.class);
    pub.publish("test publish event");
    config.close();
  }

}
