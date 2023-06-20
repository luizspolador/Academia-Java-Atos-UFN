// Obtém uma referência para o formulário
const form = document.getElementById('formulario');

// Adiciona um evento de escuta ao formulário para capturar o envio
form.addEventListener('submit', salvarDados);

// Função para salvar os dados do formulário
function salvarDados(event) {
  event.preventDefault(); // Evita o envio padrão do formulário

  // Obtém os valores dos campos do formulário
  const nome = document.getElementById('nome').value;
  const sobrenome = document.getElementById('sobrenome').value;
  const email = document.getElementById('email').value;
  const login = document.getElementById('login').value;
  const senha = document.getElementById('senha').value;
  const cep = document.getElementById('cep').value;
  const endereco = document.getElementById('endereco').value;
  const complemento = document.getElementById('complemento').value;
  const bairro = document.getElementById('bairro').value;
  const cidade = document.getElementById('cidade').value;
  const estado = document.getElementById('estado').value;
  const github = document.getElementById('github').value;
  const academia = document.getElementById('academia').value;
  const professor = document.getElementById('professor').value;
  const termos = document.getElementById('termos').checked ? 'Aceito' : 'Não Aceito';
  const info = document.getElementById('info-sim').checked ? 'Sim' : 'Não';

  // Faça o que desejar com os dados, como enviar para um servidor ou armazenar localmente

  // Exiba os dados na tabela de dados submetidos
  exibirDadosSubmetidos(nome, sobrenome, email, login, senha, cep, endereco, complemento, bairro, cidade, estado, github, academia, professor, termos, info);

  // Limpa o formulário
  form.reset();
}

// Função para exibir os dados na tabela de dados submetidos
function exibirDadosSubmetidos(nome, sobrenome, email, login, senha, cep, endereco, complemento, bairro, cidade, estado, github, academia, professor, termos, info) {
  // Obtém as referências para as células da tabela de dados submetidos
  const tdNome = document.getElementById('t-nome');
  const tdSobrenome = document.getElementById('t-sobrenome');
  const tdEmail = document.getElementById('t-email');
  const tdLogin = document.getElementById('t-login');
  const tdSenha = document.getElementById('t-senha');
  const tdCep = document.getElementById('t-cep');
  const tdEndereco = document.getElementById('t-endereco');
  const tdComplemento = document.getElementById('t-complemento');
  const tdBairro = document.getElementById('t-bairro');
  const tdCidade = document.getElementById('t-cidade');
  const tdEstado = document.getElementById('t-estado');
  const tdGithub = document.getElementById('t-github');
  const tdAcademia = document.getElementById('t-academia');
  const tdProfessor = document.getElementById('t-professor');
  const tdTermos = document.getElementById('t-termos');
  const tdInfo = document.getElementById('t-info');

  // Preenche as células com os valores dos campos do formulário
  tdNome.textContent = nome;
  tdSobrenome.textContent = sobrenome;
  tdEmail.textContent = email;
  tdLogin.textContent = login;
  tdSenha.textContent = senha;
  tdCep.textContent = cep;
  tdEndereco.textContent = endereco;
  tdComplemento.textContent = complemento;
  tdBairro.textContent = bairro;
  tdCidade.textContent = cidade;
  tdEstado.textContent = estado;
  tdGithub.textContent = github;
  tdAcademia.textContent = academia;
  tdProfessor.textContent = professor;
  tdTermos.textContent = termos;
  tdInfo.textContent = info;

  // Exibe a tabela de dados submetidos
  const tabelaDados = document.getElementById('tabela-dados');
  tabelaDados.classList.remove('d-none');
}
