package org.kucher.itacademyfitness.app.dao.entity.api;

import org.kucher.itacademyfitness.app.dao.entity.User;
import org.kucher.itacademyfitness.app.dao.entity.enums.EActivityType;
import org.kucher.itacademyfitness.app.dao.entity.enums.ESex;

import java.time.LocalDateTime;
import java.util.Date;

public interface IProfile extends IEssence{

    int getHeight();
    double getWeight();
    Date getDtBirthday();
    double getTarget();
    EActivityType getActivityType();
    ESex getSex();
    User getUser();
}
