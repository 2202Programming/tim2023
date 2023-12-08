// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Launcher;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Launcher;

public class DeActivateLauncher extends CommandBase {
  /** Creates a new DeActivateLauncher. */
  final Launcher frisbee_flipper = RobotContainer.RC().launcher;
  public DeActivateLauncher() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(frisbee_flipper);
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    new InstantCommand(() -> {
      frisbee_flipper.speed(0);
  });
  if(frisbee_flipper.get_speed() == 0){
    new InstantCommand(() -> {
      frisbee_flipper.fire();
  });
}
}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(frisbee_flipper.getFlipperStatus() == false){
      return true;
    }
    return false;
  }
}
