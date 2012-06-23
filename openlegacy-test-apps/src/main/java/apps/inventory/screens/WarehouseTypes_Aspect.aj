// WARNING: DO NOT EDIT THIS FILE.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package apps.inventory.screens;

import java.util.List;
import org.openlegacy.terminal.ScreenEntity;

privileged aspect WarehouseTypes_Aspect {
    
    declare parents: WarehouseTypes implements ScreenEntity;
    private String WarehouseTypes.focusField;
    
	
    

    public List<WarehouseTypeRow> WarehouseTypes.getWarehouseTypeRows(){
    	return this.warehouseTypeRows;
    }
    


    public String WarehouseTypes.getFocusField(){
    	return focusField;
    }
    public void WarehouseTypes.setFocusField(String focusField){
    	this.focusField = focusField;
    }
    
}
