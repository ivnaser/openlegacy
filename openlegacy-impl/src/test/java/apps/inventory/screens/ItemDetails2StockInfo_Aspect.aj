// WARNING: DO NOT EDIT THIS FILE.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package apps.inventory.screens;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;
import apps.inventory.screens.ItemDetails2.StockInfo;

privileged @SuppressWarnings("unused") aspect StockInfoTable_Aspect {
    
    declare @type: StockInfo : @Component;
	declare @type: StockInfo : @Scope("prototype");
    
	
	
    
    public String StockInfo.getListPrice(){
    	return this.listPrice;
    }
    
    public void StockInfo.setListPrice(String listPrice){
    	this.listPrice = listPrice;
    }

    public String StockInfo.getStandardUnitCost(){
    	return this.standardUnitCost;
    }
    
    public void StockInfo.setStandardUnitCost(String standardUnitCost){
    	this.standardUnitCost = standardUnitCost;
    }

}
