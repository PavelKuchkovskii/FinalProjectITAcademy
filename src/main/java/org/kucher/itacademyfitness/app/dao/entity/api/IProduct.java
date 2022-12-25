package org.kucher.itacademyfitness.app.dao.entity.api;

public interface IProduct extends IEssence{

    String getTitle();
    int getCalories();
    int getFats();
    int getCarbohydrates();
    int getWeight();
    double getProteins();
}
