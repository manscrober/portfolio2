public class Exams {
    Exam[] exams=new Exam[10];

    public static void main(String[] args) {
        Exams exams = new Exams();
    }
    public Exams() {
        for(int i = 0; i<5;i++){
            exams[i]=new Exam(i,i+1);
        }
    }

    private Exam getExam(int index){
        Exam exam;
        if(exams[index]!=null) {
            exam= exams[index];
        }else{
            exam=null;
        }
        return exam;
    }

    public void printExams(){
        for(Exam exam:exams){
            if(exam!=null) {
                System.out.println(exam.getExamNumber() + " " + exam.meanGrade());
            }
        }
    }
    public void addExam(Exam exam){
        boolean added=false;
        boolean full=true;
        for(int i=0;i<exams.length&&!added;i++){
            if(exams[i]==null){
                exams[i]=exam;
                added=true;
                full=false;
            }
        }
        if(full){
            System.out.println("Es können keine weiteren Prüfungsergebnisse erfasst werden!");
        }
    }
    public void removeExam(int examNumber){
        boolean removed=false;
        for(int i=0;i<exams.length;i++){
            if(exams[i].getExamNumber()==examNumber){
                exams[i]=null;
                removed=true;
            }
        }
        if(!removed){
            System.out.println("Das angegebenen Examen existiert nicht und kann somit nicht gelöscht werden");
            //additional n according to specification
        }

    }

}
