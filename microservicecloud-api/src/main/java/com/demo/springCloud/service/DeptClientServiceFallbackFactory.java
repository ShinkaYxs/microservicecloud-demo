package com.demo.springCloud.service;

import com.demo.springCloud.entities.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 闫喜深
 * @version 1.0
 * @date 2019/11/21 16:33
 */
@Component  //千万不要忘记添加这个注解
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept get(Long id) {
                return new Dept().setDeptno(id).setDname("该ID：" + id + "没有对应的信息,Consumer端提供的降级信息，此刻provider服务已关闭")
                        .setDbSource("no this database in MySQL");
            }

            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public boolean add(Dept dept) {
                return false;
            }
        };
    }
}
