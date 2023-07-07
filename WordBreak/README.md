Dado uma string s e um dicionário de strings wordDict, retorne verdadeiro se s pode ser segmentada em uma sequência separada por espaços de uma ou mais palavras do dicionário.

Observe que a mesma palavra do dicionário pode ser reutilizada várias vezes na segmentação.

Exemplo 1:

Entrada: s = "leetcode", wordDict = ["leet","code"]
Saída: verdadeiro
Explicação: Retorna verdadeiro porque "leetcode" pode ser segmentada como "leet code".

Exemplo 2:

Entrada: s = "applepenapple", wordDict = ["apple","pen"]
Saída: verdadeiro
Explicação: Retorna verdadeiro porque "applepenapple" pode ser segmentada como "apple pen apple".
Observe que é permitido reutilizar uma palavra do dicionário.

Exemplo 3:

Entrada: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Saída: falso

Restrições:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s e wordDict[i] consistem apenas de letras minúsculas do alfabeto inglês.
Todas as strings em wordDict são únicas.
