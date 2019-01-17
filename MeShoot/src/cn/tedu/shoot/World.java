package cn.tedu.shoot;

/**
 * 测试类
 * 
 * @author liyub 整个世界
 */
public class World {
	Sky sky;
	Hero hero;
	Airplane[] as;
	BigAirplane[] bas;
	Bee[] bs;
	Bullet[] bts;

	void action() {// 启动执行测试代码
		as = new Airplane[10];
		for (int i = 0; i < as.length; i++) {
			as[i] = new Airplane();
			as[i].step();
			System.out.println(as[i].x + "," + as[i].y);
		}
		bas = new BigAirplane[10];
		for (int i = 0; i < bas.length; i++) {
			bas[i] = new BigAirplane();
			bas[i].step();
			System.out.println(bas[i].x + "," + bas[i].y);
		}
		bs = new Bee[10];
		for (int i = 0; i < bs.length; i++) {
			bs[i] = new Bee();
			bs[i].step();
			System.out.println(bs[i].x + "," + bs[i].y);
		}
		bts = new Bullet[3];
		bts[0] = new Bullet(100, 512);
		bts[0].step();
		bts[1] = new Bullet(65, 186);
		bts[1].step();
		bts[2] = new Bullet(65, 20);
		bts[2].step();

	}

	public static void main(String[] args) {
		World world = new World();// 创建世界
		world.action();// 启动执行

	}

}
