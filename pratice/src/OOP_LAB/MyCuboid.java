package OOP;


public class MyCuboid {

    private MyPoint3D vertex1;
    private MyPoint3D vertex2;


    public MyCuboid() {
        this.vertex1 = new MyPoint3D(0, 0, 0);
        this.vertex2 = new MyPoint3D(1, 1, 1);
    }

    public MyCuboid(int x1, int y1, int z1, int x2, int y2, int z2) {
        this.vertex1 = new MyPoint3D(x1, y1, z1);
        this.vertex2 = new MyPoint3D(x2, y2, z2);
    }


    public void setVertex1(MyPoint3D v) {
        this.vertex1 = v;
    }


    public void setVertex2(MyPoint3D v) {
        this.vertex2 = v;
    }

    public MyPoint3D getVertex1() {
        return vertex1;
    }


    public MyPoint3D getVertex2() {
        return vertex2;
    }


    @Override
    public String toString() {
        return "[V1=" + vertex1.toString() + ", V2=" + vertex2.toString() + "]";}}


class testMyCuboid{
    public static void main(String[] args) {
        MyCuboid p1 = new MyCuboid();
        MyCuboid p2 = new MyCuboid(1,2,4,5,6,6);
        System.out.println("1st vertex of vertex 1: "+p1.getVertex1());
        System.out.println("2st vertex  of vertex 2: "+p2.getVertex2());
        System.out.println("Cuboid: "+p2.toString());
    }}

