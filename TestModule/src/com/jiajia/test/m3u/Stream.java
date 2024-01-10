package com.jiajia.test.m3u;

import java.io.Serializable;
import java.nio.channels.Channel;

/**
 * Created by Numen_fan on 2024/1/10
 * Desc:
 */
public final class Stream implements Serializable {
    private final String added;
    private Object backdrop_path;
    private final String category_id;
    private Channel channel;
    private final String container_extension;
    private final String cover;
    private String groupTitle;
    private final boolean isLocalFile;
    private final String last_modified;
    private final Integer num;
    private final String playlistUrl;
    private Object rating_5based;
    private final String releaseDate;
    private final String release_date;
    private final Integer series_id;
    private String streamUrl;
    private final String stream_icon;
    private final Integer stream_id;
    private String stream_type;
    private final String timeZone;
    private final String title;
    private Integer tv_archive;
    private String tvgCountry;
    private String tvgId;
    private String tvgLanguage;
    private String tvgLogo;
    private String tvgName;
    private String tvgUrl;

    public static /* synthetic */ Stream copy$default(Stream stream, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Channel channel, Integer num, String str10, Integer num2, String str11, String str12, String str13, Integer num3, Object obj, String str14, String str15, String str16, Integer num4, String str17, String str18, Object obj2, String str19, String str20, boolean z, int i, Object obj3) {
        return stream.copy((i & 1) != 0 ? stream.title : str, (i & 2) != 0 ? stream.streamUrl : str2, (i & 4) != 0 ? stream.tvgId : str3, (i & 8) != 0 ? stream.tvgName : str4, (i & 16) != 0 ? stream.tvgLogo : str5, (i & 32) != 0 ? stream.groupTitle : str6, (i & 64) != 0 ? stream.tvgCountry : str7, (i & 128) != 0 ? stream.tvgLanguage : str8, (i & 256) != 0 ? stream.tvgUrl : str9, (i & 512) != 0 ? stream.channel : channel, (i & 1024) != 0 ? stream.num : num, (i & 2048) != 0 ? stream.stream_type : str10, (i & 4096) != 0 ? stream.stream_id : num2, (i & 8192) != 0 ? stream.stream_icon : str11, (i & 16384) != 0 ? stream.added : str12, (i & 32768) != 0 ? stream.category_id : str13, (i & 65536) != 0 ? stream.tv_archive : num3, (i & 131072) != 0 ? stream.rating_5based : obj, (i & 262144) != 0 ? stream.container_extension : str14, (i & 524288) != 0 ? stream.release_date : str15, (i & 1048576) != 0 ? stream.releaseDate : str16, (i & 2097152) != 0 ? stream.series_id : num4, (i & 4194304) != 0 ? stream.cover : str17, (i & 8388608) != 0 ? stream.last_modified : str18, (i & 16777216) != 0 ? stream.backdrop_path : obj2, (i & 33554432) != 0 ? stream.playlistUrl : str19, (i & 67108864) != 0 ? stream.timeZone : str20, (i & 134217728) != 0 ? stream.isLocalFile : z);
    }

    public final String component1() {
        return this.title;
    }

    public final Channel component10() {
        return this.channel;
    }

    public final Integer component11() {
        return this.num;
    }

    public final String component12() {
        return this.stream_type;
    }

    public final Integer component13() {
        return this.stream_id;
    }

    public final String component14() {
        return this.stream_icon;
    }

    public final String component15() {
        return this.added;
    }

    public final String component16() {
        return this.category_id;
    }

    public final Integer component17() {
        return this.tv_archive;
    }

    public final Object component18() {
        return this.rating_5based;
    }

    public final String component19() {
        return this.container_extension;
    }

    public final String component2() {
        return this.streamUrl;
    }

    public final String component20() {
        return this.release_date;
    }

    public final String component21() {
        return this.releaseDate;
    }

    public final Integer component22() {
        return this.series_id;
    }

    public final String component23() {
        return this.cover;
    }

    public final String component24() {
        return this.last_modified;
    }

    public final Object component25() {
        return this.backdrop_path;
    }

    public final String component26() {
        return this.playlistUrl;
    }

    public final String component27() {
        return this.timeZone;
    }

    public final boolean component28() {
        return this.isLocalFile;
    }

    public final String component3() {
        return this.tvgId;
    }

    public final String component4() {
        return this.tvgName;
    }

    public final String component5() {
        return this.tvgLogo;
    }

    public final String component6() {
        return this.groupTitle;
    }

    public final String component7() {
        return this.tvgCountry;
    }

    public final String component8() {
        return this.tvgLanguage;
    }

    public final String component9() {
        return this.tvgUrl;
    }

