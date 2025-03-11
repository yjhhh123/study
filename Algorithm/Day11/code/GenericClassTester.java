package Day11;

public class GenericClassTester {
    static class GenericClass<T>{
        private T xyz;

        public GenericClass(T xyz) {
            this.xyz = xyz;
        }

        public T getXyz() {
            return xyz;
        }
    }

    public static void main(String[] args) {
        GenericClass<String> stringGenericClass = new GenericClass<String>("xyz");
        GenericClass<Integer> integerGenericClass = new GenericClass<Integer>(15);

        System.out.println(stringGenericClass.getXyz());
        System.out.println(integerGenericClass.getXyz());
    }
}
