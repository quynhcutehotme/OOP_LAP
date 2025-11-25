package OOP;

import java.util.Scanner;

public class Lab6Ex1 {
    MyCuboid cuboid1;
    MyCuboid cuboid2;

    public Lab6Ex1(){
        this.cuboid1 = new MyCuboid(0, 0, 0, 0, 0, 0);
        this.cuboid2 = new MyCuboid(0, 0, 0, 0, 0, 0);
    }

    public Lab6Ex1(MyCuboid cuboid1, MyCuboid cuboid2){
        this.cuboid1 = cuboid1;
        this.cuboid2 = cuboid2;
    }

    public void readCuboid(Scanner sc){ // <-- Đã sửa: nhận Scanner

        System.out.print("Input 1st cuboid: ");
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int z1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int z2 = sc.nextInt();

        this.cuboid1.getVertex1().setX(x1);
        this.cuboid1.getVertex1().setY(y1);
        this.cuboid1.getVertex1().setZ(z1);
        this.cuboid1.getVertex2().setX(x2);
        this.cuboid1.getVertex2().setY(y2);
        this.cuboid1.getVertex2().setZ(z2);

        System.out.print("Input 2st cuboid: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();
        int f = sc.nextInt();


        this.cuboid2.getVertex1().setX(a);
        this.cuboid2.getVertex1().setY(b);
        this.cuboid2.getVertex1().setZ(c);
        this.cuboid2.getVertex2().setX(d);
        this.cuboid2.getVertex2().setY(e);
        this.cuboid2.getVertex2().setZ(f);
    }
    @Override
    public String toString(){
        return "1st cuboid:"+ cuboid1.toString() +"\n2st cuboid:" +cuboid2.toString();
    }

    public int commonVolume() {
            int x1 = cuboid1.getVertex1().getX();
            int y1 = cuboid1.getVertex1().getY();
            int z1 = cuboid1.getVertex1().getZ();
            int x2 = cuboid1.getVertex2().getX();
            int y2 = cuboid1.getVertex2().getY();
            int z2 = cuboid1.getVertex2().getZ();

            int x3 = cuboid2.getVertex1().getX();
            int y3 = cuboid2.getVertex1().getY();
            int z3 = cuboid2.getVertex1().getZ();
            int x4 = cuboid2.getVertex2().getX();
            int y4 = cuboid2.getVertex2().getY();
            int z4 = cuboid2.getVertex2().getZ();

            int dx = Math.max(0, Math.min(Math.max(x1, x2), Math.max(x3, x4)) - Math.max(Math.min(x1, x2), Math.min(x3, x4)));
            int dy = Math.max(0, Math.min(Math.max(y1, y2), Math.max(y3, y4)) - Math.max(Math.min(y1, y2), Math.min(y3, y4)));
            int dz = Math.max(0, Math.min(Math.max(z1, z2), Math.max(z3, z4)) - Math.max(Math.min(z1, z2), Math.min(z3, z4)));

            return dx * dy * dz;
        }

}

class testLab6Ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Lab6Ex1 cubid = new Lab6Ex1();
        cubid.readCuboid(sc);
        System.out.println("The volume of common space:"+cubid.commonVolume());
    }
}