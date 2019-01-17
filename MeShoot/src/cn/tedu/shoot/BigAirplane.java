package cn.tedu.shoot;

import java.util.Random;

/**
 * 大敌机
 * 
 * @author liyub
 *
 */
public class BigAirplane extends FlyingObject {
	int speed;// 移动速度

	BigAirplane() {
		super(69, 99);
		speed = 1;
	}
}
