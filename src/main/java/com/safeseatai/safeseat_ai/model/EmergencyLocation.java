package com.safeseatai.safeseat_ai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmergencyLocation {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private Long busId;
	    private Long studentId;
	    private Double latitude;
	    private Double longitude;
	    private String timestamp;

	    public EmergencyLocation() {
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
		 * @return the latitude
		 */
		public Double getLatitude() {
			return latitude;
		}

		/**
		 * @param latitude the latitude to set
		 */
		public void setLatitude(Double latitude) {
			this.latitude = latitude;
		}

		/**
		 * @return the longitude
		 */
		public Double getLongitude() {
			return longitude;
		}

		/**
		 * @param longitude the longitude to set
		 */
		public void setLongitude(Double longitude) {
			this.longitude = longitude;
		}

		/**
		 * @return the timestamp
		 */
		public String getTimestamp() {
			return timestamp;
		}

		/**
		 * @param timestamp the timestamp to set
		 */
		public void setTimestamp(String timestamp) {
			this.timestamp = timestamp;
		}

}
