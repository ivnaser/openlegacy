package org.openlegacy.terminal.modules.login;

import com.someorg.examples.screens.ItemsList;
import com.someorg.examples.screens.SignOn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openlegacy.AbstractTest;
import org.openlegacy.Snapshot;
import org.openlegacy.modules.login.Login;
import org.openlegacy.modules.trail.SessionTrail;
import org.openlegacy.modules.trail.Trail;
import org.openlegacy.terminal.ScreenPosition;
import org.openlegacy.terminal.TerminalSnapshot;
import org.openlegacy.terminal.mock.MockTerminalScreen;
import org.openlegacy.terminal.spi.ScreensRecognizer;
import org.openlegacy.terminal.support.SimpleScreenPosition;
import org.openlegacy.terminal.support.TerminalOutgoingSnapshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import junit.framework.Assert;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultLoginModuleTest extends AbstractTest {

	@Autowired
	private ScreensRecognizer screensRecognizer;

	@Test
	public void testLoginObject() {
		SignOn signOn = terminalSession.getEntity(SignOn.class);
		signOn.setUser("someuser");
		signOn.setPassword("somepwd");
		terminalSession.getModule(Login.class).login(signOn);

		assertLoginPeformed();
	}

	@Test
	public void testLoginSimple() {
		terminalSession.getModule(Login.class).login("someuser", "somepwd");

		assertLoginPeformed();
	}

	@Test
	public void testLogoff() {
		terminalSession.getModule(Login.class).login("someuser", "somepwd");

		Assert.assertTrue(terminalSession.isConnected());
		Assert.assertTrue(terminalSession.getModule(Login.class).isLoggedIn());

		ItemsList itemsList = terminalSession.getEntity(ItemsList.class);
		Assert.assertNotNull(itemsList);

		terminalSession.getModule(Login.class).logoff();

		Assert.assertFalse(terminalSession.getModule(Login.class).isLoggedIn());
		Assert.assertFalse(terminalSession.isConnected());

		SessionTrail<? extends Snapshot> trail = terminalSession.getModule(Trail.class).getSessionTrail();
		Snapshot lastSnapshot = trail.getSnapshots().get(trail.getSnapshots().size() - 1); // get the last snapshot

		Class<?> lastSnapshotClass = screensRecognizer.match(new MockTerminalScreen((TerminalSnapshot)lastSnapshot));

		Assert.assertEquals(lastSnapshotClass, SignOn.class);

	}

	private void assertLoginPeformed() {
		SessionTrail<? extends Snapshot> trail = terminalSession.getModule(Trail.class).getSessionTrail();
		Assert.assertEquals(2, trail.getSnapshots().size());
		Snapshot loginSnapshot = trail.getSnapshots().get(0);
		Assert.assertEquals(loginSnapshot.getClass(), TerminalOutgoingSnapshot.class);

		Map<ScreenPosition, String> fields = ((TerminalOutgoingSnapshot)loginSnapshot).getTerminalSendAction().getFields();
		Set<ScreenPosition> fieldPositions = fields.keySet();
		Iterator<ScreenPosition> iterator = fieldPositions.iterator();

		ScreenPosition firstPosition = iterator.next();
		Assert.assertEquals(new SimpleScreenPosition(6, 53), firstPosition);
		Assert.assertEquals("someuser", fields.get(firstPosition));

		ScreenPosition secondPosition = iterator.next();
		Assert.assertEquals(new SimpleScreenPosition(7, 53), secondPosition);
		Assert.assertEquals("somepwd", fields.get(secondPosition));

		Assert.assertTrue(terminalSession.getModule(Login.class).isLoggedIn());
	}
}