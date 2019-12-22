package com.demo.springCloud.service;

import com.demo.springCloud.entities.Dept;

import java.util.List;

/**
 * @author 闫喜深
 * @version 1.0
 * @date 2019/11/6 18:01
 */
public interface DeptService {

    public boolean add(Dept dept);
    public Dept get(Long id);
    public List<Dept> list();
}
