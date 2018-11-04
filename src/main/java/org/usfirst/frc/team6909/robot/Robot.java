package org.usfirst.frc.team6909.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class Robot extends IterativeRobot {
	private XboxController driver;
	private PWMTalonSRX m_leftArm;
	private PWMTalonSRX m_rightArm;

	Robot() {
		// 入力を受け取るオブジェクト
		driver = new XboxController(0);
		// ポートを教える
		m_leftArm = new PWMTalonSRX(5);
		m_rightArm = new PWMTalonSRX(6);
	}

	public void teleopPeriodic() {
		// 右スティックのy軸の値
		double left = driver.getY(Hand.kLeft);
		double right = driver.getY(Hand.kRight);
		if (left < 0.2 || left > -0.2 && right < 0.2 || right > -0.2) {
			// モーターの速度を設定
			m_leftArm.set(0);
			m_rightArm.set(0);
		} else {
			if (left > 0.2 || left < -0.2) {
				// モーターの速度を設定
				m_leftArm.set(100);
			} else {
				// モーターの速度を設定
				m_leftArm.set(0);
			}
			if (right > 0.2 || right < -0.2) {
				// モーターの速度を設定
				m_rightArm.set(100);
			} else {
				// モーターの速度を設定
				m_rightArm.set(0);
			}
		}
	}
}
