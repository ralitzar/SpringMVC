package com.ralitzaraynova.plashtania.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Plashtane implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long kod;
	
	@NotBlank (message = "Моля въведете описание")
	@Size(max = 120, message = "Описанието не може да съдържа павече от 120 символа.")
	private String opisanie;
	
	@NotNull (message = "Моля въведете падежна дата")
	@DateTimeFormat(pattern = "dd.MM.yyyy")
	@Temporal(TemporalType.DATE)
	private Date padezhnaData;
	
	@NotNull(message = "Моля въведете сума")
	@DecimalMin(value = "0.01", message = "Сумата не може да бъде по-малка от 0,01")
	@DecimalMax(value = "9999999.99", message = "Сумата не може да бъде по-голяма от 9.999.999,99")
	@NumberFormat(pattern="#,##0.00")
	private BigDecimal suma;
	
	@Enumerated(EnumType.STRING)
	private SustoyaniePlashtane sustoyanie;
	
	public Long getKod() {
		return kod;
	}
	public void setKod(Long kod) {
		this.kod = kod;
	}
	public String getOpisanie() {
		return opisanie;
	}
	public void setOpisanie(String opisanie) {
		this.opisanie = opisanie;
	}
	public Date getPadezhnaData() {
		return padezhnaData;
	}
	public void setPadezhnaData(Date padezhnaData) {
		this.padezhnaData = padezhnaData;
	}
	public BigDecimal getSuma() {
		return suma;
	}
	public void setSuma(BigDecimal suma) {
		this.suma = suma;
	}
	public SustoyaniePlashtane getSustoyanie() {
		return sustoyanie;
	}
	public void setSustoyanie(SustoyaniePlashtane sustoyanie) {
		this.sustoyanie = sustoyanie;
	}
	
	public boolean isNeplateno() {
		return SustoyaniePlashtane.NEPLATENO.equals(this.sustoyanie);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kod == null) ? 0 : kod.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Plashtane other = (Plashtane) obj;
		if (kod == null) {
			if (other.kod != null)
				return false;
		} else if (!kod.equals(other.kod))
			return false;
		return true;
	}
	
	
	
	

}
