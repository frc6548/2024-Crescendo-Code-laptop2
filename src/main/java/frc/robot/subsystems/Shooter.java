package frc.robot.subsystems;

import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  private final CANSparkMax leftShooterMotor = new CANSparkMax(16, MotorType.kBrushless);
  private final CANSparkMax rightShooterMotor = new CANSparkMax(17, MotorType.kBrushless);
  public final RelativeEncoder leftShooterEncoder = leftShooterMotor.getEncoder();
  public final RelativeEncoder rightShooterEncoder = rightShooterMotor.getEncoder();

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Left Shooter Velocity", leftShooterEncoder.getVelocity());
    SmartDashboard.putNumber("Right Shooter Velocity", rightShooterEncoder.getVelocity());
  }

  public void setMotor(double speed) {
    leftShooterMotor.set(speed);
    rightShooterMotor.set(-speed);
  }

  public void setBrakeMode() {
    leftShooterMotor.setIdleMode(IdleMode.kBrake);
    rightShooterMotor.setIdleMode(IdleMode.kBrake);
    leftShooterMotor.burnFlash();
    rightShooterMotor.burnFlash();
  }

  public void setCoastMode() {
    leftShooterMotor.setIdleMode(IdleMode.kCoast);
    rightShooterMotor.setIdleMode(IdleMode.kCoast);
    leftShooterMotor.burnFlash();
    rightShooterMotor.burnFlash();
  }
}
