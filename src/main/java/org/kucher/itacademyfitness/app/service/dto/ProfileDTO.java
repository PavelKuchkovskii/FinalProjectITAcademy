package org.kucher.itacademyfitness.app.service.dto;

import org.kucher.itacademyfitness.app.dao.entity.User;
import org.kucher.itacademyfitness.app.dao.entity.enums.EActivityType;
import org.kucher.itacademyfitness.app.dao.entity.enums.ESex;

import java.time.LocalDateTime;
import java.util.UUID;

public class ProfileDTO {

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

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public LocalDateTime getDtCreate() {
        return dtCreate;
    }

    public void setDtCreate(LocalDateTime dtCreate) {
        this.dtCreate = dtCreate;
    }

    public LocalDateTime getDtUpdate() {
        return dtUpdate;
    }

    public void setDtUpdate(LocalDateTime dtUpdate) {
        this.dtUpdate = dtUpdate;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public LocalDateTime getDtBirthday() {
        return dtBirthday;
    }

    public void setDtBirthday(LocalDateTime dtBirthday) {
        this.dtBirthday = dtBirthday;
    }

    public double getTarget() {
        return target;
    }

    public void setTarget(double target) {
        this.target = target;
    }

    public EActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(EActivityType activityType) {
        this.activityType = activityType;
    }

    public ESex getSex() {
        return sex;
    }

    public void setSex(ESex sex) {
        this.sex = sex;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
