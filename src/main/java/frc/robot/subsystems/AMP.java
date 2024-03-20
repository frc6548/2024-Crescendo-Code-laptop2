package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class AMP extends SubsystemBase {
  private final CANSparkMax ampMotor = new CANSparkMax(30, MotorType.kBrushless);
  public final RelativeEncoder ampEncoder = ampMotor.getEncoder();

  @Override
  public void periodic() {
    SmartDashboard.putNumber("AMP Velocity", ampEncoder.getVelocity());
    SmartDashboard.putNumber("AMP Encoder", ampEncoder.getPosition());
  }

  public void setMotor(double speed) {
    ampMotor.set(speed);
  }

  public double getAmpEncoder() {
    return ampEncoder.getPosition();
  }

  public void resetEncoder() {
    ampEncoder.setPosition(0);
  }
}
