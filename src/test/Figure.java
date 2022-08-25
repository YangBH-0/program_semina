package test;

public class Figure {
    enum Shape {RECTANGLE,CIRCLE};
    final Shape shape; // 태그 필드 - 현재 모양

    //모양이 사각형일 때만 쓰이는 필드
    double length;
    double width;
    // 모양이 원일 때만 쓰이는 필드
    double radius;
    // 원용 생성자
    public Figure(double radius) {
        shape=Shape.CIRCLE;
        this.radius = radius;
    }
    //사각형용 생성자
    public Figure(double length, double width) {
        shape=Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }
}
