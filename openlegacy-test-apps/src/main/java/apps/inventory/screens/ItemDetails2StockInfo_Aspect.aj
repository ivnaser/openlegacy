// WARNING: DO NOT EDIT THIS FILE.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package apps.inventory.screens;

import apps.inventory.screens.ItemDetails2.StockInfo;

privileged aspect StockInfoTable_Aspect {
    
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
