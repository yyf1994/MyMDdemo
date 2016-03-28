package com.yyf.mymedemo.model;

import java.util.List;

/**
 * Created by Administrator on 2016/3/24.
 */
public class News {


    /**
     * reason : 查询成功
     * result : [{"title":"北京清明节超50万市民集中祭扫","content":"2016年3月27日消息,昨天全市迎来清明节第一个祭扫高峰日,全市213处墓地共接待扫墓群众52.1万人,其中,八宝山地区接待扫墓群众4.3万人。市民政局通报称,各墓区治安、交通秩序良好,消防部门未接报火情。 新设十二生肖时空邮箱  在八宝山人民公墓管理处广场的两侧,12个一米...","img_width":"661","full_title":"北京清明节超50万市民集中祭扫","pdate":"1小时前","src":"中国经济网","img_length":"1024","img":"http://p2.qhimg.com/t01b4b1e77c6af1487f.jpg","url":"http://www.ce.cn/culture/gd/201603/28/t20160328_9876393.shtml","pdate_src":"2016-03-28 13:52:00"},{"title":"正雷太极书院暨陈正雷太极拳北京总馆揭牌仪式举行","content":"2016年3月26日,正雷太极书院暨陈正雷太极拳<em>北京<\/em>总馆揭牌仪式在<em>北京<\/em>隆重举行。陈正雷大师为中国武术九段,国家非物质文化遗产陈氏太极拳代表性继承人,陈氏太极拳第11代嫡宗传人,中国国家武术院专家委员。众多武术界名流到场祝贺,来自世界各地的陈正雷太极拳弟子、传人、战...","img_width":"","full_title":"正雷太极书院暨陈正雷太极拳北京总馆揭牌仪式举行","pdate":"1小时前","src":"中国青年网","img_length":"","img":"","url":"http://news.youth.cn/sh/201603/t20160328_7788371.htm","pdate_src":"2016-03-28 13:51:59"},{"title":"北京第五大\"王牌\"群众组织隐身网络寻找\"毒瘤\"","content":"据<em>北京市<\/em>公安局网安总队相关负责人介绍,自2014年起,<em>北京市<\/em>公安局网安总队将群防群治理念引入网络虚拟社会,以\"首都网警\"网上巡查执法平台为依托,通过自愿加入的方式,形成这支\"网警志愿者\"队伍。 截至2015年12月,这支\"网警志愿者\"队伍已拥有成员3000余人,累计举报各类违法犯...","img_width":"","full_title":"北京第五大\"王牌\"群众组织隐身网络寻找\"毒瘤\"","pdate":"1小时前","src":"中国网","img_length":"","img":"","url":"http://news.china.com.cn/2016-03/28/content_38125701.htm","pdate_src":"2016-03-28 13:47:24"},{"title":"北京27日最高气温达22.1℃ 温暖趋势或将延续","content":"本报讯(记者 王斌)昨天是清明节前的最后一个周末,市属公园仅两天就迎来了近百万游客前来踏青赏花。随着<em>北京<\/em>植物园桃花节、玉渊潭公园樱花节相继开幕,各大公园的春花也开始集中开放,吸引了不少游客。<em>北京<\/em>青年报记者昨天在市公园管理中心的监控大厅看到,早上8点多,不少公园就...","img_width":"281","full_title":"北京27日最高气温达22.1℃ 温暖趋势或将延续","pdate":"2小时前","src":"中国广播网","img_length":"400","img":"http://p3.qhimg.com/t01912ac216099d51f7.jpg","url":"http://news.cnr.cn/native/gd/20160328/t20160328_521728203.shtml","pdate_src":"2016-03-28 13:05:00"}]
     * error_code : 0
     */

    private String reason;
    private int error_code;
    /**
     * title : 北京清明节超50万市民集中祭扫
     * content : 2016年3月27日消息,昨天全市迎来清明节第一个祭扫高峰日,全市213处墓地共接待扫墓群众52.1万人,其中,八宝山地区接待扫墓群众4.3万人。市民政局通报称,各墓区治安、交通秩序良好,消防部门未接报火情。 新设十二生肖时空邮箱  在八宝山人民公墓管理处广场的两侧,12个一米...
     * img_width : 661
     * full_title : 北京清明节超50万市民集中祭扫
     * pdate : 1小时前
     * src : 中国经济网
     * img_length : 1024
     * img : http://p2.qhimg.com/t01b4b1e77c6af1487f.jpg
     * url : http://www.ce.cn/culture/gd/201603/28/t20160328_9876393.shtml
     * pdate_src : 2016-03-28 13:52:00
     */

    private List<NewsResult> result;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public List<NewsResult> getResult() {
        return result;
    }

    public void setResult(List<NewsResult> result) {
        this.result = result;
    }

}
