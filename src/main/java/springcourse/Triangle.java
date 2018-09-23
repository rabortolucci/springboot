package springcourse;

public class Triangle {

    private String type;
    private String type2;
    private int height;

    public Triangle(String type2){
        this.type2 = type2;
    }

    public Triangle(String type2, int height){
        this.type2 = type2;
        this.height = height;
    }

    public void draw(){
        System.out.println(getType() + " Triangle draw " + getType2() + " height " + height);
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
