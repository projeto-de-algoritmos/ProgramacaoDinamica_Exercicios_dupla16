import java.util.Arrays;

class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        int[][] times = new int[n][n];
        // Inicializa a matriz de tempos com valores máximos
        for (int i = 0; i < n; i++)
            Arrays.fill(times[i], Integer.MAX_VALUE);
        // Preenche a matriz de tempos com os tempos fornecidos nas arestas
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1], time = edge[2];
            // Garante que os índices x e y sejam preenchidos corretamente
            if (x > y) {
                int temp = x;
                x = y;
                y = temp;
            }
            // Atualiza o tempo se for menor ou igual ao tempo máximo e menor que o tempo atual
            if (time <= maxTime && time < times[x][y]) {
                times[x][y] = time;
                times[y][x] = time;
            }
        }

        int[][] dp = new int[n][maxTime + 1];
        // Inicializa a matriz de custos acumulados com valores máximos
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        // Define o custo acumulado do primeiro vértice como a taxa de passagem desse vértice
        dp[0][0] = passingFees[0];

        for (int t = 1; t <= maxTime; t++) {
            boolean updated = false;
            // Itera sobre todos os pares de vértices (i, j)
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // Verifica se há uma aresta entre os vértices i e j
                    if (times[i][j] != Integer.MAX_VALUE) {
                        int time = times[i][j];
                        // Verifica se o tempo atual t é maior ou igual ao tempo da aresta e se o custo acumulado anterior para o vértice i no tempo t - time não é Integer.MAX_VALUE
                        if (t >= time && dp[i][t - time] != Integer.MAX_VALUE) {
                            // Atualiza o custo acumulado para o vértice j no tempo t, usando a fórmula dp[j][t] = Math.min(dp[j][t], dp[i][t - time] + passingFees[j])
                            dp[j][t] = Math.min(dp[j][t], dp[i][t - time] + passingFees[j]);
                            updated = true;
                        }
                    }
                }
            }
            // Se não houve atualizações durante a iteração atual, interrompe o loop
            if (!updated)
                break;
        }

        int minCost = Integer.MAX_VALUE;
        // Encontra o custo mínimo na última linha da matriz dp
        for (int t = 0; t <= maxTime; t++) {
            minCost = Math.min(minCost, dp[n - 1][t]);
        }

        // Retorna o custo mínimo, ou -1 se o custo mínimo for Integer.MAX_VALUE (indicando que não foi possível alcançar o último vértice dentro do tempo máximo)
        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }
}
