package com.gameloft.repository;

import com.gameloft.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unused")
@Repository
public interface PlayerRepository extends JpaRepository<Player, String> {
}
