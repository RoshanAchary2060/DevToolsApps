package com.nt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

//@Setter
//@Getter
//@ToString
//@EqualsAndHashCode
//@AllArgsConstructor(access=AccessLevel.PRIVATE)
//@NoArgsConstructor(access=AccessLevel.PUBLIC)
//@RequiredArgsConstructor(access=AccessLevel.PROTECTED)
//@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class Customer {
	@NonNull 
	private int cno;
	@NonNull
	private String cname;
//	@Getter
//	@Setter
	private String cadd;
	private float billAmt;
	
//	public Customer() {}
	
//	public void setCno(int cno) { 
//		System.out.println("123");
//		this.cno = cno; }
	
//	public String toString() { return "hello"; }
}
