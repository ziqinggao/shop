package com.dirsir.dao.entities;

public class MerchantTarding {
		private int tardingId;
		private int merchantID;
		private String tardingDate;
		private double tardingPrices;
		private int tardingState;
		private String tardingNote;
		public int getTardingId() {
			return tardingId;
		}
		public void setTardingId(int tardingId) {
			this.tardingId = tardingId;
		}
		public int getMerchantID() {
			return merchantID;
		}
		public void setMerchantID(int merchantID) {
			this.merchantID = merchantID;
		}
		public String getTardingDate() {
			return tardingDate;
		}
		public void setTardingDate(String tardingDate) {
			this.tardingDate = tardingDate;
		}
		public double getTardingPrices() {
			return tardingPrices;
		}
		public void setTardingPrices(double tardingPrices) {
			this.tardingPrices = tardingPrices;
		}
		public int getTardingState() {
			return tardingState;
		}
		public void setTardingState(int tardingState) {
			this.tardingState = tardingState;
		}
		public String getTardingNote() {
			return tardingNote;
		}
		public void setTardingNote(String tardingNote) {
			this.tardingNote = tardingNote;
		}
		public MerchantTarding() {
			super();
		}
		public MerchantTarding(int tardingId, int merchantID, String tardingDate, double tardingPrices,
				int tardingState, String tardingNote) {
			super();
			this.tardingId = tardingId;
			this.merchantID = merchantID;
			this.tardingDate = tardingDate;
			this.tardingPrices = tardingPrices;
			this.tardingState = tardingState;
			this.tardingNote = tardingNote;
		}
		
}
