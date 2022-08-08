package net.javaguides.sbBE.repo;

import net.javaguides.sbBE.entity.ArxData;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArxRepo  extends JpaRepository<ArxData, Long> {
    
}