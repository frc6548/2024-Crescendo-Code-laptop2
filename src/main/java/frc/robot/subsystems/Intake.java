package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  private final CANSparkMax intakeMotor = new CANSparkMax(14, MotorType.kBrushless);
  private final RelativeEncoder intakeEncoder = intakeMotor.getEncoder();

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Intake Velocity", intakeEncoder.getVelocity());
  }

  public void setMotor(double speed) {
    intakeMotor.set(speed);
  }
}
