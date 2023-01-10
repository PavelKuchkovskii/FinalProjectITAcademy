package org.kucher.itacademyfitness.app.dao.entity.api;

import org.kucher.itacademyfitness.app.dao.entity.User;
import org.kucher.itacademyfitness.app.dao.entity.enums.EActivityType;
import org.kucher.itacademyfitness.app.dao.entity.enums.ESex;

import java.time.LocalDateTime;

public interface IProfile extends IEssence{

    int getHeight();
    double getWeight();
    LocalDateTime getDtBirthday();
    double getTarget();
    EActivityType getActivityType();
    ESex getSex();
    User getUser();
}
