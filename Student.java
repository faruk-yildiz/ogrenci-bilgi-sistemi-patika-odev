public class Student {
    String name,stuNo;
    int classes;
    Course mat;
    Course fizik;
    Course kimya;
    double avarage;
    boolean isPass;


    Student(String name, int classes, String stuNo, Course mat,Course fizik,Course kimya) {
        this.name = name;
        this.classes = classes;
        this.stuNo = stuNo;
        this.mat = mat;
        this.fizik = fizik;
        this.kimya = kimya;
        calcAvarage();
        this.isPass = false;
    }


    public void addBulkNote(int mat,int matSozlu, int fizik,int fizikSozlu, int kimya,int kimyaSozlu) {

        if ((mat >= 0 && mat <= 100)&&(matSozlu >= 0 && matSozlu <= 100)) {
            this.mat.note = mat;
            this.mat.otherNote=matSozlu;
        }

        if ((fizik >= 0 && fizik <= 100)&&(fizikSozlu >= 0 && fizikSozlu <= 100)){
            this.fizik.note = fizik;
            this.fizik.otherNote=fizikSozlu;
        }

        if ((kimya >= 0 && kimya <= 100)&&(kimyaSozlu >= 0 && kimyaSozlu <= 100)){
            this.kimya.note = kimya;
            this.kimya.otherNote=kimyaSozlu;
        }

    }

    public void isPass() {
        if (this.mat.note == 0 || this.fizik.note == 0 || this.kimya.note == 0) {
            System.out.println("Notlar tam olarak girilmemiş");
        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Ortalama : " + this.avarage);
            if (this.isPass) {
                System.out.println("Sınıfı Geçti. ");
            } else {
                System.out.println("Sınıfta Kaldı.");
            }
        }
    }

    public void calcAvarage() {
        double avgFizik=(this.fizik.otherNote*(this.fizik.percentage/100.0))+((this.fizik.note)*((100-this.fizik.percentage)/100.0));
        double avgMat=(this.mat.otherNote*(this.mat.percentage/100.0))+((this.mat.note)*((100-this.mat.percentage)/100.0));
        double avgKimya=(this.kimya.otherNote*(this.kimya.percentage/100.0))+((this.kimya.note)*((100-this.kimya.percentage)/100.0));
        this.avarage = (avgFizik + avgKimya + avgMat) / 3;
    }

    public boolean isCheckPass() {
        calcAvarage();
        return this.avarage > 55;
    }

    public void printNote(){
        System.out.println("=========================");
        System.out.println("Öğrenci : " + this.name);
        System.out.println("Matematik Notu : " + this.mat.note);
        System.out.println("Fizik Notu : " + this.fizik.note);
        System.out.println("Kimya Notu : " + this.kimya.note);
    }

}