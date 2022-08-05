package net.javaguides.sbBE.repo;

import net.javaguides.sbBE.entity.Emp;

 
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepo extends JpaRepository<Emp, Long>{
 
    
}
