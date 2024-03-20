package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Shooter;

public class AmpCommand extends Command {
  private final Shooter shooterSubsystem;
  private final Indexer indexerSubsystem;
  private final double speed;

  public AmpCommand(Shooter shooterSubsystem, Indexer indexerSubsystem, double speed) {
    this.indexerSubsystem = indexerSubsystem;
    this.shooterSubsystem = shooterSubsystem;

    this.speed = speed;
    addRequirements(shooterSubsystem);
    addRequirements(indexerSubsystem);
  }

  @Override
  public void initialize() {
    System.out.println("AmpCommand started!");
  }

  @Override
  public void execute() {
    shooterSubsystem.setMotor(speed);
    if (shooterSubsystem.leftShooterEncoder.getVelocity() > 1300) {
      indexerSubsystem.setMotor(-1);
    }
  }

  @Override
  public void end(boolean interrupted) {
    shooterSubsystem.setMotor(0);
    indexerSubsystem.setMotor(0);
    System.out.println("AmpCommand ended!");
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
