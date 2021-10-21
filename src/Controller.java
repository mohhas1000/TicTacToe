import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

public class Controller extends WindowAdapter implements ActionListener {

	private View view;
	private Model model;
	private String[] box;
	private String text=null;

	public Controller(View v) {
		this.view = v;
		this.model = new Model();
	}

	public void actionPerformed(ActionEvent evt) {
		JButton button = (JButton) evt.getSource();
		String text = button.getText();
		if (evt.getSource() == button) {
			boolean key = model.GetTurn();
			box = view.Play(button, key);
			view.NewOverview(key);			
			text = model.check(box);		
			
			if(text != null) {
			view.NewGame(text);
			box = null;
			text=null;
			view.NewOverview(key);
			}
		}
	}

	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

}
