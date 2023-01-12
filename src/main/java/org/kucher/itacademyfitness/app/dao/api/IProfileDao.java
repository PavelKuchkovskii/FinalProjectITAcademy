package org.kucher.itacademyfitness.app.dao.api;

import org.kucher.itacademyfitness.app.dao.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IProfileDao extends JpaRepository<Profile, UUID> {
}
