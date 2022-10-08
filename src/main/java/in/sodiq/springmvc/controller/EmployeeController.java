package in.sodiq.springmvc.controller;

import in.sodiq.springmvc.model.Employee;
import in.sodiq.springmvc.repository.EmployeeRepository;
import in.sodiq.springmvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    // display list of employee
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listEmployees", employeeService.getALLEmployees());
        return "index";

    }

    @GetMapping("/showNewEmployee")
    public String showNewEmployee(Model model) {
        //create model attribute to bind the form data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";

    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
     // save employee to database
        employeeRepository.save(employee);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value="id") long id, Model model){
      //get Employee from the service
        Optional<Employee> employee = employeeService.findById(id);

        //set employee as a model attribute to pre populate he form
        model.addAttribute("employee", employee);
        return "update_employee";

    }


   /* @PostMapping("/employee")
    public ResponseEntity<Employee> save(@RequestBody Employee employee) {
        try {

            return new ResponseEntity<>(employeeRepository.save(employee), HttpStatus.CREATED);
        } catch (Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }*/

}
