package org.kucher.itacademyfitness.app.dao.entity;

import org.kucher.itacademyfitness.app.dao.entity.api.IComposition;

import javax.persistence.*;
@Entity
@Table(name = "composition")
public class Composition implements IComposition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "weight")
    private int weight;

    public Composition() {
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public Product getProduct() {
        return this.product;
    }

    @Override
    public int getWeight() {
        return this.weight;
    }

}
