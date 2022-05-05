package com.alam.mastermind.dto;

import java.time.*;
import java.util.Objects;

public class Round {
    private int id;
    private String guess;
    private String result;
    private LocalDateTime timeStamp;
    private int gameId;
    
    public Round(){
        
    }
    
    public Round(int gameId, String guess){
        this.gameId = gameId;
        this.guess = guess;
    }
    

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGuess() {
        return this.guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public LocalDateTime getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getGameId() {
        return this.gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Round)) {
            return false;
        }
        Round round = (Round) o;
        return id == round.id && Objects.equals(guess, round.guess) && Objects.equals(result, round.result) && Objects.equals(timeStamp, round.timeStamp) && gameId == round.gameId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, guess, result, timeStamp, gameId);
    }
    
}
