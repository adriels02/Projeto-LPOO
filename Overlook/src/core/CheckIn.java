package core;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckIn {
    private int idCheckIn;
    private String nome;
    private Date checkIn;
    private Date atualizarCheckIn;
    private boolean status;

    public CheckIn(int idCheckIn, String nome, Date checkIn, Date atualizarCheckIn, boolean status) {
        this.idCheckIn = idCheckIn;
        this.nome = nome;
        this.checkIn = checkIn;
        this.atualizarCheckIn = atualizarCheckIn;
        this.status = status;
    }

    public int getIdCheckIn() {
        return idCheckIn;
    }

    public void setIdCheckIn(int idCheckIn) {
        this.idCheckIn = idCheckIn;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getAtualizarCheckIn() {
        return atualizarCheckIn;
    }

    public void setAtualizarCheckIn(Date atualizarCheckIn) {
        this.atualizarCheckIn = atualizarCheckIn;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void realizarCheckIn() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String checkInFormatado = sdf.format(checkIn);
        String atualizarCheckInFormatado = sdf.format(atualizarCheckIn);

        return "Check-in de: " + nome +
                "\nID do Check-in: " + idCheckIn +
                "\nData do Check-in: " + checkInFormatado +
                "\nData de Atualização do Check-in: " + atualizarCheckInFormatado +
                "\nStatus: " + status;
    }
}
