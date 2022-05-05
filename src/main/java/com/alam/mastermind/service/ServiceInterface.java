package com.alam.mastermind.service;

import java.util.List;

import com.alam.mastermind.dto.Game;
import com.alam.mastermind.dto.Round;

public interface ServiceInterface {

    public Game addGame(Game game);

    public int startGame();

    public Round makeGuess(Round round);

    public Game getGameById(int id);
    
    public List<Game> getAllGames();

    public List<Round> getAllRoundsByGameId(int gameId);
}
