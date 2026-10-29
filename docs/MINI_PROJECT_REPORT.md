# MINI PROJECT REPORT
# TREASURE HUNT ADVENTURE: THE LOST TREASURE

**Project Title:** Treasure Hunt Adventure: The Lost Treasure

**Project Type:** Core Java Mini Project

**Programming Language:** Java

**GUI Technology:** Java Swing and AWT

**Version Control:** Git and GitHub

**Developers:**
1. Ruchita Pawar
2. Pratiksha Salunke

**GitHub Repository:** https://github.com/Ruchita2007/Treasure-Hunt-Adventure

---

## 1. ABSTRACT

Treasure Hunt Adventure: The Lost Treasure is an interactive adventure game developed using Core Java and Java Swing. The main purpose of this project is to demonstrate fundamental programming concepts through a simple, engaging, and user-friendly graphical game.

In this game, the player explores a maze-like environment, moves through different paths, collects coins, searches for a key, avoids dangerous traps, and attempts to reach the treasure and exit. The game uses a scoring system and a limited number of lives to make gameplay more interesting. A hint system can also guide the player by suggesting the next objective based on the current game situation, provided that the hint functionality is implemented in the source code.

The project demonstrates practical applications of object-oriented programming, conditional statements, loops, arrays, methods, event handling, and graphical user interface development. Java Swing is used to create the game window, display the playing area, and handle player interactions through keyboard or graphical controls.

This project is suitable for understanding how programming logic can be converted into a playable desktop application. It can be extended in the future with additional levels, sound effects, saved high scores, difficulty settings, and an improved hint mechanism.

**Keywords:** Core Java, Java Swing, Adventure Game, Maze, Treasure Hunt, Event Handling, Object-Oriented Programming.

---

## 2. INTRODUCTION

Computer games are an effective way to understand programming because they combine logical thinking, user interaction, problem-solving, and visual output. Developing a game requires the programmer to manage user input, maintain application state, apply rules, and provide appropriate feedback to the player.

Treasure Hunt Adventure: The Lost Treasure is designed as a desktop-based adventure game. The player navigates through a maze and tries to complete objectives while avoiding obstacles. Each movement can affect the player's score, progress, or remaining lives.

The game is developed using Java, a widely used object-oriented programming language. Java Swing provides the graphical components required to create the application window and display the game interface. Keyboard events and button actions allow the player to control the character.

The project focuses on applying classroom concepts to a practical application. It also introduces the basic development workflow of maintaining source code, documenting a project, and publishing the project through Git and GitHub.

---

## 3. PROBLEM STATEMENT

Beginners learning programming often find it difficult to understand how individual concepts such as loops, arrays, conditions, classes, objects, and event handling work together in a complete application.

A simple adventure game can provide a practical solution to this learning challenge. However, the game must have clear rules, meaningful objectives, interactive controls, and feedback that allows the player to understand the result of each action.

Therefore, the problem is to design and implement a simple graphical treasure-hunting game using Core Java in which the player navigates a maze, collects useful items, avoids traps, manages lives, and attempts to complete the game.

The application should be easy to run on a computer with a compatible Java Development Kit (JDK) and should have scope for future improvements.

---

## 4. OBJECTIVES

The main objectives of the project are:

1. To develop an interactive desktop game using Core Java.
2. To understand and implement object-oriented programming concepts.
3. To create a graphical user interface using Java Swing and AWT.
4. To implement player movement using keyboard controls and, where available, on-screen buttons.
5. To represent a maze or game board using a suitable data structure.
6. To implement coin collection and score calculation.
7. To introduce a key-based objective and treasure discovery.
8. To manage player lives and obstacles such as traps.
9. To implement level progression, if supported by the game logic.
10. To explore a hint system that can guide the player based on game progress.
11. To practise compiling, testing, debugging, and documenting a Java application.
12. To publish the source code in a GitHub repository for version control and project sharing.

---

## 5. SCOPE OF THE PROJECT

The project is intended for educational and demonstration purposes. It can be used by students who are learning Java programming and graphical application development.

The scope includes:

