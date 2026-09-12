package com.safeseatai.safeseat_ai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Bus {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String busNumber;

	    private String driverName;

	    private String route;

	    public Bus() {
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
		 * @return the busNumber
		 */
		public String getBusNumber() {
			return busNumber;
		}

		/**
		 * @param busNumber the busNumber to set
		 */
		public void setBusNumber(String busNumber) {
			this.busNumber = busNumber;
		}

		/**
		 * @return the driverName
		 */
		public String getDriverName() {
			return driverName;
		}

		/**
		 * @param driverName the driverName to set
		 */
		public void setDriverName(String driverName) {
			this.driverName = driverName;
		}

		/**
		 * @return the route
		 */
		public String getRoute() {
			return route;
		}

		/**
		 * @param route the route to set
		 */
		public void setRoute(String route) {
			this.route = route;
		}

}
