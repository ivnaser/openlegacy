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


var ol_lookDialog;
var ol_lookupResultField;

function openLookupDialog(resultFieldName,url,width,height){
	ol_lookupResultField = resultFieldName;
	require(["dojo/ready", "dijit/Dialog"], function(ready, Dialog){
	    ready(function(){
	    	ol_lookDialog = new Dialog({
	    		href: url,
	            title: "",
	            style: "width: " + width + "px" + ";height: " + height + "px"
	        });
	    	ol_lookDialog.show();
	    });
	});	
}
function closeAndUpdateLookup(value){
	require([ "dojo/dom"], function(dom) {
		var resultFieldName = dom.byId(ol_lookupResultField);
		resultFieldName.value = value;
		ol_lookDialog.hide();	
	});
}

