function validaCampos() {
	var form = document.getElementById('form');
	var peso = document.getElementById('peso');
	var altura = document.getElementById('altura');
	if (peso.value != '' && altura.value != '') {
		form.submit();
	} else {
		alert('Insira o peso e a altura!');
		event.preventDefault();
	}
}