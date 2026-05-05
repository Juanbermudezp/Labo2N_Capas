package org.example.labo2.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.labo2.domain.entity.Pirate;
import org.example.labo2.repository.PirateRepository;
import org.example.labo2.service.PirateService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PirateServiceImpl implements PirateService {
    private final PirateRepository pirateRepository;

    @Override
    public Pirate save(Pirate pirate) {
        return pirateRepository.save(pirate);
    }

    @Override
    public List<Pirate> findAll() {
        return pirateRepository.findAll();
    }

    @Override
    public Pirate findById(UUID id) {
        return pirateRepository.findById(id).orElseThrow(() -> new RuntimeException("Pirata no encontrado"));
    }

    @Override
    public Pirate update(UUID id, Pirate pirate) {
        Pirate existingPirate = findById(id);
        existingPirate.setName(pirate.getName());
        existingPirate.setBounty(pirate.getBounty());
        existingPirate.setCrew(pirate.getCrew());
        existingPirate.setIsAlive(pirate.getIsAlive());
        return pirateRepository.save(existingPirate);
    }

    @Override
    public void delete(UUID id) {
        pirateRepository.deleteById(id);
    }
}
