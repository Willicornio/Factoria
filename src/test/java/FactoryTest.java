import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class FactoryTest {


    Command command;

    @Before
    public void setUp() {
    }


    @After
    public void setDown(){
        command = null;
    }

    @Test
    public void testFactory(){

        command = CommandFactory.getInstance().getCommand("C1");
        Assert.assertEquals("C1",command.execute());
        command = CommandFactory.getInstance().getCommand("C2");
        Assert.assertEquals("C2",command.execute());
        command = CommandFactory.getInstance().getCommand("C1");
        Assert.assertEquals("C1",command.execute());
        command = CommandFactory.getInstance().getCommand("C2");
        Assert.assertEquals("C2",command.execute());

    }
}
