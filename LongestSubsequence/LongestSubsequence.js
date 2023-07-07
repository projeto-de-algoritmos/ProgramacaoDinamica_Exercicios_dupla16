var lengthOfLIS = function(nums) {
  const n = nums.length;
  const dp = new Array(n).fill(1); // Inicializa o array dp com 1 em todos os índices

  // Percorre o array nums
  for (let i = 1; i < n; i++) {
    // Compara o elemento atual com todos os elementos anteriores
    for (let j = 0; j < i; j++) {
      // Se o elemento atual for maior que o elemento anterior, atualiza o valor dp[i]
      if (nums[i] > nums[j]) {
        dp[i] = Math.max(dp[i], dp[j] + 1);
      }
    }
  }

  let maxLength = 0;
  // Encontra o valor máximo no array dp
  for (let i = 0; i < n; i++) {
    maxLength = Math.max(maxLength, dp[i]);
  }

  return maxLength; // Retorna o comprimento da sequência estritamente crescente mais longa
}
