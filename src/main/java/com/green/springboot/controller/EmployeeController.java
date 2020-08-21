package com.green.springboot.controller;

import com.green.springboot.dao.DepartmentDao;
import com.green.springboot.dao.EmployeeDao;
import com.green.springboot.entities.Department;
import com.green.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
        return "emp/list";
    }
    @Autowired
    private DepartmentDao departmentDao;

    //页面下拉菜单展示
    @GetMapping(value = "/emp")
    public String addEmployeePage(Model model) {
        Collection<Department> daoDepartments = departmentDao.getDepartments();
        model.addAttribute("departs",daoDepartments);
        return "emp/add";
    }

    /*
    用来存储页面数据
     */
    @PostMapping(value = "/emp")
    public String saveEmployee(Employee employee) {
        System.out.println(".............."+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }
}
