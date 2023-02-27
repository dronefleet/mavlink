# mavlink-protocol

A low-level Mavlink packet communication library with support for CRC validation and
signing.

The library provides 3 main utilities:

#### MavlinkFrameReader

Reads Mavlink frames from an `InputStream`. A frame constitutes what seems to be a complete
Mavlink packet. `MavlinkFrameReader` does not read any information from the packet except for
the magic marker and its length. Its API allows its users to drop frames that seem suspicious.

#### MavlinkPacketReader

Reads Mavlink1 and Mavlink2 packets from an `InputStream`. It returns data that was retrieved
from `MavlinkFrameReader` as `MavlinkPacket` instances.
 
#### MavlinkPacket

Represents a Mavlink packet, providing methods to easily access information in an unpacked form.
`MavlinkPacket` provides static builders which allow serializing Mavlink1 and Mavlink2 packets to
bytes, deserializing packets from bytes to object, as well as performing CRC validation/calculation
and signing.

## Get it

Maven Central coordinates are `io.dronefleet.mavlink:mavlink-protocol:1.1.10`

## Examples

### Reading and validating packets

```java
try (Socket socket = new Socket("127.0.0.1", 5760)) {
    MavlinkPacketReader reader = new MavlinkPacketReader(socket.getInputStream()); 
    MavlinkPacket packet;
    while ((packet = reader.next()) != null) {
        // Because of the way that Mavlink is built, you will likely require
        // more infrastructure in order to resolve what each packet means.
        
        // For the sake of example, we will handle a HEARTBEAT message in a hard-coded,
        // manual fashion.
        if (packet.getMessageId() == 0) { // Message ID 0 is a heartbeat message.
            
            // The CRC extra of a heartbeat message is 50 at the time of writing of
            // this example.
            if (!packet.validateCrc(50)) {
                // The CRC check did not pass. This means that we did not read the data
                // the way that it was intended or sent. We may now drop the packet to
                // try reading from position+1 (that is, we return the bytes of this
                // packet back and skip one byte, and try again).
                reader.drop();
                
            } else {
                // CRC validation passed. This is a valid packet that was read the
                // way that it was intended to be read.
            }
        } else {
            // Generally speaking, it's a good idea to drop packets which message ID is not
            // understood, because they cannot be validated (therefore if data is corrupted,
            // there is a chance of losing information).
            reader.drop();
        }
    }
} catch (EOFException e) {
    // Stream has ended
}
```

### Creating packets

The following are examples for creating Mavlink protocol packets:

```java
// Mavlink 1
MavlinkPacket packet1 = MavlinkPacket.createMavlink1Packet(
        sequence,
        systemId,
        componentId,
        messageId,
        crcExtra,
        payload);

// Mavlink 2, unsigned
MavlinkPacket packet2Unsigned = MavlinkPacket.createUnsignedMavlink2Packet(
        sequence,
        systemId,
        componentId,
        messageId,
        crcExtra,
        payload);

// Mavlink 2, signed
MavlinkPacket packet2Signed = MavlinkPacket.createSignedMavlink2Packet(
        sequence,
        systemId,
        componentId,
        messageId,
        crcExtra,
        payload,
        linkId,
        timestamp,
        secretKey);
```

The above packets are complete and ready to be sent. The creation methods calculate
CRC checksums and form signatures where appropriate.

### Obtaining packet bytes

Once may obtain the complete packet bytes from received and created packets
like so:

```java
MavlinkPacket packet = /* ... */;
byte[] packetBytes = packet.getRawBytes();
```

### Validating CRCs
CRC for packets can be validated:
```java
MavlinkPacket packet = /* ... */;
boolean validCrc = packet.validateCrc(crcExtra);
```

### Validating signatures
Signatures of signed version 2 packets can be validated:
```java
MavlinkPacket packet = /* ... */;
boolean validSignature = packet.validateSignature(secretKey);
```
