package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckOut {
    private int idCheckOut;
    private String nome;
    private Date checkOut;
    private Date atualizarCheckOut;
    private boolean status;

    public CheckOut(int idCheckOut, String nome, Date checkOut, Date atualizarCheckOut, boolean status) {
        this.idCheckOut = idCheckOut;
        this.nome = nome;
        this.checkOut = checkOut;
        this.atualizarCheckOut = atualizarCheckOut;
        this.status = status;
    }

    public int getIdCheckOut() {
        return idCheckOut;
    }

    public void setIdCheckOut(int idCheckOut) {
        this.idCheckOut = idCheckOut;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public Date getAtualizarCheckOut() {
        return atualizarCheckOut;
    }

    public void setAtualizarCheckOut(Date atualizarCheckOut) {
        this.atualizarCheckOut = atualizarCheckOut;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void realizarCheckOut() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String checkOutFormatado = sdf.format(checkOut);
        String atualizarCheckOutFormatado = sdf.format(atualizarCheckOut);

        return "Check-out de: " + nome +
                "\nID do Check-out: " + idCheckOut +
                "\nData do Check-out: " + checkOutFormatado +
                "\nData de Atualização do Check-out: " + atualizarCheckOutFormatado +
                "\nStatus: " + status;
    }
}
