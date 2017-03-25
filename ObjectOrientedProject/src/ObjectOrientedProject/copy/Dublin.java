package ObjectOrientedProject.copy;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Dublin extends Frame implements ActionListener {
	private Checkbox Hotel, Restaurant, PlacesofInterest, ToDo;
	private Button Name, Description, Location, Back, Quit;
	private Ireland town = null;
	private DublinPanel Dub;
	private String nameArea = "", descriptionArea = "", locationArea = "", nameArea1 = "" , descriptionArea1 = "" , locationArea1 = "";
	JLabel label1 = new JLabel(
			"<html>Dublin is the capital and largest city of Ireland.Dublin is in the province of Leinster on Ireland's east coast, at the mouth of the River Liffey. The city has an urban area population of 1,345,402. The population of the Greater Dublin Area, as of 2016, was 1,904,806 people</html> !");

	JLabel label2 = new JLabel("<html> --How to get to Dublin city --</html>");

	public Dublin() {
		super("Hoildays in Ireland");
		setGUI();
	}

	private void setGUI() {
		setBackground(Color.orange);
		setLayout(new GridLayout(2, 1));
		Panel left = new Panel();
		add(left);
		Panel right = new Panel();
		add(right);

		Font fancyFont2 = new Font("Serif", Font.ITALIC, 22);

		label1.setFont(fancyFont2);

		label2.setFont(fancyFont2);
		left.setLayout(new GridLayout(3, 2));
		label2.setIcon(new ImageIcon(
				"C:\\Users\\Stephen Blaney\\Documents\\Semester6\\Object Orientation with design patterns\\WeekFive\\logo.jpg"));
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
		Restaurant.addItemListener(new ResturantListener());
		PlacesofInterest.addItemListener(new InterestListener());
		ToDo.addItemListener(new ToDoListener());

		right.setLayout(new GridLayout(2, 3));
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

	public void actionPerformed(ActionEvent e) {

		Object obj = e.getSource();

		if (obj == Name)
			setName();
		if (obj == Description)
			setDescription();
		if (obj == Location)
			setLocation();

		if (obj == Back) {

			MainPage nextframe = new MainPage();
			MainPage.getWindows();
			nextframe.setExtendedState(nextframe.getExtendedState() | JFrame.MAXIMIZED_BOTH);
			dispose();
		}

		if (obj == Quit)
			System.exit(0);
	}

	private void setName() {

		if (town != null)

			nameArea = town.getName().getName();
			nameArea1 = town.getName1().getName();

		// repaints garden panel
		Dub.repaint();
	}

	private void setDescription() {
		if (town != null)

		descriptionArea = town.getDescription().getName();
		descriptionArea1 = town.getDescription1().getName();
		
		Dub.repaint();
	}

	private void setLocation() {
		if (town != null)

			locationArea = town.getLocation().getName();
			locationArea1 = town.getLocation1().getName();
			
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
		Dublin nextframe = new Dublin();

		nextframe.setExtendedState(nextframe.getExtendedState() | JFrame.MAXIMIZED_BOTH);
	}

	class DublinPanel extends Panel {
		public void paint(Graphics g) {
			Dimension sz = getSize();
			g.drawRect(0, 0, sz.width - 1, sz.height - 1);
			g.drawString(nameArea, 10, 40);
			g.drawString(nameArea1, 10, 80);
			g.drawString(descriptionArea, 150, 40);
			g.drawString(descriptionArea1, 190, 80);
			g.drawString(locationArea, 1150, 40);
			g.drawString(locationArea1, 1150, 80);

		}
	}

	class HotelListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			// creating an instance of garden as VeggieGarden
			town = new Hotel();
			clear();

		}
	}

	class ResturantListener implements ItemListener {
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
