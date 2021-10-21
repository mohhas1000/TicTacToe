import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

class Circle extends JComponent {

	private String text;

	public Circle(String text) {
		super();
		this.text = text;
	}

	@Override
	protected void paintComponent(Graphics g0) {
		super.paintComponent(g0);
		Graphics2D g = (Graphics2D) g0;
		g.setFont(new Font("Verdana", getWidth(), getHeight()));
		g.setColor(Color.blue);
		Rectangle2D rect = g.getFontMetrics().getStringBounds(text, g);
		FontMetrics fm = g.getFontMetrics();
		g.drawString(text, (getWidth() - (int) rect.getWidth()) / 2,
				((getHeight() - fm.getHeight() - 10) / 2) + fm.getAscent());

	}
}

class X extends JComponent {
	
	private String text;

	public X(String text) {
		super();
		this.text = text;
	}

	protected void paintComponent(Graphics g0) {
		super.paintComponent(g0);
		Graphics2D g = (Graphics2D) g0;
		g.setFont(new Font("Verdana", getWidth(), getHeight()));
		g.setColor(Color.red);
		Rectangle2D rect = g.getFontMetrics().getStringBounds(text, g);
		FontMetrics fm = g.getFontMetrics();
		g.drawString(text, (getWidth() - (int) rect.getWidth()) / 2,
				((getHeight() - fm.getHeight() - 10) / 2) + fm.getAscent());
	}
}

public class View {
	private Frame f;
	private Controller l;
	private GridLayout grid;
	private JPanel topPanel, centerPanel, bottomPanel;
	private JLabel JLabelO, JLabelTurn, JLabelX, Bild;
	private String value;
	private ImageIcon spelBild;
	private String[] boxOfButtons;
	private int redPoint = 0, bluePoint = 0;

	public View() {
		f = new Frame();
		l = new Controller(this);
		f.addWindowListener(l);

		displayLabels();
		displayButtons();
		displayImage();

		f.add(topPanel, BorderLayout.PAGE_START);
		f.add(centerPanel, BorderLayout.CENTER);
		f.add(bottomPanel, BorderLayout.PAGE_END);

		f.setTitle("Tic Tac Toe");
		f.setSize(800, 950);
		f.setLocation(300, 50);
		f.setVisible(true);
		f.setMinimumSize(new Dimension(500, 600));

		boxOfButtons = new String[9];
		for (int i = 0; i < boxOfButtons.length; i++) {
			boxOfButtons[i] = "null";
		}

	}

	private void displayImage() {

		bottomPanel = new JPanel();
		spelBild = new ImageIcon(getClass().getResource("/tictactoe.png"));
		Bild = new JLabel(spelBild);
		bottomPanel.add(Bild);
		bottomPanel.setBorder(new EmptyBorder(20, 0, 20, 0));

	}

	private void displayLabels() {
		grid = new GridLayout(0, 3);
		topPanel = new JPanel();
		topPanel.setLayout(grid);
		value = "X";

		JLabelX = new JLabel("<html><h1> Player <font color='red'>X</font> Score: " + redPoint + "</h1></html>");
		JLabelX.setFont(new Font("Verdana", Font.PLAIN, 30));
		JLabelX.setVerticalAlignment(SwingConstants.CENTER);
		JLabelX.setHorizontalAlignment(SwingConstants.CENTER);
		JLabelX.setVerticalAlignment(SwingConstants.CENTER);
		Border border = JLabelX.getBorder();
		Border margin = new EmptyBorder(10,0,10,0);
		JLabelX.setBorder(new CompoundBorder(border, margin));
		topPanel.add(JLabelX);

		JLabelTurn = new JLabel("<html><h1> It's <font color='red'>" + value + "</font>'s turn! </h1></html>");
		JLabelTurn.setFont(new Font("Verdana", Font.PLAIN, 30));
		JLabelTurn.setVerticalAlignment(SwingConstants.CENTER);
		JLabelTurn.setHorizontalAlignment(SwingConstants.CENTER);
		JLabelTurn.setVerticalAlignment(SwingConstants.CENTER);
		JLabelTurn.setBorder(new CompoundBorder(border, margin));
		topPanel.add(JLabelTurn);

		JLabelO = new JLabel("<html> <h1>Player <font color='blue'>O</font> Score: " + bluePoint + "</h1></html>");
		JLabelO.setFont(new Font("Verdana", Font.PLAIN, 30));
		JLabelO.setHorizontalAlignment(SwingConstants.CENTER);
		JLabelO.setVerticalAlignment(SwingConstants.CENTER);
		JLabelO.setBorder(new CompoundBorder(border, margin));
		topPanel.add(JLabelO);
		topPanel.setBorder(BorderFactory.createLineBorder(Color.black));

	}

