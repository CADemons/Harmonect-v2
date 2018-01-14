package com.cademons;
import javax.sound.midi.*;

public class MidiHandler {

    private Synthesizer synth;
    private MidiChannel[] channels;
    private short defaultVelocity = 220;

    public MidiHandler(int instrument)  {
        try {
            synth = MidiSystem.getSynthesizer();
            synth.open();
            channels = synth.getChannels();
        } catch (MidiUnavailableException e) {

        }
    }

    public void changeInstrument(int instrument) {synth.getChannels()[0].programChange(instrument);}

    public void noteOn(short note) {channels[0].noteOn(note, defaultVelocity);}
    public void noteOn(short note, short velocity) {channels[0].noteOn(note, velocity);}

    public void noteOff(short note) {channels[0].noteOff(note);}
    public void noteOff(short note, short velocity) {channels[0].noteOff(note, velocity);}
    public void allNotesOff() {channels[0].allNotesOff();}


}