package com.sola.v2ex_android.model;

import java.util.List;

/**
 * Created by wei on 2016/10/24.
 */

public class NodeInfo {
    /**
     * id : 300
     * name : programmer
     * url : http://www.v2ex.com/go/programmer
     * title : 程序员
     * title_alternative : Programmer
     * topics : 13616
     * stars : 2688
     * header : While code monkeys are not eating bananas, they're coding.
     * footer : null
     * created : 1293396163
     * avatar_mini : //cdn.v2ex.co/navatar/94f6/d7e0/300_mini.png?m=1477290858
     * avatar_normal : //cdn.v2ex.co/navatar/94f6/d7e0/300_normal.png?m=1477290858
     * avatar_large : //cdn.v2ex.co/navatar/94f6/d7e0/300_large.png?m=1477290858
     */
    public int id;
    public String name;
    public String url;
    public String title;
    public String title_alternative;
    public int topics;
    public int stars;
    public String header;
    public Object footer;
    public int created;
    public String avatar_mini;
    public String avatar_normal;
    public String avatar_large;

    public List<Replies> replies;     //主题详情使用，记录用户回复

    public List<Topics> topicsList;     //节点使用，记录某个节点的所有话题
}
