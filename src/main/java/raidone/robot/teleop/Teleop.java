package raidone.robot.teleop;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import raidone.robot.Constants;
import raidone.robot.submodules.Chassis;
import raidone.robot.submodules.SubsystemX;
import raidone.robot.submodules.Chassis.GearShift;

public class Teleop {

    private static Teleop instance = null;

    public static Teleop getInstance() {
        if (instance == null) {
            instance = new Teleop();
        }
        return instance;
    }

    private Teleop() {
    }

    private XboxController master = new XboxController(0);
    private XboxController partner = new XboxController(1);

    private static Chassis chassis = Chassis.getInstance();

    /**
     * Runs at the start of teleop.
     */
    public void onStart() {
        chassis.changeShifterState(GearShift.LOW_TORQUE);

        chassis.zero();
    }

    /**
     * Continuously loops in teleop.
     */
    public void onLoop() {
        masterLoop();
        partnerLoop();
    }

    boolean shiftState = false, prevShiftState = false, driveState = false, prevDriveState = false, switchFront = false, prevSwitchFront = false;
    boolean shift = false;
    int val = 1;
    private void masterLoop() {
        double leftY = master.getLeftY() * val * 0.9;
        switchFront = master.getRightStickButton();
        if(switchFront && !prevSwitchFront) {
            val *= -1;
        }
        prevSwitchFront = switchFront;
        chassis.curvatureDrive(leftY, -master.getRightX(), Math.abs(master.getLeftY()) < Constants.DEADBAND);        

        shiftState = master.getLeftBumper() || partner.getAButton();
        if(shiftState && !prevShiftState) {
            shift = !shift;
        }
        if(shift) {
            chassis.changeShifterState(GearShift.LOW_TORQUE);
        } else {
            chassis.changeShifterState(GearShift.HIGH_TORQUE);
        }
        prevShiftState = shiftState;
        SmartDashboard.putString("Shift state", shift ? "low torque" : "high torque");

        SmartDashboard.putNumber("x pose", chassis.getPeriodicIO().x);
        SmartDashboard.putNumber("y pose", chassis.getPeriodicIO().y);
        SmartDashboard.putNumber("rotation", chassis.getPeriodicIO().rotation.getDegrees());
    }

    private void partnerLoop() {

    }
}
