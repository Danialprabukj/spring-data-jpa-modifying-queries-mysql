package com.logicbig.example;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Employee e SET e.salary = e.salary + e.salary * :byPercent/100  WHERE e.dept = :dept")
    int updateDeptSalaries(@Param("dept") String dept, @Param("byPercent") int byPercent);
}