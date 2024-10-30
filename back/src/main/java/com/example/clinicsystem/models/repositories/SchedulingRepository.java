package com.example.clinicsystem.models.repositories;

import com.example.clinicsystem.models.entities.Scheduling;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SchedulingRepository extends CrudRepository<Scheduling, Integer> {
    List<Scheduling> findBystatusTrue();
    List<Scheduling> findBystatusFalse();
}
