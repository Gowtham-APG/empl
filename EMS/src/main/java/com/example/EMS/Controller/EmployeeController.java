package com.example.EMS.Controller;

import com.example.EMS.Entity.Employee;
import com.example.EMS.Service.EmployeeService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // Correct import
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;
    private Employee employee;


    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public String showAllEmployees(Model model) {
        model.addAttribute("employees", service.getAllEmployees()); // Correct method
        return "Index";
    }
    @GetMapping("/add")
    public String addEmployeeForm(Model model){
        model.addAttribute("employee",new Employee());
        return "add";
    }
    @PostMapping("/add")
    public String saveEmployee(@ModelAttribute Employee employee){
        service.SaveEmployee(employee);
        return "redirect:/employees";
    }
    @GetMapping("/edit/{id}")
    public String editEmployeeForm(@PathVariable Long id,Model model){
        model.addAttribute("employee", service.getById(id));
        return "edit";
    }
    @PostMapping("/edit/{id}")
    public String editEmployee(@PathVariable Long id,@ModelAttribute Employee employee){
        employee.setId(id);
        service.SaveEmployee(employee);
        return "redirect:/employees";
    }
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id,Model model){
        service.deleteEmployee(id);
        return "redirect:/employees";
    }
    @GetMapping("/view/{id}")
    public String viewEmployee(@PathVariable Long id,Model model) {
        model.addAttribute("employee", service.getById(id));
        return "view";
    }
}
