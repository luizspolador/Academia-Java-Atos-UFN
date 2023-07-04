// cores
const colors = ["red", "blue", "green", "yellow", "orange", "purple", "pink", "black", "white"];

// variáveis iniciais do jogo
let level = 1;
let timer = 3;
let score = 0;
let targetWord = "";
let targetColor = "";

//referencias com o HTML
const levelElement = document.getElementById("level");
const timerElement = document.getElementById("timer");
const scoreElement = document.getElementById("score");
const targetWordElement = document.getElementById("target-word");
const buttonContainer = document.getElementById("button-container");
const startButton = document.getElementById("start-button");

// asocciada com a função startGame
startButton.addEventListener("click", startGame);

// inicia o jogo e redefine as variáveis
function startGame() {
  level = 1;
  timer = 3;
  score = 0;
  updateLevel();
  updateScore();
  startButton.disabled = true; // desabilita o botão começar
  startButton.textContent = "Espere..."; // mostra a mensagem espere...
  nextRound(); // para próxima rodada
  setTimeout(startTimer, 1000); // temporizador
}

// para atualizar o level/nível
function updateLevel() {
  levelElement.textContent = level;
}

// atualiza a pontuação
function updateScore() {
  scoreElement.textContent = score;
}

// função para decrementar o temporizador 
function startTimer() {
  if (timer > 0) {
    timer--;
    timerElement.textContent = timer;
    setTimeout(startTimer, 1000);
  } else {
    endGame(); // quando o temporizador chegar a 0 a endGame() é chamado e o jogo é finalizado
  }
}

// finaliza o jogo
function endGame() {
  score = 0; //  define a pontuação como 0
  updateScore();
  startButton.disabled = false;
  startButton.textContent = "Reiniciar"; // aparece o botão de reiniciar
  buttonContainer.querySelectorAll(".color-button").forEach(button => {
    button.disabled = true; // desabilita botoes de cores
  });
}

// função para embaralhar aleatoriamente a ordem dos botões de cores
function shuffleButtons() {
  const buttons = Array.from(buttonContainer.querySelectorAll(".color-button"));
  for (let i = buttons.length - 1; i > 0; i--) {
    const j = Math.floor(Math.random() * (i + 1));
    [buttons[i].className, buttons[j].className] = [buttons[j].className, buttons[i].className];
  }
}

// gera uma nova cor e palavra alvo aleatoriamente. A cor alvo é selecionada a partir da lista de colores
// e a palavra alvo é selecionada aleatoriamente da mesma lista.
function generateTarget() {
  const randomIndex = Math.floor(Math.random() * colors.length);
  targetColor = colors[randomIndex];
  targetWord = colors[Math.floor(Math.random() * colors.length)];
  targetWordElement.textContent = targetWord;
  targetWordElement.style.color = targetColor;
}

// verifica se a cor selecionada pelo jogador corresponde à cor alvo.
function checkAnswer(event) {
  const selectedColor = event.target.className.split(" ")[1];
  if (selectedColor === targetColor) { // Se a resposta estiver correta, a pontuação é incrementada, a pontuação e o nível são atualizados e uma nova rodada é iniciada.
    score++;
    updateScore();
    if (score % 10 === 0) {
      level++;
      updateLevel();
    }
    nextRound();
  } else { //Caso contrário, a pontuação é redefinida para 0, a pontuação é atualizada e o jogo é encerrado.
    score = 0;
    updateScore();
    endGame();
  }
}

//  gera uma nova cor alvo e palavra alvo, embaralha os botões de cores e adiciona os event listeners aos botões de cores
function nextRound() {
  timer = getTimerByLevel(level);
  timerElement.textContent = timer;
  generateTarget();
  shuffleButtons();
  buttonContainer.querySelectorAll(".color-button").forEach(button => {
    button.disabled = false;
    button.removeEventListener("click", checkAnswer);
    button.addEventListener("click", checkAnswer);
  });
}

// relacação de tempo e nível
function getTimerByLevel(level) {
  switch (level) {
    case 1:
      return 3;
    case 2:
      return 2;
    case 3:
      return 2;
    case 4:
      return 1.7;
    case 5:
      return 1.5;
    case 6:
      return 1;
    default:
      return 1;
  }
}

// Add event listener to color buttons
buttonContainer.querySelectorAll(".color-button").forEach(button => {
  button.addEventListener("click", checkAnswer);
});
