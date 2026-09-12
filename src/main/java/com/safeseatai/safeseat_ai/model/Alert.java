package com.safeseatai.safeseat_ai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Alert {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private Long studentId;
	    private Long busId;
	    private String alertType;
	    private String message;
	    private String status;

	    public Alert() {
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
		 * @return the busId
		 */
		public Long getBusId() {
			return busId;
		}

		/**
		 * @param busId the busId to set
		 */
		public void setBusId(Long busId) {
			this.busId = busId;
		}

		/**
		 * @return the alertType
		 */
		public String getAlertType() {
			return alertType;
		}

		/**
		 * @param alertType the alertType to set
		 */
		public void setAlertType(String alertType) {
			this.alertType = alertType;
		}

		/**
		 * @return the message
		 */
		public String getMessage() {
			return message;
		}

		/**
		 * @param message the message to set
		 */
		public void setMessage(String message) {
			this.message = message;
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
