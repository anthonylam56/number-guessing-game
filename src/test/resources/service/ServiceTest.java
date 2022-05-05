
import com.alam.mastermind.TestApplicationConfiguration;
import com.alam.mastermind.service.Service;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author anthonylam
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class ServiceTest {
    
    @Autowired
    Service service;
    
    public ServiceTest(){
    }
        
    @Test
    public void detrmineResultsTest(){
        assertEquals("e:0:p:3", service.generateResult("3829", "8295"));
        assertEquals("e:4:p:0", service.generateResult("3829", "3829"));
        assertEquals("e:3:p:0", service.generateResult("3829", "3820"));
        assertEquals("e:2:p:2", service.generateResult("3829", "3892"));
        assertEquals("e:1:p:3", service.generateResult("3829", "3982"));
    }
}
