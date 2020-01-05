package io.dronefleet.mavlink.common;

import io.dronefleet.mavlink.annotations.MavlinkFieldInfo;
import io.dronefleet.mavlink.annotations.MavlinkMessageBuilder;
import io.dronefleet.mavlink.annotations.MavlinkMessageInfo;
import io.dronefleet.mavlink.util.EnumValue;
import java.lang.Deprecated;
import java.lang.Enum;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collection;
import java.util.Objects;

/**
 * Information about a component. For camera components instead use {@link io.dronefleet.mavlink.common.CameraInformation CAMERA_INFORMATION}, and 
 * for autopilots use {@link io.dronefleet.mavlink.common.AutopilotVersion AUTOPILOT_VERSION}. Components including GCSes should consider 
 * supporting requests of this message via MAV_CMD_REQUEST_MESSAGE. 
 * @deprecated This message is a work in progress. It may be modified in a non backward-compatible 
 * way in a future release without any warning. This version of the message may not even work with 
 * autopilots that support this message due to discrepancies between dialect versions. Unless 
 * you completely understand the risks of doing so, don't use it. 
 */
@MavlinkMessageInfo(
        id = 395,
        crc = 231,
        description = "Information about a component. For camera components instead use CAMERA_INFORMATION, and for autopilots use AUTOPILOT_VERSION. Components including GCSes should consider supporting requests of this message via MAV_CMD_REQUEST_MESSAGE.",
        workInProgress = true
)
@Deprecated
public final class ComponentInformation {
    private final long timeBootMs;

    private final byte[] vendorName;

    private final byte[] modelName;

    private final long firmwareVersion;

    private final long hardwareVersion;

    private final EnumValue<ComponentCapFlags> capabilityFlags;

    private final int componentDefinitionVersion;

    private final String componentDefinitionUri;

    private ComponentInformation(long timeBootMs, byte[] vendorName, byte[] modelName,
            long firmwareVersion, long hardwareVersion,
            EnumValue<ComponentCapFlags> capabilityFlags, int componentDefinitionVersion,
            String componentDefinitionUri) {
        this.timeBootMs = timeBootMs;
        this.vendorName = vendorName;
        this.modelName = modelName;
        this.firmwareVersion = firmwareVersion;
        this.hardwareVersion = hardwareVersion;
        this.capabilityFlags = capabilityFlags;
        this.componentDefinitionVersion = componentDefinitionVersion;
        this.componentDefinitionUri = componentDefinitionUri;
    }

    /**
     * Returns a builder instance for this message.
     */
    @MavlinkMessageBuilder
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Timestamp (time since system boot). 
     */
    @MavlinkFieldInfo(
            position = 2,
            unitSize = 4,
            description = "Timestamp (time since system boot)."
    )
    public final long timeBootMs() {
        return this.timeBootMs;
    }

    /**
     * Name of the component vendor 
     */
    @MavlinkFieldInfo(
            position = 3,
            unitSize = 1,
            arraySize = 32,
            description = "Name of the component vendor"
    )
    public final byte[] vendorName() {
        return this.vendorName;
    }

    /**
     * Name of the component model 
     */
    @MavlinkFieldInfo(
            position = 4,
            unitSize = 1,
            arraySize = 32,
            description = "Name of the component model"
    )
    public final byte[] modelName() {
        return this.modelName;
    }

    /**
     * Version of the component firmware (v &lt;&lt; 24 &amp; 0xff = Dev, v &lt;&lt; 16 &amp; 0xff = Patch, v &lt;&lt; 8 &amp; 0xff = Minor, v &amp; 
     * 0xff = Major) 
     */
    @MavlinkFieldInfo(
            position = 5,
            unitSize = 4,
            description = "Version of the component firmware (v << 24 & 0xff = Dev, v << 16 & 0xff = Patch, v << 8 & 0xff = Minor, v & 0xff = Major)"
    )
    public final long firmwareVersion() {
        return this.firmwareVersion;
    }