	public void NewGame(String text) {

		if (text == "Blue") {
			JOptionPane.showMessageDialog(null, "Blue Win!");
			bluePoint++;
		}

		if (text == "Red") {
			JOptionPane.showMessageDialog(null, "Red Win!");
			redPoint++;
		}

		if (text == "Draw") {
			JOptionPane.showMessageDialog(null, "It´s a draw");
		}
		f.remove(centerPanel);
		displayButtons();
		f.add(centerPanel, BorderLayout.CENTER);
		f.remove(topPanel);
		displayLabels();
		f.add(topPanel, BorderLayout.PAGE_START);
		boxOfButtons = new String[9];
		for (int i = 0; i < boxOfButtons.length; i++) {
			boxOfButtons[i] = "null";
		}

		f.setVisible(true);

	}

	private void displayButtons() {
		grid = new GridLayout(3, 3);
		centerPanel = new JPanel();
		centerPanel.setLayout(grid);

		for (int i = 1; i <= 9; i++) {
			JButton button = new JButton();
			button.setBorder(BorderFactory.createRaisedBevelBorder());
			centerPanel.add(button);
			button.addActionListener(l);
		}
	}

	public static void main(String[] args) {
		new View();
	}

	public String[] Play(JButton button, boolean key) {
		button.setBackground(new Color(170, 170, 170).brighter());

		if (key) {
			button.add(new X("X"));

		} else {
			button.add(new Circle("O"));
		}

		Component[] component = centerPanel.getComponents();

		for (int i = 0; i < component.length; i++) {
			if (component[i] == button) {
				if (key) {
					boxOfButtons[i] = "Red";
				} else {
					boxOfButtons[i] = "Blue";
				}

			}

		}
		button.setEnabled(false);
		f.setVisible(true);

		return boxOfButtons;

	}

	public void NewOverview(boolean key) {

		if (key) {
			value = "O";
			topPanel.remove(JLabelTurn);
			topPanel.remove(JLabelO);
			JLabelTurn = new JLabel("<html><h1> It's <font color='blue'>" + value + "</font>'s turn! </h1></html>");
			JLabelTurn.setFont(new Font("Verdana", Font.PLAIN, 30));
			JLabelTurn.setVerticalAlignment(SwingConstants.CENTER);
			JLabelTurn.setHorizontalAlignment(SwingConstants.CENTER);
			JLabelTurn.setVerticalAlignment(SwingConstants.CENTER);
			topPanel.add(JLabelTurn);
			topPanel.add(JLabelO);
		} else {
			value = "X";
			topPanel.remove(JLabelTurn);
			topPanel.remove(JLabelO);
			JLabelTurn = new JLabel("<html><h1> It's <font color='Red'>" + value + "</font>'s turn! </h1></html>");
			JLabelTurn.setFont(new Font("Verdana", Font.PLAIN, 30));
			JLabelTurn.setVerticalAlignment(SwingConstants.CENTER);
			JLabelTurn.setHorizontalAlignment(SwingConstants.CENTER);
			JLabelTurn.setVerticalAlignment(SwingConstants.CENTER);
			topPanel.add(JLabelTurn);
			topPanel.add(JLabelO);

		}
		f.setVisible(true);

	}
}
