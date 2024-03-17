package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Indexer extends SubsystemBase {
  private final CANSparkMax indexerMotor = new CANSparkMax(15, MotorType.kBrushless);
  private final RelativeEncoder indexerEncoder = indexerMotor.getEncoder();

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Indexer Velocity", indexerEncoder.getVelocity());
    SmartDashboard.putNumber("Indexer Encoder", indexerEncoder.getPosition());
  }

  public void setMotor(double speed) {
    indexerMotor.set(speed);
  }

  public double getIndexerEncoder() {
    return indexerEncoder.getPosition();
  }

  public void resetEncoder() {
    indexerEncoder.setPosition(0);
  }
}
