package com.alam.mastermind.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.alam.mastermind.dto.Game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class GameDaoDB implements GameDao{

    @Autowired
    JdbcTemplate jdbc;

    @Override
    @Transactional
    public Game add(Game game) {
        final String INSERT_GAME = "INSERT INTO Game(answer) VALUES(?)";
        jdbc.update(INSERT_GAME,
                game.getAnswer());

        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        game.setId(newId);
        return game;
    }

    @Override
    public List<Game> getAll() {
        final String SELECT_ALL_GAMES = "SELECT * FROM Game";
        return jdbc.query(SELECT_ALL_GAMES, new GameMapper());
    }

    @Override
    public Game getGameById(int id) {
        try{
            final String SELECT_GAME_BY_ID = "SELECT * FROM Game WHERE gameId = ?";
            return jdbc.queryForObject(SELECT_GAME_BY_ID, new GameMapper(), id);
        }catch(DataAccessException e){
            return null;
        }
    }

    @Override
    public void update(Game game) {
        final String UPDATE_GAME = "UPDATE Game SET inProgress = ? WHERE gameId = ?";

        jdbc.update(UPDATE_GAME, game.getInProgress(), game.getId());
    }

    public static final class GameMapper implements RowMapper<Game>{
        @Override
        public Game mapRow(ResultSet rs, int index) throws SQLException{
            Game game = new Game();
            game.setId(rs.getInt("gameId"));
            game.setInProgress(rs.getBoolean("inProgress"));
            game.setAnswer(rs.getString("answer"));

            return game;
        }
    }
    
}
