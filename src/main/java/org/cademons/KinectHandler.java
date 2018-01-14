package org.cademons;

import org.openkinect.freenect.*;

public class KinectHandler {
    // Declarations
    Device device = null;
    Context context = null;

    public KinectHandler() {
        this.context = Freenect.createContext();
        if(this.context.numDevices() > 0) {
            this.device = this.context.openDevice(0);
        } else {
            System.err.println("No kinects detected. Exiting.");
        }
    }
}
