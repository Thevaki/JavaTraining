package com.example.AllocationService.Service;

import com.example.AllocationService.Model.Allocation;
import com.example.AllocationService.Repository.AllocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AllocationServiceImpl implements AllocationService{
    @Autowired
    AllocationRepository allocationRepository;

    @Override
    public Allocation save(Allocation employee){
        return allocationRepository.save(employee);
    }

    public List<Allocation> findAllocationByEmpId(Integer id){
            return allocationRepository.findByEmpId(id);
    }

    public List<Allocation> fetchAllAllocations(){
        return  allocationRepository.findAll();
    }
}
