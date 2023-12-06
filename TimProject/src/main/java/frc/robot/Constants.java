// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import frc.robot.Constants.SubsystemConfig;
import frc.robot.util.ModuleInversionSpecs;
import frc.robot.util.PIDFController;
/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static final double DT = 0.02;
  public static final double FTperM = 3.28084;
  public static final double MperFT = 1.0 / FTperM;
// RoboRio and CAN ports

public static final class CAN {
  // FRC DEFAULTS
  public static final int PDP = 1; // for rev
  public static final int PCM1 = 2; // for rev
  public static final int BACK_LAUNCH_MOTOR = 10; //Talon motor
  public static final int FRONT_LAUNCH_MOTOR = 11; //Talon motor
  public static final int ELEVATION_ACTUATOR = 12;
  public static final int DT_FL_DRIVE = 20;
  public static final int DT_FL_ANGLE = 21;
  public static final int DT_BL_DRIVE = 22;
  public static final int DT_BL_ANGLE = 23;
  public static final int DT_BR_DRIVE = 24;
  public static final int DT_BR_ANGLE = 25;
  public static final int DT_FR_DRIVE = 26;
  public static final int DT_FR_ANGLE = 27;
  // drive train CANCoders
  public static final int DT_BL_CANCODER = 28;
  public static final int DT_BR_CANCODER = 31;
  public static final int DT_FR_CANCODER = 30;
  public static final int DT_FL_CANCODER = 7;
  // IMU
  public static final int PIGEON_IMU_CAN = 60;


  //TODO MrL - copy code from 2023 for Swerve CAN assignments.
  //Noah - Should be done

  public static final boolean BURN_FLASH = false;
}
public final static class NTStrings {
  public final static String NT_Name_Position = "Position";
}

 public static final class SubsystemConfig {
  public final boolean HAS_INTAKE;
  public final boolean HAS_SHOOTER;
  public final boolean IS_COMPETITION_BOT;
  public final boolean HAS_MAGAZINE;
  public final boolean HAS_CLIMBER;
  public final boolean HAS_POSITIONER;
  public final boolean HAS_DRIVETRAIN;
  public final boolean HAS_LIMELIGHT;
      public SubsystemConfig(boolean HAS_INTAKE, boolean HAS_SHOOTER, boolean IS_COMPETITION_BOT, boolean HAS_MAGAZINE,
      boolean HAS_CLIMBER,
      boolean HAS_POSITIONER, boolean HAS_DRIVETRAIN, boolean HAS_LIMELIGHT) {
    this.HAS_INTAKE = HAS_INTAKE;
    this.HAS_SHOOTER = HAS_SHOOTER;
    this.IS_COMPETITION_BOT = IS_COMPETITION_BOT;
    this.HAS_MAGAZINE = HAS_MAGAZINE;
    this.HAS_CLIMBER = HAS_CLIMBER;
    this.HAS_POSITIONER = HAS_POSITIONER;
    this.HAS_DRIVETRAIN = HAS_DRIVETRAIN;
    this.HAS_LIMELIGHT = HAS_LIMELIGHT;
  }
  public static final SubsystemConfig swerveBotSubsystemConfig = new SubsystemConfig(false,false, false, false, false,      false, true, true);
  public static final SubsystemConfig chadBotSubsystemConfig = new SubsystemConfig(true, true, false, true, true, true, true, true);
  //2023 competitionbot
  public static final SubsystemConfig compBotSubsystemConfig = new SubsystemConfig(true,
      false,
      true,
      false,
      false,
      false,
      true,
      true);

}

public static final SubsystemConfig swerveBotSubsystemConfig = new SubsystemConfig(false,false, false, false, false,      false, true, true);
public static final SubsystemConfig chadBotSubsystemConfig = new SubsystemConfig(true, true, false, true, true, true, true, true);
//2023 competitionbot
public static final SubsystemConfig compBotSubsystemConfig = new SubsystemConfig(true,
    false,
    true,
    false,
    false,
    false,
    true,
    true);

// PWM assignments on the Rio
public static final class PWM {
  // public static final int INTAKE = 0;
}
public static final class WheelOffsets {
  public final double CC_FL_OFFSET;
  public final double CC_BL_OFFSET;
  public final double CC_FR_OFFSET;
  public final double CC_BR_OFFSET;

  public WheelOffsets(double FL, double BL, double FR, double BR) {
    this.CC_FL_OFFSET = FL;
    this.CC_BL_OFFSET = BL;
    this.CC_FR_OFFSET = FR;
    this.CC_BR_OFFSET = BR;
  }
}
public static final class ChassisConfig {

  // Kinematics model - wheel offsets from center of robot (0, 0)
  // Left Front given below, symmetry used for others
  public final double XwheelOffset; // meters, half of X wheelbase
  public final double YwheelOffset; // meters, half of Y wheelbase

  public final double wheelCorrectionFactor; // percent
  public final double wheelDiameter; // meters
  public final double kSteeringGR; // [mo-turns to 1 angle wheel turn]
  public final double kDriveGR; // [mo-turn to 1 drive wheel turn]

  public ChassisConfig(double XwheelOffset, double YwheelOffset, double wheelCorrectionFactor, double wheelDiameter,
      double kSteeringGR,
      double kDriveGR) {
    this.XwheelOffset = XwheelOffset;
    this.YwheelOffset = YwheelOffset;
    this.wheelCorrectionFactor = wheelCorrectionFactor;
    this.wheelDiameter = wheelDiameter * wheelCorrectionFactor;
    this.kSteeringGR = kSteeringGR;
    this.kDriveGR = kDriveGR;
  }
  
}
public static final class ChassisInversionSpecs{
  public ModuleInversionSpecs FR;
  public ModuleInversionSpecs FL;
  public ModuleInversionSpecs BR;
  public ModuleInversionSpecs BL;

