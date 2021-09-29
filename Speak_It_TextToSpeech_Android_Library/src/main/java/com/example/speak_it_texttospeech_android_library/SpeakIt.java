package com.example.speak_it_texttospeech_android_library;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.widget.Toast;

import java.util.Locale;

abstract class SpeakIt extends Initialize {
    TextToSpeech tts;

    @Override
    public void initialize(Context context) {
            tts = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int i) {
                    if (i == TextToSpeech.SUCCESS){
                        tts.setLanguage(Locale.ENGLISH);
                    }
                    else {
                        Log.e("Speak-it", "Failed to initialize");
                    }
                }
            });
    }

    public void speak(String text){
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
    }

    public void speak(String text, Float speechRate){
        tts.setSpeechRate(speechRate);
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
    }


    public void speak(String text, Float speechRate, Float pitch){
        tts.setPitch(pitch);
        tts.setSpeechRate(speechRate);
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
    }


}
