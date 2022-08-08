package net.javaguides.sbBE.control;


 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.sbBE.entity.ArxData;
import net.javaguides.sbBE.repo.ArxRepo;
 
@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:8080")

public class ArxControl {
    @Autowired
    private ArxRepo arxRepo;
    
    @GetMapping("/arx")
    public List<ArxData> fetchArxData(){

        return arxRepo.findAll();
    }
}

 