    /**
     * Version of the component hardware (v &lt;&lt; 24 &amp; 0xff = Dev, v &lt;&lt; 16 &amp; 0xff = Patch, v &lt;&lt; 8 &amp; 0xff = Minor, v &amp; 
     * 0xff = Major) 
     */
    @MavlinkFieldInfo(
            position = 6,
            unitSize = 4,
            description = "Version of the component hardware (v << 24 & 0xff = Dev, v << 16 & 0xff = Patch, v << 8 & 0xff = Minor, v & 0xff = Major)"
    )
    public final long hardwareVersion() {
        return this.hardwareVersion;
    }

    /**
     * Bitmap of component capability flags. 
     */
    @MavlinkFieldInfo(
            position = 7,
            unitSize = 4,
            enumType = ComponentCapFlags.class,
            description = "Bitmap of component capability flags."
    )
    public final EnumValue<ComponentCapFlags> capabilityFlags() {
        return this.capabilityFlags;
    }

    /**
     * Component definition version (iteration) 
     */
    @MavlinkFieldInfo(
            position = 8,
            unitSize = 2,
            description = "Component definition version (iteration)"
    )
    public final int componentDefinitionVersion() {
        return this.componentDefinitionVersion;
    }

    /**
     * Component definition URI (if any, otherwise only basic functions will be available). The XML 
     * format is not yet specified and work in progress. 
     */
    @MavlinkFieldInfo(
            position = 9,
            unitSize = 1,
            arraySize = 140,
            description = "Component definition URI (if any, otherwise only basic functions will be available). The XML format is not yet specified and work in progress."
    )
    public final String componentDefinitionUri() {
        return this.componentDefinitionUri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !getClass().equals(o.getClass())) return false;
        ComponentInformation other = (ComponentInformation)o;
        if (!Objects.deepEquals(timeBootMs, other.timeBootMs)) return false;
        if (!Objects.deepEquals(vendorName, other.vendorName)) return false;
        if (!Objects.deepEquals(modelName, other.modelName)) return false;
        if (!Objects.deepEquals(firmwareVersion, other.firmwareVersion)) return false;
        if (!Objects.deepEquals(hardwareVersion, other.hardwareVersion)) return false;
        if (!Objects.deepEquals(capabilityFlags, other.capabilityFlags)) return false;
        if (!Objects.deepEquals(componentDefinitionVersion, other.componentDefinitionVersion)) return false;
        if (!Objects.deepEquals(componentDefinitionUri, other.componentDefinitionUri)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + Objects.hashCode(timeBootMs);
        result = 31 * result + Objects.hashCode(vendorName);
        result = 31 * result + Objects.hashCode(modelName);
        result = 31 * result + Objects.hashCode(firmwareVersion);
        result = 31 * result + Objects.hashCode(hardwareVersion);
        result = 31 * result + Objects.hashCode(capabilityFlags);
        result = 31 * result + Objects.hashCode(componentDefinitionVersion);
        result = 31 * result + Objects.hashCode(componentDefinitionUri);
        return result;
    }

    @Override
    public String toString() {
        return "ComponentInformation{timeBootMs=" + timeBootMs
                 + ", vendorName=" + vendorName
                 + ", modelName=" + modelName
                 + ", firmwareVersion=" + firmwareVersion
                 + ", hardwareVersion=" + hardwareVersion
                 + ", capabilityFlags=" + capabilityFlags
                 + ", componentDefinitionVersion=" + componentDefinitionVersion
                 + ", componentDefinitionUri=" + componentDefinitionUri + "}";
    }

    public static final class Builder {
        private long timeBootMs;

        private byte[] vendorName;

        private byte[] modelName;

        private long firmwareVersion;

        private long hardwareVersion;

        private EnumValue<ComponentCapFlags> capabilityFlags;

        private int componentDefinitionVersion;

        private String componentDefinitionUri;

        /**
         * Timestamp (time since system boot). 
         */
        @MavlinkFieldInfo(
                position = 2,
                unitSize = 4,
                description = "Timestamp (time since system boot)."
        )
        public final Builder timeBootMs(long timeBootMs) {
            this.timeBootMs = timeBootMs;
            return this;
        }

