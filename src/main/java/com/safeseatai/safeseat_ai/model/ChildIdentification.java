package com.safeseatai.safeseat_ai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ChildIdentification {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private Long studentId;
	    private String identificationType;
	    private String identificationValue;
	    private String status;

	    public ChildIdentification() {
	    }

		/**
		 * @return the id
		 */
		public Long getId() {
			return id;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(Long id) {
			this.id = id;
		}

		/**
		 * @return the studentId
		 */
		public Long getStudentId() {
			return studentId;
		}

		/**
		 * @param studentId the studentId to set
		 */
		public void setStudentId(Long studentId) {
			this.studentId = studentId;
		}

		/**
		 * @return the identificationType
		 */
		public String getIdentificationType() {
			return identificationType;
		}

		/**
		 * @param identificationType the identificationType to set
		 */
		public void setIdentificationType(String identificationType) {
			this.identificationType = identificationType;
		}

		/**
		 * @return the identificationValue
		 */
		public String getIdentificationValue() {
			return identificationValue;
		}

		/**
		 * @param identificationValue the identificationValue to set
		 */
		public void setIdentificationValue(String identificationValue) {
			this.identificationValue = identificationValue;
		}

		/**
		 * @return the status
		 */
		public String getStatus() {
			return status;
		}

		/**
		 * @param status the status to set
		 */
		public void setStatus(String status) {
			this.status = status;
		}
	    

}
