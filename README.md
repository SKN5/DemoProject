# Digital Voting System

**Student OOP Project — Educational / Demo Use**

This repository contains the Digital Voting System project with both the original browser UI prototype and the standalone Java Swing application.

## Standalone Java application

The actual application uses:

- Java Swing
- JDBC
- SQLite
- SHA-256 password hashing
- Transaction/rollback for voting
- Database uniqueness for one vote per voter
- Audit logging
- Admin, Candidate and Voter roles

The Java source is under:

`src/main/java/voting/`

## Run during development

Requirements on the development computer:

- JDK 8+ for the Java source
- Maven
- JDK 17+ is not required for the target computer

Run:

```bash
mvn clean package
java -jar target/digital-voting-system-1.0.jar
```

Or:

```bash
mvn compile exec:java
```

## Windows: target computer has Java only

The intended deployment is a **plain Java JAR**. The target computer does not need a Java development environment or any database/server software.

The build computer runs:

```text
package-portable.bat
```

This runs Maven and creates:

```text
dist/
├── digital-voting-system.jar
└── run-voting-system.bat
```

Copy the entire `dist` folder to the target Windows computer.

Then double-click:

```text
run-voting-system.bat
```

The target computer needs only:

- Java installed and available through `java`
- Permission to run Java applications

It does **not** need:

- Windows administrator privileges
- Maven
- XAMPP
- MySQL
- SQLite installed separately
- Git
- JDK
- Internet access

The SQLite JDBC driver is packaged inside the application JAR, so there is no separate SQLite installation.

### Database location

The application stores SQLite data in the current Windows user's profile:

```text
%USERPROFILE%\\.digital-voting-system\\voting.db
```

This avoids writing to protected locations such as `Program Files`.

See [docs/NO_ADMIN_WINDOWS.md](docs/NO_ADMIN_WINDOWS.md) for the deployment procedure.

## Demo credentials

| Role | Username | Password |
|---|---|---|
| Admin | `admin` | `admin123` |
| Candidate | `candidate` | `candidate123` |
| Voter | `voter` | `voter123` |

These credentials are for the college demonstration only.

## Java project structure

```text
Project/
├── pom.xml
├── package-portable.bat
├── run-portable.bat
├── docs/
│   └── NO_ADMIN_WINDOWS.md
└── src/
    └── main/
        └── java/
            └── voting/
                ├── Main.java
                ├── User.java
                ├── Candidate.java
                ├── Security.java
                ├── VotingSystem.java
                ├── LoginFrame.java
                ├── AdminFrame.java
                ├── CandidateFrame.java
                └── VoterFrame.java
```

## Browser UI prototype

The repository also retains the original browser prototype:

- `index.html`
- `style.css`
- `app.js`

It can be opened directly in a browser or served with VS Code Live Server.

The browser version is a UI prototype and does not replace the Java/SQLite implementation.

## Important distinction

The application's **ADMIN role** is not the same as a Windows administrator account.

A normal Windows user can launch the Java application. The application's Admin role only controls the project's administrative features.

If the target computer has a policy that blocks unknown Java applications or JAR files, that restriction cannot be bypassed by the project; the system administrator would need to permit the application.

This project is not intended for real elections.
