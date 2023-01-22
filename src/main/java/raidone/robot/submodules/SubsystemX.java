package raidone.robot.submodules;

import com.revrobotics.CANSparkMax.IdleMode;

public class SubsystemX extends Submodule {
    public static class PeriodicIO {
        public double desiredSpeed = 0.0;
    }

    public static enum SubsystemXState {
        DOWN, UP, OFF;
    }

    /** Motors */
    // Init motors
    
    private PeriodicIO periodicIO = new PeriodicIO();

    /** Pneumatics */
    // init any potential pneumatics

    private SubsystemX() {}
    private static SubsystemX instance = null;
    public static SubsystemX getInstance() {
        if(instance == null) {
            instance = new SubsystemX();
        }
        return instance;
    }

    @Override
    public void onInit() {
        /** Config/restore factory default */

        /** Set inversions if necessary */

        /** Set followers */

        /** Set neutral mode (brake/coast) */

        /** Enable voltage compensation */

        /** Potentially enable current limit depending on application */
    }

    @Override
    public void onStart(double timestamp) {
        periodicIO = new PeriodicIO();

        stop();
    }

    @Override
    public void run() {
        /** Set motors/pneumatics based on values from PeriodicIO */
    }

    @Override
    public void stop() {
        /** Stop everything, set values to 0 */
    }

    /**
     * Sets percent speed
     * 
     * @param speed desired speed
     */
    public void setPercentSpeed(double speed) {
        periodicIO.desiredSpeed = speed;
    }

    /**
     * Sets to the desired state (usually used with pneumatics)
     * 
     * @param state intake state
     */
    public void setState(SubsystemXState state) {
        switch(state) {
            case DOWN:
                /** Action */
                break;
            case UP:
                /** Action */
                break;
            case OFF:
                /** Action */
                break;
        }
    }

    /**
     * Sets brake type
     * 
     * @param brake idle mode
     */
    public void setBrakeMode(IdleMode brake) {
        /** Set motor brake modes */
    }
}
