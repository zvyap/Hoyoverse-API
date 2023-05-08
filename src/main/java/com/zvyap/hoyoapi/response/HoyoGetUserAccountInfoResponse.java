package com.zvyap.hoyoapi.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HoyoGetUserAccountInfoResponse extends HoyoAPIResponse {

	@JsonProperty("data")
	private Data data;

	public Data getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"HoyoGetUserAccountInfoResponse{" + 
			"data = '" + data + '\'' + 
			",message = '" + message + '\'' + 
			",retcode = '" + retcode + '\'' + 
			"}";
		}

	public static class Data{

		@JsonProperty("apple_name")
		private String appleName;

		@JsonProperty("country")
		private String country;

		@JsonProperty("gender")
		private int gender;

		@JsonProperty("area_code")
		private String areaCode;

		@JsonProperty("mobile")
		private String mobile;

		@JsonProperty("game_center_name")
		private String gameCenterName;

		@JsonProperty("user_icon_id")
		private int userIconId;

		@JsonProperty("account_id")
		private String accountId;

		@JsonProperty("twitter_name")
		private String twitterName;

		@JsonProperty("sony_name")
		private String sonyName;

		@JsonProperty("account_name")
		private String accountName;

		@JsonProperty("nick_name")
		private String nickName;

		@JsonProperty("facebook_name")
		private String facebookName;

		@JsonProperty("google_name")
		private String googleName;

		@JsonProperty("steam_name")
		private String steamName;

		@JsonProperty("email")
		private String email;

		public String getAppleName(){
			return appleName;
		}

		public String getCountry(){
			return country;
		}

		public int getGender(){
			return gender;
		}

		public String getAreaCode(){
			return areaCode;
		}

		public String getMobile(){
			return mobile;
		}

		public String getGameCenterName(){
			return gameCenterName;
		}

		public int getUserIconId(){
			return userIconId;
		}

		public String getAccountId(){
			return accountId;
		}

		public String getTwitterName(){
			return twitterName;
		}

		public String getSonyName(){
			return sonyName;
		}

		public String getAccountName(){
			return accountName;
		}

		public String getNickName(){
			return nickName;
		}

		public String getFacebookName(){
			return facebookName;
		}

		public String getGoogleName(){
			return googleName;
		}

		public String getSteamName(){
			return steamName;
		}

		public String getEmail(){
			return email;
		}

		@Override
		 public String toString(){
			return
				"Data{" +
				"apple_name = '" + appleName + '\'' +
				",country = '" + country + '\'' +
				",gender = '" + gender + '\'' +
				",area_code = '" + areaCode + '\'' +
				",mobile = '" + mobile + '\'' +
				",game_center_name = '" + gameCenterName + '\'' +
				",user_icon_id = '" + userIconId + '\'' +
				",account_id = '" + accountId + '\'' +
				",twitter_name = '" + twitterName + '\'' +
				",sony_name = '" + sonyName + '\'' +
				",account_name = '" + accountName + '\'' +
				",nick_name = '" + nickName + '\'' +
				",facebook_name = '" + facebookName + '\'' +
				",google_name = '" + googleName + '\'' +
				",steam_name = '" + steamName + '\'' +
				",email = '" + email + '\'' +
				"}";
			}
	}
}