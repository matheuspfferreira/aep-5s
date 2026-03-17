# 📌 Projeto: Sistema de Atendimento ao Cidadão — ObservaAção

## 📖 Contexto

Em muitas cidades, a população enfrenta dificuldades para:

- Entender como solicitar serviços públicos (iluminação, buracos, poda, saúde, zeladoria);
- Acompanhar o andamento (protocolos que somem, falta de retorno, respostas genéricas);
- Ter acesso claro a informações públicas (orçamento, contratos, filas, prioridades);
- Registrar demandas sem medo (ex.: denúncia de assédio, abuso, irregularidade) e com proteção de identidade.

Esses problemas:

- Enfraquecem a confiança nas instituições;
- Aumentam a desigualdade (quem “tem contato” resolve);
- Geram sensação de abandono.

---

## 🏢 Proposta

Vocês foram contratados por uma govtech fictícia chamada **ObservaAção**, que venceu um edital para criar um sistema simples que permita ao cidadão:

- Registrar solicitações de serviços (com categoria, descrição, localização e prioridade);
- Acompanhar status com clareza e prazos;
- Receber retorno objetivo e histórico do atendimento;
- Permitir que servidores/gestores tratem demandas com rastreabilidade e organização.

---

## 🎯 Objetivo do Projeto

Este projeto integrável propõe a criação de uma solução digital voltada a um problema real da comunidade, considerando:

- **IHC (Interação Humano-Computador):** entendimento dos usuários;
- **POO (Programação Orientada a Objetos):** estruturação do sistema;
- **Manutenção de Software:** qualidade, evolução e sustentabilidade.

A proposta vai além do resultado final, focando no processo e no pensamento crítico:

- Para quem a solução existe?
- Quem pode ser excluído por ela?
- Quais impactos ela gera?
- Como ela pode ser mantida e evoluída com responsabilidade?

> ⚠️ O objetivo não é “fazer um app bonito”, mas criar um sistema que:
>
> - Reduza barreiras;
> - Aumente a transparência;
> - Melhore a capacidade de resposta.

---

## 🧩 Escopo do Sistema (Mínimo Obrigatório)

### 📥 Cadastro de Solicitação

- Categoria (ex.: iluminação, buraco, limpeza, saúde, segurança escolar, etc.);
- Descrição;
- Anexo (opcional);
- Localização (texto/bairro);
- Opção de envio:
  - Identificado;
  - Anônimo (com regras diferentes).

---

### 🔄 Fila de Atendimento e Status

Fluxo de estados:
- Aberto → Triagem → Em Execução → Resolvido → Encerrado

- Histórico de movimentações com:
  - Data;
  - Responsável.

---

### 🔍 Acompanhamento pelo Cidadão

- Busca por protocolo;
- Visualização de:
  - Prazos;
  - Justificativas (em caso de atraso).

---

### 🧑‍💼 Painel do Atendente/Gestor

- Listagem de demandas por:
  - Prioridade;
  - Bairro;
  - Categoria;
- Atualização de status com **comentário obrigatório**.

---

## ⚙️ Regras Críticas

Estas regras devem gerar discussão e decisões técnicas:

- **Anonimato**
  - Limita campos pessoais;
  - Exige detalhes mínimos obrigatórios.

- **Prioridade**
  - Define SLA (prazo alvo);
  - Considera impacto social.

- **Prevenção de abuso**
  - Campos obrigatórios;
  - Validações;
  - Registro em log.

---

## 💾 Banco de Dados

- Opcional no 1º bimestre:
  - Pode ser em memória ou arquivo;
- Recomendado no 2º bimestre:
  - Implementação com banco de dados.

---

## 🚀 Resultado Esperado

Um sistema funcional que:

- Diminua barreiras de acesso a serviços públicos;
- Aumente transparência;
- Organize o atendimento;
- Promova equidade no acesso aos serviços.

---
