package Session_4;

public class Test {
	
	public static void main(String[] args) {
        try {
            badMethod();
            System.out.print("E");
            return;
        } catch (RuntimeException ex) {
            System.out.print("B");
        } catch (Exception ex1) {
            System.out.print("C");
        } finally {
            System.out.print("D");
        }
    }
    public static void badMethod() {
        System.out.print("A");
    }
}
