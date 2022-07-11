package com.reza.number.number.repository;

import com.reza.number.number.entity.Number;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface NumberRepository extends CrudRepository<Number, Long> {
    public Optional<Number> findByNumber(Long number);

    public Optional<Number> findById(UUID id);
    public Optional<Number> deleteById(UUID id);
}
