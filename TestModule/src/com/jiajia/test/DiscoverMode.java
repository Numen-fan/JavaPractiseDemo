package com.jiajia.test;

import java.util.List;

public class DiscoverMode {

    int curPage;

    int offset;

    boolean over;

    int pageCount;

    int size;

    int total;

    List<DataItem> datas;

    /**
     * datas中每一项
     */
    public static class DataItem {

        private String apkLink;
        private Integer audit;
        private String author;
        private Boolean canEdit;
        private Integer chapterId;
        private String chapterName;
        private Boolean collect;
        private Integer courseId;
        private String desc;
        private String descMd;
        private String envelopePic;
        private Boolean fresh;
        private String host;
        private Integer id;
        private String link;
        private String niceDate;
        private String niceShareDate;
        private String origin;
        private String prefix;
        private String projectLink;
        private Long publishTime;
        private Integer realSuperChapterId;
        private Integer selfVisible;
        private Long shareDate;
        private String shareUser;
        private Integer superChapterId;
        private String superChapterName;
        private List<Tags> tags;
        private String title;
        private Integer type;
        private Integer userId;
        private Integer visible;
        private Integer zan;

        public DataItem() {

        }

        /**
         * tags中每一项
         */
        public static class Tags {
            private String name;
            private String url;

            public Tags(){ }
        }
    }

}
