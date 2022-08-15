package bih.sbBE.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import bih.sbBE.entity.ArxData;

public interface ArxRepo  extends JpaRepository<ArxData, Long> {
    
}