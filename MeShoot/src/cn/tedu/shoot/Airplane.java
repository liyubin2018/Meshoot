package cn.tedu.shoot;

import java.awt.image.BufferedImage;

/**
 * 小敌机
 * 
 * @author liyub
 *
 */
public class Airplane extends FlyingObject {
	private static BufferedImage[] images;
	static {
		images = new BufferedImage[5];
		for (int i = 0; i < images.length; i++) {
			images[i] = loadImage("airplane" + i + ".png");
		}
	}
	private int speed;// 移动速度

	public Airplane() {
		super(49, 36);
		speed = 1;
	}

	public void step() {
		System.out.println("小敌机的y坐标移动了：！" + speed);
	}

}
