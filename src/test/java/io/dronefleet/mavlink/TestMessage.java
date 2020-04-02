package io.dronefleet.mavlink;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;

import java.util.Objects;

@MavlinkMessageInfo(
        id = 0,
        crc = 0,
        description = "Test message"
)
public class TestMessage {

    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    private final String text;

    private TestMessage(String text) {
        this.text = text;
    }

    @MavlinkFieldInfo(
            position = 1,
            unitSize = 1,
            arraySize = 50,
            description = "Status text message, without null termination character"
    )
    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestMessage that = (TestMessage) o;
        return Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }

    @Override
    public String toString() {
        return "TestMessage{" +
                "text='" + text + '\'' +
                '}';
    }

    public static class Builder {
        private String text;

        private Builder() {
        }

        @MavlinkFieldInfo(
                position = 1,
                unitSize = 1,
                arraySize = 50,
                description = "Status text message, without null termination character"
        )
        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public TestMessage build() {
            return new TestMessage(text);
        }
    }
}
