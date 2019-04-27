package app.n1ru20.com.dbviewpager;

public class Profile {
    String text1,image1;


    //list class for holding values
    public Profile(String text1, String image1) {

        this.text1 = text1;
        this.image1 = image1;
    }

    public Profile() {
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }
}
