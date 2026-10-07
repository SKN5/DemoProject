# Running Without Administrator Rights

The Windows deployment is designed for a target computer where **Java is already installed but other development/database software cannot be installed without administrator approval**.

## Target computer

The target user only needs:

- Java available through the `java` command
- Permission to run Java applications

The target does **not** need:

- Administrator privileges
- Maven
- JDK
- XAMPP
- MySQL
- SQLite installed separately
- Git
- Internet access

The SQLite JDBC driver is already packaged inside the application's shaded JAR.

## Build computer

The build computer needs:

- JDK 8+
- Maven

From the repository root, run:

```text
package-portable.bat
```

The script runs:

```text
mvn clean package
```

and copies the resulting self-contained JAR into:

```text
dist/
├── digital-voting-system.jar
└── run-voting-system.bat
```

## Move to the restricted computer

Copy the entire `dist` folder to a location the normal user can access, such as:

- Desktop
- Documents
- Downloads
- USB storage

Then double-click:

```text
run-voting-system.bat
```

The batch file runs:

```text
java -jar digital-voting-system.jar
```

No installation is performed.

## Why administrator rights are not required

The application is not installed into `Program Files`, does not create a Windows service, and does not require Maven or XAMPP.

The SQLite database is stored at:

```text
%USERPROFILE%\\.digital-voting-system\\voting.db
```

This location belongs to the current Windows user and normally does not require administrator access.

## Java version

The source is compatible with Java 8+. The target machine only needs a compatible Java runtime/JDK.

You can verify Java on the target computer with:

```text
java -version
```

If `java` is not available, the project cannot install it without administrator rights; the machine administrator would need to provide Java.

## Application Admin vs Windows Administrator

The application's **ADMIN** role is completely separate from Windows administrator privileges.

A normal Windows user can launch the application. The ADMIN role only controls project features such as candidate/voter management and audit-log access.

## Demo credentials

Admin: `admin / admin123`

Candidate: `candidate / candidate123`

Voter: `voter / voter123`

These credentials are for the educational project only.

## Security policy limitation

If the school/lab computer has a policy that blocks Java execution, unknown JAR files, batch files, or applications from USB/Downloads, the project cannot and should not bypass that policy. The administrator would need to allow the application.
