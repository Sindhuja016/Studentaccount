package com.student.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
	   private Integer aid;
		private String type;
		private String aname;
		public Integer getAid() {
			return aid;
		}
		public void setAid(Integer aid) {
			this.aid = aid;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getAname() {
			return aname;
		}
		public void setAname(String aname) {
			this.aname = aname;
		}
		
		
}
