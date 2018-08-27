# Overview
A Java SDK for communication using the Mavlink1 and Mavlink2 protocols.

## Structure

The project is made up of 3 components:
#### mavlink-protocol
A low-level API which deals with reading and writing packets. It does not have any
knowledge of dialects or about the meaning of messages. It does, however, provide infrastructure
for packet CRC validation as well as packet signing. The required implementation or 
session-specific information (such as message CRC extra and signing parameters) have to be 
provided, though. If you are after making your own high-level design then this is likely the 
choice for you. If you would like to use mavlink-protocol without the rest of the components of 
this repository, then you can read [mavlink-protocol's README](https://github.com/dronefleet/mavlink/tree/master/mavlink-protocol)
to learn how.

#### generator gradle plugin
Used in order to generate dialect-specific sources. The generated sources depend upon the
classes of this root project, and therefore the plugin is unlikely to be of any use as a 
stand-alone -- If you are writing your own dialect XML files, then forking this project
is likely what you're after.

#### mavlink (root project)
A higher level API which provides its users with a complete abstraction from the lower level 
protocol. This is likely what you want if you're after making an application that communicates
with Mavlink devices.

## Get it

Maven Central coordinates are `io.dronefleet.mavlink:mavlink:1.0.6`

## Examples

#### Brief
This is a brief example for the minimum required to communicate using Mavlink1 with the
default dialects.

```java
// Reading
MavlinkConnection connection = MavlinkConnection.create(in, out); // InputStream, OutputStream
MavlinkMessage message;
while ((message = connection.next()) != null) {
    // ...
}

// Writing
connection.send(new MavlinkMessage<>(
        255, // our system id
        0, // our component id (0 if we're a ground control system)
        Heartbeat.builder()
                .type(MavType.MAV_TYPE_GCS)
                .autopilot(MavAutopilot.MAV_AUTOPILOT_INVALID)
                .systemStatus(MavState.MAV_STATE_UNINIT)
                .mavlinkVersion(3)
                .build()));

```

#### Detailed
This is a detailed example of how to use the API to read and write messages.
```java
// This example uses a TCP socket, however we may also use a UDP socket by injecting
// PipedInputStream/PipedOutputStream to MavlinkConnection, or even USB by using any
// implementation that will eventually yield an InputStream and an OutputStream.
try (Socket socket = new Socket("127.0.0.1", 5760)) {
    
    // After establishing a connection, we proceed to building a MavlinkConnection instance.
    // Basically, the options conclude at mapping different autopilots to dialects, and
    // specifying configuration for packet signing.
    MavlinkConnection connection = MavlinkConnection.builder(socket.getInputStream(), socket.getOutputStream())
            
            // Dialects are associated to systems when a heartbeat is received. The heartbeat
            // informs us of the autopilot of the device, which tells us which dialect
            // that device adheres to.
            .dialect(MavAutopilot.MAV_AUTOPILOT_GENERIC, new StandardDialect())
            .dialect(MavAutopilot.MAV_AUTOPILOT_ARDUPILOTMEGA, new ArdupilotmegaDialect())
            
            // When specifying signing configuration, every Mavlink2Message that is send
            // through this connection will be signed. We will need to setup signing
            // by sending Mavlink1 messages before we can communicate with Mavlink2 messages.
            .signing(new SigningConfiguration(
                    0, // This is the initial timestamp for signing, We should only specify
                                // a value other than 0 if we do not trust that our system's clock is
                                // going to be calibrated prior to the connection. Generally, this value
                                // is loaded from persistence (where the last signature timestamp is stored)

                    1,    // The signing link ID. Generally, this should be connection-bound. So if there
                                // is more than a single connection, each of them has to have a different value.

                    // Secret key, should be 36 bytes in length. The specification recommends using a
                    // SHA-256'd passphrase.
                    MessageDigest.getInstance("SHA-256")
                            .digest("my secret key".getBytes(StandardCharsets.UTF_8))
            ))
            .build();

    // Now we are ready to read and send messages.
    MavlinkMessage message;
    while ((message = connection.next()) != null) {
        
        // The received message could be either a Mavlink1 message, or a Mavlink2 message.
        // To check if the message is a Mavlink2 message, we could do the following:
        if (message instanceof Mavlink2Message) {
            // This is a Mavlink2 message.
        }
        
        // When a message is received, its payload type isn't statically available.
        // You can resolve which kind of message it is by its payload, like so:
        if (message.getPayload() instanceof Heartbeat) {
            // This is a heartbeat message
            MavlinkMessage<Heartbeat> heartbeatMessage = (MavlinkMessage<Heartbeat>)message;
        }
        // We are likely better off by publishing the payload to a pub/sub mechanism such 
        // as RxJava, JMS or any other favorite instead, though.
        
    }
} catch (EOFException eof) {
    // The stream has ended. This is where we may want to start retrying or reporting that the
    // host has disconnected.
}
```