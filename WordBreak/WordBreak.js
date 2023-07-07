var wordBreak = function(s, wordDict) {
  // Cria um array para armazenar os resultados dos subproblemas
  const dp = new Array(s.length + 1).fill(false);
  dp[0] = true; // Uma string vazia sempre pode ser segmentada

  // Percorre a string caractere por caractere
  for (let i = 1; i <= s.length; i++) {
    // Verifica se alguma palavra do wordDict pode ser casada a partir do índice j
    for (let j = 0; j < i; j++) {
      if (dp[j] && wordDict.includes(s.substring(j, i))) {
        // Se uma casamento é encontrado, atualiza o array dp
        dp[i] = true;
        break; // Passa para o próximo índice no loop externo
      }
    }
  }

  return dp[s.length];
}
