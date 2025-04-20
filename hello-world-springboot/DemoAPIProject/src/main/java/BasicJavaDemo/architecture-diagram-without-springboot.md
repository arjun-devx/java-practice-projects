# Java App Architecture Flow

This document explains the request flow in the Java application consisting of the following classes:

- `Main`
- `aUserController`
- `bUserService`
- `cUserRepository`

---

## 📈 Sequence Diagram

```mermaid
sequenceDiagram
    participant Main
    participant Controller
    participant Service
    participant Repository

    Main->>Repository: new cUserRepository()
    Main->>Service: new bUserService(repository)
    Main->>Controller: new aUserController(service)
    Controller->>Service: getUserGreetingMsg()
    Service->>Repository: getUserName()
    Repository-->>Service: "Arjun"
    Service-->>Controller: "Hello! Welcome to our app Arjun"
    Controller-->>Main: Print greeting
