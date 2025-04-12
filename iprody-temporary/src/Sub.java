public class Sub extends Super {
    @Override
    public int getValue() {
        return super.getValue();
    }

    public void demoAccess() {
        System.out.println(getValue()); // Получаем значение
        setValue(2);                     // Изменяем значение
    }

    @Override
    protected void setValue(int value) {
        super.setValue(value);
    }
}