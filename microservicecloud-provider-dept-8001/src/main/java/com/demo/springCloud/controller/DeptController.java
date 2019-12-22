package com.demo.springCloud.controller;

import com.demo.springCloud.entities.Dept;
import com.demo.springCloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 闫喜深
 * @version 1.0
 * @date 2019/11/6 18:18
 */
@RestController
public class DeptController {
    @Autowired
    private DeptService service;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value="/dept/add" , method=RequestMethod.POST)
    public boolean add(@RequestBody Dept dept){
        return service.add(dept);
    }

    @RequestMapping(value="/dept/get/{id}" ,method=RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @RequestMapping(value="/dept/list",method=RequestMethod.GET)
    public List<Dept> list(){
        return service.list();
    }

    @RequestMapping(value="/dept/discovery", method=RequestMethod.GET)
    public Object discovery(){
        //获取所有服务
        List<String> list = discoveryClient.getServices();
        System.out.println("*********" + list);

        //找到名称为MICROSERVICECLOUD-DEPT的服务，打印它的相关信息
        List<ServiceInstance> srvList = discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");
        for(ServiceInstance element : srvList){
            System.out.println(element.getServiceId() + "\t" + element.getHost()
                    + "\t" + element.getPort() + "\t" + element.getUri());
        }
        return this.discoveryClient;
    }
}
