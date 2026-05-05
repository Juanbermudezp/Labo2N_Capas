package org.example.labo2.repository;

import org.example.labo2.domain.entity.Pirate;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface PirateRepository extends JpaRepository<Pirate, UUID> {
}
