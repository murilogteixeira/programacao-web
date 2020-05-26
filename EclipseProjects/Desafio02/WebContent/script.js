function pressed() {
	var operadores = document.getElementsByName('txtOperador');
	var operador = null;
	for(var i = 0; i < operadores.length; i++) {
		if(operadores[i].checked) {
			operador = operadores[i].value;
		}
	}
	
	if(operador == null) {
		alert('Selecione um operador!');
		event.preventDefault();
	}
	else {
		var operando1 = document.getElementById('nmbOperando1').value;
		if(operador == '/' && operando1 == 0) {
			alert('0 não é divisível!');
			event.preventDefault();
		}
	}
}