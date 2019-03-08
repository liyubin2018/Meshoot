package cn.tedu.shoot;

import java.awt.image.BufferedImage;

/**
 * 
 * @author liyub 英雄机
 */
public class Hero extends FlyingObject {
	private static BufferedImage[] images;
	static {
		images = new BufferedImage[6];
		for (int i = 0; i < images.length; i++) {
			images[i] = loadImage("hero" + i + ".png");
		}
	}
	private int life;// 生命
	private int doubleFire;

	public Hero() {
		super(97, 124, 140, 400);
		this.life = 3;
		this.doubleFire = 0;
	}

	/**
	 * 英雄机随着鼠标的移动，鼠标的坐标x，y；
	 * 
	 * @param x
	 * @param y
	 */
	public void moveTo(int x, int y) {
		this.x = x - this.width / 2;
		this.y = y - this.height / 2;
	}

	public void step() {

	}

	private int index = 0;// 活着的下标
	private int deadIndex = 2;// 死了的下标

	@Override // 重写outOfBounds方法
	public boolean outOfBounds() {
		return false;

	}

	/** 重写getImage()方法，获取图片 */
	public BufferedImage getImage() {

		if (isLife()) {// 如果活着，切换两张图片
			return images[index++ % 2];
		} else if (isDead()) {// 如果死亡
			BufferedImage img = images[deadIndex++];
			if (deadIndex == images.length) {
				state = REMOVE;
			}
			return img;
		}
		return null;
	}

	/** 英雄机发射子弹（创建子弹对象） */
	public Bullet[] shoot() {
		int xStep = this.width / 4;
		int yStep = 10;
		if (doubleFire > 0) {// 双倍火力
			Bullet[] bs = new Bullet[2];
			bs[0] = new Bullet(this.x + 1 * xStep, this.y - yStep);
			bs[1] = new Bullet(this.x + 3 * xStep, this.y - yStep);
			doubleFire -= 2;// 火力值减2
			return bs;
		} else {// 单倍火力
			Bullet[] bs = new Bullet[1];
			bs[0] = new Bullet(this.x + 2 * xStep, this.y - yStep);
			return bs;
		}
	}

	public void addLife() {//加命
		life++;
	}
	/**减命*/
	public void subtractLife() {
		life--;
	}
	/**火力值清零*/
	public void clearDoubleFire() {
		doubleFire=0;
	}
	public int getLife() {
		return life;//返回命数
	}

	/** 英雄机火力值怎加40 */
	public void addDoubleFire() {
		doubleFire += 40;
	}

}