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

		String[] res = { "", // ��
				"res/wall.PNG", // ���
				"res/end.jpg", // ���I
				"", // ���L����
				"res/123.png",// �ѹ�
		};
		Image image = null;
		Icon icon = null;
		try
		{
			image = ImageIO.read(new File("res/icon.png"));
			icon = new ImageIcon(image);
		} catch (IOException e)
		{
			// TODO �۰ʲ��ͪ� catch �϶�
			e.printStackTrace();
		}
		// Icon icon=new ImageIcon(image);
		int u[] = toInt(showInputDialog("�п�J�g�c������e(�ХHSPACE�j�})�G", "10 10"));
		int maze[][] = new int[u[0] + 2][u[1] + 2];
		showMessageDialog(null, maze.length + "*" + maze[0].length + "�g�c�w�g�ئn�F", "�g�����q", 1, icon);
		int percent[] = toInt(showInputDialog("�п�J�g�c���D���e�h�֢H(0-100 int=>)�G", "20"));
		showMessageDialog(null, "100" + ":" + percent[0] + "�D���w�g�ئn�F", "�g�����q", 1, icon);
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
