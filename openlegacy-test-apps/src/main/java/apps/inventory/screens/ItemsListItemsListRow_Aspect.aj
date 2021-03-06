// WARNING: DO NOT EDIT THIS FILE.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package apps.inventory.screens;

import java.util.List;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import apps.inventory.screens.ItemsList.ItemsListRow;

privileged @SuppressWarnings("unused") aspect ItemsListRow_Aspect {
    
    public String ItemsListRow.getAction(){
    	return this.action;
    }
    
    public void ItemsListRow.setAction(String action){
    	this.action = action;
    }

    public String ItemsListRow.getAlphaSearch(){
    	return this.alphaSearch;
    }
    

    public String ItemsListRow.getItemDescription(){
    	return this.itemDescription;
    }
    

    public Integer ItemsListRow.getItemNumber(){
    	return this.itemNumber;
    }
    


    public int ItemsListRow.hashCode(){
		return HashCodeBuilder.reflectionHashCode(this);
    }

    public boolean ItemsListRow.equals(Object other){
    	// TODO exclude terminal fields
		return EqualsBuilder.reflectionEquals(this,other);
    }
}
