package com.demo.springCloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author 闫喜深
 * @version 1.0
 * @date 2019/11/6 12:38
 */
@SuppressWarnings("serial")
//@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)    //链式风格访问
public class Dept implements Serializable { //必须序列化

    private Long deptno; //主键
    private String dname; //部门名称
    private String dbSource;// 来自哪个数据库,因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库

    public Dept(String dname){
        super();
        this.dname = dname;
    }

//    public static void main(String[] args) {
//
//        Dept dept = new Dept();
//        //链式写法
//        dept.setDeptno(11L).setDname("RD").setDbsource("DB01");
//    }

}
