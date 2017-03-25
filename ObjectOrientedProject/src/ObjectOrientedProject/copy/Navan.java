package ObjectOrientedProject.copy;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Navan extends Frame implements ActionListener {
	private Checkbox Hotel, Restaurant, PlacesofInterest, ToDo;
	private Button Name, Description, Location, Back, Quit;
	private Ireland town = null;
	private DublinPanel Dub;
	private String nameArea = "", descriptionArea = "", locationArea = "",  nameArea1 = "" , descriptionArea1 = "" , locationArea1 = "";

	public Navan() {
		super("Hoildays in Ireland");
		setGUI();
	}

	private void setGUI() {

		Font fancyFont2 = new Font("Serif", Font.ITALIC, 21);

		JLabel label2 = new JLabel("<html> --How to get to Navan --</html>");

		JLabel label1 = new JLabel(
				"<html>Navan is the county town of County Meath in Ireland. In 2016, the town and its environs had a population of 31,689; making it the 5th largest town, and 10th largest urban settlement, in Ireland. Navan is along the River Boyne and the confluence of the Blackwater and the Boyne is situated in Navan.</html> !");
		label2.setIcon(new ImageIcon(
				"C:\\Users\\Stephen Blaney\\Documents\\Semester6\\Object Orientation with design patterns\\WeekFive\\index.jpg"));

		label1.setFont(fancyFont2);
		label2.setFont(fancyFont2);

		setBackground(Color.green);
		setLayout(new GridLayout(2, 1));
		Panel left = new Panel();
		add(left);
		Panel right = new Panel();
		add(right);

		left.setLayout(new GridLayout(3, 2));
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
		Restaurant.addItemListener(new RestaurantListener());
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
			setNavanName();
		if (obj == Description)
			setNavanDescription();
		if (obj == Location)
			setNavanLocation();

		if (obj == Back) {

			MainPage nextframe = new MainPage();
			MainPage.getWindows();
			nextframe.setExtendedState(nextframe.getExtendedState() | JFrame.MAXIMIZED_BOTH);
			dispose();
		}

		if (obj == Quit)
			System.exit(0);
	}

	private void setNavanName() {

		if (town != null)

			nameArea = town.getNavanName().getName();
			nameArea1 = town.getNavanName1().getName();

		Dub.repaint();
	}

	private void setNavanDescription() {
		if (town != null)

			descriptionArea = town.getNavanDescription().getName();
			descriptionArea1 = town.getNavanDescription1().getName();
		
		
		Dub.repaint();
	}

	private void setNavanLocation() {
		if (town != null)

			locationArea = town.getNavanLocation().getName();
			locationArea1 = town.getNavanLocation1().getName();

		
		
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

	// ----------------------------------
	static public void main(String argv[]) {
		Navan nextframe = new Navan();
		nextframe.setExtendedState(nextframe.getExtendedState() | JFrame.MAXIMIZED_BOTH);

	}

	class DublinPanel extends Panel {
		public void paint(Graphics g) {
			Dimension sz = getSize();
			g.drawRect(0, 0, sz.width - 1, sz.height - 1);
			g.drawString(nameArea, 10, 50);
			g.drawString(nameArea1, 10, 80);
			g.drawString(descriptionArea, 170, 50);
			g.drawString(descriptionArea1, 190, 80);
			g.drawString(locationArea, 1150, 50);
			g.drawString(locationArea1, 1150, 80);

		}
	}

	// -----------------------------
	class HotelListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			// creating an instance of garden as VeggieGarden
			town = new Hotel();
			clear();

		}
	}

	// -----------------------------
	class RestaurantListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			// creating an instance of garden as PerennialGarden
			town = new Restaurant();
			clear();

		}
	}

	// -----------------------------
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
