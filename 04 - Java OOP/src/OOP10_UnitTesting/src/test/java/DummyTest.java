import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class DummyTest {

    private Dummy target;
    private Axe axe;

    @Before
    private void initValues(){
        this.target = new Dummy(20, 10);
        this.axe = new Axe(10, 10);
    }

    @Test
    public void dummyShouldLooseHealthIfAttacked(){

        this.axe.attack(target);

        Assert.assertEquals(10, target.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyThrowsExceptionIfAttacked(){
        this.axe.attack(this.target);
        this.axe.attack(this.target);
        this.axe.attack(this.target);
    }

    @Test
    public void deadDummyCanGiveXP(){
        this.axe.attack(this.target);
        this.axe.attack(this.target);

        int actual = this.target.giveExperience();

        Assert.assertEquals(10, actual);
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyCantGiveXP(){

        this.axe.attack(target);

        int actual = this.target.giveExperience();

    }

}
