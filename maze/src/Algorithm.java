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
		System.out.println("���U��L");
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
				if (maze[a][b + 1] == 0 || maze[a][b + 1] == 2)// �P�_�k��
				{
					maze[a][b] = 3;
					b++;
					step++;
				}
				break;
			case KeyEvent.VK_DOWN:
				if (maze[a + 1][b] == 0 || maze[a + 1][b] == 2)// �P�_�U��
				{
					maze[a][b] = 3;
					a++;
					step++;
				}
				break;
			case KeyEvent.VK_UP:
				if (maze[a - 1][b] == 0 || maze[a - 1][b] == 2)// �P�_�W��
				{
					maze[a][b] = 3;
					a--;
					step++;
				}
				break;
			case KeyEvent.VK_LEFT:
				if (maze[a][b - 1] == 0 || maze[a][b - 1] == 2)// �P�_����
				{
					maze[a][b] = 3;
					b--;
					step++;
				}
				break;
		}
		if (maze[a][b] == 2)// �����I
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
				showMessageDialog(null, "���ߦ������v");
			} else
			{
				System.out.print("�ТעܢբݡI�I �`�@��" + step + "�B");
				for (int i = 0; i < maze.length; i++)
				{
					for (int j = 0; j < maze[0].length; j++)
					{
						if (maze[i][j] == 3 || maze[i][j] == 2)// ����I�h��
						{
							maze[i][j] = 0;
						}
					}
				}
				step = 0;
				fse(maze);// ���s�����I
				maze[a][b] = 4;
			}
		} else
		{
			maze[a][b] = 4;
		}
	}
}
