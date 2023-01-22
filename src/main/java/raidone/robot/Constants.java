package raidone.robot;

import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

public final class Constants {
    public static final class ChassisConstants {
        /** Motors */
        public static final int LEFT_LEADER_ID = 0;
        public static final int LEFT_FOLLOWER_A_ID = 0;
        public static final int LEFT_FOLLOWER_B_ID = 0;

        public static final int RIGHT_LEADER_ID = 0;
        public static final int RIGHT_FOLLOWER_A_ID = 0;
        public static final int RIGHT_FOLLOWER_B_ID = 0;

        /** Sensors */
        public static final int IMU_ID = 0;

        /** Pneumatics */
        public static final PneumaticsModuleType PNEUMATICS_MODULE_TYPE = PneumaticsModuleType.REVPH;
        public static final int SHIFTER_HIGH_TORQUE_ID = 0;
        public static final int SHIFTER_LOW_TORQUE_ID = 0;

        /** Velocity PID */
        public static final int PID_LOOP_IDX = 0;
        public static final double kS = 0.0;
        public static final double kV = 0.0;
        public static final double kA = 0.0;
        public static final double kP = 0.0;
        
        /** Drive kinematics (for ramsete) */
        public static final double TRACK_WIDTH = 0.0;
        public static final DifferentialDriveKinematics DRIVE_KINEMATICS =
            new DifferentialDriveKinematics(TRACK_WIDTH);

        public static final int ENCODER_CPR = 8129; // counts per rotation
        public static final double WHEEL_DIAMETER = 0.0; // meters
        public static final double kEncoderDistancePerPulse =
            // Assumes the encoders are directly mounted on the wheel shafts
            (WHEEL_DIAMETER * Math.PI) / (double) ENCODER_CPR;

        /** Teleop Constants */
        public static final int MONOMIAL_SCALE = 0;
        public static final double RAMP_RATE = 0.0; // 0.33

        /** Current limit constants */
        public static final int CONTINUOUS_CURRENT_LIMIT = 30;
        public static final int PEAK_CURRENT_LIMIT = 80;
        public static final int PEAK_CURRENT_DURATION = 1000;
    }

    public static final class SubsystemX {
        public static final int LEADER_MOTOR = 0;
        public static final int FOLLOWER_MOTOR = 0;

        public static final int SOLENOID_1 = 0;
        public static final int SOLENOID_2 = 0;
    }

    public static final class OIConstants {
        /** Controller constants */
        public static final int DRIVE_CONTROLLER_PORT = 0;
    }

    public static final class AutoConstants {
        /** Motion profile constants */
        public static final double MAX_VEL = 0; // meters per second
        public static final double MAX_ACCEL = 0; // meters per second ^ 2
        
        /** Ramsete constants (THESE SHOULD NOT CHANGE) */
        public static final double RAMSETE_B = 2;
        public static final double RAMSETE_ZETA = 0.7;
    }
    
    /** Universal constants */
    public static final double DEADBAND = 0.06;
    public static final int TIMEOUT_MS = 10;
    public static final double VOLTAGE_COMPENSATION = 12.0;
}
