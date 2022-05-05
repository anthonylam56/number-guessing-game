package com.alam.mastermind.dao;

import java.util.List;
import com.alam.mastermind.dto.Round;

import org.springframework.stereotype.Repository;

@Repository
public interface RoundDao {
    public Round add(Round round);

    public List<Round> getAll();

    public Round getRoundById(int id);

    public List<Round> getAllRoundsByGameId(int id);
}
