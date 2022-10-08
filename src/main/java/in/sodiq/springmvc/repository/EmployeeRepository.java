package in.sodiq.springmvc.repository;

import in.sodiq.springmvc.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee,  Long> {
}
