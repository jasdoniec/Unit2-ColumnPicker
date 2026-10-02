# Unit 2 - Assignment 3: Column Picker

## Overview
In this final Karel recursive assignment, you will program a robot to analyze a world containing vertical columns of beepers (`RandomColumns.kwld`). 

* **Column Layout:** Columns start on **Street 2**, extend up to **8 streets high** (up to Street 9), and are spaced across avenues.
* **Goal:** Count the total number of beepers in each column and place a pile containing that exact total on **Street 1** directly below the column.
* **Example:** On Street 1, Avenue 2, the robot should place a pile of 5 beepers. On Street 1, Avenue 3, the robot should place 8 beepers.
* **Termination:** A single beeper placed on **Street 1** marks the end of the columns you must process.

---

## World Setup
This project uses a custom world file named `RandomColumns.kwld`. Ensure `RandomColumns.kwld` is placed directly in the root directory of your project folder alongside your `.java` files.

---

## How to Compile and Run

You can run this project using either the VS Code GUI or the integrated terminal.

### Option 1: VS Code GUI (Recommended)
1. Open `Driver.java`.
2. Click the **Play Icon** in the top-right corner, or press `F5`.

### Option 2: Integrated Terminal (Windows)
Because `KarelJRobot.jar` resides in the `lib/` folder, you must explicitly include the classpath (`-cp`) flag when compiling and running from the command line.

Open the integrated terminal in VS Code (`Ctrl + ~`) and run:

```cmd
javac -cp "lib/*;." ColumnPicker.java Driver.java
java -cp "lib/*;." Driver
```

---

## Suggested Architecture & Decomposition

Do **not** attempt to write this entire program inside one giant method. Good program design breaks complex tasks down into small, single-purpose helper methods. 

Consider decomposing your solution into the following functional pieces:

* **`countAndPlacePile()`**: Coordinates counting a single column and placing the resulting total at the base.
* **`countColumn(int numStreets)`**: Recursively navigates up a column of length `numStreets`, accumulates the total beepers, and returns the total integer count.
* **`countPile()`**: Recursively picks up all beepers on a single corner, counts them, replaces them during stack unwinding, and returns the count.
* **`putNBeepers(int n)`**: Recursively places `n` beepers on the current corner.
* **Movement Helpers:** Utilities such as `turnAround()` or `turnRight()` to keep your code clean and readable.

---

## Requirements & Constraints

* **Strictly No Loops:** You may **not** use `while` or `for` loops anywhere in your implementation. All movement, counting, and column iteration must be handled recursively.
* **State Preservation:** The original layout of beepers in every column must remain completely unchanged when your program finishes.
* **Return-Value Accumulation:** Use recursive method return values to pass counts back through the call stack during execution.

---

## Troubleshooting & Known Artifacts

* **`FileNotFoundException` for `RandomColumns.kwld`:** Ensure `RandomColumns.kwld` sits in the main assignment folder, not inside `lib/` or `.vscode/`.
* **Closing the GUI Window:** Closing the Karel GUI window after execution finishes may produce a harmless `java.lang.UnsupportedOperationException` in the terminal referencing `Thread.stop()`. This is a legacy artifact of the library on modern Java runtimes and can be safely ignored.
