package cn.tedu.shoot;

/**
 * 测试类
 * 
 * @author liyub 整个世界
 */
public class World {
	Sky sky;
	Hero hero;
	FlyingObject[] enemies= {};
	Bullet[] bts= {};

	void action() {// 启动执行测试代码
		enemies=new FlyingObject[9]; 
		enemies[0]=new Airplane();
		enemies[1]=new Airplane();
		enemies[2]=new Airplane();
		enemies[3]=new BigAirplane();
		enemies[4]=new BigAirplane();
		enemies[5]=new BigAirplane();
		enemies[6]=new Bee();
		enemies[7]=new Bee();
		enemies[8]=new Bee();
		for (int i = 0; i < enemies.length; i++) {
			FlyingObject f=enemies[i];
			f.step();
			System.out.println(f.width+","+f.height+","+","+f.x+","+f.y);
		}
		bts= new Bullet[3];
		bts[0]=new Bullet(36,68);
		bts[1]=new Bullet(120,354);
		bts[2]=new Bullet(320,652);
		for (int i = 0; i < bts.length; i++) {
			bts[i].step();
		}
		sky=new Sky();
		sky.step();
		hero=new Hero();
		hero.step();
		hero.moveTo(12, 100);
		

	}

	public static void main(String[] args) {
		World world = new World();// 创建世界
		world.action();// 启动执行

	}

}
