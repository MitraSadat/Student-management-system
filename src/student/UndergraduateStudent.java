package student;

public class UndergraduateStudent extends Student{

    String major;

    UndergraduateStudent(int id, String name, String email, long phoneNumber, boolean isGraduate, String major) {
        super(id, name, email, phoneNumber, isGraduate);
        this.major = major;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Major : " + major ;
    }
}

