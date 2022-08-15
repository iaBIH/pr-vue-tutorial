package bih.sbBE.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bih.sbBE.entity.Pat;
import bih.sbBE.repo.PatRepo;

@RestController
@RequestMapping("/api")
//@CrossOrigin("http://localhost:8080")
@CrossOrigin("app://.")

public class PatControl  {
    
    @Autowired
    private PatRepo empRepo;

    @GetMapping("/pats")
    public List<Pat> fetchEmps(){
        return empRepo.findAll();
    }
    
}
