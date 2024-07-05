# Chess System Java

:chess_pawn: __Jogo de Xadrez__ :chess_pawn:

## Introduction

Project developed during the course of [Complete Java](https://www.udemy.com/course/java-curso-completo/) of the Udemy platform through the [![Linkedin](https://i.stack.imgur.com/gVE0j.png) Prof. Dr. Nelio Alves](https://br.linkedin.com/in/nelio-alves). The repository of my activities in the course can be accessed [here](https://github.com/leo4215/Java-practice).

This project consolidates the knowledge acquired so far in the course, which includes, but is not limited to:

* Classes: default constructors, attributes, encapsulation, getters and setters, instance and class (static) methods, overloads, real and abstract classes, etc;
* Project-oriented programming, logic, and organization: inheritance, polymorphism, method overriding, dependency injection, associations, encapsulation, enumeration, downcasting, upcasting, layered architecture pattern, exception handling, lists, arrays, sequential, repetitive (for and while) and conditional (if-else and ternary) structures, UML diagram, code versioning, clean code, etc;

## Project Design

The project is based on two layers: the __Board layer__ and __Chess layer__. The board is a matrix. Each element of the matrix may or may not contain a piece. However, the way we access this matrix is different between the layers. In the __Board layer__, we have all the control logic for the board. The matrix indices are the integers corresponding to the list indices. We have the Position class, which represents a position in the matrix. The abstract Piece class represents the piece on the matrix through the Position and the abstract methods of possible movements. The Board class describes the board physically and its state. Finally, in this layer, we have the BoardException class to handle board exceptions.

The __Chess layer__ groups all the board pieces (King, Bishop, Knight, Pawn, Queen, Rook), which are entities (classes) that extend the abstract ChessPiece class, and this extends the Piece class from the other layer. Thus, each piece inherits the attributes and methods of the superclasses. Each piece implements its movement rules and special moves (if any). The game control logic (checkmate) is in the ChessMatch class of this layer, which also includes exception handling through the ChessException class, the Color enum, and the ChessPosition class. In this layer, the matrix indices are accessed with the user-friendly UI rule, i.e., through letters and numbers. The letters from a to h represent the columns, and the numbers from 1 to 8 represent the rows of the board. Therefore, conversion between the board coordinates is necessary.

Next, the UML diagram of the project (course material credits):
![](hhttps://github.com/leo4215/chess-system-java/blob/44aff3f941b51ff12a63eb042709a703293f525f/misc/chess-system-design.png)

## Development and Execution Environment

The project was developed in the Visual Studio Code IDE (version 1.80), on Windows 11, using Java OpenJDK 17. However, it can also be executed in later versions.

The program can be run directly from the IDE console or the terminal command line.

To run directly in the terminal, use the exported project file `chess-system-java.jar`. From the root folder of the cloned repository, execute:

```
java -cp exported/chess-system-java.jar application.Program
```

> Remember that you need to have Java installed on your machine, version 11 or higher.

The program screen should be executed similarly to the one shown below:

![](https://github.com/leo4215/chess-system-java/blob/44aff3f941b51ff12a63eb042709a703293f525f/misc/screen.png)

The turn starts with the White pieces (WHITE). The program's UI prompts for the source position of the piece to move (Source). For example: "a2" selects the White Pawn from position A2. Confirm with ENTER, and then the program will prompt for the target (Target) new position of the piece, for example "a4". Note that the program already displays possible moves for the piece and handles possible movement errors. After a valid move by the current player, it moves to the opponent's turn, i.e., the Black piece (BLACK). After completing the turn, the sequence repeats for the next one. Captured pieces are shown after each round.

## Work hours

The project was guided by 33 video lessons from the course, totaling approximately 5 hours and 45 minutes of recordings, and involved development activities for about 10 hours, in May 2024.

## Content: Chess game system - 33 lessons - 5h45m

1. Overview of the Chess Game System Chapter (Visão geral do capítulo Sistema Jogo de Xadrez)
2. Chapter Support Material (Material de apoio do capítulo)
3. Creating Project and Git Repository (Criando projeto e repositório Git)
4. First Class - Position (Primeira classe - Position)
5. Starting to Implement Board and Piece (Começando a implementar Board e Piece)
6. Chess Layer and Printing the Board (Camada Chess e imprimindo o tabuleiro)
7. Placing Pieces on the Board (Colocando peças no tabuleiro)
8. BoardException and Defensive Programming (BoardException e programação defensiva)
9. ChessException and ChessPosition (ChessException e ChessPosition)
10. Small Improvement in Board Printing (Pequena melhoria na impressão do tabuleiro)
11. Moving Pieces (Movendo peças)
12. Handling Exceptions and Clearing the Screen (Tratando exceções e limpando a tela)
13. Possible Moves of a Piece (Movimentos possíveis de uma peça)
14. Implementing Rook's Possible Moves (Implementando movimentos possíveis da Torre)
15. Printing Possible Moves (Imprimindo os movimentos possíveis)
16. Implementing King's Possible Moves (Implementando os movimentos possíveis do Rei)
17. Switching Players Each Turn (Trocando de jogador a cada turno)
18. Handling Captured Pieces (Manipulando peças capturadas)
19. Check Logic - PART 1 (Lógica de xeque - PARTE 1)
20. Check Logic - PART 2 (Lógica de xeque - PARTE 2)
21. Checkmate Logic (Lógica de xequemate)
22. Counting Piece Moves (Contagem de movimentos das peças)
23. Pawn (Peão)
24. Bishop (Bispo)
25. Knight (Cavalo)
26. Queen (Rainha)
27. Special Move Castling - PART 1 (Jogada especial Roque - PARTE 1)
28. Special Move Castling - PART 2 (Jogada especial Roque - PARTE 2)
29. Special Move En Passant - PART 1 (Jogada especial en passant - PARTE 1)
30. Special Move En Passant - PART 2 (Jogada especial en passant - PARTE 2)
31. Special Move Promotion (Jogada especial promoção)
32. Compliance Update (Atualização de compliance)
33. Enhancing Promotion Handling (Dando um tratamento melhor para promoção)
