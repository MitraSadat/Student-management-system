package student;

public class GraduateStudent extends Student{

    String graduateDate;

    GraduateStudent(int id, String name, String email, long phoneNumber, boolean isGraduate, String graduateDate) {
        super(id, name, email, phoneNumber, isGraduate );
        this.graduateDate = graduateDate;

    }

    @Override
    public String toString() {
        return super.toString() +
                ", Graduation Date : " + graduateDate ;

    }
}
