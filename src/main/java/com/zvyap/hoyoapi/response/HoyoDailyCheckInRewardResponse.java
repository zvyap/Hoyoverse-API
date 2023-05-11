package com.zvyap.hoyoapi.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class HoyoDailyCheckInRewardResponse extends HoyoAPIResponse {

	@JsonProperty("data")
	private Data data;

	public Data getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"HoyoDailyCheckInRewardResponse2{" + 
			"data = '" + data + '\'' + 
			",message = '" + message + '\'' + 
			",retcode = '" + retcode + '\'' + 
			"}";
		}

	public static class AwardsItem{

		@JsonProperty("icon")
		private String icon;

		@JsonProperty("name")
		private String name;

		@JsonProperty("cnt")
		private int cnt;

		public String getIcon(){
			return icon;
		}

		public String getName(){
			return name;
		}

		public int getCount() {
			return cnt;
		}

		@Override
		 public String toString(){
			return
				"AwardsItem{" +
				"icon = '" + icon + '\'' +
				",name = '" + name + '\'' +
				",cnt = '" + cnt + '\'' +
				"}";
			}
	}

	public static class Data{

		@JsonProperty("short_extra_award")
		private ShortExtraAward shortExtraAward;

		@JsonProperty("biz")
		private String biz;

		@JsonProperty("month")
		private int month;

		@JsonProperty("awards")
		private List<AwardsItem> awards;

		@JsonProperty("resign")
		private boolean resign;

		@JsonProperty("now")
		private long now; //Genshin only

		public ShortExtraAward getShortExtraAward(){
			return shortExtraAward;
		}

		public String getBiz(){
			return biz;
		}

		public int getMonth(){
			return month;
		}

		public List<AwardsItem> getAwards(){
			return awards;
		}

		public boolean isResign(){
			return resign;
		}

		public long getNow() {
			return now;
		}

		@Override
		 public String toString(){
			return
				"Data{" +
				"short_extra_award = '" + shortExtraAward + '\'' +
				",biz = '" + biz + '\'' +
				",month = '" + month + '\'' +
				",awards = '" + awards + '\'' +
				",resign = '" + resign + '\'' +
				",now = '" + now + '\'' +
				"}";
			}
	}

	public static class ShortExtraAward{

		@JsonProperty("start_time")
		private String startTime;

		@JsonProperty("has_extra_award")
		private boolean hasExtraAward;

		@JsonProperty("end_timestamp")
		private String endTimestamp;

		@JsonProperty("start_timestamp")
		private String startTimestamp;

		@JsonProperty("end_time")
		private String endTime;

		@JsonProperty("list")
		private List<Object> list;

		public String getStartTime(){
			return startTime;
		}

		public boolean isHasExtraAward(){
			return hasExtraAward;
		}

		public String getEndTimestamp(){
			return endTimestamp;
		}

		public String getStartTimestamp(){
			return startTimestamp;
		}

		public String getEndTime(){
			return endTime;
		}

		public List<Object> getList(){
			return list;
		}

		@Override
		 public String toString(){
			return
				"ShortExtraAward{" +
				"start_time = '" + startTime + '\'' +
				",has_extra_award = '" + hasExtraAward + '\'' +
				",end_timestamp = '" + endTimestamp + '\'' +
				",start_timestamp = '" + startTimestamp + '\'' +
				",end_time = '" + endTime + '\'' +
				",list = '" + list + '\'' +
				"}";
			}
	}
}