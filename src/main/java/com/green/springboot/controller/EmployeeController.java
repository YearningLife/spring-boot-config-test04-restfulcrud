package com.green.springboot.controller;

import com.green.springboot.dao.EmployeeDao;
import com.green.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
/*
获取所有的柜员
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

//    页面发送emps请求，进行展示
    @GetMapping(value = "/emps")
    public String allEmployee(Model model) {
        Collection<Employee> empl = employeeDao.getAll();
        model.addAttribute("emps",empl);
        return "/emp/list";
    }
}
