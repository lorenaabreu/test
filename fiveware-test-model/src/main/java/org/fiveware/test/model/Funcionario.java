package org.fiveware.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Entity Novo Funcionario
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
   
	@NotEmpty
    @Column(name = "SEXO", nullable = false)
    private String sexo;

	@NotEmpty
    @Column(name = "MES_PREFERENCIA", nullable = false)
    private String mesPreferencia;
     
	@NotEmpty
    @Column(name = "CTPS", unique=true, nullable = false)
    private String ctps;
    
	@NotEmpty
    @Column(name = "ACEITE", nullable = false)
    private String aceite;
 
    
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
    
    public String getAceite() {
		return aceite;
	}

	public void setAceite(String aceite) {
		this.aceite = aceite;
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
        return "Funcionario [id=" + id + ", nome=" + nome + ", sexo=" + sexo 
                +", mesPreferencia=" + mesPreferencia +", ctps=" + ctps + "]";
    }
	

}
