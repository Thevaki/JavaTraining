package com.example.AllocationService.Repository;

import com.example.AllocationService.Model.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllocationRepository extends JpaRepository<Allocation,Integer> {
}
