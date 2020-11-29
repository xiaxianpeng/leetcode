package org.example.bean;

/**
 * Created by xianpeng.xia
 * on 2020/11/29 下午11:07
 */
public class Hero {

    private int no;
    private String name;
    private String nickname;

    public Hero(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Hero{" +
            "no=" + no +
            ", name='" + name + '\'' +
            ", nickname='" + nickname + '\'' +
            '}';
    }
}
