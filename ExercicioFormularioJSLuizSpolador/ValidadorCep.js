// Obtém uma referência para o campo de input do CEP
const cepInput = document.getElementById('cep');

// Adiciona um evento de escuta ao campo de input do CEP
cepInput.addEventListener('blur', buscarEndereco);

// Função para buscar o endereço pelo CEP
function buscarEndereco() {
    // Obtém o valor do CEP digitado pelo usuário
    const cep = cepInput.value.trim();

    // Expressão regular para validar o CEP (formato: 5 dígitos seguidos de hífen e mais 3 dígitos)
    const cepRegex = /^\d{5}-\d{3}$/;

    // Verifica se o CEP é válido
    if (!cepRegex.test(cep)) {
        // CEP inválido, exibe a mensagem de erro
        exibirErroCep();
    } else {
        // CEP válido, limpa a mensagem de erro (caso esteja sendo exibida)
        limparErroCep();

        // Faz a requisição para o serviço ViaCEP
        const url = `https://viacep.com.br/ws/${cep}/json/`;
        fetch(url)
            .then(response => response.json())
            .then(data => {
                if (data.erro) {
                    // CEP não encontrado, exibe a mensagem de erro
                    exibirErroCep();
                } else {
                    // CEP encontrado, preenche os campos com os dados do endereço
                    preencherCamposEndereco(data);
                }
            })
            .catch(error => {
                console.log('Erro na requisição:', error);
                exibirErroCep();
            });
    }
}

// Função para exibir a mensagem de erro
function exibirErroCep() {
    const cepErro = document.getElementById('cep-erro');
    cepErro.classList.remove('d-none');
}

// Função para limpar a mensagem de erro
function limparErroCep() {
    const cepErro = document.getElementById('cep-erro');
    cepErro.classList.add('d-none');
}

// Função para preencher os campos com os dados do endereço
function preencherCamposEndereco(data) {
    const enderecoInput = document.getElementById('endereco');
    const bairroInput = document.getElementById('bairro');
    const cidadeInput = document.getElementById('cidade');
    const estadoInput = document.getElementById('estado');

    enderecoInput.value = data.logradouro;
    bairroInput.value = data.bairro;
    cidadeInput.value = data.localidade;
    estadoInput.value = data.uf;
}
