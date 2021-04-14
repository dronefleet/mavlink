# This project is not actively maintained
At present time and for a long while now, unfortunately, I have not been able to put time and love into `dronefleet/mavlink`. I may provide quick help within open issues, but it's hard to promise much more than that.

If you maintain a fork of this project that's in reasonable condition for users to depend on, please open an issue and I'll link to your repository from this README.

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

Maven Central coordinates are `io.dronefleet.mavlink:mavlink:1.1.9`

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
connection.send1(
        255, /* systemId */
        0, /* componentId */
        Heartbeat.builder()
             .type(MavType.MAV_TYPE_GCS)
             .autopilot(MavAutopilot.MAV_AUTOPILOT_INVALID)
             .systemStatus(MavState.MAV_STATE_UNINIT)
             .mavlinkVersion(3)
             .build()));

```

#### Reading & disambiguating messages
This is a detailed example of how to use the API to read and write messages.
```java
// This example uses a TCP socket, however we may also use a UDP socket by injecting
// PipedInputStream/PipedOutputStream to MavlinkConnection, or even USB by using any
// implementation that will eventually yield an InputStream and an OutputStream.
try (Socket socket = new Socket("127.0.0.1", 5760)) {
    // After establishing a connection, we proceed to building a MavlinkConnection instance.
    MavlinkConnection connection = MavlinkConnection.create(
            socket.getInputStream(), 
            socket.getOutputStream());

    // Now we are ready to read and send messages.
    MavlinkMessage message;
    while ((message = connection.next()) != null) {
        // The received message could be either a Mavlink1 message, or a Mavlink2 message.
        // To check if the message is a Mavlink2 message, we could do the following:
        if (message instanceof Mavlink2Message) {
            // This is a Mavlink2 message.
            Mavlink2Message message2 = (Mavlink2Message)message;
            
            if (message2.isSigned()) {
                // This is a signed message. Let's validate its signature.
                if (message2.validateSignature(mySecretKey)) {
                    // Signature is valid.
                } else {
                    // Signature validation failed. This message is suspicious and
                    // should not be handled. Perhaps we should log this incident.
                }
            } else {
                // This is an unsigned message.
            }
        } else {
           // This is a Mavlink1 message.
        }
        
        // When a message is received, its payload type isn't statically available.
        // We can resolve which kind of message it is by its payload, like so:
        if (message.getPayload() instanceof Heartbeat) {
            // This is a heartbeat message
            MavlinkMessage<Heartbeat> heartbeatMessage = (MavlinkMessage<Heartbeat>)message;
        }
        // We are better off by publishing the payload to a pub/sub mechanism such 
        // as RxJava, JMS or any other favorite instead, though.
    }
} catch (EOFException eof) {
    // The stream has ended.
}
```

#### Writing Mavlink 2 messages
```java
int systemId = 255;
int componentId = 0;
Heartbeat heartbeat = Heartbeat.builder()
          .type(MavType.MAV_TYPE_GCS)
          .autopilot(MavAutopilot.MAV_AUTOPILOT_INVALID)
          .systemStatus(MavState.MAV_STATE_UNINIT)
          .mavlinkVersion(3)
          .build()

// Write an unsigned heartbeat
connection.send2(systemId, componentId, heartbeat);

// Write a signed heartbeat
int linkId = 1;
long timestamp = /* provide microsecond time */;
byte[] secretKey = MessageDigest.getInstance("SHA-256")
                       .digest("a secret phrase".getBytes(StandardCharsets.UTF_8))
connection.send2(systemId, componentId, heartbeat, linkId, timestamp, secretKey);
```
