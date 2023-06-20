document.addEventListener('DOMContentLoaded', function() {
    // Encontra o formulário pelo ID
    const form = document.getElementById('formulario');
  
    // Adiciona um listener para o evento 'submit'
    form.addEventListener('submit', function(event) {
      event.preventDefault(); // Impede o envio padrão do formulário
  
      // Exibe um alerta informando que as informações foram salvas
      alert('As informações foram salvas.');
  
      // Limpa o formulário
      form.reset();
    });
  });