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
		y+=yspeed;
		x+=xspeed;
		if (x<=0||x>=World.WIDTH) {//判断小蜜蜂是否移动到窗口边缘
			xspeed*=-1;
		}
	}
	
	@Override//重写outOfBounds方法
	public boolean outOfBounds() {
		return this.y>=World.HEIGTH;
		
	}
	
	/** 重写getImage()方法，获取图片 */
	private int deadIndex = 1;
	public BufferedImage getImage() {
		if (isLife()) {
			return images[0];
		} else if (isDead()) {
			BufferedImage img = images[deadIndex++];
			if (deadIndex == images.length) {
				state = REMOVE;
			}
			return img;
		}
		return null;
	}
}
