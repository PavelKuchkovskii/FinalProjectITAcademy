package org.kucher.itacademyfitness.app.dao.api;

import org.kucher.itacademyfitness.app.dao.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface IRecipeDao extends JpaRepository<Recipe, UUID> {

}
