import javax.swing.JOptionPane;

public class Model {
	private boolean key;
	private boolean draw;
	private int antal;
	public Model() {
		key = false;
	}

	public boolean GetTurn() {
		if (!key) {
			key = true;
		} else {
			key = false;
		}
		return key;
	}
	
	public String check(String[] box) {
		draw= true;
		if ((box[0].equals("Red") && box[1].equals("Red") && box[2].equals("Red")
				|| box[3].equals("Red") && box[4].equals("Red") && box[5].equals("Red")
				|| box[6].equals("Red") && box[7].equals("Red") && box[8].equals("Red"))) {

			draw = false;
			return "Red";		

		} else {
			if (box[0].equals("Blue") && box[1].equals("Blue") && box[2].equals("Blue")
					|| box[3].equals("Blue") && box[4].equals("Blue") && box[5].equals("Blue")
					|| box[6].equals("Blue") && box[7].equals("Blue") && box[8].equals("Blue")) {
				draw = false;
				return "Blue";
			}
		}

		if (box[0].equals("Red") && box[3].equals("Red") && box[6].equals("Red")
				|| box[1].equals("Red") && box[4].equals("Red") && box[7].equals("Red")
				|| box[2].equals("Red") && box[5].equals("Red") && box[8].equals("Red")) {

			draw = false;
			return "Red";

		} else {
			if (box[0].equals("Blue") && box[3].equals("Blue") && box[6].equals("Blue")
					|| box[1].equals("Blue") && box[4].equals("Blue") && box[7].equals("Blue")
					|| box[2].equals("Blue") && box[5].equals("Blue") && box[8].equals("Blue")) {
				draw = false;
				return "Blue";
			}
		}

		if (box[0].equals("Red") && box[4].equals("Red") && box[8].equals("Red")
				|| box[2].equals("Red") && box[4].equals("Red") && box[6].equals("Red")) {

			draw = false;
			return "Red";

		} else {
			if (box[0].equals("Blue") && box[4].equals("Blue") && box[8].equals("Blue")
					|| box[2].equals("Blue") && box[4].equals("Blue") && box[6].equals("Blue")) {
				draw = false;				
				return "Blue";
			}
		}
		
		for (int i = 0; i < box.length ; i++) {
			if (box[i].equals("null")) {
				draw=false;
			}
		}
		

		if (draw) {
			return "Draw";
		}

		return null;

	}

}
