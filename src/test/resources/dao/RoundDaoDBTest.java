
import com.alam.mastermind.TestApplicationConfiguration;
import com.alam.mastermind.dao.GameDao;
import com.alam.mastermind.dao.RoundDao;
import com.alam.mastermind.dto.Game;
import com.alam.mastermind.dto.Round;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class RoundDaoDBTest {
    
    @Autowired
    RoundDao roundDao;
    
    @Autowired
    GameDao gameDao;
    
    public RoundDaoDBTest(){
    }
        
    @Test
    public void testMakeGuess(){
        Game game1 = new Game();
        game1.setInProgress(true);
        game1.setAnswer("3425");
        
        gameDao.add(game1);
        
        assertEquals(game1.getId(),1);
        assertEquals(game1.getAnswer(), "3425");
        
        
        Round r = new Round();
        r.setResult("e:0:p:0");
        r.setGuess("9876");
        r.setGameId(game1.getId());
        
        roundDao.add(r);
        
        Game tempGame = gameDao.getGameById(r.getGameId());
        
        assertEquals(r.getGameId(), 1);
        assertEquals(tempGame, game1);
        assertNotNull(tempGame.getAnswer());
        /*
        Round r1 = new Round();
        r1.setResult("e:1:p:0");
        r1.setGuess("9875");
        r1.setGameId(game1.getId());
        
        roundDao.add(r);
        roundDao.add(r1);
        
        List<Round> roundsList = roundDao.getAll();
        
        assertNotNull(r);
        assertNotNull(r1);
        
        assertEquals(2, roundsList.size());
        assertNotNull(roundDao.getRoundById(r.getId()));
        assertNotNull(roundDao.getRoundById(r1.getId()));*/
    }
}