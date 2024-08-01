package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.AMP;

public class AmpPIDCommand extends Command {
  private final AMP ampSubsystem;
  private final PIDController pidController;

  public AmpPIDCommand(AMP ampSubsystem, double setpoint) {
    this.ampSubsystem = ampSubsystem;
    this.pidController = new PIDController(0.08, 0.0, 0.0); // .06
    pidController.setSetpoint(setpoint);
    addRequirements(ampSubsystem);
  }

  @Override
  public void initialize() {
    System.out.println("ampPIDCommand started!");
    pidController.reset();
    ampSubsystem.setMotor(0);
  }

  @Override
  public void execute() {
    double speed = pidController.calculate(ampSubsystem.getAmpEncoder());
    ampSubsystem.setMotor(speed);
  }

  @Override
  public void end(boolean interrupted) {
    ampSubsystem.setMotor(0);
    System.out.println("armPIDCommand ended!");
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
