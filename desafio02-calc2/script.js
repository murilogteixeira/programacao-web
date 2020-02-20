var label = '';
var calculo = 0;
var operadores = [0,0];
var i = 0;
var operadorSelecionado = null;

window.onload = function() {
    this.label = document.getElementById('txtNumero');
}

function botaoPressionado(valor) {
    if (operadorSelecionado) {
        label.value = '';
    }

    label.value += valor;
    operadores[i] = parseInt(label.value);
}

function limpar() {
    label.value = '';
    calculo = 0;
    op1 = 0;
    operadorSelecionado = null;
}

function somar() {
    calculo = op1 + op2;
    operadorSelecionado = '+';
    op1 = 0;
}

function subtrair() {
    calculo = op1 - op2;
    operadorSelecionado = '-';
    op1 = 0;
}

function multiplicar() {
    calculo = op1 * op2;
    operadorSelecionado = '*';
    op1 = 0;
    console.log(calculo);
}

function dividir() {
    calculo = op1 / op2;
    operadorSelecionado = '/';
    op1 = 0;
    console.log(calculo);
}

function resultado() {
    switch (operadorSelecionado) {
    case '+':
        somar();
        break;
    case '-':
        subtrair();
        break;
    case '*':
        multiplicar();
        break;
    case '/':
        dividir();
        break;
    default:
        calculo = label.value;
        break;
    }
    operadorSelecionado = null;
    label.value = calculo;
    console.log(calculo);
}