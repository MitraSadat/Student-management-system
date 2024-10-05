package student;

public class GraduateStudent extends Student{

    String graduateDate;

    GraduateStudent(int id, String name, String email, int phoneNumber, String graduateDate) {
        super(id, name, email, phoneNumber);
        this.graduateDate = graduateDate;

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