- A desktop-based graphical game.
- A maze or grid-based playing environment.
- Player movement and collision checks.
- Collectible objects and score management.
- Keys, treasure, exits, and traps according to the implemented rules.
- Lives or failure conditions.
- A restart or replay option, if provided by the application.
- A code repository and project documentation.

The current version is designed for local execution on a computer. It does not require an online game server or a database unless additional functionality is introduced.

---

## 6. SOFTWARE AND HARDWARE REQUIREMENTS

### 6.1 Hardware Requirements

| Component | Minimum Requirement |
|---|---|
| Processor | Any modern dual-core processor |
| RAM | 4 GB or more recommended |
| Storage | Sufficient free space for JDK, IDE, and project files |
| Display | Standard laptop or desktop display |
| Input | Keyboard; mouse or touchpad recommended |

These are general recommendations for a small Java Swing application.

### 6.2 Software Requirements

| Software | Purpose |
|---|---|
| Java Development Kit (JDK) | Compiling and running Java code |
| Visual Studio Code or another Java IDE | Writing and editing source code |
| Git | Tracking changes in the project |
| GitHub | Hosting and sharing source code |
| Windows, Linux, or macOS | Operating system |

The installed JDK must be compatible with the Java source code. The game uses standard Java desktop libraries such as Swing and AWT.

---

## 7. TECHNOLOGIES USED

### 7.1 Core Java

Java is the main programming language used to implement the game logic. It supports classes, objects, methods, arrays, conditional statements, loops, and event-driven programming.

### 7.2 Java Swing

Swing is used to create the graphical interface of the game. Components such as `JFrame` and `JPanel` can be used to create the main window and draw the playing area.

### 7.3 Java AWT

Abstract Window Toolkit (AWT) provides supporting functionality for graphics, colours, fonts, keyboard events, and other graphical operations.

### 7.4 Git

Git is a distributed version control system. It helps track changes in source files and maintain project history through commits.

### 7.5 GitHub

GitHub hosts the project's Git repository online. It allows the developers to share source code, documentation, and project updates.

---

## 8. GAME DESCRIPTION

The game places the player in a maze-like environment containing different paths, obstacles, and objectives. The player must explore the available area and make decisions about which direction to move.

The main goal is to find the required items and reach the treasure or exit according to the game's rules.

### 8.1 Player Movement

The player moves through the playing area using the available controls. The game checks whether the requested movement is valid before updating the player's position.

If a movement leads to a blocked cell or wall, the game should prevent the player from moving through it.

### 8.2 Coin Collection

Coins act as collectible items. When the player reaches a coin, the game updates the score and removes or marks the coin as collected.

The score provides feedback about the player's progress.

### 8.3 Key Collection

The key is an important objective of the adventure. Depending on the implemented rules, the player may need to collect the key before accessing the exit or completing the level.

### 8.4 Treasure Discovery

The treasure represents the main reward of the game. Finding it contributes to completing the adventure and may provide additional points.

### 8.5 Traps and Lives

Traps act as obstacles. If the player enters a trap, the game may reduce the remaining lives or apply another penalty according to the implemented logic.

When the player runs out of lives, the game can display a failure message or offer a restart.

### 8.6 Exit and Level Completion

The exit represents the destination of the maze. The game checks whether the player has satisfied the required conditions before allowing the level to be completed.

If multiple levels are implemented, completing one level can lead to the next level.

### 8.7 Smart Hint System

A hint system can assist the player when progress becomes difficult. It can consider the player's current position and the status of important objectives.

For example:
- If the key has not been collected, the hint can suggest finding the key.
- If the key has been collected but the treasure has not been found, the hint can suggest exploring further for the treasure.
- If the required objectives are complete, the hint can guide the player toward the exit.

The hints should reflect the actual game state. This feature should be described as implemented only if the corresponding logic exists in the submitted Java source code.

---

## 9. SYSTEM DESIGN

The game can be understood as a collection of cooperating logical components.

### 9.1 Input Module

The input module receives player actions through keyboard controls or on-screen buttons. It identifies the requested movement and sends it to the game logic.

### 9.2 Game Logic Module

The game logic module validates movement, checks collisions, updates the player position, processes collected items, and determines whether an action changes the game state.

### 9.3 Score and Lives Module

This module maintains the player's score and remaining lives. It updates these values when the player collects rewards or encounters penalties.

