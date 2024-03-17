package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Indexer;
import frc.robot.subsystems.Intake;

public class IndexerPIDCommand extends Command {
  private final Indexer indexerSubsystem;
  private final Intake intakeSubsystem;
  private final PIDController pidController;

  public IndexerPIDCommand(Indexer indexerSubsystem, Intake intakeSubsystem, double setpoint) {
    this.intakeSubsystem = intakeSubsystem;
    this.indexerSubsystem = indexerSubsystem;
    this.pidController = new PIDController(0.05, 0, 0);
    pidController.setSetpoint(setpoint);
    addRequirements(indexerSubsystem);
    addRequirements(intakeSubsystem);
  }

  @Override
  public void initialize() {
    indexerSubsystem.resetEncoder();
    System.out.println("IndexerPIDCommand started!");
    pidController.reset();
    intakeSubsystem.setMotor(0);
  }

  @Override
  public void execute() {
    double speed = pidController.calculate(indexerSubsystem.getIndexerEncoder());
    indexerSubsystem.setMotor(speed);
  }

  @Override
  public void end(boolean interrupted) {
    indexerSubsystem.setMotor(0);
    System.out.println("IndexerPIDCommand ended!");
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
