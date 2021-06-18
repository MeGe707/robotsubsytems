package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class intakeSubsystem {
    

    private final PWMVictorSPX intake_redline_motor1 = new PWMVictorSPX(0);
    private final PWMVictorSPX intake_redline_motor2 = new PWMVictorSPX(1);

    private final PWMVictorSPX intake_turn_180_motor = new PWMVictorSPX(2);

    private final SpeedControllerGroup intake_redline_motors = new SpeedControllerGroup(intake_redline_motor1, intake_redline_motor2);


private static intakeSubsystem INSTANCE = new intakeSubsystem();

    public static intakeSubsystem getInstance() {
      if (INSTANCE == null){
          synchronized (intakeSubsystem.class) {
              if (INSTANCE == null){
                  INSTANCE = new intakeSubsystem();
              }
          }
      }
      return INSTANCE;
  }



    public void stop_intake_motors(){
        intake_redline_motors.set(0);
    }   

    public void open_intake_motors(double speed){
        intake_redline_motors.set(speed);
    }

    public void intakeStopTurning(){
        intake_turn_180_motor.set(0);
    }

    public void intakeTurn(double speed){
        if(speed>0){
        intake_turn_180_motor.set(speed);
        }
    }

    public void intakeTurnback(double speed){
        if(speed<0){
        intake_turn_180_motor.set(speed);
        }
    }

}