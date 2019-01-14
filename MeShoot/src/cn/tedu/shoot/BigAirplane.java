package cn.tedu.shoot;

import java.util.Random;

/**
 * 大敌机
 * 
 * @author liyub
 *
 */
public class BigAirplane {
	int width;// 宽
	int height;// 高
	int x;// x坐标
	int y;// y坐标
	int speed;// 移动速度
	BigAirplane(){
		width=69;
		height=99;
		Random rand=new Random();
		x=rand.nextInt(400-this.width);
		y=-this.height;
		speed=1;
	}

	/* 大敌机移动 */
	void step() {
		System.out.println("大敌机的y坐标移动了:" + speed);
	}
}
