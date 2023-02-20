# Impacto de Two Phase Commit (2PC / XA) na disponibilidade / performance

Este repositório foi utilizado para a escrita do artigo sobre como chamadas remotas em contexto transacional de banco de dados impactam o tempo de resposta / escalabilidade da aplicação.

O artigo pode ser encontrado na seguinte URL: ...

## Requisitos
Rodar um Oracle com o seguinte comando:

```
docker run -d --name oracle --network host -e ORACLE_ALLOW_REMOTE=true oracleinanutshell/oracle-xe-11g
```

Rodar o ActiveMQ Artemis com os seguite comando:

```
docker run --name activemq-artemis --cpus 1.0 --rm --network host -e ARTEMIS_USERNAME=admin -e ARTEMIS_PASSWORD=secret vromero/activemq-artemis
```

## Execução
Para rodar o código, executar os seguinte comandos:

Caso queira executar com o Two Phase Commit habilitado:

```
./gradlew bootRun -P2pc
```

Para desabilitar o Two Phase Commit:

```
./gradlew bootRun
```

## URL's

Utilizar as seguintes URL para verificar o comportamento com / sem Two Phase Commit:

http://localhost:8081/produce
