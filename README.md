# Chain

## Task

The objective is to collect more points
than the other player by taking links out of either end of a chain. Each link has a value, and
you are only allowed to take links from the ends (you can take them from either end of the
chain).

## Getting Started

### Prerequisites

- IDE: IntelliJ IDEA
- Java: JDK 17
- Build tool: Maven 3.10.1

### Dependencies

- JUnit 5.9.2
- Mockito 5.3.1

## Gameplay

Initial random chain is generated. The console asks the player to choose which end of the chain (link)
to be removed from the structure and its value is added to his score.

> 0 4 -8 5 100 -9

Player can type "1" (for LEFT end) or "2" (for RIGHT end):

> Player 1, it's your turn.
> Choose which end of the chain to take a link from:
>
> 1.  LEFT end
> 2.  RIGHT end

After every choice, the current score is displayed as well as the chain without the previously chosen link.

> Score:
>
> Player 1 - -9
>
> Player 2 - "0"
>
> Current chain:
>
> 0 4 -8 5 100

The end of the game occurs when the last link is picked. The score is displayed as well
as the winner (or "DRAW" if score is even).

> GAME OVER
>
> Score:
>
> Player 1 - -17
>
> Player 2 - 109
>
> Winner is: Player 2

## Requirements

- The starting length of the chain should be a random number between 5 and 100
- There are two players
- Player 1 always goes first

### Quickstart

- Run "Application" class
- Follow instructions in the console
  - Players' interaction with the console application is to choose whether to take left link or right link.

### Tests

The application is 100% covered with unit tests. Additional integration tests are added to simulate a game.
The tests can be found in the "test" directory. Integration tests are located in "GameTest" class.

### JavaDoc

JavaDoc is provided for more convenient documentation's view (HTML).

> Location of the file: javadoc/index.html

## Author

[![Ivan Parnarev Linkedin](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/ivan-parnarev/)
