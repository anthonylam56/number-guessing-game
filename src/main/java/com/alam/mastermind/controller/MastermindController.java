package com.alam.mastermind.controller;

import java.util.List;

import com.alam.mastermind.dto.Game;
import com.alam.mastermind.dto.Round;
import com.alam.mastermind.service.ServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MastermindController {

    @Autowired
    ServiceInterface service;

    @PostMapping("/begin")
    @ResponseStatus(HttpStatus.CREATED)
    public int createGame(){
        return service.startGame();
    }

    @PostMapping("/guess")
    public Round makeGuess(@RequestBody Round round){
        return service.makeGuess(round);
    }

    @GetMapping("/game")
    public List<Game> getAllGames(){
        return service.getAllGames();
    }

    @GetMapping("game/{gameId}")
    public Game getGameById(@PathVariable("gameId") int id){
        return service.getGameById(id);

    }

    @GetMapping("rounds/{roundId}")
    public List<Round> getRoundsByGameId(@PathVariable("roundId") int id){
        return service.getAllRoundsByGameId(id);
    }
}
