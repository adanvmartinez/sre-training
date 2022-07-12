package springrest

class Student {
    int id;
    String fname;
    String lname;
    int age;
    String major;

    public Student(int id, String fname, String lname, int age, String major){
        this.id = id;
        this.fname=fname;
        this.lname=lname;
        this.age=age;
        this.major=major;
    }

    public Student(){

    }

    int getId() {
        return this.id
    }

    String getFname() {
        return this.fname
    }

    String getLname() {
        return this.lname
    }

    int getAge() {
        return age
    }

    String getMajor() {
        return major
    }

    void setId(int id) {
        this.id = id
    }

    void setFname(String fname) {
        this.fname = fname
    }

    void setLname(String lname) {
        this.lname = lname
    }

    void setAge(int age) {
        this.age = age
    }

    void setMajor(String major) {
        this.major = major
    }
}
