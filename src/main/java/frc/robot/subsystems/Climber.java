package frc.robot.subsystems;

import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climber extends SubsystemBase {
  private final CANSparkMax leftClimberMotor = new CANSparkMax(18, MotorType.kBrushless);
  private final CANSparkMax rightClimberMotor = new CANSparkMax(19, MotorType.kBrushless);
  private final RelativeEncoder leftClimberEncoder = leftClimberMotor.getEncoder();
  private final RelativeEncoder rightClimberEncoder = leftClimberMotor.getEncoder();

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Left Climber Encoder", leftClimberEncoder.getPosition());
    SmartDashboard.putNumber("Right Climber Encoder", rightClimberEncoder.getPosition());
    SmartDashboard.putNumber("Left Climber Velocity", leftClimberEncoder.getVelocity());
    SmartDashboard.putNumber("Right Climber Velocity", rightClimberEncoder.getVelocity());
  }

  public void setMotor(double speed) {
    leftClimberMotor.set(speed);
    rightClimberMotor.set(-speed);
  }

  public double getLeftEncoder() {
    return leftClimberEncoder.getPosition();
  }

  public void resetEncoder() {
    leftClimberEncoder.setPosition(0);
    leftClimberMotor.setIdleMode(IdleMode.kBrake);
  }
}
