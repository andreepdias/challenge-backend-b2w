# Challenge Backend B2W

Desafio de um processo seletivo da B2W de 2019, realizado para praticar Java e SQL.

O desafio consiste em duas etapas: a primeira construir uma API rest capaz de se comunicar com um API externa; a segundo construir uma consulta SQL.

Repositório original: https://github.com/b2w-marketplace/challenge-backend

Desafio encontrado em: https://github.com/CollabCodeTech/backend-challenges

## Desafio 1

#### Resumo

O primeiro desafio consiste em criar um endpoint com data inicial e data final que retorna uma lista de ordens de pedido que são conseguidos a partir de uma API externa: http://www.mocky.io/v2/5817803a1000007d01cc7fc9, filtrados pelas datas.

#### Solução

A solução foi construída em Spring Boot e está disponível no DockerHub andreepdias:

`docker pull andreepdias/challenge-backend-b2w`

Para iniciar a aplicação basta rodar o container expondo a porta 8080: 

`docker run -p 8080:8080 andreepdias/challenge-backend-b2w`

O endpoint criado pode ser testado pela URL:

`http://localhost:8080/challenge-backend/item?begindate=05-10-2016&finaldate=10-10-2016`


### Desafio 2

#### Resumo

O segundo desafio consiste em criar um query SQL capaz de filtrar registros de uma tabela de eventos. Os requerimentos são os seguintes: "Para cada *event_type* com mais de um registro, retornar a diferença entre o penúltimo e o último valor (em termos do atributo *time*). A tabela deve ser ordenada por *time* em ordem crescente."

Ou seja, uma query capaz de agrupar registros; calcular diferença entre valores de linhas diferentes; reduzir um grupo em apenas um registro, contendo o valor da diferença.

#### Solução

A solução proposta consiste em uma query composta por uma subquery, criada devido a utilização de window function no SQL e a necessidade de filtrar o GROUP BY (utilizando HAVING).

```
SELECT
	*
FROM (
  SELECT
    event_type,
    (LEAD(value) OVER (PARTITION BY event_type ORDER BY time ASC) - value) AS value
  FROM events 
  ORDER BY time ASC
    ) AS quertDiffBetweenPreviousAndCurrent
GROUP BY event_type
HAVING COUNT(event_type) > 1
ORDER BY event_type
```
Os arquivos de saída criados a partir das databases propostas pelo desafio se encontram na pasta 2-sql-query deste repositório.
