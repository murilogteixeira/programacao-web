window.onload = function () {
    $.ajax({
        url: "VeiculoServlet",
        type: "GET",
        data: "opcao=listar",
        success: function (responseText) { // $("#divConteudo").html(responseText);
            alert(responseText);
        }
    });
}
// $(document).ready(function () {
//     $.ajax({
//         alert("")url: "VeiculoServlet",
//         type: "GET",
//         data: "opcao=listar",
//         success: function (responseText) { // $("#divConteudo").html(responseText);
//             alert(responseText);
//         }
//     });
// })
