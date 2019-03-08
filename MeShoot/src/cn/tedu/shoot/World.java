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
import java.awt.image.BufferedImage;

/**
 * 测试类
 * 
 * @author liyub 整个世界
 */
@SuppressWarnings("serial")
public class World extends JPanel {
	public static final int WIDTH = 400;
	public static final int HEIGTH = 700;
	public static final int START=0;//启动
	public static final int RUNNING=1;//运行
	public static final int PAUSE=2;//暂停
	public static final int GAME_OVER=3;//游戏结束
	private int state=START;//当前状态默认为启动	
	
	private static BufferedImage start;
	private static BufferedImage pause;
	private static BufferedImage gameover;
	static {
		start=FlyingObject.loadImage("start.png");
		pause=FlyingObject.loadImage("pause.png");
		gameover=FlyingObject.loadImage("gameover.png");
	}
		
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
			if (!f.outOfBounds()&&!f.isRemove()) {
				enemyLives[index] = f;
				index++;
			}
		}
		enemies = Arrays.copyOf(enemyLives, index);
		index = 0;
	}
	int index=0;
	/** 删除越界子弹 */
	public void outOfBulletAction() {
		Bullet[] btsLives=new Bullet[bts.length];
		for (int i = 0; i < bts.length; i++) {
			Bullet b=bts[i];
			if (!b.outOfBounds()&&!b.isRemove()) {
				
				btsLives[index]=b;
				index++;
				System.out.println("子弹删除");
			}
		}
		bts=Arrays.copyOf(btsLives, index);
		index=0;
	}

	int score = 0;

	/** 子弹与敌人碰撞 */
	private void bulletBangAction() {
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

	/**英雄机与敌人碰撞*/
	public void heroBangAction(){
		for (int i = 0; i < enemies.length; i++) {
			FlyingObject f=enemies[i];
			if (f.isLife()&&f.hit(hero)) {
				enemies[i].goDead();
				hero.subtractLife();
				hero.clearDoubleFire();
			}
		}
	}
	
	/**检测游戏结束*/
	public void checkGameOverAction() {
		if (hero.getLife()<=0) {
			score=0;
			sky=new Sky();
			hero=new Hero();
			enemies=new FlyingObject[0];
			bts=new Bullet[0];
			state=GAME_OVER;
		}
	}
	/** 程序启动执行 */
	public void action() {// 启动执行测试代码
		/** 创建侦听器对象 */
		MouseAdapter l = new MouseAdapter() {
			public void mouseMoved(MouseEvent e) {
				if (state==RUNNING) {
					int x = e.getX();// 获取鼠标x
					int y = e.getY();// 获取鼠标y
					hero.moveTo(x, y);// 调用英雄机随鼠标移动的方法
				}
					
				
			}
			
			public void mouseClicked(MouseEvent e){
				switch (state) {
				case START:
					state=RUNNING;
					break;

				case GAME_OVER:
					state=START;
					break;
				
				}
			  }
			/**鼠标移出事件*/
			public void mouseExited(MouseEvent e) {
				if (state==RUNNING) {
					state=PAUSE;
				}
			}
			/**鼠标移出事件*/
			public void mouseEntered(MouseEvent e) {
				if (state==PAUSE) {
					state=RUNNING;
				}
			}
			
		};
		this.addMouseListener(l);// 处理鼠标移动事件
		this.addMouseMotionListener(l);

		Timer timer = new Timer();// 创建定时对象
		timer.schedule(new TimerTask() {
			@Override // 重写计时方法
			public void run() {
				if (state==RUNNING) {//运行状态时调用
					enterdAction();
					stepAction();// 飞行物移动
					shootAction(); // 子弹入场
					outOfBoundsAction();// 删除越界的飞行物
					bulletBangAction();//子弹与敌人撞
					heroBangAction();
					checkGameOverAction();//检测游戏结束
				}
					
				
			
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
		
		switch (state) {
		case START:
			g.drawImage(start,0,0,null );
			break;

		case PAUSE:
			g.drawImage(pause,0,0,null);
			break;
		case GAME_OVER:
			g.drawImage(gameover,0,0,null);
			break;
		}
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
