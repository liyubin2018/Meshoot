package cn.tedu.shoot;

import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 小蜜蜂
 * 
 * @author liyub
 *
 */
public class Bee extends FlyingObject {
	private static BufferedImage[] images;
	static {
		images = new BufferedImage[5];
		for (int i = 0; i < images.length; i++) {
			images[i] = loadImage("bee" + i + ".png");
		}
	}
	private int xspeed;// x方向的移动速度
	private int yspeed;// y方向的移动速度
	private int awardType;// 打下小蜜蜂的奖励（0或1）

	public Bee() {
		super(60, 50);
		Random rand = new Random();
		xspeed = 1;
		yspeed = 1;
		awardType = rand.nextInt(2);
	}

	public void step() {
		System.out.println("小蜜蜂的y坐标移动了：" + xspeed + "，小蜜蜂的y坐标移动了：" + yspeed);
	}
}
