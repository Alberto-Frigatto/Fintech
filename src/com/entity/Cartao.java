package com.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cartao
{
    private Integer id;
    private String numero;
    private int idConta;
    private int idBandeira;
    private int idTipoCartao;
    private Date dataValidade;
    private String cvv;
    private boolean desbloqueado;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("MM-yy");

    public Cartao(
        Integer id,
        String numero,
        int idConta,
        int idBandeira,
        int idTipoCartao,
        String dataValidade,
        String cvv,
        boolean desbloqueado
    ) throws ParseException
    {
        this.id = id;
        this.numero = numero;
        this.idConta = idConta;
        this.idBandeira = idBandeira;
        this.idTipoCartao = idTipoCartao;
        this.dataValidade = this.dateFormat.parse(dataValidade);
        this.cvv = cvv;
        this.desbloqueado = desbloqueado;
    }

    public Cartao(
        String numero,
        int idConta,
        int idBandeira,
        int idTipoCartao,
        String dataValidade,
        String cvv,
        boolean desbloqueado
    ) throws ParseException
    {
        this.numero = numero;
        this.idConta = idConta;
        this.idBandeira = idBandeira;
        this.idTipoCartao = idTipoCartao;
        this.dataValidade = this.dateFormat.parse(dataValidade);
        this.cvv = cvv;
        this.desbloqueado = desbloqueado;
    }

    public void data()
    {
        System.out.println("Cartao(");
        System.out.println("\tid=" + this.id + ",");
        System.out.println("\tnumero=" + this.numero + ",");
        System.out.println("\tidConta=" + this.idConta + ",");
        System.out.println("\tidBandeira=" + this.idBandeira + ",");
        System.out.println("\tidTipoCartao=" + this.idTipoCartao + ",");
        System.out.println("\tdataValidade=" + this.dateFormat.format(this.dataValidade) + ",");
        System.out.println("\tcvv=" + this.cvv + ",");
        System.out.println("\tdesbloqueado=" + this.desbloqueado + ",");
        System.out.println(")\n");
    }

    public Integer getId()
    {
        return this.id;
    }

    public String getNumero()
    {
        return this.numero;
    }

    public int getIdConta()
    {
        return this.idConta;
    }

    public int getIdBandeira()
    {
        return this.idBandeira;
    }

    public int getIdTipoCartao()
    {
        return this.idTipoCartao;
    }

    public Date getDataValidade()
    {
        return this.dataValidade;
    }

    public String getCvv()
    {
        return this.cvv;
    }

    public boolean getDesbloqueado()
    {
        return this.desbloqueado;
    }

    public void updateDesbloqueado(boolean desbloqueado)
    {
        this.desbloqueado = desbloqueado;
    }
}
