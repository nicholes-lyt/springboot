package com.test;

import com.test.entity.DemoEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

  @Override
  public void onApplicationEvent(DemoEvent demoEvent) {
    System.out.println("recive msg:"+demoEvent.getMsg());
  }

}
