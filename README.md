\# Java Multi-Client Chat Application (Socket Programming)



\## Overview



This project implements a basic multi-client chat system using Java TCP sockets.

A central server accepts multiple client connections and broadcasts messages from any client to all connected clients.



\---



\## Features



\* Multi-client support using multithreading

\* Real-time message broadcasting

\* Simple console-based interaction

\* No external dependencies (pure Java)



\---



\## Project Structure



```

.

├── server.java   # Server-side implementation

├── client.java   # Client-side implementation

├── README.md

└── .gitignore

```



\---



\## How It Works



\### Server



\* Listens on port `5000`

\* Accepts incoming client connections

\* Spawns a new thread (`clientHandler`) for each client

\* Maintains a shared set of client output streams

\* Broadcasts messages to all connected clients



\### Client



\* Connects to `127.0.0.1:5000`

\* Uses two threads:



&#x20; \* \*\*SendingMsg\*\* → Reads input from user and sends to server

&#x20; \* \*\*ReceiveMsg\*\* → Receives messages from server and prints to console



\---



\## How to Run



\### 1. Compile



```

javac server.java

javac client.java

```



\### 2. Start Server



```

java server

```



\### 3. Run Client(s)



(Open multiple terminals for multiple clients)



```

java client

```



\---



\## Example Usage



1\. Start the server

2\. Launch multiple clients

3\. Type a message in any client terminal

4\. Message will be broadcast to all connected clients



\---



\## Important Notes



\* Typing `exit` removes the client from the broadcast list

\* The server runs continuously until manually stopped

\* No authentication or encryption is implemented



\---



\## Concepts Used



\* Java Socket Programming (`ServerSocket`, `Socket`)

\* Multithreading (`Thread`, `Runnable`)

\* Input/Output Streams (`BufferedReader`, `PrintWriter`)

\* Synchronization (`synchronized` blocks)



\---



\## Limitations



\* No username or identity system

\* No proper disconnection handling

\* Console-based (no GUI)

\* No security (plain text communication)



\---



\## Possible Improvements



\* Add usernames for clients

\* Implement private messaging

\* Add GUI (JavaFX or Swing)

\* Improve connection cleanup

\* Add encryption (SSL/TLS)

\* Maintain chat history



\---



\## License



This project is intended for educational purposes and is free to use.



