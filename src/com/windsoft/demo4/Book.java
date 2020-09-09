package com.windsoft.demo4;

/**
 * @author Ricost
 */
public class Book {
    /**
     * 名称
     */
    private String title;
    /**
     * 页数
     */
    private int pageNum;
    {
        /**
         * 默认值
         */
        pageNum = 200;
    }

    public Book(){

    }
    public Book(String title) {
        this.title = title;
    }

    public Book(String title, int pageNum) {
        this.title = title;
        this.pageNum = pageNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public void detail(){
        System.out.println("名称："+ title +",页数："+pageNum );
    }
}
