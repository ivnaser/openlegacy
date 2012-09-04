package org.openlegacy.terminal.layout.support;

import org.openlegacy.terminal.definitions.ScreenFieldDefinition;

public class DefaultBidiScreenPageBuilder extends DefaultScreenPageBuilder {

	@Override
	protected int calculateStartColumn(ScreenFieldDefinition field) {
		return field.getPosition().getColumn();
	}

	@Override
	protected int calculateEndColumn(ScreenFieldDefinition field) {
		if (field.getLabelPosition() != null) {
			int totalFieldLength = field.getLabelPosition().getColumn() + field.getDisplayName().length()
					+ getLabelFieldDistance();
			return totalFieldLength + getAdditionalPartWidth();
		} else {
			int fieldEndColumn = field.getLength() > 0 ? field.getEndPosition().getColumn() : field.getPosition().getColumn()
					+ getDefaultFieldLength();
			return fieldEndColumn + getAdditionalPartWidth();
		}
	}

}
