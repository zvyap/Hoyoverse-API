package com.zvyap.hoyoapi.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zvyap.hoyoapi.HoyoGameRole;

import java.util.List;

public class HoyoGetUserGameRolesResponse extends HoyoAPIResponse {

	@JsonProperty("data")
	private Data data;

	public Data getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"HoyoUserGameRolesResponse{" + 
			"data = '" + data + '\'' + 
			",message = '" + message + '\'' + 
			",retcode = '" + retcode + '\'' + 
			"}";
		}

	public static class Data{

		@JsonProperty("list")
		private List<HoyoGameRole> roles;

		public List<HoyoGameRole> getRoles(){
			return roles;
		}

		@Override
		 public String toString(){
			return
				"Data{" +
				"roles = '" + roles + '\'' +
				"}";
			}
	}
}