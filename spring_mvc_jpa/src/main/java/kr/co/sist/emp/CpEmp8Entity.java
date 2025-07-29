package kr.co.sist.emp;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@Entity
@Table(name="CP_EMP8")
public class CpEmp8Entity {
	@Id
	@Column(name="EMPNO")
	private Integer empno;
	
	@Column(name="ENAME", length=10)
	private String ename;
	@Column(name="JOB", length=9)
	private String job;
	@Column(name="MGR")
	private Integer mgr;
	@Column(name="HIREDATE")
	private Date hiredate;
	
	@Column(name="SAL",precision=7, scale=2)
	private BigDecimal sal;
	@Column(name="COMM",precision=7, scale=2)
	private BigDecimal comm;
	
	@Column(name="DEPTNO")
	private int deptno;	

}
