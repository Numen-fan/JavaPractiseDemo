package com.jiajia.test.m3u;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Numen_fan on 2024/1/10
 * Desc:
 */
public class M3UParser {
    public static final M3UParser INSTANCE = new M3UParser();

    private M3UParser() {
    }

    public final List<Stream> parse(String contentsOfFile) {
        ArrayList arrayList = new ArrayList();
        for (String str : StringsKt.lines(contentsOfFile)) {
            if (StringsKt.startsWith$default(str, "#EXTINF:", false, 2, (Object) null)) {
                String replace$default = StringsKt.replace$default(str, "#EXTINF:", "", false, 4, (Object) null);
                Stream stream = new Stream((String) CollectionsKt.last((List<? extends Object>) StringsKt.split$default((CharSequence) replace$default, new String[]{","}, false, 0, 6, (Object) null)), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, 268435452, null);
                String substringBefore = StringsKt.substringBefore(StringsKt.substringAfter(replace$default, "tvg-id=\"", ""), "\"", "");
                if (substringBefore.length() > 0) {
                    stream.setTvgId(substringBefore);
                }
                String substringBefore2 = StringsKt.substringBefore(StringsKt.substringAfter(replace$default, "tvg-name=\"", ""), "\"", "");
                if (substringBefore2.length() > 0) {
                    stream.setTvgName(substringBefore2);
                }
                String substringBefore3 = StringsKt.substringBefore(StringsKt.substringAfter(replace$default, "group-title=\"", ""), "\"", "");
                if (substringBefore3.length() > 0) {
                    stream.setGroupTitle(substringBefore3);
                }
                String substringBefore4 = StringsKt.substringBefore(StringsKt.substringAfter(replace$default, "tvg-logo=\"", ""), "\"", "");
                if (substringBefore4.length() > 0) {
                    stream.setTvgLogo(substringBefore4);
                }
                String substringBefore5 = StringsKt.substringBefore(StringsKt.substringAfter(replace$default, "tvg-country=\"", ""), "\"", "");
                if (substringBefore5.length() > 0) {
                    stream.setTvgCountry(substringBefore5);
                }
                String substringBefore6 = StringsKt.substringBefore(StringsKt.substringAfter(replace$default, "tvg-language=\"", ""), "\"", "");
                if (substringBefore6.length() > 0) {
                    stream.setTvgLanguage(substringBefore6);
                }
                String substringBefore7 = StringsKt.substringBefore(StringsKt.substringAfter(replace$default, "tvg-url=\"", ""), "\"", "");
                if (substringBefore7.length() > 0) {
                    stream.setTvgUrl(substringBefore7);
                }
                arrayList.add(stream);
            } else if (!arrayList.isEmpty()) {
                Stream stream2 = (Stream) CollectionsKt.last((List<? extends Object>) arrayList);
                if (str.length() > 0) {
                    stream2.setStreamUrl(str);
                }
                CollectionsKt.removeLast(arrayList);
                arrayList.add(stream2);
            }
        }
        return arrayList;
    }
}
