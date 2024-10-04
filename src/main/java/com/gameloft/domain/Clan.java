package com.gameloft.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "clans")
@NoArgsConstructor
@AllArgsConstructor
public class Clan {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name", nullable = false)
    private String name;
}

