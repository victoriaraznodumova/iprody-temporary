package generics;

public class Person <T, K, O>{
    private int id;
    private T data;
    private K next;


    public Person(int id, T data) {
        this.id = id;
        this.data = data;
    }

    public void setId(int id) {
        this.id = id;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void doSomething(T someDate){
        System.out.println(someDate);
    }
    public O getO(){
        return (O) data;
    }
//    public O getO(O some){
//        return data;
//    }
//    //в таком случае не надо делать приведение данных
}