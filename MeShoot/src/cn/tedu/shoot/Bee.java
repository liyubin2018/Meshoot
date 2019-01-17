package cn.tedu.shoot;

import java.util.Random;

/**
 * 小蜜蜂
 * 
 * @author liyub
 *
 */
public class Bee extends FlyingObject {
	int xspeed;// x方向的移动速度
	int yspeed;// y方向的移动速度
	int awardType;// 打下小蜜蜂的奖励（0或1）

	Bee() {
		super(60, 50);
		Random rand = new Random();
		xspeed = 1;
		yspeed = 1;
		awardType = rand.nextInt(2);
	}
}
