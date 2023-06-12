package checkIn_checkOut;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CheckOut  {
    private String nome;
    private LocalDateTime CheckOut;

    public CheckOut(String nome) {
        this.nome = nome;
        this.CheckOut = LocalDateTime.now();
    }

    public String getNome() {
        return nome;
    }

    public LocalDateTime getDataHoraCheckOut() {
        return CheckOut;
    }

    public long calcularTempoPermanencia() {
        LocalDateTime dataHoraCheckIn = LocalDateTime.of(2023, 6, 1, 10, 0, 0); // Exemplo da data e hora do check-in
        Duration duracao = Duration.between(dataHoraCheckIn, CheckOut); //porém, como chamar o metodo realizarCheckIn?
        
        return duracao.toDays();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataHoraFormatada = formatter.format(CheckOut);

        return "Check-out de : " + nome +
                "\nNo dia e hora: " + dataHoraFormatada +
                "\nDiarias: " + calcularTempoPermanencia();
    }

}