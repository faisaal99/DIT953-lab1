@ECHO OFF
REM This batch file is used to compile and run the java files.
REM Author: Faisal A.

REM Compile all files
javac -d labOutput src/*.java
java -cp labOutput Program
