package com.springboot.demo.controller.restful;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@Controller
public class DemoSwaggerController {

    @ApiOperation(value = "测试swagger", notes = "测试API", httpMethod = "GET")
    @ApiParam(name = "content", value = "参数：content")
    @RequestMapping(value = "/demo/swagger", method = RequestMethod.GET)
    @ResponseBody
    public String demo(String content) {
        Map<String, String> map = new HashMap<>();
        map.put("result", "sucess");
        map.put("data", "{数据}");
        return new Gson().toJson(map);
    }

    @GetMapping("/getStream")
    public StreamingResponseBody getStream() {
        return new StreamingResponseBody() {
            @Override
            public void writeTo(OutputStream out) throws IOException {
                for (int i = 0; i < 1000; i++) {
                    out.write((Integer.toString(i) + " - ").getBytes());
                    out.flush();
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }

    private ExecutorService executor = Executors.newCachedThreadPool();

    @GetMapping("/v2/getStream")
    public ResponseEntity<ResponseBodyEmitter> getStreamThread() {
        ResponseBodyEmitter emitter = new ResponseBodyEmitter();
        executor.execute(() -> {
            try {
                for (int i = 0; i < 1000; i++) {
                    emitter.send(i + " - " + new Date().getTime() + "\n", MediaType.TEXT_PLAIN);
                    Thread.sleep(50);
                }
                emitter.complete();
            } catch (Exception ex) {
                emitter.completeWithError(ex);
            }
        });
        return new ResponseEntity(emitter, HttpStatus.OK);
    }


}
