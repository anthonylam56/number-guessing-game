package com.alam.mastermind.dao;

import java.util.List;
import com.alam.mastermind.dto.Game;

import org.springframework.stereotype.Repository;

@Repository
public interface GameDao {
    public Game add(Game game);

    public List<Game> getAll();

    public Game getGameById(int id);

    public void update(Game game);
}
