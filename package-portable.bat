@echo off
setlocal
where java >nul 2>nul
if errorlevel 1 (
  echo ERROR: JDK not found on the build computer.
  pause
  exit /b 1
)
where mvn >nul 2>nul
if errorlevel 1 (
  echo ERROR: Maven not found on the build computer.
  pause
  exit /b 1
)
call mvn clean package
if errorlevel 1 (
  echo ERROR: Maven build failed.
  pause
  exit /b 1
)
if exist dist rmdir /s /q dist
mkdir dist
jpackage --type app-image --name DigitalVotingSystem --input target --main-jar digital-voting-system-1.0.jar --main-class voting.Main --dest dist --app-version 1.0 --vendor "Student OOP Project" --description "Digital Voting System - Java Swing and SQLite"
if errorlevel 1 (
  echo ERROR: jpackage failed. Use JDK 17 or newer.
  pause
  exit /b 1
)
echo.
echo BUILD COMPLETE
echo Portable app: dist\DigitalVotingSystem\DigitalVotingSystem.exe
echo Copy the entire DigitalVotingSystem folder to another PC.
echo No administrator installation, XAMPP, or Java installation is required on the target PC.
pause
