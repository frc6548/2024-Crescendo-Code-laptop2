package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.LEDs;

public class RejectCommand extends Command {
  private final Intake intakeSubsystem;
  private final Indexer indexerSubsystem;
  private final LEDs ledsSubsystem;
  private final double speed;

  public RejectCommand(
      Intake intakeSubsystem, Indexer indexerSubsystem, LEDs ledsSubsystem, double speed) {
    this.intakeSubsystem = intakeSubsystem;
    this.indexerSubsystem = indexerSubsystem;
    this.ledsSubsystem = ledsSubsystem;
    this.speed = speed;
    addRequirements(intakeSubsystem);
    addRequirements(indexerSubsystem);
    addRequirements(ledsSubsystem);
  }

  @Override
  public void initialize() {
    System.out.println("RejectCommand started!");
    indexerSubsystem.getIndexerEncoder();
    indexerSubsystem.getIndexerEncoder();
  }

  @Override
  public void execute() {
    intakeSubsystem.setMotor(-speed);
    indexerSubsystem.setMotor(speed);
    ledsSubsystem.redLED();
  }

  @Override
  public void end(boolean interrupted) {
    intakeSubsystem.setMotor(0);
    indexerSubsystem.setMotor(0);
    System.out.println("RejectCommand ended!");
    ledsSubsystem.turnOffLED();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
