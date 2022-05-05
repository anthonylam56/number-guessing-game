package com.alam.mastermind.dto;

import java.util.Objects;

public class Game {
    
    private int id;
    private boolean inProgress;
    private String answer;
    
    public Game(){
        
    }
    
    public Game(String answer, boolean inProgress){
        this.inProgress = inProgress;
        this.answer = answer;
    }
    
    public Game(int id, String answer, boolean inProgress){
        this.id = id;
        this.inProgress = inProgress;
        this.answer = answer;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getInProgress() {
        return this.inProgress;
    }

    public void setInProgress(boolean inProgress) {
        this.inProgress = inProgress;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Game)) {
            return false;
        }
        Game game = (Game) o;
        return id == game.id && inProgress == game.inProgress && Objects.equals(answer, game.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, inProgress, answer);
    }


}
