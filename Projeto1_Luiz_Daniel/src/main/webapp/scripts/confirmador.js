function confirmar(id) {
    let resposta = confirm("Confirma a exclusão do contato?")
    if (resposta === true) {
        //alert(id)
        window.location.href = "delete?id=" + id
    }
}