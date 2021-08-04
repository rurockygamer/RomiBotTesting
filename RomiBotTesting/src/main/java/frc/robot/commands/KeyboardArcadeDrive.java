// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;
import java.util.function.Supplier;
import javax.swing.KeyStroke;

public class KeyboardArcadeDrive extends CommandBase {
  private final Drivetrain m_drivetrain;
  private final Supplier<Double> m_xaxisSpeedSupplier;
  private final Supplier<Double> m_zaxisRotateSupplier;

  /**
   * Creates a new KeyboardArcadeDrive. This command will drive your robot according to the speed supplier
   * lambdas. This command does not terminate.
   *
   * @param drivetrain The drivetrain subsystem on which this command will run
   * @param xaxisSpeedSupplier Lambda supplier of forward/backward speed
   * @param zaxisRotateSuppplier Lambda supplier of rotational speed
   */
  public KeyboardArcadeDrive(Drivetrain drivetrain) {
    m_drivetrain = drivetrain;
    addRequirements(drivetrain);
  }

  public int forwardSpeed(){


  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivetrain.KeyboardArcadeDrive(FBDirection(), LRDirection());
  }

  public double FBDirection(){
    switch(m_keystroke.getKeyChar()) {
      case 'w':
        return 1.0 * speedFactor;
      case 's':
        return -1.0 * speedFactor;
      default:
       return 0;
     }
  }

  public double LRDirection(){
    switch(m_keystroke.getKeyChar()) {
      case 'a':
        return 1.0 * speedFactor;
      case 'd':
        return -1.0 * speedFactor;
      default:
       return 0;
     }
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
