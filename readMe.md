# Drawing Canvas

#### Please find ClassDiagram.png to get high level overview of application objects

####  Program Overview
* DrawingConsole is java program created using maven structure
* Starting point of application is DrawingConsoleApplication.java
* Once started application ask for command as an input to run
* List of valid commands can be found by typing  "help" command on terminal/command
  prompt once asked for "enter command : "
* Basic idea is you will need canvas to draw any object like line, rectangle
* You can also fill canvas with color(use any character as color)

#### Running Program:
* Prerequisite - java 8 version should be available/installed on target machine.
* Extract archive - in DrawingConsoleV1/target, you will find DrawingCanvas.jar
* Open command prompt on Windows OR terminal on Mac/Linux/Unix
* Navigate to DrawingCanvas.jar on command prompt or terminal
* Run jar with command java -jar DrawingCanvas.jar
* Start playing with drawing console application.

#### Updating existing functionality
* All display messages are referenced from MessageConstants.java file
  and This will be central location for any message change.
* After any changes, please build program with 'maven clean install' command.
* To run above command, please install maven on target  machine.

#### Assumptions and restrictions
* Reverse line and rectangle are  not allowed i.e x1,y1 coordinates should always have lesser value than x2, y2
* We have added restrictions on canvas size as max of 150 * 100 (width * height)
* Max height and width can be updated from MessageConstants.java
#### Additional feature
* Use command 'clear' to clear all objects drawn in canvas

#### Commands and Sample outputs
* For commands and sample output, please refer problem.txt