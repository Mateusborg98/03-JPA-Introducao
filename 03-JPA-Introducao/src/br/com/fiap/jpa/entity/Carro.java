package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "TB_CARRO")
@SequenceGenerator(name = "carro", sequenceName = "SQ_TB_CARRO)", allocationSize = 1)
public class Carro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CD_CARRO")
	@GeneratedValue(generator = "carro", strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "DS_MODELO", nullable = false, length = 100)
	private String modelo;

	// Classe wrapper para valores nulos
	@Column(name = "NR_ANO")
	private Integer ano;

	@Column(name = "DS_MOTOR", length = 10)
	private String motor;

	@Column(name = "DS_MONTADORA")
	private String montadora;

	@Column(name = "DS_PLACA", nullable = false, length = 8)
	private String placa;

	@Column(name = "DT_FABRICACAO")
	@Temporal(TemporalType.DATE)
	private Calendar dataFabricacao;

	@Column(name = "FG_COLECIONADOR")
	private boolean colecionador;

	@Transient // Usa-se o transit para colunas que não serão mapedas no banco de dados
	private boolean paraIpva;

	@Lob // grvar arquivo no banco de dados (BLOB)
	@Column(name = "FL_FOTO")
	private byte[] foto;

	@Enumerated(EnumType.STRING)
	@Column(name = "DS_TRANSMISSAO")
	private Transmissao transmissoes;

	public Carro() {
		super();
	}

	public Carro(String modelo, Integer ano, String motor, String montadora, String placa, Calendar dataFabricacao,
			boolean colecionador, boolean paraIpva, byte[] foto, Transmissao transmissoes) {
		super();
		this.modelo = modelo;
		this.ano = ano;
		this.motor = motor;
		this.montadora = montadora;
		this.placa = placa;
		this.dataFabricacao = dataFabricacao;
		this.colecionador = colecionador;
		this.paraIpva = paraIpva;
		this.foto = foto;
		this.transmissoes = transmissoes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public String getMontadora() {
		return montadora;
	}

	public void setMontadora(String montadora) {
		this.montadora = montadora;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Calendar getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Calendar dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public boolean isColecionador() {
		return colecionador;
	}

	public void setColecionador(boolean colecionador) {
		this.colecionador = colecionador;
	}

	public boolean isParaIpva() {
		return paraIpva;
	}

	public void setParaIpva(boolean paraIpva) {
		this.paraIpva = paraIpva;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Transmissao getTransmissoes() {
		return transmissoes;
	}

	public void setTransmissoes(Transmissao transmissoes) {
		this.transmissoes = transmissoes;
	}
	
}
