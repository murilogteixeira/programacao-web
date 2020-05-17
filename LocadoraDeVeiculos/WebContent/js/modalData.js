$('#veiculoModal').on('show.bs.modal', function (event) {
    var button = $(event.relatedTarget) // Botão que acionou o modal
    var recipient = button.data('whatever') // Extrai informação dos atributos data-*

    var modal = $(this);

    const method = 'POST';
    const url = 'VeiculoServlet';
    const params = new URLSearchParams({
        opcao: "buscarId",
        id: recipient,
    }).toString();
    const callback = (carro) => {
        console.log(carro);
        modal.find('#foto').attr("src", carro.foto);
        modal.find('#modelo').text(carro.modelo);
        modal.find('#marca').text(carro.marca);
        modal.find('#preco').text(Number(carro.preco).toFixed(2));
        modal.find('#descricao').text(carro.descricao);
        modal.find('#veiculoId').val(carro.id);
        
        if(carro.alugado) {
            modal.find('#disponivel').text('Indisponível');
            modal.find('#opcao').val('devolver');
            modal.find('#alugarButton').text('Devolver');
            modal.find('#alugarButton').toggleClass('btn-primary btn-success');
        }
        else {
            modal.find('#disponivel').text('Disponível');
            modal.find('#opcao').val('alugar');
            modal.find('#alugarButton').text('Alugar');
            modal.find('#alugarButton').toggleClass('btn-success btn-primary');
        }
    };

    request(method, url, params, callback);
});

$( "#alugarButton" ).on( "click", function() {
    // $(this).toggleClass('btn-success btn-primary');
    $('#formAlugar').submit();
});

function request(method, url, params, callback) {
    var ajax = new XMLHttpRequest();

    if(method === 'POST' || method === 'post') {
        ajax.open(method, url, true);
        ajax.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        ajax.send(params);
    }
    else if (method === 'GET' || method === 'get') {
        ajax.open(method, url + '/?' + params, true);
        ajax.send();
    }

    // Cria um evento para receber o retorno.
    ajax.onreadystatechange = function() {
    // Caso o state seja 4 e o http.status for 200, é porque a requisiçõe deu certo.
        if (ajax.readyState == 4 && ajax.status == 200) {
            // Retorno do Ajax
            var ajaxReturn = ajax.responseText;
            var data = JSON.parse(ajaxReturn);
            callback(data);
        }
    }
}