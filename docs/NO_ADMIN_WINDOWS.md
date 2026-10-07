# Running Without Administrator Rights

The Windows version is designed as a portable application image, not a system-wide installer.

## Target computer

The finished portable build includes its own Java runtime and SQLite JDBC dependency.

The target user does not need:
- Administrator privileges
- XAMPP
- MySQL
- Maven
- Git
- A separate Java installation

## Build

The build computer needs JDK 17 or newer and Maven.

From the repository root:

package-portable.bat

The output is:

dist\DigitalVotingSystem\DigitalVotingSystem.exe

## Move to another computer

Copy the entire DigitalVotingSystem folder from dist to Desktop, Documents, Downloads, or a USB drive.

Then double-click DigitalVotingSystem.exe.

Do not copy only the EXE. The folder contains the bundled Java runtime and required files.

## Why no administrator rights are needed

The project uses jpackage with --type app-image. This creates a self-contained application directory instead of a system-wide installer.

The SQLite database is stored at:

%USERPROFILE%\.digital-voting-system\voting.db

This is inside the normal user's profile and does not require write access to Program Files.

## Application Admin vs Windows Administrator

The application's ADMIN role is separate from Windows administrator privileges.

A normal Windows user can run the application. The ADMIN role only controls project features such as candidate/voter management and audit-log access.

## Demo credentials

Admin: admin / admin123
Candidate: candidate / candidate123
Voter: voter / voter123

These credentials are for the educational project only.

## SmartScreen

A locally built executable may trigger Windows SmartScreen because it is not digitally signed. That is separate from administrator privileges. Production deployment should use code signing.
