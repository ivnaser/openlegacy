function uploadStockItemImage() {
	require([ "dojo/request/iframe", "dojo/dom", "dijit/registry" ], function(
			iframe, dom, registry) {
		var form = dom.byId("uploadForm");
		var itemNumber = dom.byId("itemNumber").value;
		iframe.post(form.action, {
			data : {
				itemNumber : itemNumber
			},
			form : form,
			preventCache : true,
			handleAs : "html"
		}).then(function(data) {
			registry.byId("ItemImages").refresh();
		}, function(res) {
			alert(res);
		});
	});
};

//the field id which the lookup dialog result should return 
var ol_lookupFieldId;
var ol_lookupDisplayFieldId;
function openLookupDialog(fieldId,displayFieldId,url,style){
	ol_lookupFieldId = fieldId;
	ol_lookupDisplayFieldId = displayFieldId;
	require(["dojo/ready", "dijit/registry", "dijit/Dialog","dojo/dom"], function(ready, registry,Dialog,dom){
	    ready(function(){
	    	var lookDialog = registry.byId("lookupDialog");
	    	lookDialog.set("style",style);
	    	lookDialog.set("href",url);
	    	
	    	lookDialog.show();
	    });
	});	
}
function closeAndUpdateLookup(value,displayValue){
	require([ "dojo/dom" , "dijit/registry"], function(dom,registry) {
		
    	var lookupDialog = registry.byId("lookupDialog");
		var resultField= dom.byId(ol_lookupFieldId);
		resultField.value = value;
		ol_lookupFieldId = null;
		if (ol_lookupDisplayFieldId != null){
			var resultDisplayField = dom.byId(ol_lookupDisplayFieldId);
			resultDisplayField.innerHTML = displayValue;
			ol_lookupDisplayFieldId = null;
		}
		lookupDialog.hide();	
	});
}

