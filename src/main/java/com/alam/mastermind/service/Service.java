package com.alam.mastermind.service;

import java.util.List;
import java.util.Random;

import com.alam.mastermind.dao.GameDao;
import com.alam.mastermind.dao.RoundDao;
import com.alam.mastermind.dto.Game;
import com.alam.mastermind.dto.Round;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Service implements ServiceInterface{
    
    @Autowired
    GameDao gameDao;
    
    @Autowired
    RoundDao roundDao;
    
    /*
    @Autowired
    public Service(GameDao gameDao, RoundDao roundDao){
        this.gameDao = gameDao;
        this.roundDao = roundDao;
    }*/

    public Game addGame(Game game){
        return gameDao.add(game);
    }
    
    @Override
    public int startGame(){
        Game game = new Game();
        game.setAnswer(generateAnswer());
        game = gameDao.add(game);

        return game.getId();
    }
    
    @Override
    public Round makeGuess(Round round){        
        Game game = gameDao.getGameById(round.getGameId());
        String answer = game.getAnswer();
        String guess = round.getGuess();
        round.setResult(generateResult(guess, answer));
        
        if(answer.equals(guess)){
            //Game game = gameDao.getGameById(round.getGameId());
            game.setInProgress(false);
            gameDao.update(game);
        }
        
        return roundDao.add(round);
    }
    
    @Override
    public Game getGameById(int id){
        Game game = gameDao.getGameById(id);
        if(game.getInProgress()){
            game.setAnswer("****");
        }

        return game;
    }
    
    @Override
    public List<Game> getAllGames(){
        List<Game> gamesList = gameDao.getAll();
        for (Game game : gamesList){
            if (game.getInProgress()){
                game.setAnswer("****");
            }
        }
        return gameDao.getAll();
    }

    public List<Round> getAllRoundsByGameId(int gameId){
        return roundDao.getAllRoundsByGameId(gameId);
    }

    public String generateResult(String guess, String answer){
        char[] guessChars = guess.toCharArray();
        char[] answerChars = answer.toCharArray();
        int exact = 0;
        int partial = 0;

        for (int i = 0; i < guessChars.length; i++){
            if(answer.indexOf(guessChars[i]) != -1){
                if(guessChars[i] == answerChars[i]){
                    exact++;
                }else{
                    partial++;
                }
            }
        }

        return "e:" + exact + ":p:" + partial;
    }

    //generate random number for the answer in a game
    //no repeating digits
    private String generateAnswer(){
        Random rand = new Random();

        int firstDigit = rand.nextInt(10);
        
        int secondDigit = rand.nextInt(10);
        while(secondDigit == firstDigit){
            secondDigit = rand.nextInt(10);
        }

        int thirdDigit = rand.nextInt(10);
        while(thirdDigit == firstDigit || thirdDigit == secondDigit){
            thirdDigit = rand.nextInt(10);
        }

        int fourthDigit = rand.nextInt(10);
        while(fourthDigit == thirdDigit || fourthDigit == secondDigit || fourthDigit == firstDigit){
            fourthDigit = rand.nextInt(10);
        }

        
        String answer = String.valueOf(firstDigit) + String.valueOf(secondDigit) + 
            String.valueOf(thirdDigit) + String.valueOf(fourthDigit);

        return answer;
    }
}
