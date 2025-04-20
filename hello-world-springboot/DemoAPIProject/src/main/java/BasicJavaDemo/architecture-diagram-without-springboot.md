# Java App Architecture Flow
1.Main creates an instance of cUserRepository.
2.Passes it to bUserService while creating it.
3.Passes the bUserService instance to aUserController.
4.The controller calls getUserGreetingMsg() on the service.
5.The service gets the username from the repository.
6.The service builds a greeting message.
7.The controller prints the message to the console.


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
