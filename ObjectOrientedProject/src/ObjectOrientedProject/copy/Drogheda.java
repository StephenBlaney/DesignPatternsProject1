
package ObjectOrientedProject.copy;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Drogheda extends Frame implements ActionListener {
	private Checkbox Hotel, Restaurant, PlacesofInterest, ToDo;
	private Button Name, Description, Location, Back, Quit;
	private Ireland town = null;
	private DublinPanel Dub;
	private String nameArea = "", descriptionArea = "", locationArea = "" ,nameArea1 = "" , descriptionArea1 = "" , locationArea1 = "";

	public Drogheda() {
		super("Hoildays in Ireland");
		setGUI();
	}

	private void setGUI() {

		JLabel label2 = new JLabel("<html> --How to get to Drogheda --</html>");
		JLabel label1 = new JLabel(
				"<html>Drogheda is one of the oldest towns in Ireland, known for its tourism and as a centre of industry, and medical care. It is located in County Louth on the Dublin-Belfast corridor on the east coast of Ireland, 49 km or 30 miles north of Dublin.</html> !");

		label2.setIcon(new ImageIcon(
				"C:\\Users\\Stephen Blaney\\Documents\\Semester6\\Object Orientation with design patterns\\WeekFive\\index2.jpg"));
		setBackground(Color.pink);
		setLayout(new GridLayout(2, 1)); // 1 row 2 columns
		Panel left = new Panel();
		add(left);
		Panel right = new Panel();
		add(right);

		Font fancyFont2 = new Font("Serif", Font.ITALIC, 22);
		label1.setFont(fancyFont2);
		label2.setFont(fancyFont2);
		left.setLayout(new GridLayout(3, 1));
		CheckboxGroup grp = new CheckboxGroup();
		Hotel = new Checkbox("Hotel", grp, false);
		Restaurant = new Checkbox("Restaurant", grp, false);
		PlacesofInterest = new Checkbox("Places of interest", grp, false);
		ToDo = new Checkbox("Things to do ", grp, false);

		left.add(label1);
		left.add(label2);
		left.add(Hotel);
		left.add(Restaurant);
		left.add(PlacesofInterest);
		left.add(ToDo);

		Hotel.addItemListener(new HotelListener());
		Restaurant.addItemListener(new RestuarantListener());
		PlacesofInterest.addItemListener(new InterestListener());
		ToDo.addItemListener(new ToDoListener());

		right.setLayout(new GridLayout(2, 2));
		Dub = new DublinPanel();
		Dub.setBackground(Color.white);
		Panel botRight = new Panel();

		right.add(Dub);
		right.add(botRight);
		Name = new Button("Name");
		Description = new Button("Description");
		Location = new Button("Location");
		Back = new Button("Back");
		Quit = new Button("Quit");

		botRight.add(Name);
		Name.addActionListener(this);

		botRight.add(Description);
		Description.addActionListener(this);

		botRight.add(Location);
		Location.addActionListener(this);

		botRight.add(Back);
		Back.addActionListener(this);

		botRight.add(Quit);
		Quit.addActionListener(this);
		setBounds(200, 200, 500, 300);
		setVisible(true);

	}

	// ----------------------------------
	public void actionPerformed(ActionEvent e) {

		Object obj = e.getSource();

		if (obj == Name)
			setDroghedaName();
		if (obj == Description)
			setDroghedaDescription();
		if (obj == Location)
			setDroghedaLocation();

		if (obj == Back) {

			MainPage nextframe = new MainPage();
			MainPage.getWindows();
			nextframe.setExtendedState(nextframe.getExtendedState() | JFrame.MAXIMIZED_BOTH);
			dispose();
		}

		if (obj == Quit)
			System.exit(0);
	}

	private void setDroghedaName() {

		if (town != null)

			nameArea = town.getDroghedaName().getName();
			nameArea1 = town.getDroghedaName1().getName();

		Dub.repaint();
	}

	private void setDroghedaDescription() {
		if (town != null)

			descriptionArea = town.getDroghedaDescription().getName();
			descriptionArea1 = town.getDroghedaDescription1().getName();

		Dub.repaint();
	}

	private void setDroghedaLocation() {
		if (town != null)

			locationArea = town.getDroghedaLocation().getName();
			locationArea1 = town.getDroghedaLocation1().getName();

		Dub.repaint();
	}

	private void clear() {
		descriptionArea = "";
		descriptionArea1 = "";
		locationArea = "";
		locationArea1 = "";
		nameArea = "";
		nameArea1 = "";
		Dub.repaint();
	}

	static public void main(String argv[]) {
		new Drogheda();
		Drogheda nextframe = new Drogheda();
		nextframe.setExtendedState(nextframe.getExtendedState() | JFrame.MAXIMIZED_BOTH);

	}

	class DublinPanel extends Panel {
		public void paint(Graphics g) {
			Dimension sz = getSize();
			g.drawRect(0, 0, sz.width - 1, sz.height - 1);
			g.drawString(nameArea, 10, 50);
			g.drawString(nameArea1, 10, 80);
			g.drawString(descriptionArea, 200, 50);
			g.drawString(descriptionArea1, 200, 80);
			g.drawString(locationArea, 1200, 50);
			g.drawString(locationArea1, 1200, 80);

		}
	}

	class HotelListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			// creating an instance of garden as VeggieGarden
			town = new Hotel();
			clear();

		}
	}

	class RestuarantListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			// creating an instance of garden as PerennialGarden
			town = new Restaurant();
			clear();

		}
	}

	class InterestListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			town = new Interest();
			clear();

		}
	}

	class ToDoListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			town = new ToDo();
			clear();

		}
	}

}
