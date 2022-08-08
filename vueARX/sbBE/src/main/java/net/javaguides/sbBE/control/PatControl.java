package net.javaguides.sbBE.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.sbBE.entity.Pat;
import net.javaguides.sbBE.repo.PatRepo;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:8080")
public class PatControl  {
    
    @Autowired
    private PatRepo empRepo;

    @GetMapping("/pats")
    public List<Pat> fetchEmps(){
        return empRepo.findAll();
    }
    
}
