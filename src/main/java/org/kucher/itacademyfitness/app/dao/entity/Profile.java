package org.kucher.itacademyfitness.app.dao.entity;

import org.kucher.itacademyfitness.app.dao.entity.api.IProfile;
import org.kucher.itacademyfitness.app.dao.entity.enums.EActivityType;
import org.kucher.itacademyfitness.app.dao.entity.enums.ESex;

import java.time.LocalDateTime;
import java.util.UUID;

public class Profile implements IProfile {

    private UUID uuid;
    private LocalDateTime dtCreate;
    private LocalDateTime dtUpdate;
    private int height;
    private double weight;
    private LocalDateTime dtBirthday;
    private double target;
    private EActivityType activityType;
    private ESex sex;
    private User user;

    @Override
    public UUID getUuid() {
        return uuid;
    }

    @Override
    public LocalDateTime getDtCreate() {
        return dtCreate;
    }

    @Override
    public LocalDateTime getDtUpdate() {
        return dtUpdate;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public LocalDateTime getDtBirthday() {
        return dtBirthday;
    }

    @Override
    public double getTarget() {
        return target;
    }

    @Override
    public EActivityType getActivityType() {
        return activityType;
    }

    @Override
    public ESex getSex() {
        return sex;
    }

    @Override
    public User getUser() {
        return user;
    }
}
