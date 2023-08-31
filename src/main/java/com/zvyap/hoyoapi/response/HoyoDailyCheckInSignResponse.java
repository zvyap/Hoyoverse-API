package com.zvyap.hoyoapi.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HoyoDailyCheckInSignResponse extends HoyoAPIResponse {

	@JsonProperty("data")
	private Data data;

	public Data getData(){
		return data;
	}

	@Override
	public String toString() {
		return
				"HoyoDailyCheckInSignResponse{" +
						"data = '" + data + '\'' +
						",message = '" + message + '\'' +
						",retcode = '" + retcode + '\'' +
						"}";
	}

	public boolean isCaptcha() {
		return isSuccess() ? getData().isRisk() : false;
	}

	public static class Data {

		@JsonProperty("gt_result")
		private GtResult gtResult;

		@JsonProperty("code")
		private String code;

		@JsonProperty("success")
		private Integer success;

		@JsonProperty("challenge")
		private String challenge;

		@JsonProperty("risk_code")
		private Integer riskCode;

		@JsonProperty("gt")
		private String gt;

		@JsonProperty("first_bind")
		private boolean firstBind;

		@JsonProperty("is_risk")
		private Boolean isRisk;

		//Some api use this, some don't
		public GtResult getGtResult(){
			return gtResult;
		}

		public String getCode(){
			return code;
		}

		public int getSuccess(){
			return success != null ? success : getGtResult().getSuccess();
		}

		public String getChallenge(){
			return challenge != null ? challenge : getGtResult().getChallenge();
		}

		public int getRiskCode(){
			return riskCode != null ? riskCode : getGtResult().getRiskCode();
		}

		public String getGt(){
			return gt != null ? gt : getGtResult().getGt();
		}

		public boolean isFirstBind(){
			return firstBind;
		}

		public boolean isRisk(){
			return isRisk != null ? isRisk : getGtResult().isRisk();
		}

		@Override
		 public String toString(){
			return
				"Data{" +
				"gt_result = '" + gtResult + '\'' +
				",code = '" + code + '\'' +
				",success = '" + getSuccess() + '\'' +
				",challenge = '" + getChallenge() + '\'' +
				",risk_code = '" + getRiskCode() + '\'' +
				",gt = '" + getGt() + '\'' +
				",first_bind = '" + firstBind + '\'' +
				",is_risk = '" + isRisk() + '\'' +
				"}";
			}
	}

	public static class GtResult{

		@JsonProperty("success")
		private int success;

		@JsonProperty("challenge")
		private String challenge;

		@JsonProperty("risk_code")
		private int riskCode;

		@JsonProperty("gt")
		private String gt;

		@JsonProperty("is_risk")
		private boolean isRisk;

		public int getSuccess(){
			return success;
		}

		public String getChallenge(){
			return challenge;
		}

		public int getRiskCode(){
			return riskCode;
		}

		public String getGt(){
			return gt;
		}

		public boolean isRisk(){
			return isRisk;
		}

		@Override
		 public String toString(){
			return
				"GtResult{" +
				"success = '" + success + '\'' +
				",challenge = '" + challenge + '\'' +
				",risk_code = '" + riskCode + '\'' +
				",gt = '" + gt + '\'' +
				",is_risk = '" + isRisk + '\'' +
				"}";
			}
	}
}