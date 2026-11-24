# App Armazenamento Interno (Java Android)

> Repositório didático: exercício prático de Android nativo com **Java**, desenvolvido e aplicado em sala de aula pelo Prof. Fabricio Curvello.

## Sobre o projeto

Aplicativo que grava e lê uma mensagem em um arquivo no **armazenamento interno** do aparelho. Os dados continuam disponíveis mesmo depois que o app é fechado.

## Contexto acadêmico

Exercício aplicado em sala de aula, usado como prática guiada com os alunos.

## O que o app faz

- Campo de texto para o usuário digitar uma mensagem.
- Botão **Salvar**: grava a mensagem no arquivo `dados.txt` no armazenamento interno do app (`openFileOutput` com `MODE_PRIVATE`) e informa se deu certo.
- Botão **Carregar**: lê o arquivo e exibe a mensagem salva.
- Preserva o texto exibido quando a tela é recriada (por exemplo, ao girar o aparelho), usando `onSaveInstanceState`.

## Conceitos trabalhados em aula

- **Armazenamento interno** privado do app (`openFileOutput` / `openFileInput`)
- Persistência de dados entre execuções do app
- Tratamento de exceções com *try-with-resources*
- Preservação de estado da Activity com `onSaveInstanceState` / `onRestoreInstanceState`

## Tecnologias

- **Java**
- **Android SDK** (Android Studio)
- **Gradle**
- `minSdk 28` / `compileSdk 34`

## Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/fabcurvello/AppArmazenamentoInternoJavaAndroid.git
   ```
2. Abra a pasta no **Android Studio** e aguarde a sincronização do Gradle.
3. Execute em um emulador ou dispositivo físico com Android compatível com a API 28 ou superior.

## Veja também

Outros repositórios de aula com o mesmo tema:

- [AppArmazenamentoInternoAnimaUNA](https://github.com/fabcurvello/AppArmazenamentoInternoAnimaUNA)
- [AppArmazenamentoInternoAnima](https://github.com/fabcurvello/AppArmazenamentoInternoAnima)
- [AppArmazenamentoInternoJava](https://github.com/fabcurvello/AppArmazenamentoInternoJava)
- [AppArmazenamentoInternoKotlin](https://github.com/fabcurvello/AppArmazenamentoInternoKotlin)

## Autor

**Fabricio Curvello**: professor de desenvolvimento de software no SENAI-RJ (desde 1997) e em faculdades do grupo Ânima Educação (IBMR e UNA).

- GitHub: [github.com/fabcurvello](https://github.com/fabcurvello)
- LinkedIn: [linkedin.com/in/fabriciocurvello](https://www.linkedin.com/in/fabriciocurvello)
- YouTube: [@fabriciocurvello](https://www.youtube.com/@fabriciocurvello)
