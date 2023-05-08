package com.zvyap.hoyoapi.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class HoyoGetForumFullUserResponse extends HoyoAPIResponse {

	@JsonProperty("data")
	private Data data;

	public Data getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"HoyoGetForumFullUserResponse{" + 
			"data = '" + data + '\'' + 
			",message = '" + message + '\'' + 
			",retcode = '" + retcode + '\'' + 
			"}";
		}

    public static class Achieve{

        @JsonProperty("like_num_unit")
        private String likeNumUnit;

        @JsonProperty("like_num")
        private String likeNum;

        @JsonProperty("followed_cnt")
        private String followedCnt;

        @JsonProperty("followed_cnt_unit")
        private String followedCntUnit;

        @JsonProperty("post_num")
        private String postNum;

        @JsonProperty("new_follower_num_unit")
        private String newFollowerNumUnit;

        @JsonProperty("replypost_num")
        private String replypostNum;

        @JsonProperty("good_post_num")
        private String goodPostNum;

        @JsonProperty("follow_cnt")
        private String followCnt;

        @JsonProperty("topic_cnt_unit")
        private String topicCntUnit;

        @JsonProperty("follow_collection_cnt")
        private String followCollectionCnt;

        @JsonProperty("replypost_num_unit")
        private String replypostNumUnit;

        @JsonProperty("follow_cnt_unit")
        private String followCntUnit;

        @JsonProperty("good_post_num_unit")
        private String goodPostNumUnit;

        @JsonProperty("topic_cnt")
        private String topicCnt;

        @JsonProperty("post_num_unit")
        private String postNumUnit;

        @JsonProperty("new_follower_num")
        private String newFollowerNum;

        public String getLikeNumUnit(){
            return likeNumUnit;
        }

        public String getLikeNum(){
            return likeNum;
        }

        public String getFollowedCnt(){
            return followedCnt;
        }

        public String getFollowedCntUnit(){
            return followedCntUnit;
        }

        public String getPostNum(){
            return postNum;
        }

        public String getNewFollowerNumUnit(){
            return newFollowerNumUnit;
        }

        public String getReplypostNum(){
            return replypostNum;
        }

        public String getGoodPostNum(){
            return goodPostNum;
        }

        public String getFollowCnt(){
            return followCnt;
        }

        public String getTopicCntUnit(){
            return topicCntUnit;
        }

        public String getFollowCollectionCnt(){
            return followCollectionCnt;
        }

        public String getReplypostNumUnit(){
            return replypostNumUnit;
        }

        public String getFollowCntUnit(){
            return followCntUnit;
        }

        public String getGoodPostNumUnit(){
            return goodPostNumUnit;
        }

        public String getTopicCnt(){
            return topicCnt;
        }

        public String getPostNumUnit(){
            return postNumUnit;
        }

        public String getNewFollowerNum(){
            return newFollowerNum;
        }

        @Override
         public String toString(){
            return
                "Achieve{" +
                "like_num_unit = '" + likeNumUnit + '\'' +
                ",like_num = '" + likeNum + '\'' +
                ",followed_cnt = '" + followedCnt + '\'' +
                ",followed_cnt_unit = '" + followedCntUnit + '\'' +
                ",post_num = '" + postNum + '\'' +
                ",new_follower_num_unit = '" + newFollowerNumUnit + '\'' +
                ",replypost_num = '" + replypostNum + '\'' +
                ",good_post_num = '" + goodPostNum + '\'' +
                ",follow_cnt = '" + followCnt + '\'' +
                ",topic_cnt_unit = '" + topicCntUnit + '\'' +
                ",follow_collection_cnt = '" + followCollectionCnt + '\'' +
                ",replypost_num_unit = '" + replypostNumUnit + '\'' +
                ",follow_cnt_unit = '" + followCntUnit + '\'' +
                ",good_post_num_unit = '" + goodPostNumUnit + '\'' +
                ",topic_cnt = '" + topicCnt + '\'' +
                ",post_num_unit = '" + postNumUnit + '\'' +
                ",new_follower_num = '" + newFollowerNum + '\'' +
                "}";
            }
    }

    public static class AuditInfo{

        @JsonProperty("is_introduce_in_audit")
        private boolean isIntroduceInAudit;

        @JsonProperty("introduce")
        private String introduce;

        @JsonProperty("is_nickname_in_audit")
        private boolean isNicknameInAudit;

        @JsonProperty("nickname")
        private String nickname;

        @JsonProperty("nickname_status")
        private int nicknameStatus;

        public boolean isIntroduceInAudit(){
            return isIntroduceInAudit;
        }

        public String getIntroduce(){
            return introduce;
        }

        public boolean isNicknameInAudit(){
            return isNicknameInAudit;
        }

        public String getNickname(){
            return nickname;
        }

        public int getNicknameStatus(){
            return nicknameStatus;
        }

        @Override
         public String toString(){
            return
                "AuditInfo{" +
                "is_introduce_in_audit = '" + isIntroduceInAudit + '\'' +
                ",introduce = '" + introduce + '\'' +
                ",is_nickname_in_audit = '" + isNicknameInAudit + '\'' +
                ",nickname = '" + nickname + '\'' +
                ",nickname_status = '" + nicknameStatus + '\'' +
                "}";
            }
    }

    public static class Certification{

        @JsonProperty("label")
        private String label;

        @JsonProperty("type")
        private int type;

        public String getLabel(){
            return label;
        }

        public int getType(){
            return type;
        }

        @Override
         public String toString(){
            return
                "Certification{" +
                "label = '" + label + '\'' +
                ",type = '" + type + '\'' +
                "}";
            }
    }

    public static class CertificationsItem{

        @JsonProperty("certification_id")
        private String certificationId;

        @JsonProperty("id")
        private String id;

        @JsonProperty("label")
        private String label;

        @JsonProperty("type")
        private int type;

        public String getCertificationId(){
            return certificationId;
        }

        public String getId(){
            return id;
        }

        public String getLabel(){
            return label;
        }

        public int getType(){
            return type;
        }

        @Override
         public String toString(){
            return
                "CertificationsItem{" +
                "certification_id = '" + certificationId + '\'' +
                ",id = '" + id + '\'' +
                ",label = '" + label + '\'' +
                ",type = '" + type + '\'' +
                "}";
            }
    }

    public static class CollectionInfo{

        @JsonProperty("num")
        private int num;

        public int getNum(){
            return num;
        }

        @Override
         public String toString(){
            return
                "CollectionInfo{" +
                "num = '" + num + '\'' +
                "}";
            }
    }

    public static class CommunityInfo{

        @JsonProperty("privacy_invisible")
        private PrivacyInvisible privacyInvisible;

        @JsonProperty("notify_disable")
        private NotifyDisable notifyDisable;

        @JsonProperty("last_login_time")
        private int lastLoginTime;

        @JsonProperty("is_realname")
        private boolean isRealname;

        @JsonProperty("forum_silent_info")
        private List<Object> forumSilentInfo;

        @JsonProperty("created_at")
        private int createdAt;

        @JsonProperty("silent_end_time_v2")
        private String silentEndTimeV2;

        @JsonProperty("silent_end_time")
        private int silentEndTime;

        @JsonProperty("has_initialized")
        private boolean hasInitialized;

        @JsonProperty("forbid_end_time_v2")
        private String forbidEndTimeV2;

        @JsonProperty("info_upd_time_v2")
        private String infoUpdTimeV2;

        @JsonProperty("forbid_end_time")
        private int forbidEndTime;

        @JsonProperty("user_func_status")
        private UserFuncStatus userFuncStatus;

        @JsonProperty("push_disable")
        private PushDisable pushDisable;

        @JsonProperty("last_login_ip")
        private String lastLoginIp;

        @JsonProperty("agree_status")
        private boolean agreeStatus;

        @JsonProperty("info_upd_time")
        private int infoUpdTime;

        public PrivacyInvisible getPrivacyInvisible(){
            return privacyInvisible;
        }

        public NotifyDisable getNotifyDisable(){
            return notifyDisable;
        }

        public int getLastLoginTime(){
            return lastLoginTime;
        }

        public boolean isRealname(){
            return isRealname;
        }

        public List<Object> getForumSilentInfo(){
            return forumSilentInfo;
        }

        public int getCreatedAt(){
            return createdAt;
        }

        public String getSilentEndTimeV2(){
            return silentEndTimeV2;
        }

        public int getSilentEndTime(){
            return silentEndTime;
        }

        public boolean hasInitialized(){
            return hasInitialized;
        }

        public String getForbidEndTimeV2(){
            return forbidEndTimeV2;
        }

        public String getInfoUpdTimeV2(){
            return infoUpdTimeV2;
        }

        public int getForbidEndTime(){
            return forbidEndTime;
        }

        public UserFuncStatus getUserFuncStatus(){
            return userFuncStatus;
        }

        public PushDisable getPushDisable(){
            return pushDisable;
        }

        public String getLastLoginIp(){
            return lastLoginIp;
        }

        public boolean isAgreeStatus(){
            return agreeStatus;
        }

        public int getInfoUpdTime(){
            return infoUpdTime;
        }

        @Override
         public String toString(){
            return
                "CommunityInfo{" +
                "privacy_invisible = '" + privacyInvisible + '\'' +
                ",notify_disable = '" + notifyDisable + '\'' +
                ",last_login_time = '" + lastLoginTime + '\'' +
                ",is_realname = '" + isRealname + '\'' +
                ",forum_silent_info = '" + forumSilentInfo + '\'' +
                ",created_at = '" + createdAt + '\'' +
                ",silent_end_time_v2 = '" + silentEndTimeV2 + '\'' +
                ",silent_end_time = '" + silentEndTime + '\'' +
                ",has_initialized = '" + hasInitialized + '\'' +
                ",forbid_end_time_v2 = '" + forbidEndTimeV2 + '\'' +
                ",info_upd_time_v2 = '" + infoUpdTimeV2 + '\'' +
                ",forbid_end_time = '" + forbidEndTime + '\'' +
                ",user_func_status = '" + userFuncStatus + '\'' +
                ",push_disable = '" + pushDisable + '\'' +
                ",last_login_ip = '" + lastLoginIp + '\'' +
                ",agree_status = '" + agreeStatus + '\'' +
                ",info_upd_time = '" + infoUpdTime + '\'' +
                "}";
            }
    }

    public static class CreatorInfo{

        @JsonProperty("show_beta")
        private boolean showBeta;

        @JsonProperty("card_url")
        private String cardUrl;

        @JsonProperty("can_collect")
        private boolean canCollect;

        @JsonProperty("can_top")
        private boolean canTop;

        @JsonProperty("card_type")
        private String cardType;

        public boolean isShowBeta(){
            return showBeta;
        }

        public String getCardUrl(){
            return cardUrl;
        }

        public boolean canCollect(){
            return canCollect;
        }

        public boolean canTop(){
            return canTop;
        }

        public String getCardType(){
            return cardType;
        }

        @Override
         public String toString(){
            return
                "CreatorInfo{" +
                "show_beta = '" + showBeta + '\'' +
                ",card_url = '" + cardUrl + '\'' +
                ",can_collect = '" + canCollect + '\'' +
                ",can_top = '" + canTop + '\'' +
                ",card_type = '" + cardType + '\'' +
                "}";
            }
    }

    public static class CustomerService{

        @JsonProperty("is_customer_service_staff")
        private boolean isCustomerServiceStaff;

        @JsonProperty("game_id")
        private int gameId;

        public boolean isCustomerServiceStaff(){
            return isCustomerServiceStaff;
        }

        public int getGameId(){
            return gameId;
        }

        @Override
         public String toString(){
            return
                "CustomerService{" +
                "is_customer_service_staff = '" + isCustomerServiceStaff + '\'' +
                ",game_id = '" + gameId + '\'' +
                "}";
            }
    }

    public static class Data{

        @JsonProperty("perm_game_list")
        private List<Object> permGameList;

        @JsonProperty("creator_info")
        private CreatorInfo creatorInfo;

        @JsonProperty("paladin_info")
        private PaladinInfo paladinInfo;

        @JsonProperty("is_has_collection")
        private boolean isHasCollection;

        @JsonProperty("perm_expr_list")
        private List<Object> permExprList;

        @JsonProperty("customer_service")
        private CustomerService customerService;

        @JsonProperty("is_creator")
        private boolean isCreator;

        @JsonProperty("is_in_blacklist")
        private boolean isInBlacklist;

        @JsonProperty("audit_info")
        private AuditInfo auditInfo;

        @JsonProperty("user_info")
        private UserInfo userInfo;

        @JsonProperty("perm_common_list")
        private List<Object> permCommonList;

        @JsonProperty("follow_relation")
        private Object followRelation;

        @JsonProperty("auth_relations")
        private List<Object> authRelations;

        @JsonProperty("collection_info")
        private CollectionInfo collectionInfo;

        public List<Object> getPermGameList(){
            return permGameList;
        }

        public CreatorInfo getCreatorInfo(){
            return creatorInfo;
        }

        public PaladinInfo getPaladinInfo(){
            return paladinInfo;
        }

        public boolean hasCollection(){
            return isHasCollection;
        }

        public List<Object> getPermExprList(){
            return permExprList;
        }

        public CustomerService getCustomerService(){
            return customerService;
        }

        public boolean isCreator(){
            return isCreator;
        }

        public boolean isInBlacklist(){
            return isInBlacklist;
        }

        public AuditInfo getAuditInfo(){
            return auditInfo;
        }

        public UserInfo getUserInfo(){
            return userInfo;
        }

        public List<Object> getPermCommonList(){
            return permCommonList;
        }

        public Object getFollowRelation(){
            return followRelation;
        }

        public List<Object> getAuthRelations(){
            return authRelations;
        }

        public CollectionInfo getCollectionInfo(){
            return collectionInfo;
        }

        @Override
         public String toString(){
            return
                "Data{" +
                "perm_game_list = '" + permGameList + '\'' +
                ",creator_info = '" + creatorInfo + '\'' +
                ",paladin_info = '" + paladinInfo + '\'' +
                ",is_has_collection = '" + isHasCollection + '\'' +
                ",perm_expr_list = '" + permExprList + '\'' +
                ",customer_service = '" + customerService + '\'' +
                ",is_creator = '" + isCreator + '\'' +
                ",is_in_blacklist = '" + isInBlacklist + '\'' +
                ",audit_info = '" + auditInfo + '\'' +
                ",user_info = '" + userInfo + '\'' +
                ",perm_common_list = '" + permCommonList + '\'' +
                ",follow_relation = '" + followRelation + '\'' +
                ",auth_relations = '" + authRelations + '\'' +
                ",collection_info = '" + collectionInfo + '\'' +
                "}";
            }
    }

    public static class Level{

        @JsonProperty("bg_color")
        private String bgColor;

        @JsonProperty("level")
        private int level;

        @JsonProperty("exp")
        private int exp;

        @JsonProperty("level_desc")
        private String levelDesc;

        @JsonProperty("bg_image")
        private String bgImage;

        public String getBgColor(){
            return bgColor;
        }

        public int getLevel(){
            return level;
        }

        public int getExp(){
            return exp;
        }

        public String getLevelDesc(){
            return levelDesc;
        }

        public String getBgImage(){
            return bgImage;
        }

        @Override
         public String toString(){
            return
                "Level{" +
                "bg_color = '" + bgColor + '\'' +
                ",level = '" + level + '\'' +
                ",exp = '" + exp + '\'' +
                ",level_desc = '" + levelDesc + '\'' +
                ",bg_image = '" + bgImage + '\'' +
                "}";
            }
    }

    public static class LevelExp{

        @JsonProperty("level")
        private int level;

        @JsonProperty("exp")
        private int exp;

        @JsonProperty("game_id")
        private int gameId;

        public int getLevel(){
            return level;
        }

        public int getExp(){
            return exp;
        }

        public int getGameId(){
            return gameId;
        }

        @Override
         public String toString(){
            return
                "LevelExp{" +
                "level = '" + level + '\'' +
                ",exp = '" + exp + '\'' +
                ",game_id = '" + gameId + '\'' +
                "}";
            }
    }

    public static class Marketing{

        @JsonProperty("is_opened")
        private boolean isOpened;

        @JsonProperty("is_operation")
        private boolean isOperation;

        @JsonProperty("expire")
        private String expire;

        @JsonProperty("is_hint")
        private boolean isHint;

        @JsonProperty("hint_type")
        private int hintType;

        public boolean isOpened(){
            return isOpened;
        }

        public boolean isOperation(){
            return isOperation;
        }

        public String getExpire(){
            return expire;
        }

        public boolean isHint(){
            return isHint;
        }

        public int getHintType(){
            return hintType;
        }

        @Override
         public String toString(){
            return
                "Marketing{" +
                "is_opened = '" + isOpened + '\'' +
                ",is_operation = '" + isOperation + '\'' +
                ",expire = '" + expire + '\'' +
                ",is_hint = '" + isHint + '\'' +
                ",hint_type = '" + hintType + '\'' +
                "}";
            }
    }

    public static class NotifyDisable{

        @JsonProperty("system_v2")
        private boolean systemV2;

        @JsonProperty("creator")
        private boolean creator;

        @JsonProperty("system")
        private boolean system;

        @JsonProperty("award")
        private boolean award;

        @JsonProperty("activity")
        private boolean activity;

        @JsonProperty("award_update_ts")
        private String awardUpdateTs;

        @JsonProperty("chat")
        private boolean chat;

        @JsonProperty("admin")
        private boolean admin;

        @JsonProperty("reply")
        private boolean reply;

        @JsonProperty("follow")
        private boolean follow;

        @JsonProperty("upvote")
        private boolean upvote;

        public boolean isSystemV2(){
            return systemV2;
        }

        public boolean isCreator(){
            return creator;
        }

        public boolean isSystem(){
            return system;
        }

        public boolean isAward(){
            return award;
        }

        public boolean isActivity(){
            return activity;
        }

        public String getAwardUpdateTs(){
            return awardUpdateTs;
        }

        public boolean isChat(){
            return chat;
        }

        public boolean isAdmin(){
            return admin;
        }

        public boolean isReply(){
            return reply;
        }

        public boolean isFollow(){
            return follow;
        }

        public boolean isUpvote(){
            return upvote;
        }

        @Override
         public String toString(){
            return
                "NotifyDisable{" +
                "system_v2 = '" + systemV2 + '\'' +
                ",creator = '" + creator + '\'' +
                ",system = '" + system + '\'' +
                ",award = '" + award + '\'' +
                ",activity = '" + activity + '\'' +
                ",award_update_ts = '" + awardUpdateTs + '\'' +
                ",chat = '" + chat + '\'' +
                ",admin = '" + admin + '\'' +
                ",reply = '" + reply + '\'' +
                ",follow = '" + follow + '\'' +
                ",upvote = '" + upvote + '\'' +
                "}";
            }
    }

    public static class PaladinInfo{

        @JsonProperty("path")
        private String path;

        public String getPath(){
            return path;
        }

        @Override
         public String toString(){
            return
                "PaladinInfo{" +
                "path = '" + path + '\'' +
                "}";
            }
    }

    public static class PrivacyInvisible{

        @JsonProperty("marketing")
        private Marketing marketing;

        @JsonProperty("watermark")
        private boolean watermark;

        @JsonProperty("follower")
        private boolean follower;

        @JsonProperty("post")
        private boolean post;

        @JsonProperty("gamerecord")
        private boolean gamerecord;

        @JsonProperty("recommend")
        private Recommend recommend;

        @JsonProperty("post_and_instant")
        private boolean postAndInstant;

        @JsonProperty("follow")
        private boolean follow;

        @JsonProperty("reply")
        private boolean reply;

        @JsonProperty("collect")
        private boolean collect;

        public Marketing getMarketing(){
            return marketing;
        }

        public boolean isWatermark(){
            return watermark;
        }

        public boolean isFollower(){
            return follower;
        }

        public boolean isPost(){
            return post;
        }

        public boolean isGamerecord(){
            return gamerecord;
        }

        public Recommend getRecommend(){
            return recommend;
        }

        public boolean isPostAndInstant(){
            return postAndInstant;
        }

        public boolean isFollow(){
            return follow;
        }

        public boolean isReply(){
            return reply;
        }

        public boolean isCollect(){
            return collect;
        }

        @Override
         public String toString(){
            return
                "PrivacyInvisible{" +
                "marketing = '" + marketing + '\'' +
                ",watermark = '" + watermark + '\'' +
                ",follower = '" + follower + '\'' +
                ",post = '" + post + '\'' +
                ",gamerecord = '" + gamerecord + '\'' +
                ",recommend = '" + recommend + '\'' +
                ",post_and_instant = '" + postAndInstant + '\'' +
                ",follow = '" + follow + '\'' +
                ",reply = '" + reply + '\'' +
                ",collect = '" + collect + '\'' +
                "}";
            }
    }

    public static class PushDisable{

        @JsonProperty("creator")
        private boolean creator;

        @JsonProperty("system")
        private boolean system;

        @JsonProperty("award")
        private boolean award;

        @JsonProperty("activity")
        private boolean activity;

        @JsonProperty("like")
        private boolean like;

        @JsonProperty("admin")
        private boolean admin;

        @JsonProperty("recommend")
        private boolean recommend;

        @JsonProperty("reply")
        private boolean reply;

        @JsonProperty("follow")
        private boolean follow;

        public boolean isCreator(){
            return creator;
        }

        public boolean isSystem(){
            return system;
        }

        public boolean isAward(){
            return award;
        }

        public boolean isActivity(){
            return activity;
        }

        public boolean isLike(){
            return like;
        }

        public boolean isAdmin(){
            return admin;
        }

        public boolean isRecommend(){
            return recommend;
        }

        public boolean isReply(){
            return reply;
        }

        public boolean isFollow(){
            return follow;
        }

        @Override
         public String toString(){
            return
                "PushDisable{" +
                "creator = '" + creator + '\'' +
                ",system = '" + system + '\'' +
                ",award = '" + award + '\'' +
                ",activity = '" + activity + '\'' +
                ",like = '" + like + '\'' +
                ",admin = '" + admin + '\'' +
                ",recommend = '" + recommend + '\'' +
                ",reply = '" + reply + '\'' +
                ",follow = '" + follow + '\'' +
                "}";
            }
    }

    public static class Recommend{

        @JsonProperty("is_opened")
        private boolean isOpened;

        @JsonProperty("is_operation")
        private boolean isOperation;

        @JsonProperty("expire")
        private String expire;

        @JsonProperty("is_tip")
        private boolean isTip;

        @JsonProperty("is_hint")
        private boolean isHint;

        @JsonProperty("hint_type")
        private int hintType;

        public boolean isOpened(){
            return isOpened;
        }

        public boolean isOperation(){
            return isOperation;
        }

        public String getExpire(){
            return expire;
        }

        public boolean isTip(){
            return isTip;
        }

        public boolean isHint(){
            return isHint;
        }

        public int getHintType(){
            return hintType;
        }

        @Override
         public String toString(){
            return
                "Recommend{" +
                "is_opened = '" + isOpened + '\'' +
                ",is_operation = '" + isOperation + '\'' +
                ",expire = '" + expire + '\'' +
                ",is_tip = '" + isTip + '\'' +
                ",is_hint = '" + isHint + '\'' +
                ",hint_type = '" + hintType + '\'' +
                "}";
            }
    }

    public static class UserFuncStatus{

        @JsonProperty("user_center_view")
        private int userCenterView;

        @JsonProperty("enable_history_view")
        private boolean enableHistoryView;

        @JsonProperty("enable_mention")
        private boolean enableMention;

        @JsonProperty("enable_recommend")
        private boolean enableRecommend;

        public int getUserCenterView(){
            return userCenterView;
        }

        public boolean isEnableHistoryView(){
            return enableHistoryView;
        }

        public boolean isEnableMention(){
            return enableMention;
        }

        public boolean isEnableRecommend(){
            return enableRecommend;
        }

        @Override
         public String toString(){
            return
                "UserFuncStatus{" +
                "user_center_view = '" + userCenterView + '\'' +
                ",enable_history_view = '" + enableHistoryView + '\'' +
                ",enable_mention = '" + enableMention + '\'' +
                ",enable_recommend = '" + enableRecommend + '\'' +
                "}";
            }
    }

    public static class UserInfo{

        @JsonProperty("level_exps")
        private List<LevelExp> levelExps;

        @JsonProperty("is_logoff")
        private boolean isLogoff;

        @JsonProperty("community_info")
        private CommunityInfo communityInfo;

        @JsonProperty("ip_region")
        private String ipRegion;

        @JsonProperty("gender")
        private int gender;

        @JsonProperty("level")
        private Level level;

        @JsonProperty("introduce")
        private String introduce;

        @JsonProperty("achieve")
        private Achieve achieve;

        @JsonProperty("bg_url")
        private String bgUrl;

        @JsonProperty("pc_bg_url")
        private String pcBgUrl;

        @JsonProperty("avatar")
        private String avatar;

        @JsonProperty("pendant")
        private String pendant;

        @JsonProperty("certifications")
        private List<CertificationsItem> certifications;

        @JsonProperty("nickname_times_left")
        private String nicknameTimesLeft;

        @JsonProperty("level_exp")
        private LevelExp levelExp;

        @JsonProperty("certification")
        private Certification certification;

        @JsonProperty("uid")
        private String uid;

        @JsonProperty("avatar_url")
        private String avatarUrl;

        @JsonProperty("community_email")
        private String communityEmail;

        @JsonProperty("nickname")
        private String nickname;

        public List<LevelExp> getLevelExps(){
            return levelExps;
        }

        public boolean isIsLogoff(){
            return isLogoff;
        }

        public CommunityInfo getCommunityInfo(){
            return communityInfo;
        }

        public String getIpRegion(){
            return ipRegion;
        }

        public int getGender(){
            return gender;
        }

        public Level getLevel(){
            return level;
        }

        public String getIntroduce(){
            return introduce;
        }

        public Achieve getAchieve(){
            return achieve;
        }

        public String getBgUrl(){
            return bgUrl;
        }

        public String getPcBgUrl(){
            return pcBgUrl;
        }

        public String getAvatar(){
            return avatar;
        }

        public String getPendant(){
            return pendant;
        }

        public List<CertificationsItem> getCertifications(){
            return certifications;
        }

        public String getNicknameTimesLeft(){
            return nicknameTimesLeft;
        }

        public LevelExp getLevelExp(){
            return levelExp;
        }

        public Certification getCertification(){
            return certification;
        }

        public String getUid(){
            return uid;
        }

        public String getAvatarUrl(){
            return avatarUrl;
        }

        public String getCommunityEmail(){
            return communityEmail;
        }

        public String getNickname(){
            return nickname;
        }

        @Override
         public String toString(){
            return
                "UserInfo{" +
                "level_exps = '" + levelExps + '\'' +
                ",is_logoff = '" + isLogoff + '\'' +
                ",community_info = '" + communityInfo + '\'' +
                ",ip_region = '" + ipRegion + '\'' +
                ",gender = '" + gender + '\'' +
                ",level = '" + level + '\'' +
                ",introduce = '" + introduce + '\'' +
                ",achieve = '" + achieve + '\'' +
                ",bg_url = '" + bgUrl + '\'' +
                ",pc_bg_url = '" + pcBgUrl + '\'' +
                ",avatar = '" + avatar + '\'' +
                ",pendant = '" + pendant + '\'' +
                ",certifications = '" + certifications + '\'' +
                ",nickname_times_left = '" + nicknameTimesLeft + '\'' +
                ",level_exp = '" + levelExp + '\'' +
                ",certification = '" + certification + '\'' +
                ",uid = '" + uid + '\'' +
                ",avatar_url = '" + avatarUrl + '\'' +
                ",community_email = '" + communityEmail + '\'' +
                ",nickname = '" + nickname + '\'' +
                "}";
            }
    }
}