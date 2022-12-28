package org.kucher.itacademyfitness.app.dao.api;

import org.kucher.itacademyfitness.app.dao.entity.JournalFood;
import org.kucher.itacademyfitness.app.dao.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IJournalFoodDao extends JpaRepository<JournalFood, UUID> {
}
