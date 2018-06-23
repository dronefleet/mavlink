package io.dronefleet.mavlink.common;

import com.benbarkay.events.EventEmitter;
import com.benbarkay.events.EventSource;
import io.dronefleet.mavlink.MavlinkDialect;
import java.lang.Class;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.util.Collections;
import java.util.Set;

public final class CommonDialect implements MavlinkDialect<CommonVehicle> {
    private static final Set<MavlinkDialect> dependencies;

    static {
        dependencies = Collections.emptySet();
    }

    @Override
    public final CommonVehicle newVehicle(int systemId, EventSource<Object> incoming,
            EventEmitter<Object> outgoing) {
        return new CommonVehicle.Impl(systemId, incoming, outgoing);
    }

    @Override
    public final boolean supports(int messageId) {
        switch (messageId) {
            case 0:
            case 1:
            case 2:
            case 4:
            case 5:
            case 6:
            case 7:
            case 11:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 54:
            case 55:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 69:
            case 70:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
            case 115:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 126:
            case 127:
            case 128:
            case 129:
            case 130:
            case 131:
            case 132:
            case 133:
            case 134:
            case 135:
            case 136:
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case 142:
            case 143:
            case 144:
            case 146:
            case 147:
            case 148:
            case 149:
            case 230:
            case 231:
            case 232:
            case 233:
            case 234:
            case 235:
            case 241:
            case 242:
            case 243:
            case 244:
            case 245:
            case 246:
            case 247:
            case 248:
            case 249:
            case 250:
            case 251:
            case 252:
            case 253:
            case 254:
            case 256:
            case 257:
            case 258:
            case 259:
            case 260:
            case 261:
            case 262:
            case 263:
            case 264:
            case 265:
            case 266:
            case 267:
            case 268:
            case 269:
            case 270:
            case 299:
            case 300:
            case 310:
            case 311:
            case 320:
            case 321:
            case 322:
            case 323:
            case 324:
            case 330:
            case 331:
            case 332:
            return true;
        }
        return dependencies.stream()
                .anyMatch(d -> d.supports(messageId));
    }

