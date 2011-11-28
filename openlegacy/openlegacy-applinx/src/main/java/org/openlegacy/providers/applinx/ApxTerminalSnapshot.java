package org.openlegacy.providers.applinx;

import com.sabratec.applinx.common.runtime.GXScreenPosition;
import com.sabratec.applinx.common.runtime.field.GXIField;
import com.sabratec.applinx.common.runtime.screen.GXRuntimeScreen;

import org.openlegacy.terminal.ScreenPosition;
import org.openlegacy.terminal.ScreenSize;
import org.openlegacy.terminal.TerminalField;
import org.openlegacy.terminal.TerminalRow;
import org.openlegacy.terminal.TerminalSnapshot;
import org.openlegacy.terminal.support.SimpleScreenSize;
import org.openlegacy.terminal.utils.ScreenPainter;
import org.openlegacy.terminal.utils.TerminalEqualsHashcodeUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ApxTerminalSnapshot implements TerminalSnapshot {

	private final GXRuntimeScreen screen;
	private ArrayList<TerminalRow> rows;
	private ArrayList<TerminalField> fields;
	private ArrayList<ScreenPosition> fieldSeperators;
	private String text;

	public ApxTerminalSnapshot(GXRuntimeScreen screen) {
		this.screen = screen;
	}

	@Override
	public String toString() {
		return ScreenPainter.paint(this, true);
	}

	public String getText() {
		if (text != null) {
			return text;
		}
		text = new String(screen.getBuffers().getTextBuffer());
		return text;
	}

	public String getText(ScreenPosition position, int length) {
		int beginIndex = ((position.getRow() - 1) * getSize().getColumns()) + (position.getColumn() - 1);
		return getText().substring(beginIndex, beginIndex + length);
	}

	public TerminalField getField(ScreenPosition position) {
		GXIField field = screen.getFields().get(new GXScreenPosition(position.getRow(), position.getColumn(), screen.getSize()));
		return new ApxTerminalField(field);
	}

	public Object getDelegate() {
		return screen;
	}

	public Collection<TerminalField> getFields() {
		if (fields != null) {
			return fields;
		}

		@SuppressWarnings("unchecked")
		Collection<GXIField> apxInputFields = screen.getFields();

		fields = new ArrayList<TerminalField>();
		for (GXIField apxField : apxInputFields) {
			fields.add(new ApxTerminalField(apxField));
		}
		return fields;
	}

	public ScreenSize getSize() {
		return new SimpleScreenSize(screen.getSize().getHeight(), screen.getSize().getWidth());
	}

	public List<TerminalRow> getRows() {
		if (rows != null) {
			return rows;
		}

		@SuppressWarnings("unchecked")
		Collection<GXIField> apxFields = screen.getFields();
		rows = new ArrayList<TerminalRow>();

		ApxTerminalRow currentRow = new ApxTerminalRow(1);
		for (GXIField apxField : apxFields) {
			if (apxField.getPosition().getRow() > currentRow.getRowNumber()) {
				rows.add(currentRow);
				currentRow = new ApxTerminalRow(apxField.getPosition().getRow());
			}
			currentRow.getFields().add(new ApxTerminalField(apxField));
		}
		rows.add(currentRow);
		return rows;
	}

	public SnapshotType getSnapshotType() {
		return SnapshotType.INCOMING;
	}

	public List<ScreenPosition> getFieldSeperators() {
		if (fieldSeperators != null) {
			return fieldSeperators;
		}
		@SuppressWarnings("unchecked")
		List<GXScreenPosition> attributes = screen.getAttributePositions();

		fieldSeperators = new ArrayList<ScreenPosition>();
		for (Object object : attributes) {
			fieldSeperators.add(ApxPositionUtil.toScreenPosition((GXScreenPosition)object));
		}
		return fieldSeperators;

	}

	public ScreenPosition getCursorPosition() {
		return ApxPositionUtil.toScreenPosition(screen.getCursorPosition());
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

	public TerminalRow getRowByRowNumber(int rowNumber) {
		return getRows().get(rowNumber - 1);
	}

}