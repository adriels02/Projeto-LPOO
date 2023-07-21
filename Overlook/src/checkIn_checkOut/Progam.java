package checkIn_checkOut;



public class Progam {
	public static void main(String[] args) {
        CheckIn checkIn = new CheckIn("João");
        checkIn.realizarCheckIn();
        
        CheckOut checkOut = new CheckOut("joao");    
        System.out.println(checkOut.toString());
    }
}

