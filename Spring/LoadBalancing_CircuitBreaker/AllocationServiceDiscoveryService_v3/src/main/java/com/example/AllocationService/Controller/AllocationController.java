package com.example.AllocationService.Controller;

import com.example.AllocationService.Model.Allocation;
import com.example.AllocationService.Service.AllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@RestController
@RequestMapping("/Allocation")
@XmlRootElement
public class AllocationController {

    @Autowired
    AllocationService allocationService;

    @RequestMapping(value = "/createAllocation" , method = RequestMethod.POST)
    public Allocation save(@RequestBody Allocation allocation){
        return allocationService.save(allocation);
    }

    @RequestMapping(value="/findAllocationByEmpId/{id}",method = RequestMethod.GET)
    public List<Allocation> findEmployee(@PathVariable Integer id){
        //System.out.println("Service_1");
        return allocationService.findAllocationByEmpId(id);
    }

    @RequestMapping(value="/fetchAllAllocations",method = RequestMethod.GET)
    public List<Allocation> fetchAllEmployees(){
        return allocationService.fetchAllAllocations();
    }
}