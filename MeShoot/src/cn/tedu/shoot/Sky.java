package cn.tedu.shoot;

/**
 * 天空
 * 
 * @author liyub
 *
 */
public class Sky {
	int width;// 宽
	int height;// 高
	int x;// x坐标
	int y;// y坐标
	int y1;// y1坐标(图片轮换)
	int speed;

	Sky() {
		width = 400;
		height = 700;
		x = 0;
		y = 0;
		speed = 1;
		y1=-height;
	}

	/* 天空移动 */
	void step() {
		System.out.println("天空移动了：" + speed);
	}
}
