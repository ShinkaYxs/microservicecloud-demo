package com.demo.springCloud.mapper;

import com.demo.springCloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 闫喜深
 * @version 1.0
 * @date 2019/11/6 17:45
 */
@Mapper
public interface DeptMapper {

    public boolean addDept(Dept dept);
    public Dept findById(Long id);
    public List<Dept> findAll();

}
