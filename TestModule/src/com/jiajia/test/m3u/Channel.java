package com.jiajia.test.m3u;

import java.io.Serializable;

/**
 * Created by Numen_fan on 2024/1/10
 * Desc:
 */
public final class Channel implements Serializable {
    private final String displayName;
    private final String icon;

    /* renamed from: id */
    private final String f198id;
    private List<Programme> programmes;
    private List<Programme> searchResultProgrammes;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Channel copy$default(Channel channel, String str, String str2, String str3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = channel.f198id;
        }
        if ((i & 2) != 0) {
            str2 = channel.displayName;
        }
        if ((i & 4) != 0) {
            str3 = channel.icon;
        }
        if ((i & 8) != 0) {
            list = channel.programmes;
        }
        return channel.copy(str, str2, str3, list);
    }

    public final String component1() {
        return this.f198id;
    }

    public final String component2() {
        return this.displayName;
    }

    public final String component3() {
        return this.icon;
    }

    public final List<Programme> component4() {
        return this.programmes;
    }

    public final Channel copy(String str, String str2, String str3, List<Programme> list) {
        return new Channel(str, str2, str3, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Channel) {
            Channel channel = (Channel) obj;
            return Intrinsics.areEqual(this.f198id, channel.f198id) && Intrinsics.areEqual(this.displayName, channel.displayName) && Intrinsics.areEqual(this.icon, channel.icon) && Intrinsics.areEqual(this.programmes, channel.programmes);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f198id;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.displayName;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.icon;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<Programme> list = this.programmes;
        return hashCode3 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "Channel(id=" + this.f198id + ", displayName=" + this.displayName + ", icon=" + this.icon + ", programmes=" + this.programmes + ')';
    }

    public Channel(String str, String str2, String str3, List<Programme> list) {
        this.f198id = str;
        this.displayName = str2;
        this.icon = str3;
        this.programmes = list;
    }

    public final String getId() {
        return this.f198id;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final List<Programme> getProgrammes() {
        return this.programmes;
    }

    public final void setProgrammes(List<Programme> list) {
        this.programmes = list;
    }

    public final Programme nowProgramme() {
        List<Programme> list = this.programmes;
        if (list != null) {
            for (Programme programme : list) {
                LocalDateTime now = LocalDateTime.now();
                if (now.compareTo((ChronoLocalDateTime<?>) programme.startDateTime()) > 0 && now.compareTo((ChronoLocalDateTime<?>) programme.endDateTime()) < 0) {
                    return programme;
                }
            }
            return null;
        }
        return null;
    }

    public final Tuples<Integer, Programme> nowProgrammeWithIndex() {
        List<Programme> list = this.programmes;
        if (list != null) {
            int i = 0;
            for (Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Programme programme = (Programme) obj;
                LocalDateTime now = LocalDateTime.now();
                if (now.compareTo((ChronoLocalDateTime<?>) programme.startDateTime()) > 0 && now.compareTo((ChronoLocalDateTime<?>) programme.endDateTime()) < 0) {
                    return TuplesKt.m30to(Integer.valueOf(i), programme);
                }
                i = i2;
            }
            return null;
        }
        return null;
    }

    public final List<Programme> nowProgrammes() {
        ArrayList arrayList = new ArrayList();
        List<Programme> list = this.programmes;
        Integer num = null;
        if (list != null) {
            int i = 0;
            for (Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Programme programme = (Programme) obj;
                LocalDateTime now = LocalDateTime.now();
                if (now.compareTo((ChronoLocalDateTime<?>) programme.startDateTime()) > 0 && now.compareTo((ChronoLocalDateTime<?>) programme.endDateTime()) < 0) {
                    num = Integer.valueOf(i);
                    arrayList.add(programme);
                }
                i = i2;
            }
        }
        if (num != null) {
            int intValue = num.intValue();
            List<Programme> list2 = this.programmes;
            Intrinsics.checkNotNull(list2);
            if (intValue < list2.size() - 1) {
                List<Programme> list3 = this.programmes;
                Intrinsics.checkNotNull(list3);
                arrayList.add(list3.get(intValue + 1));
            }
            List<Programme> list4 = this.programmes;
            Intrinsics.checkNotNull(list4);
            if (intValue < list4.size() - 2) {
                List<Programme> list5 = this.programmes;
                Intrinsics.checkNotNull(list5);
                arrayList.add(list5.get(intValue + 2));
            }
        }
        return arrayList;
    }

    public final List<Programme> getSearchResultProgrammes() {
        return this.searchResultProgrammes;
    }

    public final void setSearchResultProgrammes(List<Programme> list) {
        this.searchResultProgrammes = list;
    }
}
