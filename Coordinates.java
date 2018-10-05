
public class Coordinates {

	// Since the coordinates are given as string we have to
	// Change them to ints.

	int horizon;
	int vertical;
	 double distance;
	String cordinates;


	public Coordinates(String s) {
		this.cordinates=s;
		
		this.vertical = Vertical(s);
		this.horizon = Horizon(s);
		this.distance = Math.sqrt((vertical * vertical) + (horizon * horizon));
	}

	// This method takes an int and
	// gives back the
	private int Vertical(String s) {

		String S2 = (s.replaceAll("[A-Z]", " "));
		String[] splitted = S2.split(" ");
		if (splitted.length < 3 && (s.charAt(0) != 'N' && s.charAt(0) != 'S'))
			return 0;
		Integer v = Integer.parseInt(splitted[1]);

		return v;

	}

	private int Horizon(String s) {
		Integer v;
		String S2 = (s.replaceAll("[A-Z]", " "));
		String[] splitted = S2.split(" ");
		if (splitted.length < 3 && (s.charAt(0) == 'N' || s.charAt(0) == 'S'))
			return 0;
		else if (splitted.length < 3) {
			v = Integer.parseInt(splitted[1]);
		} else {
			v = Integer.parseInt(splitted[2]);
		}

		return v;
	}

	public double getD() {
		return 2 * this.distance*60;
	}



}