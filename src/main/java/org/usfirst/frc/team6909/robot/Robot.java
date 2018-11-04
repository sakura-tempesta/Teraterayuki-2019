package org.usfirst.frc.team6909.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	private XboxController driver;
	private PWMTalonSRX m_leftArm;

	RObot(){
		driver= new XboxController(0);
		//ポートを教える
		m_leftArm = new PWMTalonSRX(5);
		m_rightArm = new PWMTalonSRX(6);
	}

	public void teleopPeriodic() {
		// 右スティックのy軸の値
		double value = driver.getY(Hand.kLeft);
		if (value > 0.2 || value < -0.2) {
			// モーターの速度を設定
			m_leftArm.set(value);
			m_rightArm.set(-value);
		}
	}
}
