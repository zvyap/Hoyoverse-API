package com.zvyap.hoyoapi.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MYSNavigatorsResponse extends HoyoAPIResponse {

    @JsonProperty("data")
    private Data data;

    public Data getData() {
        return data;
    }

    @Override
    public String toString() {
        return
                "MYSNavigatorsResponse{" +
                        "data = '" + data + '\'' +
                        ",message = '" + message + '\'' +
                        ",retcode = '" + retcode + '\'' +
                        "}";
    }

    public static class Navigator {

        @JsonProperty("is_reset")
        private boolean isReset;

        @JsonProperty("offline_ts")
        private String offlineTs;

        @JsonProperty("icon")
        private String icon;

        @JsonProperty("online_ts")
        private String onlineTs;

        @JsonProperty("publish_time")
        private String publishTime;

        @JsonProperty("name")
        private String name;

        @JsonProperty("app_path")
        private String appPath;

        @JsonProperty("id")
        private String id;

        @JsonProperty("is_online")
        private boolean isOnline;

        @JsonProperty("web_path")
        private String webPath;

        @JsonProperty("sort_order")
        private int sortOrder;

        @JsonProperty("reddot_status")
        private int reddotStatus;

        @JsonProperty("desc")
        private String desc;

        public boolean isReset() {
            return isReset;
        }

        public String getOfflineTs() {
            return offlineTs;
        }

        public String getIcon() {
            return icon;
        }

        public String getOnlineTs() {
            return onlineTs;
        }

        public String getPublishTime() {
            return publishTime;
        }

        public String getName() {
            return name;
        }

        public String getAppPath() {
            return appPath;
        }

        public String getId() {
            return id;
        }

        public boolean isOnline() {
            return isOnline;
        }

        public String getWebPath() {
            return webPath;
        }

        public int getSortOrder() {
            return sortOrder;
        }

        public int getReddotStatus() {
            return reddotStatus;
        }

        public String getDesc() {
            return desc;
        }

        @Override
        public String toString() {
            return
                    "NavigatorsItem{" +
                            "is_reset = '" + isReset + '\'' +
                            ",offline_ts = '" + offlineTs + '\'' +
                            ",icon = '" + icon + '\'' +
                            ",online_ts = '" + onlineTs + '\'' +
                            ",publish_time = '" + publishTime + '\'' +
                            ",name = '" + name + '\'' +
                            ",app_path = '" + appPath + '\'' +
                            ",id = '" + id + '\'' +
                            ",is_online = '" + isOnline + '\'' +
                            ",web_path = '" + webPath + '\'' +
                            ",sort_order = '" + sortOrder + '\'' +
                            ",reddot_status = '" + reddotStatus + '\'' +
                            ",desc = '" + desc + '\'' +
                            "}";
        }
    }

    public static class Data {

        @JsonProperty("list")
        private List<ListItem> list;

        public List<ListItem> getList() {
            return list;
        }

        public List<Navigator> getNavigator(Type type) {
            for (ListItem item : getList()) {
                if (item.getType() == type) {
                    return item.getNavigators();
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return
                    "Data{" +
                            "list = '" + list + '\'' +
                            "}";
        }
    }

    public static class ListItem {

        @JsonProperty("navigators")
        private List<Navigator> navigators;

        @JsonProperty("type")
        private Type type;

        public List<Navigator> getNavigators() {
            return navigators;
        }

        public Type getType() {
            return type;
        }

        @Override
        public String toString() {
            return
                    "ListItem{" +
                            "navigators = '" + navigators + '\'' +
                            ",type = '" + type + '\'' +
                            "}";
        }
    }

    public static enum Type {
        WEB_GTOOL_PC, WEB_GTOOL_APP;
    }

}