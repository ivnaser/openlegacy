// WARNING: DO NOT EDIT THIS FILE.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package org.openlegacy.terminal.samples.model;

import java.util.*;
import org.openlegacy.terminal.ScreenEntity;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;

privileged @SuppressWarnings("unused") aspect WorkWithWarehouseDetails1_Aspect {
    
    declare @type: WorkWithWarehouseDetails1 : @Component;
	declare @type: WorkWithWarehouseDetails1 : @Scope("prototype");
    

    declare parents: WorkWithWarehouseDetails1 implements ScreenEntity;
    private String WorkWithWarehouseDetails1.focusField;
    
	

	

	

	

	

	

	

	

	

    private Map<Object,Object> WorkWithWarehouseDetails1.warehouseTypeValues;
	

    

    public String WorkWithWarehouseDetails1.getAmendedBy(){
    	return this.amendedBy;
    }
    



    public Date WorkWithWarehouseDetails1.getAmendedDate(){
    	return this.amendedDate;
    }
    
    public void WorkWithWarehouseDetails1.setAmendedDate(Date amendedDate){
    	this.amendedDate = amendedDate;
    }



    public Integer WorkWithWarehouseDetails1.getCostingType(){
    	return this.costingType;
    }
    
    public void WorkWithWarehouseDetails1.setCostingType(Integer costingType){
    	this.costingType = costingType;
    }

    public String WorkWithWarehouseDetails1.getAddress(){
    	return this.address;
    }
    
    public void WorkWithWarehouseDetails1.setAddress(String address){
    	this.address = address;
    }


    public String WorkWithWarehouseDetails1.getCreatedBy(){
    	return this.createdBy;
    }
    



    public String WorkWithWarehouseDetails1.getCreatedDate(){
    	return this.createdDate;
    }
    



    public String WorkWithWarehouseDetails1.getReplenishmentCycleFlag(){
    	return this.replenishmentCycleFlag;
    }
    
    public void WorkWithWarehouseDetails1.setReplenishmentCycleFlag(String replenishmentCycleFlag){
    	this.replenishmentCycleFlag = replenishmentCycleFlag;
    }



    public String WorkWithWarehouseDetails1.getWarehouseDescription(){
    	return this.warehouseDescription;
    }
    
    public void WorkWithWarehouseDetails1.setWarehouseDescription(String warehouseDescription){
    	this.warehouseDescription = warehouseDescription;
    }



    public Integer WorkWithWarehouseDetails1.getWarehouseNumber(){
    	return this.warehouseNumber;
    }
    
    public void WorkWithWarehouseDetails1.setWarehouseNumber(Integer warehouseNumber){
    	this.warehouseNumber = warehouseNumber;
    }



    public String WorkWithWarehouseDetails1.getWarehouseType(){
    	return this.warehouseType;
    }
    
    public void WorkWithWarehouseDetails1.setWarehouseType(String warehouseType){
    	this.warehouseType = warehouseType;
    }

    public Map<Object,Object> WorkWithWarehouseDetails1.getWarehouseTypeValues(){
    	return warehouseTypeValues;
    }


    public String WorkWithWarehouseDetails1.getWarehouseType1(){
    	return this.warehouseType1;
    }
    




    public String WorkWithWarehouseDetails1.getFocusField(){
    	return focusField;
    }
    public void WorkWithWarehouseDetails1.setFocusField(String focusField){
    	this.focusField = focusField;
    }
    
}