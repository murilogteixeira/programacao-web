function selecionarMateria() {
    var checkboxs = document.getElementsByName('ckMateria');
    var divConteudo = document.getElementById('divConteudo');

    checkboxs.forEach(checkbox => {
        if (checkbox.checked == true) {
            // alert(checkbox.id);
            divConteudo.innerHTML += checkbox.id
        }
    }) 

    // for (var i = 0; i < checkboxs.length; i++) {
    //     if (checkboxs[i].checked == true) {
    //         alert(checkboxs[i].id);
    //     }
    // }
}