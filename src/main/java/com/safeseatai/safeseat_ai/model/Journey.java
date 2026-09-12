package com.safeseatai.safeseat_ai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Journey {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private Long busId;
	    private String expectedStartTime;
	    private String expectedEndTime;
	    private String actualStartTime;
	    private String actualEndTime;
	    private String status;

	    public Journey() {
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
		 * @return the expectedStartTime
		 */
		public String getExpectedStartTime() {
			return expectedStartTime;
		}

		/**
		 * @param expectedStartTime the expectedStartTime to set
		 */
		public void setExpectedStartTime(String expectedStartTime) {
			this.expectedStartTime = expectedStartTime;
		}

		/**
		 * @return the expectedEndTime
		 */
		public String getExpectedEndTime() {
			return expectedEndTime;
		}

		/**
		 * @param expectedEndTime the expectedEndTime to set
		 */
		public void setExpectedEndTime(String expectedEndTime) {
			this.expectedEndTime = expectedEndTime;
		}

		/**
		 * @return the actualStartTime
		 */
		public String getActualStartTime() {
			return actualStartTime;
		}

		/**
		 * @param actualStartTime the actualStartTime to set
		 */
		public void setActualStartTime(String actualStartTime) {
			this.actualStartTime = actualStartTime;
		}

		/**
		 * @return the actualEndTime
		 */
		public String getActualEndTime() {
			return actualEndTime;
		}

		/**
		 * @param actualEndTime the actualEndTime to set
		 */
		public void setActualEndTime(String actualEndTime) {
			this.actualEndTime = actualEndTime;
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
