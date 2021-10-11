import javax.swing.ImageIcon;
import javax.swing.Icon;
import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Image;

public class maze_main
{
	public static void main(String[] args)
	{

		String[] res = { "", // 路
				"res/wall.PNG", // 牆壁
				"res/end.jpg", // 終點
				"", // 走過的路
				"res/123.png",// 老鼠
		};
		Image image = null;
		Icon icon = null;
		try
		{
			image = ImageIO.read(new File("res/icon.png"));
			icon = new ImageIcon(image);
		} catch (IOException e)
		{
			// TODO 自動產生的 catch 區塊
			e.printStackTrace();
		}
		// Icon icon=new ImageIcon(image);
		int u[] = toInt(showInputDialog("請輸入迷宮的高跟寬(請以SPACE隔開)：", "10 10"));
		int maze[][] = new int[u[0] + 2][u[1] + 2];
		showMessageDialog(null, maze.length + "*" + maze[0].length + "迷宮已經建好了", "貪婪之島", 1, icon);
		int percent[] = toInt(showInputDialog("請輸入迷宮中道路占多少％(0-100 int=>)：", "20"));
		showMessageDialog(null, "100" + ":" + percent[0] + "道路已經建好了", "貪婪之島", 1, icon);
		canvas can = new canvas(20, maze);
		can.setRes(res);
		can.buildfence(percent[0]);
		can.initMaze();
	}

	static int[] toInt(String n)
	{
		String a[] = n.split("\\s+");
		int u[] = new int[a.length];
		for (int i = 0; i < a.length; i++)
		{
			u[i] = Integer.parseInt(a[i]);
		}
		return u;
	}
}
