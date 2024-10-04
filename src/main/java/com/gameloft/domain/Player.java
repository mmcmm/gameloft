package com.gameloft.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
@Builder(toBuilder = true)
@EqualsAndHashCode(of = "playerId")
@Entity
@Table(name = "players")
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    @Id
    @Column(name = "player_id", nullable = false, unique = true)
    private String playerId;

    @Column(name = "credential", nullable = false)
    private String credential;

    @Column(name = "created", nullable = false)
    private ZonedDateTime created;

    @Column(name = "modified", nullable = false)
    private ZonedDateTime modified;

    @Column(name = "last_session", nullable = false)
    private ZonedDateTime lastSession;

    @Column(name = "total_spent", nullable = false)
    private int totalSpent;

    @Column(name = "total_refund", nullable = false)
    private int totalRefund;

    @Column(name = "total_transactions", nullable = false)
    private int totalTransactions;

    @Column(name = "last_purchase", nullable = false)
    private ZonedDateTime lastPurchase;

    @ToString.Exclude
    @ElementCollection
    @CollectionTable(name = "active_campaigns", joinColumns = @JoinColumn(name = "player_id"))
    @Column(name = "campaign")
    private List<String> activeCampaigns;

    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "player_id")
    private List<Device> devices;

    @Column(name = "level", nullable = false)
    private int level;

    @Column(name = "xp", nullable = false)
    private int xp;

    @Column(name = "total_playtime", nullable = false)
    private int totalPlaytime;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "language", nullable = false)
    private String language;

    @Column(name = "birthdate", nullable = false)
    private ZonedDateTime birthdate;

    @Column(name = "gender", nullable = false)
    private String gender;

    @ToString.Exclude
    @ElementCollection
    @CollectionTable(name = "inventory", joinColumns = @JoinColumn(name = "player_id"))
    @MapKeyColumn(name = "item_name")
    @Column(name = "quantity")
    private Map<String, Integer> inventory;

    @ToString.Exclude
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "clan_id", referencedColumnName = "id")
    private Clan clan;

    @Column(name = "custom_field")
    private String customField;
}
