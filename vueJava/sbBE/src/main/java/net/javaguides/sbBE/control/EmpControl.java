package net.javaguides.sbBE.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.sbBE.entity.Emp;
import net.javaguides.sbBE.repo.EmpRepo;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:8080")
public class EmpControl  {
    
    @Autowired
    private EmpRepo empRep;

    @GetMapping("/emps")
    public List<Emp> fetchEmps(){
        return empRep.findAll();
    }
    
}
