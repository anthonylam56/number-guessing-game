
import com.alam.mastermind.TestApplicationConfiguration;
import com.alam.mastermind.dao.GameDao;
import com.alam.mastermind.dto.Game;
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
public class GameDaoDBTest{

    @Autowired
    GameDao gameDao;
    
    public GameDaoDBTest(){
    }
    
    @Test
    public void testAddGetGame(){
        /*
        Game game1 = new Game();
        game1.setAnswer("0123");
        game1.setInProgress(false);
        
        
        
        Game game2 = new Game();
        game2.setAnswer("4567");
        game2.setInProgress(false);
        
        gameDao.add(game1);
        gameDao.add(game2);
        
        List<Game> gamesList = gameDao.getAll();
        
        assertEquals(2, gamesList.size());
        assertEquals(game1, gamesList.get(0));
        assertEquals(game2, gamesList.get(1));
        
        assertNotNull(gameDao.getGameById(game1.getId()));
        assertNotNull(gameDao.getGameById(game2.getId()));
        */
    }
}