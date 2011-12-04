package org.openlegacy.terminal.support;

import org.openlegacy.terminal.TerminalSnapshot;
import org.openlegacy.terminal.utils.ScreenPainter;
import org.openlegacy.terminal.utils.TerminalEqualsHashcodeUtil;

public abstract class AbstractSnapshot implements TerminalSnapshot {

	@Override
	public String toString() {
		return ScreenPainter.paint(this, true);
	}

	@Override
	public int hashCode() {
		return TerminalEqualsHashcodeUtil.snapshotHashcode(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof TerminalSnapshot)) {
			return false;
		}
		return TerminalEqualsHashcodeUtil.snapshotsEquals(this, (TerminalSnapshot)obj);
	}
}