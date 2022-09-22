import org.testng.Assert;
import org.testng.annotations.*;

public class FrogJmpTest {
    private FrogJmp solution;
 
  @BeforeTest
  public void setUp() {
    solution = new FrogJmp();
  }
 
  @DataProvider(name = "test1")
  public Object [][] createData1() {
    return new Object [][] {
      new Object [] { new int [] {    10,      85,     30 },   3 },
      new Object [] { new int [] {     1,      14,      3 },   5 },
      new Object [] { new int [] {   100,    1001,    100 },  10 },
      new Object [] { new int [] {150000,  999999,  10000 },  85 },
      new Object [] { new int [] {150000, 1000000,  10000 },  85 },
     
      //X and Y are the same - no jumps required
      new Object [] { new int [] {     14,      14,      3 },   0 },
    };
  }

  @org.testng.annotations.Test(dataProvider = "test1")
  public void verifySolution(int [] pArgs, int pExpectedJumps) {
    Assert.assertEquals(solution.solution(pArgs[0], pArgs[1], pArgs[2]), pExpectedJumps);
  }
}