### 9.4 Hint Module

If implemented, the hint module examines the player's current state and provides a relevant suggestion about the next objective.

### 9.5 Display Module

The display module renders the game board, player, obstacles, items, score, lives, and status messages. It refreshes the interface when the game state changes.

### 9.6 Level and Completion Module

This module checks the conditions required to complete a level or finish the game.

### 9.7 System Flow

The following flow represents the general gameplay sequence:

```text
        START
          |
          v
   Initialize Game
          |
          v
    Display Maze
          |
          v
   Read Player Input
          |
          v
    Validate Move
          |
          v
  Update Player Position
          |
          v
 Check Items and Traps
          |
          v
 Update Score and Lives
          |
          v
  Check Game Objectives
          |
          v
  Display Status or Hint
          |
          v
 Check Completion Condition
       /       \
      No        Yes
      |          |
      v          v
  Continue    Show Result
  Gameplay        |
      |           v
      +------->  END
```

This is a conceptual flow; the exact sequence depends on the implementation in the Java source file.

---

## 10. ALGORITHM

The following algorithm describes the general gameplay.

**Step 1:** Start the application.

**Step 2:** Initialize the game board, player position, score, lives, and objective states.

**Step 3:** Display the game window and playing area.

**Step 4:** Read the player's movement input.

**Step 5:** Calculate the proposed next position.

**Step 6:** Check whether the movement is valid and does not cross a blocked cell.

**Step 7:** If the movement is valid, update the player position.

**Step 8:** Check whether the new position contains a coin, key, treasure, trap, or exit.

**Step 9:** Update the score, lives, and objective states according to the game rules.

**Step 10:** If a hint system is implemented, generate a hint using the current position and unfinished objectives.

**Step 11:** Check whether the player has completed the required objectives or lost all lives.

**Step 12:** If the game is continuing, refresh the display and return to Step 4.

**Step 13:** Otherwise, display the appropriate result and end the game or allow a restart.

---

## 11. JAVA CONCEPTS USED

### 11.1 Classes and Objects

Classes define the structure and behaviour of the application. Objects represent instances of those classes. For example, a class extending `JFrame` can represent the game window.

### 11.2 Inheritance

Inheritance allows a class to reuse and extend the behaviour of another class. In a Swing application, the main game class may extend `JFrame`, or a custom drawing panel may extend `JPanel`.

### 11.3 Encapsulation

Encapsulation groups data and the methods that operate on it. Player position, score, lives, and objective states can be maintained as fields and updated through controlled methods.

### 11.4 Arrays

A two-dimensional array can represent a maze or grid. Each cell can represent a path, wall, coin, trap, or other game object.

### 11.5 Conditional Statements

Statements such as `if`, `else if`, and `else` are used to check movement validity, handle collected objects, update lives, and determine whether objectives are complete.

### 11.6 Loops

Loops are useful for iterating through rows and columns of a grid, initializing the game board, and processing collections of game elements.

### 11.7 Methods

Methods divide the program into manageable tasks, such as moving the player, checking collisions, updating the score, drawing the board, and restarting the game.

### 11.8 Event Handling

Java Swing event listeners respond to user interactions. Keyboard input and button clicks can trigger movement or other game actions.

### 11.9 Graphical User Interface

Swing components provide the main window and display area. Graphics methods can be used to draw tiles, characters, objects, and text.

### 11.10 State Management

The game maintains a state consisting of the player's position, score, remaining lives, collected items, and completion status. Each valid action may update this state.

---

## 12. IMPLEMENTATION DETAILS

The application is implemented as a Java desktop program.

The main class creates the game window and initializes the required game state. A grid or map is used to represent the playing environment. The player's position is updated in response to input events.

When the player requests movement, the program calculates the next cell and validates it against the map. If movement is permitted, the player's position changes and the game checks for objects or obstacles at the new location.

Collectible items update the player's score or objective state. Traps can reduce the remaining lives. The game then refreshes the display to show the latest position and status.

If the program includes a smart hint system, the hint logic examines the current state and chooses an appropriate suggestion. This approach helps keep the hint system connected to the player's actual progress.

