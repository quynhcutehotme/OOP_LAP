package OOP;

public class MyPoint3D {
    public int x;
    public int y;
    public int z;

    public MyPoint3D(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public MyPoint3D(){
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public void setX(int x) {
            this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
    @Override
    public String toString(){return "(x="+this.x+", y="+ this.y+ ", z="+this.z+")";}
}

class testMyPoint3D{
    public static void main(String[] args) {
        MyPoint3D p1 = new MyPoint3D();
        MyPoint3D p2 = new MyPoint3D(1,2,4);
        System.out.println("Point 1: "+p1.toString());
        System.out.println("Point 2: "+p2.toString());
    }
}
