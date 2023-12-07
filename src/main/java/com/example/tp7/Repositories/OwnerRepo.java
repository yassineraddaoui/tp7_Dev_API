package com.example.tp7.Repositories;

import com.example.tp7.Models.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OwnerRepo extends CrudRepository<Owner,Long> {
    Optional<Owner> findByName(String email);
    void deleteByName(String name);
}
