
function calcularTotal(){
		var tarifaBase = parseFloat(document.getElementById('tarifabase').value);
	
		var tarifaAdulto = parseFloat(document.getElementById('tarifaadulto').value);
		
		var tarifaNino = parseFloat(document.getElementById('tarifanino').value);
		
		var tarifaFC = parseFloat(document.getElementById('tarifafc').value);
		
    	var cantAdultos = parseInt($('#nroadulto').val());
    	var cantNinos = parseInt($('#nronino').val());
    	var cantFC = parseInt($('#nrofc').val());
    	
    	var total= cantAdultos *tarifaBase * tarifaAdulto + cantNinos *tarifaBase * tarifaNino + cantFC * tarifaBase * tarifaFC;
    	
    	var inputTotal = $('#total');
    	
    	console.log("Calculando...");
    	
    	inputTotal.attr("value","$" + total);
}
$(function() {
    
    var inputAdultos = $('#nroadulto');
    
    var inputNinos = $('#nronino');
    
    var inputFC = $('#nrofc');
    
    
    inputAdultos.bind('keyup mouseup',function(){
        calcularTotal();
    });
    
    inputNinos.bind('keyup mouseup',function(){
        calcularTotal();
    });
    
    inputFC.bind('keyup mouseup',function(){
        calcularTotal();
    });
    
});


