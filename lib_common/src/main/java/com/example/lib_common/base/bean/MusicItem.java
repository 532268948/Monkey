package com.example.lib_common.base.bean;

import com.example.lib_common.music.MusicSource;

/**
 * @author : 叶天华
 * @project: Monkey
 * @date : 2018/12/16
 * @time : 22:23
 * @email : 15869107730@163.com
 * @note :
 */
public class MusicItem extends BaseItem{


    /**
     * 播放次数
     */
    private long playTimes;
    /**
     * 音频时长
     */
    private long duration;
    /**
     * 播放音频的id
     */
    private long musicId;
    private String music;
    /**
     * 音频名字
     */
    private String name;
    /**
     * 作者
     */
    private String author;

    /**
     * 封面图片
     */
    private String cover;

    /**
     * 播放音频的url
     */
    private String url;
    /**
     * 边下载边播放下载的路径
     */
    private String cachedFile;
    /**
     * 本地下载文件路径
     */
    private String localFile;
    /**
     * music来源
     */
    private MusicSource source;
    /**
     * 是否正在播放
     */
    private boolean isPlaying;

    /**
     * 是否边下载边播放
     */
    private boolean downloadWhenPlaying = true;

    /**
     * 是否需要付款播放
     */
    private boolean isNeedPay=true;

    /**
     * 是否已经付款
     */
    private boolean isHasPay=false;

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public long getPlayTimes() {
        return playTimes;
    }

    public void setPlayTimes(long playTimes) {
        this.playTimes = playTimes;
    }

    public long getMusicId() {
        return musicId;
    }

    public void setMusicId(long musicId) {
        this.musicId = musicId;
    }

    public String getMusic() {
        return music;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCachedFile() {
        return cachedFile;
    }

    public void setCachedFile(String cachedFile) {
        this.cachedFile = cachedFile;
    }

    public String getLocalFile() {
        return localFile;
    }

    public void setLocalFile(String localFile) {
        this.localFile = localFile;
    }

    public MusicSource getSource() {
        return source;
    }

    public void setSource(MusicSource source) {
        this.source = source;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    public boolean isDownloadWhenPlaying() {
        return downloadWhenPlaying;
    }

    public void setDownloadWhenPlaying(boolean downloadWhenPlaying) {
        this.downloadWhenPlaying = downloadWhenPlaying;
    }

    public boolean isNeedPay() {
        return isNeedPay;
    }

    public void setNeedPay(boolean needPay) {
        isNeedPay = needPay;
    }

    public boolean isHasPay() {
        return isHasPay;
    }

    public void setHasPay(boolean hasPay) {
        isHasPay = hasPay;
    }
}