package Task5;

public class ReflectionChecker {
    private String name;
    private int secter;

    private void privateMethod1(){
    }

    private void privateMethod2(){
    }

    public void publicmethod1(){

    }

    public ReflectionChecker(String name) {
        this.name = name;
    }

    public ReflectionChecker() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSecter() {
        return secter;
    }

    public void setSecter(int secter) {
        this.secter = secter;
    }
}
