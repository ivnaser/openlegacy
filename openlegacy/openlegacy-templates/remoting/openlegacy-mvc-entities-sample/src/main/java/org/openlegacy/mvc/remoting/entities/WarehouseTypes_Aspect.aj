// WARNING: DO NOT EDIT THIS FILE.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.openlegacy.mvc.remoting.entities;

import org.openlegacy.mvc.remoting.entities.WarehouseTypes.WarehouseTypesRecord;
import org.openlegacy.terminal.ScreenEntity;

import java.io.Serializable;
import java.util.List;

privileged aspect WarehouseTypes_Aspect {

	declare parents: WarehouseTypes implements ScreenEntity, Serializable;
	private String WarehouseTypes.focusField;

	public List<WarehouseTypesRecord> WarehouseTypes.getWarehouseTypesRecords() {
		return this.warehouseTypesRecords;
	}

	public String WarehouseTypes.getFocusField() {
		return focusField;
	}

	public void WarehouseTypes.setFocusField(String focusField) {
		this.focusField = focusField;
	}

}
