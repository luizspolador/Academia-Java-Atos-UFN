function confirmar(idcon) {
    let resposta = confirm("Confirma a exclusão do contato?")
    if (resposta === true) {
        //alert(idcon)
        window.location.href = "delete?idcon=" + idcon
    }
}