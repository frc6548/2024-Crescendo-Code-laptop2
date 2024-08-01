package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Shooter;

public class SpeakerCommand extends Command {
  private final Shooter shooterSubsystem;
  private final Indexer indexerSubsystem;
  private final double speed;

  public SpeakerCommand(Shooter shooterSubsystem, Indexer indexerSubsystem, double speed) {
    this.indexerSubsystem = indexerSubsystem;
    this.shooterSubsystem = shooterSubsystem;
    this.speed = speed;
    addRequirements(shooterSubsystem);
    addRequirements(indexerSubsystem);
  }

  @Override
  public void initialize() {
    System.out.println("SpeakerCommand started!");
  }

  @Override
  public void execute() {
    shooterSubsystem.setCoastMode();
    shooterSubsystem.setMotor(speed);
    if (shooterSubsystem.leftShooterEncoder.getVelocity() > 3700) {
      indexerSubsystem.setMotor(-1);
    }
  }

  @Override
  public void end(boolean interrupted) {
    shooterSubsystem.setBrakeMode();
    shooterSubsystem.setMotor(0);
    indexerSubsystem.setMotor(0);
    System.out.println("SpeakerCommand ended!");
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
