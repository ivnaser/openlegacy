// WARNING: DO NOT EDIT THIS FILE.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package apps.inventory.screens;

import java.util.List;
import org.openlegacy.terminal.ScreenEntity;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;

privileged @SuppressWarnings("unused") aspect ItemDetails1_Aspect {
    
    declare @type: ItemDetails1 : @Component;
	declare @type: ItemDetails1 : @Scope("prototype");
    

    declare parents: ItemDetails1 implements ScreenEntity;
    private String ItemDetails1.focusField;
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    

    public String ItemDetails1.getAlphaSearch(){
    	return this.alphaSearch;
    }
    
    public void ItemDetails1.setAlphaSearch(String alphaSearch){
    	this.alphaSearch = alphaSearch;
    }

    public String ItemDetails1.getItemClass(){
    	return this.itemClass;
    }
    
    public void ItemDetails1.setItemClass(String itemClass){
    	this.itemClass = itemClass;
    }

    public String ItemDetails1.getItemClass1(){
    	return this.itemClass1;
    }
    

    public String ItemDetails1.getItemDescription(){
    	return this.itemDescription;
    }
    
    public void ItemDetails1.setItemDescription(String itemDescription){
    	this.itemDescription = itemDescription;
    }

    public ItemDetails2 ItemDetails1.getItemDetails2(){
    	return this.itemDetails2;
    }
    

    public String ItemDetails1.getItemNumber(){
    	return this.itemNumber;
    }
    

    public String ItemDetails1.getItemWeight(){
    	return this.itemWeight;
    }
    
    public void ItemDetails1.setItemWeight(String itemWeight){
    	this.itemWeight = itemWeight;
    }

    public String ItemDetails1.getManufacturersItemNo(){
    	return this.manufacturersItemNo;
    }
    
    public void ItemDetails1.setManufacturersItemNo(String manufacturersItemNo){
    	this.manufacturersItemNo = manufacturersItemNo;
    }

    public String ItemDetails1.getOuterQuantity(){
    	return this.outerQuantity;
    }
    
    public void ItemDetails1.setOuterQuantity(String outerQuantity){
    	this.outerQuantity = outerQuantity;
    }

    public String ItemDetails1.getOuterUnitOfMeasure(){
    	return this.outerUnitOfMeasure;
    }
    
    public void ItemDetails1.setOuterUnitOfMeasure(String outerUnitOfMeasure){
    	this.outerUnitOfMeasure = outerUnitOfMeasure;
    }

    public String ItemDetails1.getPackingMultiplier(){
    	return this.packingMultiplier;
    }
    
    public void ItemDetails1.setPackingMultiplier(String packingMultiplier){
    	this.packingMultiplier = packingMultiplier;
    }

    public String ItemDetails1.getPalletLabelRequired(){
    	return this.palletLabelRequired;
    }
    
    public void ItemDetails1.setPalletLabelRequired(String palletLabelRequired){
    	this.palletLabelRequired = palletLabelRequired;
    }

    public String ItemDetails1.getStockGroup(){
    	return this.stockGroup;
    }
    
    public void ItemDetails1.setStockGroup(String stockGroup){
    	this.stockGroup = stockGroup;
    }

    public String ItemDetails1.getStockGroup1(){
    	return this.stockGroup1;
    }
    

    public String ItemDetails1.getSubstituteItemNumber(){
    	return this.substituteItemNumber;
    }
    
    public void ItemDetails1.setSubstituteItemNumber(String substituteItemNumber){
    	this.substituteItemNumber = substituteItemNumber;
    }

    public String ItemDetails1.getSupercedingItemfrom(){
    	return this.supercedingItemfrom;
    }
    
    public void ItemDetails1.setSupercedingItemfrom(String supercedingItemfrom){
    	this.supercedingItemfrom = supercedingItemfrom;
    }

    public String ItemDetails1.getSupercedingItemto(){
    	return this.supercedingItemto;
    }
    
    public void ItemDetails1.setSupercedingItemto(String supercedingItemto){
    	this.supercedingItemto = supercedingItemto;
    }

    public String ItemDetails1.getUnitOfMeasure(){
    	return this.unitOfMeasure;
    }
    
    public void ItemDetails1.setUnitOfMeasure(String unitOfMeasure){
    	this.unitOfMeasure = unitOfMeasure;
    }

    public String ItemDetails1.getVatCode(){
    	return this.vatCode;
    }
    
    public void ItemDetails1.setVatCode(String vatCode){
    	this.vatCode = vatCode;
    }


    public String ItemDetails1.getFocusField(){
    	return focusField;
    }
    public void ItemDetails1.setFocusField(String focusField){
    	this.focusField = focusField;
    }
    
}