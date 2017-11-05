package com.cademons;
import javax.sound.midi.*;

public class MIDIHandler {

    private Synthesizer synth;
    private MidiChannel[] channels;
    private short defaultVelocity = 220;

    public MIDIHandler(int instrument) {
        try {
            synth = MidiSystem.getSynthesizer();
            synth.open();
            channels = synth.getChannels();
        } catch (MidiUnavailableException e) {

        }
    }

    void changeInstrument(int instrument) {synth.getChannels()[0].programChange(instrument);}

    void noteOn(short note) {channels[0].noteOn(note, defaultVelocity);}
    void noteOn(short note, short velocity) {channels[0].noteOn(note, velocity);}

    void noteOff(short note) {channels[0].noteOff(note);}
    void noteOff(short note, short velocity) {channels[0].noteOff(note, velocity);}
    void allNotesOff() {channels[0].allNotesOff();}

}
