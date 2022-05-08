public class Student implements Comparable<Student> {
    String name;
    int age;
    String group;
    Subject subject;

    public Student(String name, int age, String group, Subject subject) {
        this.name = name;
        this.age = age;
        this.group = group;
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGroup() {
        return group;
    }

    public Subject getSubject() {
        return subject;
    }

    @Override
    public int compareTo(Student o) {
        return name.compareTo(o.name) + (age - o.age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", group='" + group + '\'' +
                ", subject=" + subject +
                '}';
    }
//set.headSet(element).size()
}
