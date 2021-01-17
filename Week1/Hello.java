public class Hello {
    public static void drawTriangle (int n){ 
    int rows=1;
    int stars=1;
    while (rows<=5) {
        while (stars<=rows) {
            System.out.print("*");
            stars = stars + 1;
        }
        stars = 1 ;
        rows = rows + 1 ;
        System.out.println("");
    }
}
    public static void main(String[] args) {
	drawTriangle(5);
    }
}