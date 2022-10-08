package in.sodiq.springmvc.service;

import in.sodiq.springmvc.model.Employee;
import in.sodiq.springmvc.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImp implements EmployeeService  {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeService employeeService;

    @Override
    public List<Employee> getALLEmployees() {
        return employeeRepository.findAll();

    }

    @Override
    public void saveEmployee(Employee employee) {
       this.employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        Employee employee = null;
        if(optional.isPresent()){
            employee = optional.get();
        }else{ throw new RuntimeException("Employee not found for id :: " + id);

        }
        return  employee;
    }

  /*  @Override
    public Optional<Employee> findById(long id) {
        Optional<Employee> optional = employeeService.findById(id);
        Employee employee = null;
        if(optional.isPresent()){
            employee = optional.get();
        }else{ throw new RuntimeException("Employee not found for id :: " + id);

        }
        return Optional.of(employee);
    }*/
}
