package com.reza.number.number.repository;

import com.reza.number.number.entity.Number;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NumberRepository extends CrudRepository<Number, Long> {
    public Optional<Number> findByNumber(Long number);
}
