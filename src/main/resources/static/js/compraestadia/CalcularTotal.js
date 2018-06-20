
function calcularTotal(){
    	var nrodias= parseInt(document.getElementById('nrodias').value);
    	
    	var costoxdia = parseFloat(document.getElementById('costoxdia').value);
    	
    	
    	var total= costoxdia * nrodias;
    	
    	var inputTotal = $('#total');
    	
    	console.log("Calculando...");
    	
    	inputTotal.attr("value","$" + total);
}

$(function() {
	
    var inputDias = $('#nrodias');
    inputDias.bind('keyup mouseup',function(){
        calcularTotal();
    });
    
});


