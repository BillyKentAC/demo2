package com.example.demoESB.repository;

import com.example.demoESB.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteJPARepositorio extends JpaRepository<Cliente,Integer> {

}
