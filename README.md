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
- JDK 17+ recommended for packaging
- Maven

Run:

```bash
mvn clean package
java -jar target/digital-voting-system-1.0.jar
```

Or:

```bash
mvn compile exec:java
```

## Windows: run without administrator rights

The project includes a portable Windows packaging script:

`package-portable.bat`

On the **build computer**, install JDK 17+ and Maven, then run:

```text
package-portable.bat
```

It creates:

```text
dist\\DigitalVotingSystem\\DigitalVotingSystem.exe
```

This is an **app-image**, not a system-wide installer.

Copy the entire `DigitalVotingSystem` folder to another Windows computer and launch:

```text
DigitalVotingSystem.exe
```

The target computer does **not** need:

- Windows administrator privileges
- XAMPP
- MySQL
- Maven
- Git
- Java installed separately

The Java runtime is bundled into the application image.

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

A normal Windows user can launch the portable application. The application's Admin role only controls the project's administrative features.

This project is not intended for real elections.
