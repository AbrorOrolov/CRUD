package com.example.crud.repository;

import com.example.crud.entity.Xodim;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface XodimRepository extends JpaRepository<Xodim,Integer> {
    Optional<Xodim> findByTel(String tel);
}
