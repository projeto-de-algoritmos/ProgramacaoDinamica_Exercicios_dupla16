Dada uma matriz binária de tamanho rows x cols preenchida com 0's e 1's, encontre o maior retângulo que contém apenas 1's e retorne a sua área.

Exemplo 1:

Input: matrix = 
[["1","0","1","0","0"],
["1","0","1","1","1"],
["1","1","1","1","1"],
["1","0","0","1","0"]]
Output: 6
Explicação: O retângulo máximo é mostrado na imagem acima.

Exemplo 2:

Input: matrix = [["0"]]
Output: 0

Exemplo 3:

Input: matrix = [["1"]]
Output: 1

Restrições:

rows é igual ao comprimento da matriz.
cols é igual ao comprimento de cada linha da matriz.
1 <= rows, cols <= 200.
matrix[i][j] é '0' ou '1'.
