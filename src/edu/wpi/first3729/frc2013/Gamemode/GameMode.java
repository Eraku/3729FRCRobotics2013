/*  ______ ______ ______ ______
 * |__    |      |__    |  __  |
 * |__    |_     |    __|__    |
 * |______| |____|______|______|
 */
package edu.wpi.first3729.frc2013.Gamemode;

//import edu.wpi.first3729.frc2013.inputs.*;
import edu.wpi.first3729.frc2013.Movement.*;
import edu.wpi.first3729.frc2013.Robot;

/*
 *
 * @author teddy
 */
public abstract class GameMode implements Movement {
    protected Robot _robot;
    protected Drive _drive;
    protected Climber _climber;
    protected Shooter _shooter;

    
       public GameMode(Robot robot) {
        this._robot = robot;
    }
       public void setup() {
           this._drive.setup();
//           this._shooter.setup();
//           this._climber.setup();
       }
    /**
     *
     * @param mode
     * @param robot
     * @return
     */     
    public static GameMode toautonomous(GameMode mode) {
        return toautonomous(mode, mode._robot);
    }
    
    public static GameMode toautonomous(GameMode mode, Robot robot) {
        GameMode ret = new Autonomous(robot);
        if (mode != null) {
            ret._drive = mode._drive;
//            ret._shooter = mode._shooter;
//            ret._climber = mode._climber;
        } else {
            ret._drive = new Drive(ret);
//            ret._shooter = new Shooter(ret);
//            ret._climber = new Climber(ret);
            ret.setup();
        }
        return ret;
    }
       
    public static GameMode toteleoperated(GameMode mode) {
        return toteleoperated(mode, mode._robot);
    }   
    public static GameMode toteleoperated(GameMode mode, Robot robot) {
        GameMode ret = new Teleoperated(robot);
        if (mode != null) {
            ret._drive = mode._drive;
//            ret._climber = mode._climber;
//            ret._shooter = mode._shooter;
        } else {
            ret._drive = new Drive(ret);
//            ret._climber = new Climber(ret);
//            ret._shooter = new Shooter(ret);
            ret.setup();
        }
//        ret._manipulator.lift(0);
        return ret;
    }
    
    public static GameMode todisabled(GameMode mode) {
        return todisabled(mode, mode._robot);
    }    
    public static GameMode todisabled(GameMode mode, Robot robot) {
        GameMode ret = new Disabled(robot);
        if (mode != null) {
            ret._drive = mode._drive;
//            ret._climber = mode._climber;
//            ret._shooter = mode._shooter;
        } else {
            ret._drive = new Drive(ret);
//            ret._climber = new Climber(ret);
//            ret._shooter = new Shooter(ret);
            ret.setup();
        }
        return ret;
    }
    
    public void init() {}       
}