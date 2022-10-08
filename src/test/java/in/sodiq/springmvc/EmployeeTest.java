package in.sodiq.springmvc;

import in.sodiq.springmvc.model.Employee;
import in.sodiq.springmvc.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeTest {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Test
    public void saveStudent() {
        Employee employee = Employee.builder()
                .Email("Mrsjohn@gmail.com")
                .LastName("Johnny")
                .FirstName("gor")
                .build();
        employeeRepository.save(employee);
    }
}
