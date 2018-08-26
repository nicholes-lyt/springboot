package com.test;

import com.test.entity.DemoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DemoPublish {

  @Autowired
  private ApplicationContext context;

  public void publish(String msg){
    context.publishEvent(new DemoEvent(this,msg));
  }

}
