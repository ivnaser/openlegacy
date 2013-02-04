package tests;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openlegacy.terminal.TerminalSession;
import org.springframework.test.context.ContextConfiguration;
import org.openlegacy.terminal.actions.TerminalActions;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test1.WarehouseTypes;  

@ContextConfiguration("/META-INF/spring/applicationContext-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class Demo_sessionTest {

	@Inject
	private TerminalSession terminalSession;
	
	@Test
	public void testSession(){

		 WarehouseTypes warehouseTypes = terminalSession.getEntity(WarehouseTypes.class);
				
	}
}
