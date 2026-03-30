package poop;

public class Person {
    
    private String namn;

    public Person(String namn)
    {
        this.namn = namn;
    }


    public void setNamn(String namn) {
        this.namn = namn;
    }

    public String getNamn() {
        return this.namn;
    }


        public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person other = (Person) o;
        return namn.equals(other.namn);
    }

    @Override
    public int hashCode() {
        return namn.hashCode();
    }
}
