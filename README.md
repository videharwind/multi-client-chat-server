\Java Multi-Client Chat Application (Socket Programming)



\Overview:



This project implements a basic multi-client chat system using Java TCP sockets.

A central server accepts multiple client connections and broadcasts messages from any client to all connected clients.







\Features:



\1. Multi-client support using multithreading

\2. Real-time message broadcasting

\3. Simple console-based interaction


\How It Works:



\Server



\*Listens on port `5000`

\*Accepts incoming client connections

\*Spawns a new thread (`clientHandler`) for each client

\*Maintains a shared set of client output streams

\*Broadcasts messages to all connected clients



\Client



\Connects to `127.0.0.1:5000`

\Uses two threads:



&#x20; \*SendingMsg → Reads input from user and sends to server

&#x20; \*ReceiveMsg → Receives messages from server and prints to console

\How to Run



\1. Compile



```

javac server.java

javac client.java

```



\2. Start Server



```

java server

```



\3. Run Client(s)



(Open multiple terminals for multiple clients)



```

java client

```






\Important Notes



\* Typing `exit` removes the client from the broadcast list

\* The server runs continuously until manually stopped









\Concepts Used



\* Java Socket Programming (`ServerSocket`, `Socket`)

\* Multithreading (`Thread`, `Runnable`)

\* Input/Output Streams (`BufferedReader`, `PrintWriter`)

\* Synchronization (`synchronized` blocks)












\License



This project is intended for educational purposes and is free to use.