  public ChassisInversionSpecs(ModuleInversionSpecs FR, ModuleInversionSpecs FL, ModuleInversionSpecs BR, ModuleInversionSpecs BL){
      this.FR = FR;
      this.FL = FL;
      this.BR = BR;
      this.BL = BL;
  }
}

public static final class DriveTrain {
  // motor constraints
  public static final double motorMaxRPM = 5600; // motor limit

  // Constraints on speeds enforeced in DriveTrain
  public static final double kMaxSpeed = 21.0 * MperFT; // [m/s]
  public static final double kMaxAngularSpeed = 2 * Math.PI; // [rad/s]

  /****
   * ### REMINDER - enable these once we have basics working
   * // Other constraints
   * public static final int smartCurrentMax = 60; //amps in SparkMax, max setting
   * public static final int smartCurrentLimit = 35; //amps in SparkMax, inital
   * setting
   */
  // Acceleration limits
  /// public static final double slewRateMax = 2; //sec limits adjusting slewrate
  // public static final boolean safetyEnabled = false;

  // SmartMax PID values [kp, ki, kd, kff] - these get sent to hardware controller
  // DEBUG - SET FF first for drive, then add KP

  // public static final PIDFController drivePIDF = new
  // PIDFController(0.09*MperFT, 0.0, 0.0, 0.08076*MperFT);
  public static final PIDFController drivePIDF = new PIDFController(0.09 * FTperM, 0.0, 0.0, 0.08076 * FTperM);
  public static final PIDFController anglePIDF = new PIDFController(0.01, 0.0, 0.0, 0.0); // maybe 1.0,0.0,0.1 from
                                                                                          // SDS sample code?

  // FOR SWERVEBOT, aka Tim 2.0
  public static final WheelOffsets swerveBotOffsets = new WheelOffsets(-98.942, 91.33, -177.035, -28.215);
  public static final ChassisConfig swerveBotChassisConfig = new ChassisConfig(10.5 / 12, 10.5 / 12, 0.995,
      99.5 / 1000.0, 12.8, 8.14);

  // FOR 2022 Chad Bot - degrees
  public static final WheelOffsets chadBotOffsets = new WheelOffsets(-175.60, -115.40, -162.15, 158.81);
  public static final ChassisConfig chadBotChassisConfig = new ChassisConfig(MperFT * (21.516 / 12.0) / 2.0,
      MperFT * (24.87 / 12) / 2, 0.995, 99.5 / 1000.0, 12.8, 8.14);

  // For 2023 CompetitionBot
  public static final WheelOffsets compBotOffsets = new WheelOffsets(129.03, -83.94, -57.83, 139.38);
  public static final ChassisConfig compBotChassisConfig = new ChassisConfig(
      MperFT * (23.5 / 12.0) / 2.0, //based on CAD in reference_links
      MperFT * (19.5 / 12.0) / 2.0, //based on CAD in reference_links
      0.999, // scale [] <= 1.0
      MperFT * (4.0/12.0), // wheel diameter[m] Comp bot is 4" wheels
      12.8, //confirmed with vince
      8.14); //confirmed with vince

}
public static final class DriverControls {

  public enum Id {
    Driver(0), Operator(1), SwitchBoard(2), Phantom(3);

    public final int value;

    Id(int value) {
      this.value = value;
    }
  }

  public enum DriverMode {
    Arcade(0), Tank(1), XYRot(2);

    public final int value;

    DriverMode(int value) {
      this.value = value;
    }
  }
}

public static final ChassisInversionSpecs swerveBotChassisInversionSpecs = new ChassisInversionSpecs(
  new ModuleInversionSpecs(true,false,false), //FR
  new ModuleInversionSpecs(false,false,false), //FL
  new ModuleInversionSpecs(true,false,false), //BR
  new ModuleInversionSpecs(false,false,false)); //BL
  public static final ChassisInversionSpecs chadBotChassisInversionSpecs = new ChassisInversionSpecs(
    new ModuleInversionSpecs(true,false,false), //FR
    new ModuleInversionSpecs(false,false,false), //FL
    new ModuleInversionSpecs(true,false,false), //BR
    new ModuleInversionSpecs(false,false,false)); //BL
  
  public static final ChassisInversionSpecs compBotChassisInversionSpecs = new ChassisInversionSpecs(
    new ModuleInversionSpecs(true,false,false), //FR
    new ModuleInversionSpecs(false,false,false), //FL
    new ModuleInversionSpecs(true,false,false), //BR
    new ModuleInversionSpecs(false,false,false)); //BL
// Digital IO on the RIO
//nothing atm 11/15/23
public static final class DigitalIO {
}

public static final class AnalogIn {
  public static final int LINEAR_ACTUATOR = 0;
}

//why is there a loose wire :cry: 11/15/23 (aka ask elec - should be nothing)
// PWM assignments on the Rio
public static final class PCM1 {
  // might need to flip numbers dependent on testing - 11/15/23
  public static final int FRISBEE_FLIPPER_FWD= 0;
  public static final int FRISBEE_FLIPPER_BACK = 1;

}

// if we use a second PCM
public static final class PCM2 {
}


  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }
public static class LauncherConfiguration {
}

}
