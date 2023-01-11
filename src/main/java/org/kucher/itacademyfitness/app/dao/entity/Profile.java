package org.kucher.itacademyfitness.app.dao.entity;

import org.kucher.itacademyfitness.app.dao.entity.api.IProfile;
import org.kucher.itacademyfitness.app.dao.entity.enums.EActivityType;
import org.kucher.itacademyfitness.app.dao.entity.enums.ESex;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Profile implements IProfile {

    @Id
    private UUID uuid;
    @Column(name = "dt_create")
    private LocalDateTime dtCreate;
    @Column(name = "dt_update")
    private LocalDateTime dtUpdate;
    @Column(name = "height")
    private int height;
    @Column(name = "weight")
    private double weight;
    @Column(name = "dt_birthday")
    private LocalDateTime dtBirthday;
    @Column(name = "target")
    private double target;
    @Column(name = "activity_type")
    private EActivityType activityType;
    @Column(name = "sex")
    private ESex sex;
    @Embedded
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
