@echo off
setlocal
set "APP=dist\DigitalVotingSystem\DigitalVotingSystem.exe"
if not exist "%APP%" (
  echo Portable application was not built yet.
  echo Run package-portable.bat first on the build computer.
  pause
  exit /b 1
)
start "" "%APP%"
