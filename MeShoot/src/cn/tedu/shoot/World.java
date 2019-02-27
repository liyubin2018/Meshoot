package cn.tedu.shoot;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;
import java.util.Arrays;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 测试类
 * 
 * @author liyub 整个世界
 */
@SuppressWarnings("serial")
public class World extends JPanel {
	public static final int WIDTH = 400;
	public static final int HEIGTH = 700;
	private Sky sky = new Sky();
	private Hero hero = new Hero();
	private FlyingObject[] enemies = {};
	private Bullet[] bts = {};

	/** 创建敌人对象 */
	public FlyingObject nextOne() {
		Random rand = new Random();
		int type = rand.nextInt(20);
		if (type < 10) {
			return new Airplane();
		} else if (type < 18) {
			return new BigAirplane();
		} else {
			return new Bee();
		}
	}

	int enterIndex = 0;

	/** 敌人入场 */
	public void enterdAction() {
		enterIndex++;
		if (enterIndex % 30 == 0) {
			FlyingObject obj = nextOne();
			enemies = Arrays.copyOf(enemies, enemies.length + 1);
			enemies[enemies.length - 1] = obj;
		}

	}

	public void stepAction() {// 10毫秒走一次
		sky.step();

		for (int i = 0; i < bts.length; i++) {
			bts[i].step();
		}
		for (int i = 0; i < enemies.length; i++) {
			enemies[i].step();
		}

	}

	int shootIndex = 0;// 子弹发射计数

	/** 子弹入场 */
	public void shootAction() {// 10毫秒走一次
		shootIndex++;
		if (shootIndex % 20 == 0) {// 每100毫秒走一次
			Bullet[] bs = hero.shoot();
			bts = Arrays.copyOf(bts, bts.length + bs.length);// bs有几发子弹就扩容几
			System.arraycopy(bs, 0, bts, bts.length - bs.length, bs.length);
		}
	}

	/** 删除越界的飞行物 */
	public void outOfBoundsAction() {
		int index = 0;
		FlyingObject[] enemyLives = new FlyingObject[enemies.length];
		for (int i = 0; i < enemies.length; i++) {
			FlyingObject f = enemies[i];
			if (!f.outOfBounds()) {
				enemyLives[index] = f;
				index++;
			}
		}
		enemies = Arrays.copyOf(enemyLives, index);
		index = 0;
	}

	/** 删除越界子弹 */
	public void outOfBulletAction() {
//		int index=0;
//		Bullet[] btsLives=new Bullet[bts.length];
//		for (int i = 0; i < bts.length; i++) {
//			Bullet b=bts[i];
//			if (!b.outOfBounds()) {
//				btsLives[index]=b;
//				index++;
//			}
//		}
//		bts=Arrays.copyOf(btsLives, index);
//		index=0;
	}

	int score = 0;

	/** 子弹与敌人碰撞 */
	private void bulletBoundAction() {
		for (int i = 0; i < bts.length; i++) {
			Bullet b = bts[i];
			for (int j = 0; j < enemies.length; j++) {
				FlyingObject f = enemies[j];
				if (b.isLife() && f.isLife() && f.hit(b)) {
					b.goDead();
					f.goDead();
					if (f instanceof Enemy) {
						Enemy e = (Enemy) f;
						score += e.getScore();
					}
					if (f instanceof Award) {
						Award a = (Award) f;
						int Type = a.getType();
						switch (Type) {
						case Award.DOUBLE_FIRE:
							hero.addDoubleFire();
							break;

						case Award.LIFE:
							hero.addLife();
							break;
						}
					}
				}
			}
		}

	}

	/** 程序启动执行 */
	public void action() {// 启动执行测试代码
		/** 创建侦听器对象 */
		MouseAdapter l = new MouseAdapter() {
			public void mouseMoved(MouseEvent e) {
				int x = e.getX();// 获取鼠标x
				int y = e.getY();// 获取鼠标y
				hero.moveTo(x, y);// 调用英雄机随鼠标移动的方法
			}
		};
		this.addMouseListener(l);// 处理鼠标移动事件
		this.addMouseMotionListener(l);

		Timer timer = new Timer();// 创建定时对象
		timer.schedule(new TimerTask() {
			@Override // 重写计时方法
			public void run() {
				enterdAction();
				System.out.println(enemies.length);
				stepAction();// 飞行物移动
				shootAction(); // 子弹入场
				outOfBoundsAction();// 删除越界的飞行物
				outOfBulletAction();// 删除越界的子弹
				bulletBoundAction();
				repaint();// 重画(重新调用paint()方法);

			}

		}, 10, 10);// 定时任务

	}

	/** 重写paint()方法 */
	public void paint(Graphics g) {
		sky.paintObject(g);// 画天空
		hero.paintObject(g);// 画英雄机
		for (int i = 0; i < enemies.length; i++) {
			enemies[i].paintObject(g);// 画敌人
		}
		for (int i = 0; i < bts.length; i++) {
			bts[i].paintObject(g);
		}

		g.drawString("得分：" + score, 10, 25);
		g.drawString("生命值：" + hero.getLife(), 10, 40);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame(); // 创建一个窗口对象
		World world = new World(); // 创建一个面板对象
		frame.add(world); // 将面板添加到窗口中
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置关闭窗口时退出程序
		frame.setSize(WIDTH, HEIGTH); // 设置窗口的大小
		frame.setLocationRelativeTo(null); // 设置窗口居中显示
		frame.setVisible(true); // 1)设置窗口可见 2)尽快调用paint()

		world.action();// 启动执行

	}

}
