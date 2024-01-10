package com.jiajia.test.m3u;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by Numen_fan on 2024/1/10
 * Desc:
 */
public final class Programme implements Serializable {
    private final String channelID;
    private final String dateEnd;
    private final String dateStart;
    private final String description;
    private final Long duration;
    private final String end;
    private final Boolean hasArchive;
    private final String serverTimeStart;
    private final String start;
    private final String subTitle;
    private final String timeEnd;
    private final String timeStart;
    private final String title;
    private String url;

    public final String component1() {
        return this.channelID;
    }

    public final Long component10() {
        return this.duration;
    }

    public final String component11() {
        return this.description;
    }

    public final Boolean component12() {
        return this.hasArchive;
    }

    public final String component13() {
        return this.serverTimeStart;
    }

    public final String component14() {
        return this.url;
    }

    public final String component2() {
        return this.start;
    }

    public final String component3() {
        return this.end;
    }

    public final String component4() {
        return this.title;
    }

    public final String component5() {
        return this.subTitle;
    }

    public final String component6() {
        return this.timeStart;
    }

    public final String component7() {
        return this.dateStart;
    }

    public final String component8() {
        return this.timeEnd;
    }

    public final String component9() {
        return this.dateEnd;
    }

    public final Programme copy(String channelID, String start, String end, String title, String str, String str2, String str3, String str4, String str5, Long l, String str6, Boolean bool, String str7, String str8) {
        Intrinsics.checkNotNullParameter(channelID, "channelID");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        Intrinsics.checkNotNullParameter(title, "title");
        return new Programme(channelID, start, end, title, str, str2, str3, str4, str5, l, str6, bool, str7, str8);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Programme) {
            Programme programme = (Programme) obj;
            return Intrinsics.areEqual(this.channelID, programme.channelID) && Intrinsics.areEqual(this.start, programme.start) && Intrinsics.areEqual(this.end, programme.end) && Intrinsics.areEqual(this.title, programme.title) && Intrinsics.areEqual(this.subTitle, programme.subTitle) && Intrinsics.areEqual(this.timeStart, programme.timeStart) && Intrinsics.areEqual(this.dateStart, programme.dateStart) && Intrinsics.areEqual(this.timeEnd, programme.timeEnd) && Intrinsics.areEqual(this.dateEnd, programme.dateEnd) && Intrinsics.areEqual(this.duration, programme.duration) && Intrinsics.areEqual(this.description, programme.description) && Intrinsics.areEqual(this.hasArchive, programme.hasArchive) && Intrinsics.areEqual(this.serverTimeStart, programme.serverTimeStart) && Intrinsics.areEqual(this.url, programme.url);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((this.channelID.hashCode() * 31) + this.start.hashCode()) * 31) + this.end.hashCode()) * 31) + this.title.hashCode()) * 31;
        String str = this.subTitle;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.timeStart;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.dateStart;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.timeEnd;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.dateEnd;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Long l = this.duration;
        int hashCode7 = (hashCode6 + (l == null ? 0 : l.hashCode())) * 31;
        String str6 = this.description;
        int hashCode8 = (hashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Boolean bool = this.hasArchive;
        int hashCode9 = (hashCode8 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str7 = this.serverTimeStart;
        int hashCode10 = (hashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.url;
        return hashCode10 + (str8 != null ? str8.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Programme(channelID=").append(this.channelID).append(", start=").append(this.start).append(", end=").append(this.end).append(", title=").append(this.title).append(", subTitle=").append(this.subTitle).append(", timeStart=").append(this.timeStart).append(", dateStart=").append(this.dateStart).append(", timeEnd=").append(this.timeEnd).append(", dateEnd=").append(this.dateEnd).append(", duration=").append(this.duration).append(", description=").append(this.description).append(", hasArchive=");
        sb.append(this.hasArchive).append(", serverTimeStart=").append(this.serverTimeStart).append(", url=").append(this.url).append(')');
        return sb.toString();
    }

    public Programme(String channelID, String start, String end, String title, String str, String str2, String str3, String str4, String str5, Long l, String str6, Boolean bool, String str7, String str8) {
        Intrinsics.checkNotNullParameter(channelID, "channelID");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        Intrinsics.checkNotNullParameter(title, "title");
        this.channelID = channelID;
        this.start = start;
        this.end = end;
        this.title = title;
        this.subTitle = str;
        this.timeStart = str2;
        this.dateStart = str3;
        this.timeEnd = str4;
        this.dateEnd = str5;
        this.duration = l;
        this.description = str6;
        this.hasArchive = bool;
        this.serverTimeStart = str7;
        this.url = str8;
    }

    public /* synthetic */ Programme(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Long l, String str10, Boolean bool, String str11, String str12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, str7, str8, str9, l, str10, bool, str11, (i & 8192) != 0 ? null : str12);
    }

    public final String getChannelID() {
        return this.channelID;
    }

    public final String getStart() {
        return this.start;
    }

    public final String getEnd() {
        return this.end;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final String getTimeStart() {
        return this.timeStart;
    }

    public final String getDateStart() {
        return this.dateStart;
    }

    public final String getTimeEnd() {
        return this.timeEnd;
    }

    public final String getDateEnd() {
        return this.dateEnd;
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Boolean getHasArchive() {
        return this.hasArchive;
    }

    public final String getServerTimeStart() {
        return this.serverTimeStart;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final LocalDateTime startDateTime() {
        return StringExt.toDeviceDateTime(this.start, "yyyyMMddHHmmss Z");
    }

    public final LocalDateTime endDateTime() {
        return StringExt.toDeviceDateTime(this.end, "yyyyMMddHHmmss Z");
    }

    public final Stream toStream(Stream stream) {
        String str = this.url;
        if (str == null || stream == null) {
            return null;
        }
        return Stream.copy$default(stream, null, str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, 268435453, null);
    }
}
