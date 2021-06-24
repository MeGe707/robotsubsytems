package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import frc.robot.Constants;

public class hatchSubsystem {
    
    private final PWMVictorSPX hatch_motor = new PWMVictorSPX(0); 
    
    private final Encoder hatch_encoder = new Encoder(1, 2);

    private static hatchSubsystem INSTANCE = new hatchSubsystem();

    public static hatchSubsystem getInstance() {
      if (INSTANCE == null){
          synchronized (hatchSubsystem.class) {
              if (INSTANCE == null){
                  INSTANCE = new hatchSubsystem();
              }
          }
      }
      return INSTANCE;
  }

    public void stop_hatch_motor() {
        hatch_motor.set(0);
    }

    public void open_hatch_motor(double speed) {
        hatch_motor.set(speed);
    }

    public void reset_encoder(){
        hatch_encoder.reset();
    }

    public void getHatchRaising(){
        hatch_encoder.setDistancePerPulse(Constants.encoder.elevatorEncoderMovePerTour/Constants.encoder.encoderPPR);
    }

    
}
