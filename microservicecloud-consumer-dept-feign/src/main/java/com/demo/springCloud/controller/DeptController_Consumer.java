package com.demo.springCloud.controller;

import com.demo.springCloud.entities.Dept;
import com.demo.springCloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController_Consumer {

    @Autowired
    private DeptClientService deptClientService;

    @GetMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return deptClientService.get(id);
    }

    @GetMapping(value = "/consumer/get/list")
    public List<Dept> list(){
        return deptClientService.list();
    }

    @PostMapping(value = "/consumer/dept/add")
    public boolean add(@RequestBody Dept dept){
        return deptClientService.add(dept);
    }



    /* 以下为调用使用restTemplate，也就是使用Ribbon+RestTemplate的方式

//    private static final String REST_URL_PREFIX = "http://localhost:8001";
    private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";

    //Controller层通过RestTemplate来进行 Rest的调用 和 发出Rest请求、
    @Autowired
    private RestTemplate restTemplate;

//    使用restTemplate访问restful接口非常的简单粗暴无脑。
//    (url, requestMap, ResponseBean.class)这三个参数分别代表
//    REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。

    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(@RequestBody Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add", dept, Boolean.class);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id, Dept.class);
    }

    @RequestMapping(value = "/consumer/dept/get/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list", List.class);
    }

    //测试@EnableDiscoveryClient，消费端可以调用服务发现
    @RequestMapping(value = "/consumer/dept/discovery")
    public Object discovery(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/discovery", Object.class);
    }

    */
}
