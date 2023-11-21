package com.employee.controller;

import com.employee.entity.Employee;
import com.employee.service.EmpService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmpController {
    @Autowired
    private EmpService service;
    @GetMapping("/")
    public String home(Model m)
    {
        List<Employee> emp = service.getAllEmp();
        m.addAttribute("emp",emp);
        return "Index";

    }
    @GetMapping("/addemp")
    public String addEmpForm(){
        return "add_emp";
    }
    @PostMapping("/register")
    public String empRegister(@ModelAttribute Employee e, HttpSession session){
        System.out.println(e);

        service.addEmp(e);
        session.setAttribute("msg","Employee Added Successfully.!");
        return "redirect:/";

    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model m){
        Employee e = service.getEmpByID(id);

        m.addAttribute("emp",e);
        return "edit";
    }
    @PostMapping("/update")
    public String updateEmp(@ModelAttribute Employee e, HttpSession session){
        System.out.println(e);

        service.addEmp(e);
        session.setAttribute("msg","Employee data updated successfully.!");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmp(@PathVariable int id, HttpSession session){
        service.deleteEmp(id);
        session.setAttribute("msg","Employee deleted successfully.!");
        return "redirect:/";
    }
    @GetMapping("/error")
    public String handleError(HttpServletRequest request){
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null && Integer.valueOf(status.toString()) == HttpStatus.NOT_FOUND.value()) {
            return "404";
        }

        return "error";
    }
}
