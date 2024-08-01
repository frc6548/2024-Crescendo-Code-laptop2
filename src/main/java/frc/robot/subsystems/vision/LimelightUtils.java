package frc.robot.subsystems.vision;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.drive.Drive;

public class LimelightUtils extends SubsystemBase {
  static NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  static NetworkTableEntry tx = table.getEntry("tx");
  static NetworkTableEntry ty = table.getEntry("ty");
  static NetworkTableEntry tv = table.getEntry("tv");
  ;

  @Override
  public void periodic() {
    double y = ty.getDouble(0);
    double x = tx.getDouble(0);
    long v = tv.getInteger(0);
    SmartDashboard.putNumber("LimelightX", x);
    SmartDashboard.putNumber("LimelightY", y);
    SmartDashboard.putNumber("Valid Target", v);
  }

  public static double targetingAngularVelocity() {
    double kP = .00155;
    double x = tx.getDouble(0);
    double targetingAngularVelocity = x * kP;
    targetingAngularVelocity *= Drive.MAX_ANGULAR_SPEED;
    targetingAngularVelocity *= -1.0;
    return targetingAngularVelocity;
  }

  public static double targetingForwardSpeed() {
    double y = ty.getDouble(0);
    double kP = .001;
    double targetingForwardSpeed = y * kP;
    targetingForwardSpeed *= Drive.MAX_LINEAR_SPEED;
    targetingForwardSpeed *= -1.0;
    return targetingForwardSpeed;
  }

  public static double validTarget() {
    long v = tv.getInteger(0);
    return v;
  }

  public void ledOff() {
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(1);
  }

  public void ledBlink() {
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(2);
  }

  public void ledSolid() {
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(3);
  }

  public static boolean validtarget;
}