    public final Stream copy(@Json(name = "name") String str, String str2, @Json(nIntrinsicsame = "epg_channel_id") String str3, String str4, String str5, String str6, String str7, String str8, String str9, Channel channel, Integer num, String str10, Integer num2, String str11, String str12, String str13, Integer num3, Object obj, String str14, String str15, String str16, Integer num4, String str17, String str18, Object obj2, String str19, String str20, boolean z) {
        return new Stream(str, str2, str3, str4, str5, str6, str7, str8, str9, channel, num, str10, num2, str11, str12, str13, num3, obj, str14, str15, str16, num4, str17, str18, obj2, str19, str20, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.title;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.streamUrl;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.tvgId;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.tvgName;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.tvgLogo;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.groupTitle;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.tvgCountry;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.tvgLanguage;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.tvgUrl;
        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Channel channel = this.channel;
        int hashCode10 = (hashCode9 + (channel == null ? 0 : channel.hashCode())) * 31;
        Integer num = this.num;
        int hashCode11 = (hashCode10 + (num == null ? 0 : num.hashCode())) * 31;
        String str10 = this.stream_type;
        int hashCode12 = (hashCode11 + (str10 == null ? 0 : str10.hashCode())) * 31;
        Integer num2 = this.stream_id;
        int hashCode13 = (hashCode12 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str11 = this.stream_icon;
        int hashCode14 = (hashCode13 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.added;
        int hashCode15 = (hashCode14 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.category_id;
        int hashCode16 = (hashCode15 + (str13 == null ? 0 : str13.hashCode())) * 31;
        Integer num3 = this.tv_archive;
        int hashCode17 = (hashCode16 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Object obj = this.rating_5based;
        int hashCode18 = (hashCode17 + (obj == null ? 0 : obj.hashCode())) * 31;
        String str14 = this.container_extension;
        int hashCode19 = (hashCode18 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.release_date;
        int hashCode20 = (hashCode19 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.releaseDate;
        int hashCode21 = (hashCode20 + (str16 == null ? 0 : str16.hashCode())) * 31;
        Integer num4 = this.series_id;
        int hashCode22 = (hashCode21 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str17 = this.cover;
        int hashCode23 = (hashCode22 + (str17 == null ? 0 : str17.hashCode())) * 31;
        String str18 = this.last_modified;
        int hashCode24 = (hashCode23 + (str18 == null ? 0 : str18.hashCode())) * 31;
        Object obj2 = this.backdrop_path;
        int hashCode25 = (hashCode24 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        String str19 = this.playlistUrl;
        int hashCode26 = (hashCode25 + (str19 == null ? 0 : str19.hashCode())) * 31;
        String str20 = this.timeZone;
        int hashCode27 = (hashCode26 + (str20 != null ? str20.hashCode() : 0)) * 31;
        boolean z = this.isLocalFile;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode27 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stream(title=").append(this.title).append(", streamUrl=").append(this.streamUrl).append(", tvgId=").append(this.tvgId).append(", tvgName=").append(this.tvgName).append(", tvgLogo=").append(this.tvgLogo).append(", groupTitle=").append(this.groupTitle).append(", tvgCountry=").append(this.tvgCountry).append(", tvgLanguage=").append(this.tvgLanguage).append(", tvgUrl=").append(this.tvgUrl).append(", channel=").append(this.channel).append(", num=").append(this.num).append(", stream_type=");
        sb.append(this.stream_type).append(", stream_id=").append(this.stream_id).append(", stream_icon=").append(this.stream_icon).append(", added=").append(this.added).append(", category_id=").append(this.category_id).append(", tv_archive=").append(this.tv_archive).append(", rating_5based=").append(this.rating_5based).append(", container_extension=").append(this.container_extension).append(", release_date=").append(this.release_date).append(", releaseDate=").append(this.releaseDate).append(", series_id=").append(this.series_id).append(", cover=").append(this.cover);
        sb.append(", last_modified=").append(this.last_modified).append(", backdrop_path=").append(this.backdrop_path).append(", playlistUrl=").append(this.playlistUrl).append(", timeZone=").append(this.timeZone).append(", isLocalFile=").append(this.isLocalFile).append(')');
        return sb.toString();
    }

    public Stream(@Json(name = "name") String str, String str2, @Json(name = "epg_channel_id") String str3, String str4, String str5, String str6, String str7, String str8, String str9, Channel channel, Integer num, String str10, Integer num2, String str11, String str12, String str13, Integer num3, Object obj, String str14, String str15, String str16, Integer num4, String str17, String str18, Object obj2, String str19, String str20, boolean z) {
        this.title = str;
        this.streamUrl = str2;
        this.tvgId = str3;
        this.tvgName = str4;
        this.tvgLogo = str5;
        this.groupTitle = str6;
        this.tvgCountry = str7;
        this.tvgLanguage = str8;
        this.tvgUrl = str9;
        this.channel = channel;
        this.num = num;
        this.stream_type = str10;
        this.stream_id = num2;
        this.stream_icon = str11;
        this.added = str12;
        this.category_id = str13;
        this.tv_archive = num3;
        this.rating_5based = obj;
        this.container_extension = str14;
        this.release_date = str15;
        this.releaseDate = str16;
        this.series_id = num4;
        this.cover = str17;
        this.last_modified = str18;
        this.backdrop_path = obj2;
        this.playlistUrl = str19;
        this.timeZone = str20;
        this.isLocalFile = z;
    }

    public /* synthetic */ Stream(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Channel channel, Integer num, String str10, Integer num2, String str11, String str12, String str13, Integer num3, Object obj, String str14, String str15, String str16, Integer num4, String str17, String str18, Object obj2, String str19, String str20, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9, (i & 512) != 0 ? null : channel, (i & 1024) != 0 ? null : num, (i & 2048) != 0 ? null : str10, (i & 4096) != 0 ? null : num2, (i & 8192) != 0 ? null : str11, (i & 16384) != 0 ? null : str12, (32768 & i) != 0 ? null : str13, (65536 & i) != 0 ? null : num3, (131072 & i) != 0 ? null : obj, (262144 & i) != 0 ? null : str14, (524288 & i) != 0 ? null : str15, (1048576 & i) != 0 ? null : str16, (2097152 & i) != 0 ? null : num4, (4194304 & i) != 0 ? null : str17, (8388608 & i) != 0 ? null : str18, (16777216 & i) != 0 ? null : obj2, (33554432 & i) != 0 ? null : str19, (67108864 & i) != 0 ? null : str20, (i & 134217728) != 0 ? false : z);
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getStreamUrl() {
        return this.streamUrl;
    }

    public final void setStreamUrl(String str) {
        this.streamUrl = str;
    }

    public final String getTvgId() {
        return this.tvgId;
    }

    public final void setTvgId(String str) {
        this.tvgId = str;
    }

    public final String getTvgName() {
        return this.tvgName;
    }

    public final void setTvgName(String str) {
        this.tvgName = str;
    }

    public final String getTvgLogo() {
        return this.tvgLogo;
    }

    public final void setTvgLogo(String str) {
        this.tvgLogo = str;
    }

    public final String getGroupTitle() {
        return this.groupTitle;
    }

    public final void setGroupTitle(String str) {
        this.groupTitle = str;
    }

    public final String getTvgCountry() {
        return this.tvgCountry;
    }

    public final void setTvgCountry(String str) {
        this.tvgCountry = str;
    }

    public final String getTvgLanguage() {
        return this.tvgLanguage;
    }

    public final void setTvgLanguage(String str) {
        this.tvgLanguage = str;
    }

    public final String getTvgUrl() {
        return this.tvgUrl;
    }

    public final void setTvgUrl(String str) {
        this.tvgUrl = str;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final void setChannel(Channel channel) {
        this.channel = channel;
    }

    public final Integer getNum() {
        return this.num;
    }

    public final String getStream_type() {
        return this.stream_type;
    }

    public final void setStream_type(String str) {
        this.stream_type = str;
    }

    public final Integer getStream_id() {
        return this.stream_id;
    }

    public final String getStream_icon() {
        return this.stream_icon;
    }

    public final String getAdded() {
        return this.added;
    }

    public final String getCategory_id() {
        return this.category_id;
    }

    public final Integer getTv_archive() {
        return this.tv_archive;
    }

    public final void setTv_archive(Integer num) {
        this.tv_archive = num;
    }

    public final Object getRating_5based() {
        return this.rating_5based;
    }

    public final void setRating_5based(Object obj) {
        this.rating_5based = obj;
    }

    public final String getContainer_extension() {
        return this.container_extension;
    }

    public final String getRelease_date() {
        return this.release_date;
    }

    public final String getReleaseDate() {
        return this.releaseDate;
    }

    public final Integer getSeries_id() {
        return this.series_id;
    }

    public final String getCover() {
        return this.cover;
    }

    public final String getLast_modified() {
        return this.last_modified;
    }

    public final Object getBackdrop_path() {
        return this.backdrop_path;
    }

    public final void setBackdrop_path(Object obj) {
        this.backdrop_path = obj;
    }

    public final String getPlaylistUrl() {
        return this.playlistUrl;
    }

    public final String getTimeZone() {
        return this.timeZone;
    }

    public final boolean isLocalFile() {
        return this.isLocalFile;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof Stream ? (Stream) obj : null) != null) {
            Stream stream = (Stream) obj;
            return Intrinsics.areEqual(this.title, stream.title) && Intrinsics.areEqual(this.streamUrl, stream.streamUrl);
        }
        return false;
    }
}
