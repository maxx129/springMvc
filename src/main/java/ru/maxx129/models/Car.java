package ru.maxx129.models;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "owner")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    private String model;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

}
