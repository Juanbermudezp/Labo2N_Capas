package org.example.labo2.service;

import org.example.labo2.domain.entity.Pirate;

import java.util.List;
import java.util.UUID;

public interface PirateService {
    Pirate save(Pirate pirate);
    List<Pirate> findAll();
    Pirate findById(UUID id);
    Pirate update(UUID id, Pirate pirate);
    void delete(UUID id);
}
