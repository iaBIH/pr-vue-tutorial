package bih.sbBE.control;


 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bih.sbBE.entity.ArxData;
import bih.sbBE.repo.ArxRepo;
 
@RestController
@RequestMapping("/api")
@CrossOrigin({"app://.", "http://127.0.0.1:8080","http://localhost:8080"})


public class ArxControl {
    @Autowired
    private ArxRepo arxRepo;
    
    @GetMapping("/arx")
    public List<ArxData> fetchArxData(){

        return arxRepo.findAll();
    }

    @PostMapping(value = "/arx")
    @ResponseBody
    public String getcalcoperation(@RequestBody String msg) {
         System.out.println("Data recieved xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
         System.out.println(msg + "         xxxxxxxxxxxxxxx");
        //  arxRepo.save(arxData)
        //return "OK!!!"
    return "redirect:/arx";  
    }

    // @RequestMapping(value = "/arx", method = RequestMethod.POST)
    // void getcalcoperation(@RequestParam String msg) {
    //      System.out.println("Data recieved xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    //      System.out.println(msg + "         xxxxxxxxxxxxxxx");
    // }

    // @GetMapping("/") // from spring boot to vue
    // public String home() {
    //     return calcvalue;
    // }
}

 