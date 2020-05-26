function somar() {
    var op1 = document.getElementById('nmbOp1').value;
    var op2 = document.getElementById('nmbOp2').value;

    if(op1 === '' || op2 === '') {
        alert('Operador(es) não pode(m) ser nulo(s).');
        return;
    }

    op1 = parseInt(op1, 10);
    op2 = parseInt(op2, 10);

    alert('Resultado da soma: ' + (op1 + op2));
}

function subtrair() {
    var op1 = document.getElementById('nmbOp1').value;
    var op2 = document.getElementById('nmbOp2').value;

    if(op1 === '' || op2 === '') {
        alert('Operador(es) não pode(m) ser nulo(s).');
        return;
    }

    op1 = parseInt(op1, 10);
    op2 = parseInt(op2, 10);

    alert('Resultado da subtração: ' + (op1 - op2))
}

function multiplicar() {
    var op1 = document.getElementById('nmbOp1').value;
    var op2 = document.getElementById('nmbOp2').value;

    if(op1 === '' || op2 === '') {
        alert('Operador(es) não pode(m) ser nulo(s).');
        return;
    }

    op1 = parseInt(op1, 10);
    op2 = parseInt(op2, 10);

    alert('Resultado da multiplicação: ' + (op1 * op2))
}

function dividir() {
    var op1 = document.getElementById('nmbOp1').value;
    var op2 = document.getElementById('nmbOp2').value;

    if(op1 === '' || op2 === '') {
        alert('Operador(es) não pode(m) ser nulo(s).');
        return;
    }

    op1 = parseInt(op1, 10);
    op2 = parseInt(op2, 10);

    alert('Resultado da divisão: ' + (op1 / op2))
}