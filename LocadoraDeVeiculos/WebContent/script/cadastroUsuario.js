/**
 * 
 */
var inputSenha = document.getElementById('senha');

inputSenha.onkeyup = function() {

    if (this.value.length == 0) {
    	var key = event.keyCode || event.charCode;
    	if( key == 8 || key == 46 ) {
        	document.getElementById('forcaSenha').innerHTML = ""
    	}
    	return;
    }
    
	validarSenhaForca(this.value);
};

var inputConfirmaSenha = document.getElementById('confirmaSenha');

inputConfirmaSenha.onchange = function() {
	
	var msgErro = document.getElementById('erroConfirmaSenha');
	
	if(senha.value != this.value) {
		msgErro.innerHTML = "Senha não confere."
	}
	else {
		msgErro.innerHTML = ""
	}
};

function validarSenhaForca(senha) {
	
	var forca = 0;

	if((senha.length >= 4) && (senha.length <= 7)) {
		forca += 10;
	} else if(senha.length > 7) {
		forca += 25;
	}

	if((senha.length >= 5) && (senha.match(/[a-z]+/))) {
		forca += 10;
	}

	if((senha.length >= 6) && (senha.match(/[A-Z]+/))) {
		forca += 20;
	}

	if((senha.length >= 7) && (senha.match(/[^a-zA-Z0-9]+/g))) {
		forca += 25;
	}

	if(senha.match(/([1-9]+)\1{1,}/)) {
		forca += -25;
	}

	mostrarForca(forca);
}

function mostrarForca(forca) {
	
	var corBarra;
	var tamanhoBarra;
	var text;
	
	if(forca < 30 ) {
		corBarra = "bg-danger";
		tamanhoBarra = "25";
		text = "Fraca";
	} else if((forca >= 30) && (forca < 50)) {
		corBarra = "bg-warning";
		tamanhoBarra = "50";
			text = "Média";
	} else if((forca >= 50) && (forca < 70)) {
		corBarra = "bg-primary";
		tamanhoBarra = "75";
		text = "Forte";
	} else if((forca >= 70) && (forca < 100)) {
		corBarra = "bg-success";
		tamanhoBarra = "100";
		text = "Muito Forte";
	}

	document.getElementById('forcaSenha').innerHTML = `<div class="progress mb-3"><div class="progress-bar ${corBarra}" role="progressbar" style="width: ${tamanhoBarra}%" aria-valuenow="${tamanhoBarra}" aria-valuemin="0" aria-valuemax="100">${text}</div></div>`
}
