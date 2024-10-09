package student;

public class GraduateStudent extends Student{

    String graduateDate;

    GraduateStudent(int id, String name, String email, long phoneNumber, String graduateDate) {
        super(id, name, email, phoneNumber);
        this.graduateDate = graduateDate;

    }

    @Override
    public String toString() {
        return super.toString() +
                ", Graduation Date : " + graduateDate ;

    }
}
