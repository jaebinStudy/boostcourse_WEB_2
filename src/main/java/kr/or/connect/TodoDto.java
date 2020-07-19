package kr.or.connect;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;


public class TodoDto {

    private long id;
    private String name;
    private String reqDate;
    private int sequence;
    private String title;
    private String type;

    TodoDto() {

    }
    TodoDto(long id,String name,String reqDate,int sequence,String title,String type){
        super();
        this.id=id;
        this.name=name;
        this.reqDate=reqDate;
        this.sequence=sequence;
        this.title=title;
        this.type=type;

    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getReqDate() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat fourteen_format = new SimpleDateFormat("yyyy.MM.dd");
        reqDate = fourteen_format.format(date);
        return reqDate;
    }

    public int getSequence() {
        return sequence;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReqDate(String reqDate) {
        this.reqDate = reqDate;
    }

    public void setSequence() {
        this.sequence = sequence;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        return title + "등록날짜 :" + reqDate + "," + name + "," + sequence ;
    }
}




