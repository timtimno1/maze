import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static javax.swing.JOptionPane.showMessageDialog;

public class Algorithm extends canvas implements KeyListener
{
	int a = 1;
	int b = 1;
	int times;
	int step = 0;
	int maze[][];

	public void keyPressed(KeyEvent e)
	{
		System.out.println("按下鍵盤");
		int key = e.getKeyCode();
		gomaze(maze, key);
		updateMaze(maze);
	};

	public void keyReleased(KeyEvent e)
	{
	};

	public void keyTyped(KeyEvent e)
	{
		// int key=e.getKeyCode();
		// gomaze_1(maze,key,times);
	}

	public Algorithm()
	{
	}

	public Algorithm(int[][] maze, int times)
	{
		this.maze = maze;
		this.times = times;
	}

	public void gomaze(int maze[][] , int dir)
	{
		switch (dir)
		{
			case KeyEvent.VK_RIGHT:
				if (maze[a][b + 1] == 0 || maze[a][b + 1] == 2)// 判斷右邊
				{
					maze[a][b] = 3;
					b++;
					step++;
				}
				break;
			case KeyEvent.VK_DOWN:
				if (maze[a + 1][b] == 0 || maze[a + 1][b] == 2)// 判斷下面
				{
					maze[a][b] = 3;
					a++;
					step++;
				}
				break;
			case KeyEvent.VK_UP:
				if (maze[a - 1][b] == 0 || maze[a - 1][b] == 2)// 判斷上面
				{
					maze[a][b] = 3;
					a--;
					step++;
				}
				break;
			case KeyEvent.VK_LEFT:
				if (maze[a][b - 1] == 0 || maze[a][b - 1] == 2)// 判斷左邊
				{
					maze[a][b] = 3;
					b--;
					step++;
				}
				break;
		}
		if (maze[a][b] == 2)// 踩到終點
		{
			if (times-- == 0)
			{
				for (int i = 0; i < maze.length; i++)
				{
					for (int j = 0; j < maze[0].length; j++)
					{
						maze[i][j] = 0;
					}
				}
				maze[0][0] = 5;
				showMessageDialog(null, "恭喜成為火影");
			} else
			{
				System.out.print("ＢＩＮＧＯ！！ 總共走" + step + "步");
				for (int i = 0; i < maze.length; i++)
				{
					for (int j = 0; j < maze[0].length; j++)
					{
						if (maze[i][j] == 3 || maze[i][j] == 2)// 把終點去掉
						{
							maze[i][j] = 0;
						}
					}
				}
				step = 0;
				fse(maze);// 做新的終點
				maze[a][b] = 4;
			}
		} else
		{
			maze[a][b] = 4;
		}
	}
}
