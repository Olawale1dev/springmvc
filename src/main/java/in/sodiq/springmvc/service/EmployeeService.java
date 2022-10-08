package in.sodiq.springmvc.service;

import in.sodiq.springmvc.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getALLEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(long Id);


   /* Optional<Employee> findById(long id);*/
}
