@echo off
setlocal

where java >nul 2>nul
if errorlevel 1 (
  echo ERROR: Java was not found on the build computer.
  pause
  exit /b 1
)

where mvn >nul 2>nul
if errorlevel 1 (
  echo ERROR: Maven was not found on the build computer.
  pause
  exit /b 1
)

echo Building the self-contained Java JAR...
call mvn clean package
if errorlevel 1 (
  echo ERROR: Maven build failed.
  pause
  exit /b 1
)

if not exist target\digital-voting-system-1.0.jar (
  echo ERROR: Shaded JAR was not created.
  pause
  exit /b 1
)

if exist dist rmdir /s /q dist
mkdir dist
copy /y target\digital-voting-system-1.0.jar dist\digital-voting-system.jar >nul
copy /y run-portable.bat dist\run-voting-system.bat >nul

echo.
echo BUILD COMPLETE
echo.
echo Deployment folder:
echo dist
echo.
echo Files:
echo   dist\digital-voting-system.jar
echo   dist\run-voting-system.bat
echo.
echo The target PC only needs Java installed.
echo No Maven, XAMPP, MySQL, SQLite installation, Git, or Windows administrator rights are required.
echo Copy the entire dist folder to the target PC.
echo.
pause
