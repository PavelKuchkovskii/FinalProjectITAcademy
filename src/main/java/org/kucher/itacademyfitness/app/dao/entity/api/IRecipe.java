package org.kucher.itacademyfitness.app.dao.entity.api;

import org.kucher.itacademyfitness.app.dao.entity.Composition;

import java.util.List;

public interface IRecipe extends IEssence{

    String getTitle();

    List<Composition> getComposition();
}
