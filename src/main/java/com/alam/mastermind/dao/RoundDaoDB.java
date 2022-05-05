package com.alam.mastermind.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.alam.mastermind.dto.Round;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RoundDaoDB implements RoundDao{
    
    @Autowired
    JdbcTemplate jdbc;

    @Override
    @Transactional
    public Round add(Round round) {
        final String INSERT_ROUND = "INSERT INTO Round(guess, result, gameId) VALUES(?,?,?)";
        jdbc.update(INSERT_ROUND, round.getGuess(), round.getResult(), round.getGameId());

        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        round.setId(newId);
        return round;
    }

    @Override
    public List<Round> getAll() {
        final String SELECT_ALL_ROUNDS = "SELECT * FROM Round";
        return jdbc.query(SELECT_ALL_ROUNDS, new RoundMapper());
    }

    @Override
    public Round getRoundById(int id) {
        try{
            final String SELECT_ROUND_BY_ID = "SELECT * FROM Round WHERE roundId = ?";
            return jdbc.queryForObject(SELECT_ROUND_BY_ID, new RoundMapper(), id);
        }catch(DataAccessException e){
            return null;
        }
    }
    
    @Override
    public List<Round> getAllRoundsByGameId(int id){
        try{
            final String SELECT_ROUNDS_BY_GAME_ID = "SELECT * FROM Round " +
                "WHERE gameId = ? ORDER by timeStamp";

                return jdbc.query(SELECT_ROUNDS_BY_GAME_ID, new RoundMapper(), id);
        }catch(DataAccessException e){
            return null;
        }
    }

    public static final class RoundMapper implements RowMapper<Round>{
        @Override
        public Round mapRow(ResultSet rs, int index) throws SQLException{
            Round round = new Round();
            round.setId(rs.getInt("roundId"));
            round.setResult(rs.getString("result"));
            round.setTimeStamp(rs.getTimestamp("timeStamp").toLocalDateTime());
            round.setGuess(rs.getString("guess"));
            round.setGameId(rs.getInt("gameid"));

            return round;
        }
    }
    
}
