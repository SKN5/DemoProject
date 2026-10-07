# Digital Voting System — DEMO UI

# DEMO — UI PROTOTYPE ONLY

This repository contains a **DEMO UI PROTOTYPE** for the Digital Voting System OOPS project. It is designed to demonstrate the screens, navigation and user flows before implementing the same interface in Java Swing/JavaFX.

**THIS IS NOT A REAL VOTING SYSTEM. DO NOT USE IT FOR REAL ELECTIONS OR REAL VOTING.**

## Goal

The browser version is temporary. The interface and flows are intentionally limited to features that can be implemented in the actual Java application.

### Planned Java implementation

- **Java Swing/JavaFX** — user interface
- **Java** — application logic
- **JDBC** — database access
- **SQLite** — persistent database
- **SHA-256** — password hashing concept specified by the project
- Database uniqueness — duplicate-vote prevention
- Transactions/rollback — atomic vote operations
- Audit records — accountability

## DEMO screens

- **Admin**
  - Overview
  - Candidate management
  - Voter management
  - Results
  - Audit log
- **Candidate**
  - Candidate dashboard
  - Results
  - Audit log
- **Voter**
  - Voter dashboard
  - Candidate selection
  - Vote confirmation
  - Results

## DEMO limitations

The browser demo intentionally uses simulated in-memory data.

- Any non-empty username/password is accepted.
- No real authentication occurs.
- No real SHA-256 password verification occurs.
- Votes are not written to SQLite.
- Data disappears when the page is refreshed.
- The displayed candidates/voters are sample data.
- The demo cannot provide real election security.

The actual Java project must implement the database and security requirements.

## Mapping to the project specification

The supplied project describes methods/modules including:

1. `connect()`
2. `initDatabase()`
3. `hash()`
4. `auth()`
5. `login()`
6. `manage()`
7. `vote()`
8. `tally()`

The DEMO only visualizes the user-facing behavior of these requirements. It does not replace their Java implementation.

## Files

- `index.html` — DEMO login and application shell
- `style.css` — responsive DEMO UI styling
- `app.js` — DEMO interactions and temporary in-memory state

## Run

Open `index.html` directly or use VS Code Live Server.

## Java feasibility

The UI uses ordinary concepts that map directly to Java Swing components:

| DEMO UI | Java Swing equivalent |
|---|---|
| Login form | JFrame + JPanel + JLabel + JTextField + JPasswordField + JComboBox + JButton |
| Navigation | JPanel + JButton |
| Dashboard cards | JPanel + JLabel |
| Tables | JTable + JScrollPane |
| Candidate cards | JPanel + JButton |
| Confirmation dialog | JOptionPane |
| Audit log | JTable/JTextArea |
| Results | JTable/JPanel with progress indicators |

The database operations can then be connected through JDBC to SQLite.

## GitHub Pages

The root contains `index.html`, so the **DEMO UI** is ready for GitHub Pages.