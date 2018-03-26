package test01;

public class Client{
   
    private String name;
    private String juminNum;
    private String tel;
    private String gender;
    private String hobby;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJuminNum() {
        return juminNum;
    }

    public void setJuminNum(String juminNum) {
        this.juminNum = juminNum;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }


    @Override
    public String toString() {
        return this.getName();
    }
}
