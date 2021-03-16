import java.util.Scanner;

public class Lab1 {
    public static void main(String[] args) {
        Point3d p1 = createPoint();
        Point3d p2 = createPoint();
        Point3d p3 = createPoint();
        if (p1.equals(p2) || p1.equals(p3) || p2.equals(p3))
            System.out.println("Некоторые точки совпадают, невозможно вычислить площадь треугольника");
        else
            System.out.println(computeArea(p1, p2, p3));
    }
    public static double computeArea(Point3d a, Point3d b, Point3d c) {
        //Возвращает площадь треугольника созданного по трём точкам
        double p = (a.distanceTo(b) + b.distanceTo(c) + c.distanceTo(a)) / 2;
        double s = Math.sqrt(p * (p - a.distanceTo(b)) * (p - b.distanceTo(c)) * (p - c.distanceTo(a)));
        return s;
    }
    public static Point3d createPoint(){
        //Создаёт экземпляр класс Point3d
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите координаты точки: ");
        String input = scanner.nextLine();
        String[] xyz = input.split("\\s");
        double x = Double.parseDouble(xyz[0]);
        double y = Double.parseDouble(xyz[1]);
        double z = Double.parseDouble(xyz[2]);
        return new Point3d(x, y, z);
    }

}
