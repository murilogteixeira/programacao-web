function meuNome() {
    var nome = document.getElementById('txtNome').value;
    alert(`Meu nome é ${nome}.`);
}

function calculo() {
    var num1 = document.getElementById('num1').value.parseInt();
    var num2 = document.getElementById('num2').value.parseInt();
    var soma = num1 + num2;
    alert(`${num1} + ${num2} = ${soma}`);
}

// Extension: Transforma uma string em um numero inteiro
String.prototype.parseInt = function() {
    return parseInt(this);
}