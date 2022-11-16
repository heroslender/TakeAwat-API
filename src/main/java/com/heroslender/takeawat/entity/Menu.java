package com.heroslender.takeawat.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties("id")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "menu_id_seq")
    @SequenceGenerator(name = "menu_id_seq", sequenceName = "menu_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private String date;

    @Column(name = "price")
    private double price;

    @Column(name = "halfPrice")
    private double halfPrice;

    @Column(name = "description")
    private String description;

    public Menu(String name, String date, double price, double halfPrice, String description) {
        this.name = name;
        this.date = date;
        this.price = price;
        this.halfPrice = halfPrice;
        this.description = description;
    }
}
