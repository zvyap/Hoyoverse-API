package com.zvyap.hoyoapi.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HoyoDailyCheckInInfoResponse extends HoyoAPIResponse {

	@JsonProperty("data")
	private Data data;

	public Data getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"HoyoDailyCheckInInfoResponse{" + 
			"data = '" + data + '\'' + 
			",message = '" + message + '\'' + 
			",retcode = '" + retcode + '\'' + 
			"}";
		}

	public static class Data{

		@JsonProperty("is_sub")
		private boolean isSub;

		@JsonProperty("today")
		private String today;

		@JsonProperty("short_sign_day")
		private int shortSignDay;

		@JsonProperty("sign_cnt_missed")
		private int signCntMissed;

		@JsonProperty("region")
		private String region;

		@JsonProperty("is_sign")
		private boolean isSign;

		@JsonProperty("total_sign_day")
		private int totalSignDay;

		@JsonProperty("first_bind")
		private boolean isFirstBind;

		@JsonProperty("month_last_day")
		private boolean isMonthLastDay;

		public boolean isMonthLastDay() {
			return isMonthLastDay;
		}

		public boolean isSub() {
			return isSub;
		}

		public String getToday() {
			return today;
		}

		public int getShortSignDay() {
			return shortSignDay;
		}

		public int getSignCntMissed(){
			return signCntMissed;
		}

		public String getRegion(){
			return region;
		}

		public boolean isSign(){
			return isSign;
		}

		public boolean isFirstBind() {
			return isFirstBind;
		}

		public int getTotalSignDay(){
			return totalSignDay;
		}

		@Override
		 public String toString(){
			return
					"Data{" +
							"is_sub = '" + isSub + '\'' +
							",today = '" + today + '\'' +
							",short_sign_day = '" + shortSignDay + '\'' +
							",sign_cnt_missed = '" + signCntMissed + '\'' +
							",region = '" + region + '\'' +
							",is_sign = '" + isSign + '\'' +
							",total_sign_day = '" + totalSignDay + '\'' +
							",month_last_day = '" + isMonthLastDay + '\'' +
							"}";
			}
	}
}