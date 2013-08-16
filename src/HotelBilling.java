import javax.swing.JOptionPane;

public class HotelBilling {
	
	final static float SALES_TAX = 0.13f;

	public static void main(String[] args) {
		
		//Declare value for objects
		double roomRate = 99.00;
		int bookedRooms = 3;
		double coupon = 0.10;
		double totalBill;
		
		totalBill = calculateBill(roomRate);
		JOptionPane.showMessageDialog(null, "Your total bill is $" + totalBill);
		
		totalBill = calculateBill(roomRate, bookedRooms);
		JOptionPane.showMessageDialog(null, "Your total with tax for " + bookedRooms + " rooms is $" + totalBill);
		
		totalBill = calculateBill(roomRate, bookedRooms, coupon);
		JOptionPane.showMessageDialog(null, "Your total with tax for " + bookedRooms + " rooms is $ " + totalBill
				+ "\nThat includes a discount of " + coupon * 100 + "%");
	}
	
	//This method is to calculate the rate and tax 
	public static double calculateBill(double rate) {
		double tax = rate * SALES_TAX;
		double finalRate = rate + tax;
		finalRate = twoDecimalPlaces(finalRate);
		return finalRate;		
	}
	
	//This method is to calculate the rate, tax, and rooms a person would want
	public static double calculateBill(double rate, int rooms) {
		double tax = rate * SALES_TAX;
		double finalRate = rate + tax;
		finalRate = finalRate * rooms;
		finalRate = twoDecimalPlaces(finalRate);
		return finalRate;
	}
	
	//This method is to calculate the rate, tax, rooms, with a discounted coupon
	public static double calculateBill(double rate, int rooms, double coupon) {
		double tax = rate * SALES_TAX;
		double finalRate = rate + tax;
		finalRate = finalRate * rooms;
		double discount = coupon * finalRate;
		finalRate = finalRate - discount;
		finalRate = twoDecimalPlaces(finalRate);
		return finalRate;
	}
	
	//This method is to round 2 decimal places in final rate
	public static double twoDecimalPlaces(double decimal) {
		decimal = decimal * 100;
		decimal = decimal + 0.5;
		decimal = (int) decimal;
		decimal = decimal / 100;
		return decimal;
	}
				
}

