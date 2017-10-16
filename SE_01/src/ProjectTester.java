import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class ProjectTester {
	
	@Before
	public void preserved(){
	ProjOrder smallStr = new ProjOrder(new String[][]{{"A","B"},{"B","D"},{"D","C"}});
	ProjOrder longStr = new ProjOrder(new String[][]{{"F","A"},{"E","B"},{"D","C"},{"G","H"}});
	ProjOrder equal = new ProjOrder(new String [][]{{"B","B"}});	
	}
	
	@Test
	public void test_smallStr() {
		assertTrue(smallStr.isWellSortet(new String[]{"A","B","D","C"}));
	}
	
	@Test
	public void test_smallStr_2() {
		assertFalse(smallStr.isWellSortet(new String[]{"A","B","C","D"}));
	}
	
	@Test
	public void test_longStr() {
		assertTrue(longStr.isWellSortet(new String[]{"F","E","D","C","B","A","G","H"}));
	}
	
	@Test
	public void test_longStr_2() {
		assertFalse(longStr.isWellSortet(new String[]{"F","A","D","C","B","E","G","H"}));
	}
	
	@Test
	public void test_equal() {
		assertTrue(equal.isWellSortet(new String[]{"C","B"}));
	}

	@Test
	public void test_equal_2() {
		assertFalse(equal.isWellSortet(new String[]{"A","B"}));
	}
}