package com.demo.springCloud.service.impl;

import com.demo.springCloud.entities.Dept;
import com.demo.springCloud.mapper.DeptMapper;
import com.demo.springCloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 闫喜深
 * @version 1.0
 * @date 2019/11/6 18:11
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public boolean add(Dept dept) {
        return deptMapper.addDept(dept);
    }

    @Override
    public Dept get(Long id) {
        return deptMapper.findById(id);
    }

    @Override
    public List<Dept> list() {
        return deptMapper.findAll();
    }
}
