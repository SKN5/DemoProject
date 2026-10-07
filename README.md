# Digital Voting System — UI Prototype

Temporary browser UI for the Digital Voting System OOPS project, based on the supplied project specification.

## Included requirements

- Role-based access: **Admin, Candidate, Voter**
- SHA-256 authentication concept
- Admin candidate management
- Admin voter management
- One-vote / duplicate-vote prevention
- Live vote counts and candidate ranking
- Audit-log view
- Atomic transaction / rollback concepts
- Java + JDBC + SQLite as the intended application/database stack

The project specification lists Swing/JavaFX as a **future GUI enhancement**, so this repository currently contains the requested temporary HTML UI.

## Files

- `index.html` — login and application shell
- `style.css` — responsive interface
- `app.js` — prototype state and interactions

## Run

Open `index.html` directly or use VS Code Live Server.

Any non-empty username/password is accepted by the prototype. Select a role to see its permitted menu.

## Production integration

This is **not the final secure voting backend**. The browser demo stores its state in memory.

The Java application should implement the project's backend responsibilities:

1. `connect()`
2. `initDatabase()`
3. `hash()`
4. `auth()`
5. `login()`
6. `manage()`
7. `vote()`
8. `tally()`

Production authentication, SHA-256 password handling, JDBC operations, SQLite persistence, database uniqueness, audit records, and atomic transactions/rollback must be implemented in Java.

## GitHub Pages

The repository root contains `index.html`, so it is ready to be published through GitHub Pages using the `main` branch and root folder.