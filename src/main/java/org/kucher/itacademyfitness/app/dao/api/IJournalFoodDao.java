package org.kucher.itacademyfitness.app.dao.api;

import org.kucher.itacademyfitness.app.dao.entity.JournalFood;
import org.kucher.itacademyfitness.app.dao.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IJournalFoodDao extends JpaRepository<JournalFood, UUID> {
    Page<JournalFood> findAllByProfile_Uuid(UUID profile_uuid, Pageable pageable);
}
