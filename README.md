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
choice for you.

#### generator gradle plugin
Used in order to generate dialect-specific sources. The generated sources depend upon the
classes of this root project, and therefore the plugin is unlikely to be of any use as a 
stand-alone -- If you are writing your own dialect XML files, then forking this project
is likely your best bet.

#### mavlink (root project)
A higher level API which provides its users with a complete abstraction from the lower level 
protocol. This is likely what you want if you're after making an application that communicates
with Mavlink devices.

## Get it

Still no maven release.