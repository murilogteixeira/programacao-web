var label = '';
var calculo = 0;
var valorAtual = 0;
var operadorSelecionado = null;

window.onload = function() {
    this.label = document.getElementById('txtNumero');
}

function botaoPressionado(valor) {
    if (operadorSelecionado) {
        label.value = '';
    }

    label.value += valor;
    valorAtual = parseInt(label.value);
}

function limpar() {
    label.value = '';
    calculo = 0;
    valorAtual = 0;
    operadorSelecionado = null;
}

function somar() {
    calculo = calculo + valorAtual;
    operadorSelecionado = '+';
    valorAtual = 0;
}

function subtrair() {
    calculo = calculo === 0 ? valorAtual : calculo - valorAtual;
    operadorSelecionado = '-';
    valorAtual = 0;
}

function multiplicar() {
    calculo = calculo === 0 ? valorAtual : calculo * valorAtual;
    operadorSelecionado = '*';
    valorAtual = 0;
    console.log(calculo);
}

function dividir() {
    calculo = calculo === 0 ? valorAtual : calculo / valorAtual;
    operadorSelecionado = '/';
    valorAtual = 0;
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