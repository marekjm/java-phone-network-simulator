# Phone network simulator

The simulator is a network of microservices waiting for commands on sockets.
There are two types of nodes in the network:

- `Cell`: a microservice representing a phone tower,
- `Phone`: a microservice representing a phone,

There is no limit imposed on number of cells and phones in a network.
The network is only limited by available number of ports (that still leaves
about 64000 nodes).

----

## Cells

Cells are spawned using either one of the following commands:

- `java Cellular.Cell <port>`: a standalone cell, usually used for spawning the first cell
  in a network,
- `java Cellular.Cell <port> <nearby-cell>`: a cell that is linked to a `<nearby-cell>`,

Both `<port>` and `<nearby-cell>` must be valid port numbers (sockets are opened on them).
Cells are noninteractive nodes, they only route, send, and respond to messages.

----

## Phones

Phones are spawned using this command: `java Cellular.Phone <port> '<number>'`.
The command will create a process representing a phone with number `<number>`, with a
socket open on port `<port>`.

Once a phone is running, it must be registered in a cell using `register <port>` command
where `<port>` is a port on which there is a `Cell` listening.
After connecting, a phone may send the following messages to the network:

- `trace <number>`: trace a number, returns a path to the given phone number,
- `unregister`: unregisters from a cell,
- `send <number> <message>`: send a one word message to `<number>`, message will still be
  sent even if the number is untraceable (it will not be delievered, though),
- `receive`: receive and print first message waiting in queue, prints empty string if there
  are no messages waiting,
