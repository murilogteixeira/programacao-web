var label = '';
var calculo = 0;
var i = 0;
var operando = [null,null];
var operador = null;

window.onload = function() {
    this.label = document.getElementById('txtNumero');
}

function numeroPressionado(valor) {
    if (operador) {
        label.value = '';
    }

    label.value += valor;
    operando[i] = parseInt(label.value);
}

function limpar() {
    label.value = '';
    calculo = 0;
    op1 = 0;
    operador = null;
}

function somar() {
    if (operando[0] && operando[1]) {
        calculo = operando[0] + operando[1];
    }

    if (i === 0) {
        i++;
    }
    
    operador = '+';
}

function subtrair() {
    calculo = op1 - op2;
    operador = '-';
    op1 = 0;
}

function multiplicar() {
    calculo = op1 * op2;
    operador = '*';
    op1 = 0;
    console.log(calculo);
}

function dividir() {
    calculo = op1 / op2;
    operador = '/';
    op1 = 0;
    console.log(calculo);
}

function resultado() {
    switch (operador) {
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
    operador = null;
    label.value = calculo;
    console.log(calculo);
}