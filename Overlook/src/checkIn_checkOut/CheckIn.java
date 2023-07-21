package checkIn_checkOut;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CheckIn {
		
		
	    private String nome;
	    private LocalDateTime CheckIn;
	    
	   
	    public CheckIn(String nome ) {
	        this.nome = nome;
	        this.CheckIn = LocalDateTime.now();
	    }

	    public String getNome() {
	        return nome;
	    }

	    public LocalDateTime getDataHoraCheckIn() {
	        return CheckIn;
	    }

	    public void realizarCheckIn() {
	        System.out.println(this.toString());
	    }

	    @Override
	    public String toString() {
	        DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	        String dataHoraFormatada = CheckIn.format(formatacao);

	        return "Check-in de : " + nome +
	                "\nNo dia hora: " + dataHoraFormatada;
	    }

}   


