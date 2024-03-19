public class OverloadingExample {

    // 첫 번째 add 메소드
    public int add(int a, int b) {
        return a + b;
    }

    // 두 번째 add 메소드 (오버로딩)
    public double add(double a, double b) {
        return a + b;
    }

    // 세 번째 add 메소드 (오버로딩)
    public int add(int a, int b, int c) {
        return a + b + c;
    }

}