package com.zvyap.hoyoapi.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class HoyoGamesDetailsResponse extends HoyoAPIResponse {

    @JsonProperty("data")
    private Data data;

    public Data getData() {
        return data;
    }

    @Override
    public String toString() {
        return
                "HoyoGamesDetailsResponse{" +
                        "data = '" + data + '\'' +
                        ",message = '" + message + '\'' +
                        ",retcode = '" + retcode + '\'' +
                        "}";
    }

    public static class Kingkong {

        @JsonProperty("list")
        private List<GameTool> list;

        @JsonProperty("config")
        private Config config;

        public List<GameTool> getGameTools() {
            return list;
        }

        public Config getConfig() {
            return config;
        }

        @Override
        public String toString() {
            return
                    "Kingkong{" +
                            "gameTools = '" + list + '\'' +
                            ",config = '" + config + '\'' +
                            "}";
        }

        public static class Config {

            @JsonProperty("promote_show_time_window")
            private String promoteShowTimeWindow;

            @JsonProperty("toolbox")
            private Toolbox toolbox;

            public String getPromoteShowTimeWindow() {
                return promoteShowTimeWindow;
            }

            public Toolbox getToolbox() {
                return toolbox;
            }

            @Override
            public String toString() {
                return
                        "Config{" +
                                "promote_show_time_window = '" + promoteShowTimeWindow + '\'' +
                                ",toolbox = '" + toolbox + '\'' +
                                "}";
            }
        }
    }

    public static class Toolbox {

        @JsonProperty("promote_tool")
        private Object promoteTool;

        public Object getPromoteTool() {
            return promoteTool;
        }

        @Override
        public String toString() {
            return
                    "Toolbox{" +
                            "promote_tool = '" + promoteTool + '\'' +
                            "}";
        }
    }

    public static class GameTool {

        @JsonProperty("tool_type")
        private String toolType;

        @JsonProperty("red_dot_time")
        private String redDotTime;

        @JsonProperty("name")
        private String name;

        @JsonProperty("icon")
        private String icon;

        @JsonProperty("tool_icon_animation")
        private String toolIconAnimation;

        @JsonProperty("toolbox")
        private Object toolbox;

        @JsonProperty("app_path")
        private String appPath;

        @JsonProperty("id")
        private int id;

        @JsonProperty("web_path")
        private String webPath;

        @JsonProperty("desc")
        private String desc;

        public String getToolType() {
            return toolType;
        }

        public String getRedDotTime() {
            return redDotTime;
        }

        public String getName() {
            return name;
        }

        public String getIcon() {
            return icon;
        }

        public String getToolIconAnimation() {
            return toolIconAnimation;
        }

        public Object getToolbox() {
            return toolbox;
        }

        public String getAppPath() {
            return appPath;
        }

        public int getId() {
            return id;
        }

        public String getWebPath() {
            return webPath;
        }

        public String getDesc() {
            return desc;
        }

        @Override
        public String toString() {
            return
                    "ToolItem{" +
                            "tool_type = '" + toolType + '\'' +
                            ",red_dot_time = '" + redDotTime + '\'' +
                            ",name = '" + name + '\'' +
                            ",icon = '" + icon + '\'' +
                            ",tool_icon_animation = '" + toolIconAnimation + '\'' +
                            ",toolbox = '" + toolbox + '\'' +
                            ",app_path = '" + appPath + '\'' +
                            ",id = '" + id + '\'' +
                            ",web_path = '" + webPath + '\'' +
                            ",desc = '" + desc + '\'' +
                            "}";
        }
    }

    public static class GameDetails {

        @JsonProperty("bg_color")
        private String bgColor;

        @JsonProperty("bg")
        private String bg;

        @JsonProperty("icon")
        private String icon;

        @JsonProperty("name")
        private String name;

        @JsonProperty("kingkong")
        private Kingkong kingkong;

        @JsonProperty("id")
        private String id;

        @JsonProperty("tool")
        private List<GameTool> tools;

        public String getBgColor() {
            return bgColor;
        }

        public String getBg() {
            return bg;
        }

        public String getIcon() {
            return icon;
        }

        public String getName() {
            return name;
        }

        public Kingkong getKingkong() {
            return kingkong;
        }

        public String getId() {
            return id;
        }

        public List<GameTool> getTools() {
            return tools;
        }

        @Override
        public String toString() {
            return
                    "GameListItem{" +
                            "bg_color = '" + bgColor + '\'' +
                            ",bg = '" + bg + '\'' +
                            ",icon = '" + icon + '\'' +
                            ",name = '" + name + '\'' +
                            ",kingkong = '" + kingkong + '\'' +
                            ",id = '" + id + '\'' +
                            ",tools = '" + tools + '\'' +
                            "}";
        }
    }

    public static class Data {

        @JsonProperty("game_list")
        private List<GameDetails> gameList;

        public List<GameDetails> getGameList() {
            return gameList;
        }

        @Override
        public String toString() {
            return
                    "Data{" +
                            "game_list = '" + gameList + '\'' +
                            "}";
        }
    }
}