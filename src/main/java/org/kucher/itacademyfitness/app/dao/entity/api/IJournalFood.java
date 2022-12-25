package org.kucher.itacademyfitness.app.dao.entity.api;

import java.time.LocalDateTime;

public interface IJournalFood extends IEssence{

    LocalDateTime getDtSupply();

    IRecipe getRecipe();

    IProduct getProduct();

    int getWeight();

}
