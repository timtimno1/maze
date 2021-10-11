import java.awt.Image;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class canvas extends CanvasBase
{
	static int ponx = 400;
	static int pony = 400;
	static ArrayList<String> maze = new ArrayList<String>();
	static String[][] strmaze;
	static int con = 0;
	static int fps = 0;
	static String[] res;
	static String fileRes;
	int m[][];
	Image image;

	public canvas()
	{
	}

	public canvas(int f, int m[][])
	{
		this.m = m;
		fps = f;
	}

	public void setRes(String[] res)
	{
		// 設定res
		this.res = res;
	}

	public void paintCanvas(Graphics g)
	{
		if (con < maze.size())
		{
			for (int x = 0; x < ponx; x++)
			{
				for (int y = 0; y < pony; y++)
				{
					strmaze[x][y] = maze.get(con);
					con += 1;
				}
			}
		}
		for (int x = 0; x < ponx; x++)
		{
			for (int y = 0; y < pony; y++)
			{
				switch (strmaze[x][y])
				{
					case "0":
						try
						{
							fileRes = this.res[Integer.parseInt(strmaze[x][y])];
							image = ImageIO.read(new File(fileRes));
							g.drawImage(image, y * 50, x * 50, 50, 50, null);
						} catch (Exception ex)
						{
						}
						break;
					case "1":
						try
						{
							fileRes = this.res[Integer.parseInt(strmaze[x][y])];
							image = ImageIO.read(new File(fileRes));
							g.drawImage(image, y * 50, x * 50, 50, 50, null);
						} catch (Exception ex)
						{
							g.fillRect(y * 50, x * 50, 50, 50);
						}
						break;
					case "2":
						try
						{
							fileRes = this.res[Integer.parseInt(strmaze[x][y])];
							image = ImageIO.read(new File(fileRes));
							g.drawImage(image, y * 50, x * 50, 50, 50, null);
						} catch (Exception ex)
						{
							g.fillOval(y * 50 + 10, x * 50 + 10, 30, 30);
						}
						break;
					case "3":
						try
						{
							fileRes = this.res[Integer.parseInt(strmaze[x][y])];
							image = ImageIO.read(new File(fileRes));
							g.drawImage(image, y * 50, x * 50, 50, 50, null);
						} catch (Exception ex)
						{
							g.fillRect(y * 50 + 20, x * 50 + 20, 10, 10);
						}
						break;
					case "4":
						try
						{
							fileRes = this.res[Integer.parseInt(strmaze[x][y])];
							image = ImageIO.read(new File(fileRes));
							g.drawImage(image, y * 50, x * 50, 50, 50, null);
						} catch (Exception ex)
						{
							g.fillOval(y * 50 + 10, x * 50 + 10, 30, 30);
						}
						break;
					case "5":
						try
						{
							int widh = ponx * 50 / 7;
							int Long = pony * 50 / 10;
							// image = ImageIO.read(new File("res/01.jpg"));
							// g.drawImage(image, y*50, x*50,widh*7/3,Long*10/3,null);
							image = ImageIO.read(new File("res/02.png"));
							g.drawImage(image, y * 50 + widh * 7 / 3, x * 50, widh * 7 / 3, Long * 10 / 3, null);
							// image = ImageIO.read(new File("res/03.jpg"));
							// g.drawImage(image, y*50+2*widh*7/3, x*50,widh*7/3,Long*10/3,null);
							image = ImageIO.read(new File("res/04.png"));
							g.drawImage(image, y * 50 + widh * 7 / 3, x * 50 + Long * 10 / 3, widh * 7 / 3,
									Long * 10 / 3, null);
						} catch (Exception ex)
						{
							g.fillOval(y * 50 + 10, x * 50 + 10, 30, 30);
						}
						break;
					default:
						try
						{
							fileRes = this.res[Integer.parseInt(strmaze[x][y])];
							image = ImageIO.read(new File(fileRes));
							g.drawImage(image, y * 50, x * 50, 50, 50, null);
						} catch (Exception ex)
						{
							g.fillOval(y * 50 + 25, x * 50 + 25, 30, 30);
						}
						break;
				}
			}
		}
	}

	public void buildfence(int percent)
	{
		// 建上、下牆
		for (int i = 0; i < m[0].length; i++)
		{
			m[0][i] = 1;
			m[m.length - 1][i] = 1;
		}
		// 建左、右牆
		for (int i = 0; i < m.length; i++)
		{
			m[i][0] = 1;
			m[i][m[i].length - 1] = 1;
		}
		// 建道路
		for (int i = 1; i < m.length - 1; i++)
		{
			for (int j = 1; j < m[i].length - 1; j++)
			{
				m[i][j] = ((int) (Math.random() * 100000) % 100 >= percent) ? 0 : 1;
			}
		}
		m[1][1] = 4;
		fse(m);
	}

	protected void fse(int[][] maze)// 設定終點
	{
		while (true)
		{
			int a = ((int) (Math.random() * 100000) % maze.length);
			int b = ((int) (Math.random() * 100000) % maze[0].length);
			// System.out.println(a + " " + b);
			if (maze[a][b] == 0)
			{
				maze[a][b] = 2;
				break;
			}
		}
		/*
		 * while(true) { int a=((int)(Math.random()*100000)%maze.length); int
		 * b=((int)(Math.random()*100000)%maze[0].length); //System.out.println(a + " "
		 * + b); if(maze[a][b]==0) { maze[a][b]=4; this.a=a; this.b=b; break; } }
		 */
	}

	public void end(Graphics g)
	{

		try
		{
			image = ImageIO.read(new File("res/01"));
		} catch (IOException e)
		{
			// TODO 自動產生的 catch 區塊
			e.printStackTrace();
		}
		g.drawImage(image, 50, 50, 50, 50, null);
	}

	public void updateMaze(int[][] m)
	{
		// 更新地圖
		for (int i = 0; i < m.length; i++)
		{
			for (int j = 0; j < m[i].length; j++)
			{
				maze.add(m[i][j] + "");
			}
		}
	}

	public void initMaze()
	{
		// 初始化地圖
		for (int i = 0; i < m.length; i++)
		{
			for (int j = 0; j < m[i].length; j++)
			{
				maze.add(m[i][j] + "");
			}
		}

		ponx = m.length;
		pony = m[0].length;

		strmaze = new String[ponx][pony];
		JFrame jf = new JFrame("貪婪之島2.2");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		canvas canvas = new canvas();
		jf.getContentPane().add(canvas);
		System.out.println("FPS = " + fps);
		canvas.setFPS(fps);
		canvas.startPaint();

		jf.setBounds(50, 50, ponx * 50 + 50, pony * 50 + 50);
		jf.setVisible(true);

		jf.addKeyListener(new Algorithm(m, 3));
	}
}
