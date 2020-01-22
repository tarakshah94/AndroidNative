#include <jni.h>
#include <android/input.h>
#include "AudioEngine.h"

static AudioEngine *audioEngine = new AudioEngine();

extern "C"
JNIEXPORT void JNICALL
Java_com_example_tarak_wavemaker_MainActivity_touchEvent(JNIEnv *env, jobject instance,
                                                         jint action) {

    // TODO
    switch (action) {
        case AMOTION_EVENT_ACTION_DOWN:
            audioEngine->setToneOn(true);
            break;
        case AMOTION_EVENT_ACTION_UP:
            audioEngine->setToneOn(false);
            break;
        default:
            break;
    }

}

extern "C"
JNIEXPORT void JNICALL
Java_com_example_tarak_wavemaker_MainActivity_startEngine(JNIEnv *env, jobject instance) {

    // TODO
    audioEngine->start();

}

extern "C"
JNIEXPORT void JNICALL
Java_com_example_tarak_wavemaker_MainActivity_stopEngine(JNIEnv *env, jobject instance) {

    // TODO
    audioEngine->stop();

}
