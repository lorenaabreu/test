package org.fiveware.test.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
 
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Entity funcionario
 * @author Lorena Abreu
 *
 */

@Entity
@Table(name="FUNCIONARIO")
public class Funcionario {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
 
    @Size(min=3, max=50)
    @Column(name = "NOME", nullable = false)
    private String nome;
 
    @NotNull
    @DateTimeFormat(pattern="dd/MM/yyyy") 
    @Column(name = "DATA_CONTRATACAO", nullable = false)
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    private LocalDate dataContratacao;
 
    @NotNull
    @Digits(integer=8, fraction=2)
    @Column(name = "SALARIO", nullable = false)
    private BigDecimal salario;
    
    @NotEmpty
    @Column(name = "SEXO", nullable = false)
    private String sexo;
    
    @NotEmpty
    @Column(name = "MES_PREFERENCIA", nullable = false)
    private String mesPreferencia;
     
    @NotEmpty
    @Column(name = "CTPS", unique=true, nullable = false)
    private String ctps;
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getNome() {
        return nome;
    }
 
    public void setNome(String nome) {
        this.nome = nome;
    }
 
    public LocalDate getDataContratacao() {
        return dataContratacao;
    }
 
    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }
 
    public BigDecimal getSalario() {
        return salario;
    }
 
    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
 
    public String getSexo(){
    	return sexo;
    }
    
    public void setSexo(String sexo){
    	this.sexo = sexo;
    }
    
    public String getMesPreferencia(){
    	return mesPreferencia;
    }
    
    public void setMesPreferencia(String mesPreferencia){
    	this.mesPreferencia = mesPreferencia;
    }
    
    public String getCtps() {
        return ctps;
    }
 
    public void setCtps(String ctps) {
        this.ctps = ctps;
    }
 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((ctps == null) ? 0 : ctps.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Funcionario))
            return false;
        Funcionario other = (Funcionario) obj;
        if (id != other.id)
            return false;
        if (ctps == null) {
            if (other.ctps != null)
                return false;
        } else if (!ctps.equals(other.ctps))
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "Funcionario [id=" + id + ", nome=" + nome + ", dataContratacao="
                + dataContratacao + ", salario=" + salario + ", sexo=" + sexo 
                +", mesPreferencia=" + mesPreferencia +", ctps=" + ctps + "]";
    }
	

}
