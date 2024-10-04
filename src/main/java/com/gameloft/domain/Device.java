package com.gameloft.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@ToString
@Builder(toBuilder = true)
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "devices")
@NoArgsConstructor
@AllArgsConstructor
public class Device {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "carrier", nullable = false)
    private String carrier;

    @Column(name = "firmware", nullable = false)
    private String firmware;
}