The exact class names, variable names, point values, number of levels, and game rules should be documented according to the final source code.

---

## 13. TESTING

Testing is required to verify that the game behaves correctly for different player actions.

| Test Case | Action | Expected Result |
|---|---|---|
| 1 | Launch the application | The game window opens |
| 2 | Move in a valid direction | The player position updates |
| 3 | Attempt to move through a wall | The move is blocked |
| 4 | Move onto a coin | The score updates |
| 5 | Collect the key | The key status updates |
| 6 | Encounter a trap | The configured penalty is applied |
| 7 | Reach the treasure | The treasure status or score updates |
| 8 | Attempt to use the exit | The game checks the exit requirements |
| 9 | Request a hint | A relevant hint appears, if implemented |
| 10 | Restart the game | The game returns to its initial state, if restart is implemented |

**Note:** These are proposed test cases. A test should be marked as passed only after testing the actual application and confirming the result.

---

## 14. ADVANTAGES

1. Provides practical experience with Core Java.
2. Demonstrates how programming concepts work together.
3. Offers an interactive graphical interface.
4. Encourages logical thinking and problem-solving.
5. Shows how user input can control application behaviour.
6. Demonstrates basic state management and event handling.
7. Can be run locally without a dedicated game server.
8. Can be maintained and shared using GitHub.
9. Provides a foundation for adding more advanced game features.
10. Encourages collaboration and shared project documentation.

---

## 15. LIMITATIONS

1. The game is designed primarily for desktop use.
2. The game environment and rules are limited to the implemented design.
3. The current version may not save player progress after closing.
4. The game may not support multiplayer gameplay.
5. The quality of the hint system depends on the rules used to generate suggestions.
6. The game may have limited graphics and sound compared with commercial games.
7. Additional testing is required to ensure all movement and completion conditions work correctly.

---

## 16. FUTURE SCOPE

The project can be enhanced in several ways.

### 16.1 Additional Levels

More maze layouts, puzzles, obstacles, and challenges can be added to increase replay value.

### 16.2 Improved Hint System

The hint system can be improved to provide more precise directions based on the map, player position, available paths, and remaining objectives. A pathfinding algorithm such as Breadth-First Search (BFS) could be explored for finding routes through a grid.

### 16.3 High-Score Management

The application can store the best scores in a file or database so that players can compare their results across sessions.

### 16.4 Sound Effects

Background music and sound effects can be added for collecting coins, finding the treasure, losing a life, or completing a level.

### 16.5 Difficulty Levels

Easy, medium, and hard modes can vary the maze layout, number of traps, available lives, or other game rules.

### 16.6 Improved Visual Design

Sprites, animations, menus, and improved graphics can make the game more visually attractive.

### 16.7 Save and Resume

A save feature could allow the player to continue a previous game instead of starting again.

---

## 17. CONTRIBUTION OF DEVELOPERS

The project was developed collaboratively by Ruchita Pawar and Pratiksha Salunke.

The work may include planning the game, implementing the Java program, designing the user interface, testing gameplay, preparing documentation, and maintaining the GitHub repository.

The exact contribution of each developer should be described according to the work actually completed by the team.

---

## 18. CONCLUSION

Treasure Hunt Adventure: The Lost Treasure is a practical educational project that demonstrates the use of Core Java and Java Swing to develop an interactive desktop game.

The project combines player input, movement validation, game-state updates, scoring, obstacles, and objective completion into one application. It provides practical exposure to object-oriented programming, arrays, conditional statements, methods, event handling, and graphical user interface development.

The project also demonstrates the importance of testing, documentation, and version control. Publishing the source code on GitHub makes it easier to share the application, track changes, and maintain project documentation.

Overall, this mini project provides a useful foundation for understanding Java-based application development and can be extended with improved graphics, additional levels, persistent high scores, and more advanced hint generation.

---

## 19. REFERENCES

1. Oracle Java Documentation: https://docs.oracle.com/en/java/
2. Java Swing Tutorial: https://docs.oracle.com/javase/tutorial/uiswing/
3. Git Documentation: https://git-scm.com/doc
4. GitHub Documentation: https://docs.github.com/
5. Project Source Code: https://github.com/Ruchita2007/Treasure-Hunt-Adventure