        /**
         * Name of the component vendor 
         */
        @MavlinkFieldInfo(
                position = 3,
                unitSize = 1,
                arraySize = 32,
                description = "Name of the component vendor"
        )
        public final Builder vendorName(byte[] vendorName) {
            this.vendorName = vendorName;
            return this;
        }

        /**
         * Name of the component model 
         */
        @MavlinkFieldInfo(
                position = 4,
                unitSize = 1,
                arraySize = 32,
                description = "Name of the component model"
        )
        public final Builder modelName(byte[] modelName) {
            this.modelName = modelName;
            return this;
        }

        /**
         * Version of the component firmware (v &lt;&lt; 24 &amp; 0xff = Dev, v &lt;&lt; 16 &amp; 0xff = Patch, v &lt;&lt; 8 &amp; 0xff = Minor, v &amp; 
         * 0xff = Major) 
         */
        @MavlinkFieldInfo(
                position = 5,
                unitSize = 4,
                description = "Version of the component firmware (v << 24 & 0xff = Dev, v << 16 & 0xff = Patch, v << 8 & 0xff = Minor, v & 0xff = Major)"
        )
        public final Builder firmwareVersion(long firmwareVersion) {
            this.firmwareVersion = firmwareVersion;
            return this;
        }

        /**
         * Version of the component hardware (v &lt;&lt; 24 &amp; 0xff = Dev, v &lt;&lt; 16 &amp; 0xff = Patch, v &lt;&lt; 8 &amp; 0xff = Minor, v &amp; 
         * 0xff = Major) 
         */
        @MavlinkFieldInfo(
                position = 6,
                unitSize = 4,
                description = "Version of the component hardware (v << 24 & 0xff = Dev, v << 16 & 0xff = Patch, v << 8 & 0xff = Minor, v & 0xff = Major)"
        )
        public final Builder hardwareVersion(long hardwareVersion) {
            this.hardwareVersion = hardwareVersion;
            return this;
        }

        /**
         * Bitmap of component capability flags. 
         */
        @MavlinkFieldInfo(
                position = 7,
                unitSize = 4,
                enumType = ComponentCapFlags.class,
                description = "Bitmap of component capability flags."
        )
        public final Builder capabilityFlags(EnumValue<ComponentCapFlags> capabilityFlags) {
            this.capabilityFlags = capabilityFlags;
            return this;
        }

        /**
         * Bitmap of component capability flags. 
         */
        public final Builder capabilityFlags(ComponentCapFlags entry) {
            return capabilityFlags(EnumValue.of(entry));
        }

        /**
         * Bitmap of component capability flags. 
         */
        public final Builder capabilityFlags(Enum... flags) {
            return capabilityFlags(EnumValue.create(flags));
        }

        /**
         * Bitmap of component capability flags. 
         */
        public final Builder capabilityFlags(Collection<Enum> flags) {
            return capabilityFlags(EnumValue.create(flags));
        }

        /**
         * Component definition version (iteration) 
         */
        @MavlinkFieldInfo(
                position = 8,
                unitSize = 2,
                description = "Component definition version (iteration)"
        )
        public final Builder componentDefinitionVersion(int componentDefinitionVersion) {
            this.componentDefinitionVersion = componentDefinitionVersion;
            return this;
        }

        /**
         * Component definition URI (if any, otherwise only basic functions will be available). The XML 
         * format is not yet specified and work in progress. 
         */
        @MavlinkFieldInfo(
                position = 9,
                unitSize = 1,
                arraySize = 140,
                description = "Component definition URI (if any, otherwise only basic functions will be available). The XML format is not yet specified and work in progress."
        )
        public final Builder componentDefinitionUri(String componentDefinitionUri) {
            this.componentDefinitionUri = componentDefinitionUri;
            return this;
        }

        public final ComponentInformation build() {
            return new ComponentInformation(timeBootMs, vendorName, modelName, firmwareVersion, hardwareVersion, capabilityFlags, componentDefinitionVersion, componentDefinitionUri);
        }
    }
}
