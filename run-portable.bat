@echo off
setlocal
cd /d "%~dp0"

where java >nul 2>nul
if errorlevel 1 (
  echo ERROR: Java is not installed or is not available in PATH.
  echo Ask the system administrator to provide Java before running this application.
  pause
  exit /b 1
)

if not exist "digital-voting-system.jar" (
  echo ERROR: digital-voting-system.jar was not found.
  echo Keep this BAT file in the same folder as the JAR.
  pause
  exit /b 1
)

java -jar "digital-voting-system.jar"
if errorlevel 1 (
  echo.
  echo The application exited with an error.
  pause
)
