package org.kucher.itacademyfitness.app.dao.entity.api;

public interface IDish extends IEssence{

    String getTitle();

    IDishComposition getComposition();
}
