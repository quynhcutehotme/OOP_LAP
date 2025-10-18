package OOP_LAB;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BoxSimulation {
    private static BoxSimulation instance;
    public int height;
    public int width;
    public ArrayList<Particle> particles;
    public int step;
    public int currentStep = 0;

    private BoxSimulation(int height, int width,int step){
        this.height = height;
        this.width = width;
        this.particles = new ArrayList<>();
        this.step = step;

        for (int i = 0; i < 3; i++) {
            Particle p = new Particle(this);
            particles.add(p);
        }
    }
    public static BoxSimulation getInstance(int height, int width, int step) {
        if (instance == null) {
            instance = new BoxSimulation(height, width, step);
        }
        return instance;
    }

    public int getStep(){return step;}

    public void addParticle(Particle particle) {
        particles.add(particle);
    }

    public int getCurrentStep() {
        return currentStep;
    }



    public void simulate() {
        for (int s = 0; s < step; s++) {
            currentStep++;
            for (Particle p : particles) {
                p.moving();}
            ArrayList<Particle> draftSpace = new ArrayList<>();
            for (int i = 0; i < particles.size(); i++) {
                for (int j = i + 1; j < particles.size(); j++) {
                    Particle p1 = particles.get(i);
                    Particle p2 = particles.get(j);

                    if (p1.x == p2.x && p1.y == p2.y) {
                        Particle newP = new Particle(this);
                        draftSpace.add(newP);
                        System.out.println("Collision at point" + newP.getPosition()+ " on step " + getCurrentStep());
                    }
                }
                particles.addAll(draftSpace);
            }
            try {
            Thread.sleep(50);}
            catch (InterruptedException e) {
            e.printStackTrace();}
        }
        visualize();
    }
    public void visualize() {
        char[][] boxMap = new char[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                boxMap[i][j] = ' ';
            }
        }

        for (Particle p : particles) {
            boxMap[p.y][p.x] = '*';
        }

        System.out.println("-".repeat(width + 2));
        for (int i = 0; i < height; i++) {
            System.out.print("|");
            for (int j = 0; j < width; j++) {
                System.out.print(boxMap[i][j]);
            }
            System.out.println("|");
        }
        System.out.println("-".repeat(width + 2));
    }

}


class Particle{

    public int x;
    public int y;
    public Direction dir;
    public enum Direction{South,SouthEast,SouthWest, West, East, North, NorthEast,NorthWest};
    public BoxSimulation box;
    public static int count=0;



    public Particle(BoxSimulation box) {
        this.box = box;
        Random rand = new Random();
        this.x = rand.nextInt(box.width);
        this.y = rand.nextInt(box.height);
        this.dir = getDirection();
        count++;
    }

    public Direction getDirection() {
        Random random = new Random();
        Direction[] dirs = Direction.values();
        return dirs[random.nextInt(dirs.length)];
    }

    public void randomPosition() {
        Random rand = new Random();
        this.x = rand.nextInt(box.width);
        this.y = rand.nextInt(box.height);
    }

    public String getPosition() {
        return "(" + this.x + ", " + this.y + ")";
    }

    public void moving(){
        switch (getDirection()){
            case North : this.y -=1;
            break;
            case South:
                this.y += 1;
                break;

            case East:
                this.x += 1;
                break;

            case West:
                this.x -= 1;
                break;

            case NorthEast:
                this.x += 1;
                this.y -= 1;
                break;

            case NorthWest:
                this.x -= 1;
                this.y -= 1;
                break;

            case SouthEast:
                this.x += 1;
                this.y += 1;
                break;

            case SouthWest:
                this.x -= 1;
                this.y += 1;
                break;
        }

        if (this.x < 0) this.x = 0;
        if (this.y < 0) this.y = 0;
        if (this.x >= box.width) this.x = box.width - 1;
        if (this.y >= box.height) this.y = box.height - 1;

    }

}

class CheckingBox{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input height and width: ");
        int height = sc.nextInt();
        int width = sc.nextInt();

        System.out.print("Input step: ");
        int step = sc.nextInt();

        System.out.println("______There are 3 initial particles._______");
        BoxSimulation box = BoxSimulation.getInstance(height, width, step);
        box.simulate();
        System.out.println("After " + box.getStep()+" steps, there are "+Particle.count+" particles");
    }}
