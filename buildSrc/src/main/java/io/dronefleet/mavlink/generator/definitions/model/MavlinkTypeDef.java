package io.dronefleet.mavlink.generator.definitions.model;

import java.util.HashMap;
import java.util.Map;

public class MavlinkTypeDef {

    private static final Map<String, Integer> typeLengths = new HashMap<String, Integer>() {{
        put("float", 4);
        put("double", 8);
        put("char", 1);
        put("int8_t", 1);
        put("uint8_t", 1);
        put("uint8_t_mavlink_version", 1);
        put("int16_t", 2);
        put("uint16_t", 2);
        put("int32_t", 4);
        put("uint32_t", 4);
        put("int64_t", 8);
        put("uint64_t", 8);
    }};

    private static final Map<String, String> convertedTypes = new HashMap<String, String>() {{
        put("uint8_t_mavlink_version", "uint8_t");
        put("array", "uint8_t");
    }};

    public static MavlinkTypeDef fromXmlValue(String xmlValue) {
        String originalType;
        String convertedType;
        int arrayLength;
        int typeLength;
        int wireLength;

        if (xmlValue.endsWith("]")) {
            int lenIdx = xmlValue.lastIndexOf("[");
            if (lenIdx == -1) {
                throw new IllegalArgumentException("Malformed XML type: " + xmlValue);
            }
            originalType = xmlValue.substring(0, lenIdx);
            arrayLength = Integer.parseInt(xmlValue.substring(lenIdx + 1, xmlValue.length() - 1));
        } else {
            originalType = xmlValue;
            arrayLength = 0;
        }


        if (convertedTypes.containsKey(originalType)) {
            convertedType = convertedTypes.get(originalType);
        } else if (typeLengths.containsKey(originalType)) {
            convertedType = originalType;
        } else if (typeLengths.containsKey(originalType + "_t")) {
            convertedType = originalType + "_t";
        } else {
            throw new IllegalArgumentException("Unknown type " + originalType);
        }

        typeLength = typeLengths.get(convertedType);
        wireLength = Math.max(1, arrayLength) * typeLength;

        return new MavlinkTypeDef(
                originalType,
                convertedType,
                typeLength,
                arrayLength,
                wireLength);
    }

    private final String originalType;
    private final String convertedType;
    private final int typeLength;
    private final int arrayLength;
    private final int wireLength;

    public MavlinkTypeDef(
            String originalType,
            String convertedType,
            int typeLength,
            int arrayLength,
            int wireLength) {
        this.originalType = originalType;
        this.convertedType = convertedType;
        this.typeLength = typeLength;
        this.arrayLength = arrayLength;
        this.wireLength = wireLength;
    }

    public String getOriginalType() {
        return originalType;
    }

    public String getConvertedType() {
        return convertedType;
    }

    public int getTypeLength() {
        return typeLength;
    }

    public int getArrayLength() {
        return arrayLength;
    }

    public int getWireLength() {
        return wireLength;
    }

    public boolean isArray() {
        return getArrayLength() > 0;
    }

    @Override
    public String toString() {
        return "MavlinkTypeDef{" +
                "originalType='" + originalType + '\'' +
                ", convertedType='" + convertedType + '\'' +
                ", typeLength=" + typeLength +
                ", arrayLength=" + arrayLength +
                ", wireLength=" + wireLength +
                '}';
    }
}
