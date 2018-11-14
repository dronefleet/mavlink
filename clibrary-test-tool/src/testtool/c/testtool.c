#include <jni.h>
#include <stdio.h>
#include "common/mavlink.h"

jint throwIllegalStateException ( JNIEnv *env, char *message )
{
    jclass exClass;
    char *className = "java/lang/IllegalStateException" ;
    exClass = (*env)->FindClass( env, className );
    return (*env)->ThrowNew( env, exClass, message );
}

mavlink_message_t parsePacket(JNIEnv *env, jbyteArray packet) {
    mavlink_message_t msg;
    mavlink_status_t status;
    jbyte* packetBytes = (*env)->GetByteArrayElements(env, packet, NULL);
    jsize packetLength = (*env)->GetArrayLength(env, packet);
    int chan = 0;
    for (int i = 0; i < packetLength; i++) {
        uint8_t byte = packetBytes[i] & 0xff;
        uint8_t framingStatus = mavlink_frame_char(chan, byte, &msg, &status);
    }
    (*env)->ReleaseByteArrayElements(env, packet, packetBytes, 0);
    return msg;
}


JNIEXPORT jboolean JNICALL
Java_io_dronefleet_mavlink_testtool_CLibraryTestTool_signatureCheck(
        JNIEnv *env,
        jobject obj,
        jint linkId,
        jlong timestamp,
        jbyteArray secretKey,
        jbyteArray packet) {

    mavlink_message_t msg;
    mavlink_signing_streams_t signingStreams;
    mavlink_signing_t signing;
    msg = parsePacket(env, packet);
    signing.link_id = linkId;
    jbyte* secretKeyBytes = (*env)->GetByteArrayElements(env, secretKey, NULL);
    jsize secretKeySize = (*env)->GetArrayLength(env, secretKey);
    memcpy(signing.secret_key, secretKeyBytes, secretKeySize);
    (*env)->ReleaseByteArrayElements(env, secretKey, secretKeyBytes, 0);
    return mavlink_signature_check(&signing, &signingStreams, &msg);
}