/**
 * @param {character[][]} matrix
 * @return {number}
 */

// Função principal para encontrar o maior retângulo em uma matriz binária
var maximalRectangle = function(matrix) {
  if (matrix.length === 0) return 0;

  const rows = matrix.length;
  const cols = matrix[0].length;
  let maxArea = 0;

  // Cria uma matriz auxiliar para armazenar a altura de cada coluna
  const heights = Array(cols).fill(0);

  // Itera pelas linhas da matriz
  for (let i = 0; i < rows; i++) {
    // Atualiza a altura de cada coluna na matriz auxiliar
    for (let j = 0; j < cols; j++) {
      if (matrix[i][j] === "1") {
        heights[j] += 1; // Incrementa a altura se o elemento da matriz for '1'
      } else {
        heights[j] = 0; // Reseta a altura se o elemento da matriz for '0'
      }
    }

    // Calcula a área do retângulo máximo em cada linha
    maxArea = Math.max(maxArea, largestRectangleArea(heights));
  }

  return maxArea; // Retorna a área do maior retângulo encontrado
};

// Função auxiliar para encontrar a área do maior retângulo em um histograma
function largestRectangleArea(heights) {
  const stack = [];
  let maxArea = 0;
  let i = 0;

  while (i <= heights.length) {
    if (stack.length === 0 || heights[i] >= heights[stack[stack.length - 1]]) {
      stack.push(i);
      i++;
    } else {
      const top = stack.pop();
      const area = heights[top] * (stack.length === 0 ? i : i - stack[stack.length - 1] - 1);
      maxArea = Math.max(maxArea, area);
    }
  }

  return maxArea; // Retorna a área do maior retângulo encontrado no histograma
}