    @Override
    public final Class resolve(int messageId) {
        switch (messageId) {
            case 0: return Heartbeat.class;
            case 1: return SysStatus.class;
            case 2: return SystemTime.class;
            case 4: return Ping.class;
            case 5: return ChangeOperatorControl.class;
            case 6: return ChangeOperatorControlAck.class;
            case 7: return AuthKey.class;
            case 11: return SetMode.class;
            case 20: return ParamRequestRead.class;
            case 21: return ParamRequestList.class;
            case 22: return ParamValue.class;
            case 23: return ParamSet.class;
            case 24: return GpsRawInt.class;
            case 25: return GpsStatus.class;
            case 26: return ScaledImu.class;
            case 27: return RawImu.class;
            case 28: return RawPressure.class;
            case 29: return ScaledPressure.class;
            case 30: return Attitude.class;
            case 31: return AttitudeQuaternion.class;
            case 32: return LocalPositionNed.class;
            case 33: return GlobalPositionInt.class;
            case 34: return RcChannelsScaled.class;
            case 35: return RcChannelsRaw.class;
            case 36: return ServoOutputRaw.class;
            case 37: return MissionRequestPartialList.class;
            case 38: return MissionWritePartialList.class;
            case 39: return MissionItem.class;
            case 40: return MissionRequest.class;
            case 41: return MissionSetCurrent.class;
            case 42: return MissionCurrent.class;
            case 43: return MissionRequestList.class;
            case 44: return MissionCount.class;
            case 45: return MissionClearAll.class;
            case 46: return MissionItemReached.class;
            case 47: return MissionAck.class;
            case 48: return SetGpsGlobalOrigin.class;
            case 49: return GpsGlobalOrigin.class;
            case 50: return ParamMapRc.class;
            case 51: return MissionRequestInt.class;
            case 54: return SafetySetAllowedArea.class;
            case 55: return SafetyAllowedArea.class;
            case 61: return AttitudeQuaternionCov.class;
            case 62: return NavControllerOutput.class;
            case 63: return GlobalPositionIntCov.class;
            case 64: return LocalPositionNedCov.class;
            case 65: return RcChannels.class;
            case 66: return RequestDataStream.class;
            case 67: return DataStream.class;
            case 69: return ManualControl.class;
            case 70: return RcChannelsOverride.class;
            case 73: return MissionItemInt.class;
            case 74: return VfrHud.class;
            case 75: return CommandInt.class;
            case 76: return CommandLong.class;
            case 77: return CommandAck.class;
            case 81: return ManualSetpoint.class;
            case 82: return SetAttitudeTarget.class;
            case 83: return AttitudeTarget.class;
            case 84: return SetPositionTargetLocalNed.class;
            case 85: return PositionTargetLocalNed.class;
            case 86: return SetPositionTargetGlobalInt.class;
            case 87: return PositionTargetGlobalInt.class;
            case 89: return LocalPositionNedSystemGlobalOffset.class;
            case 90: return HilState.class;
            case 91: return HilControls.class;
            case 92: return HilRcInputsRaw.class;
            case 93: return HilActuatorControls.class;
            case 100: return OpticalFlow.class;
            case 101: return GlobalVisionPositionEstimate.class;
            case 102: return VisionPositionEstimate.class;
            case 103: return VisionSpeedEstimate.class;
            case 104: return ViconPositionEstimate.class;
            case 105: return HighresImu.class;
            case 106: return OpticalFlowRad.class;
            case 107: return HilSensor.class;
            case 108: return SimState.class;
            case 109: return RadioStatus.class;
            case 110: return FileTransferProtocol.class;
            case 111: return Timesync.class;
            case 112: return CameraTrigger.class;
            case 113: return HilGps.class;
            case 114: return HilOpticalFlow.class;
            case 115: return HilStateQuaternion.class;
            case 116: return ScaledImu2.class;
            case 117: return LogRequestList.class;
            case 118: return LogEntry.class;
            case 119: return LogRequestData.class;
            case 120: return LogData.class;
            case 121: return LogErase.class;
            case 122: return LogRequestEnd.class;
            case 123: return GpsInjectData.class;
            case 124: return Gps2Raw.class;
            case 125: return PowerStatus.class;
            case 126: return SerialControl.class;
            case 127: return GpsRtk.class;
            case 128: return Gps2Rtk.class;
            case 129: return ScaledImu3.class;
            case 130: return DataTransmissionHandshake.class;
            case 131: return EncapsulatedData.class;
            case 132: return DistanceSensor.class;
            case 133: return TerrainRequest.class;
            case 134: return TerrainData.class;
            case 135: return TerrainCheck.class;
            case 136: return TerrainReport.class;
            case 137: return ScaledPressure2.class;
            case 138: return AttPosMocap.class;
            case 139: return SetActuatorControlTarget.class;
            case 140: return ActuatorControlTarget.class;
            case 141: return Altitude.class;
            case 142: return ResourceRequest.class;
            case 143: return ScaledPressure3.class;
            case 144: return FollowTarget.class;
            case 146: return ControlSystemState.class;
            case 147: return BatteryStatus.class;
            case 148: return AutopilotVersion.class;
            case 149: return LandingTarget.class;
            case 230: return EstimatorStatus.class;
            case 231: return WindCov.class;
            case 232: return GpsInput.class;
            case 233: return GpsRtcmData.class;
            case 234: return HighLatency.class;
            case 235: return HighLatency2.class;
            case 241: return Vibration.class;
            case 242: return HomePosition.class;
            case 243: return SetHomePosition.class;
            case 244: return MessageInterval.class;
            case 245: return ExtendedSysState.class;
            case 246: return AdsbVehicle.class;
            case 247: return Collision.class;
            case 248: return V2Extension.class;
            case 249: return MemoryVect.class;
            case 250: return DebugVect.class;
            case 251: return NamedValueFloat.class;
            case 252: return NamedValueInt.class;
            case 253: return Statustext.class;
            case 254: return Debug.class;
            case 256: return SetupSigning.class;
            case 257: return ButtonChange.class;
            case 258: return PlayTune.class;
            case 259: return CameraInformation.class;
            case 260: return CameraSettings.class;
            case 261: return StorageInformation.class;
            case 262: return CameraCaptureStatus.class;
            case 263: return CameraImageCaptured.class;
            case 264: return FlightInformation.class;
            case 265: return MountOrientation.class;
            case 266: return LoggingData.class;
            case 267: return LoggingDataAcked.class;
            case 268: return LoggingAck.class;
            case 269: return VideoStreamInformation.class;
            case 270: return SetVideoStreamSettings.class;
            case 299: return WifiConfigAp.class;
            case 300: return ProtocolVersion.class;
            case 310: return UavcanNodeStatus.class;
            case 311: return UavcanNodeInfo.class;
            case 320: return ParamExtRequestRead.class;
            case 321: return ParamExtRequestList.class;
            case 322: return ParamExtValue.class;
            case 323: return ParamExtSet.class;
            case 324: return ParamExtAck.class;
            case 330: return ObstacleDistance.class;
            case 331: return Odometry.class;
            case 332: return Trajectory.class;
        }
        return dependencies.stream()
                .filter(d -> d.supports(messageId))
                .map(d -> d.resolve(messageId))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Dialect common does not support a message of ID " + messageId));
    }
}
