import java.util.Arrays;

public class Exam {
    private int examNumber;
    private String[] students;
    private double[] grades;

    public Exam(int examNumber, int studentCount) {
        this.examNumber = examNumber;
        this.students = new String[studentCount];
        this.grades=new double[students.length];
    }

    public double meanGrade(){
        return sumOfArray(grades)/nonZeroElementCount(grades);
    }
    public double bestGrade(){
        double bestGrade = 5.0f;
        double[] gradesWithoutNulls=removeZerodoubles(grades);
        for(double grade:gradesWithoutNulls){
            if(Double.compare(grade,bestGrade)==-1){
                bestGrade=grade;
            }
        }
        return bestGrade;
    }

    private double sumOfArray(double[] arr){
        double sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        return sum;
    }

    private int nonNullElementCount(String[] arr){
        int count=0;
        for(String element:arr){
            if(element!=null){
                count++;
            }
        }
        return count;
    }
    private int nonZeroElementCount(double[] arr){
        int count=0;
        for(double element:arr){
            if(element!=0){
                count++;
            }
        }
        return count;
    }
    private double[] removeZerodoubles(double[] doubles){
        double[] nonZerodoubles=new double[nonZeroElementCount(doubles)];
        int elementsAdded=0;
        for(int i=0;i<doubles.length&&nonZerodoubles!=null;i++){
            if(doubles[i]!=0){
                if(elementsAdded<nonZerodoubles.length&&nonZerodoubles!=null) {
                    nonZerodoubles[elementsAdded] = doubles[i];
                    elementsAdded++;
                }else{
                    nonZerodoubles=null;
                }

            }
        }
        return nonZerodoubles;
    }
    private String[] removeNullStrings(String[] strings){
        String[] nonNullStrings=new String[nonNullElementCount(strings)];
        int elementsAdded=0;
        int i=0;
        while(i<strings.length&&nonNullStrings!=null){
            if(strings[i]!=null){
                if(elementsAdded<nonNullStrings.length&&nonNullStrings!=null) {
                    nonNullStrings[elementsAdded] = strings[i];
                    elementsAdded++;
                }else{
                    nonNullStrings=null;
                }

            }
            i++;
        }
        return nonNullStrings;
    }
    public void bestStudents(){
        double bestgrade=bestGrade();
        for(int i=0;i<grades.length;i++){
            if(grades[i]==bestgrade){
                System.out.print(students[i] +" ");
            }
        }
        System.out.println();
    }
    public void printStudentsWithGrades(){
        for(int i=0;i<students.length;i++){
            if(students[i]!=null){
                System.out.println(students[i] + "    " + convertToGradeLevelString(grades[i]));
            }
        }
    }
    private String convertToGradeLevelString(double grade){
        String gradeLevel=null;
        if(Double.compare(grade,0)==0.0f) {
            gradeLevel="keine Note";
        }else if(Double.compare(grade,1.7)==-1){
            gradeLevel="sehr gut";
        }else if(Double.compare(grade,2.7)==-1){
            gradeLevel="gut";
        }else if(Double.compare(grade,3.7)==-1){
            gradeLevel="befriedigend";
        }else if(Double.compare(grade,4.0)==-1||Double.compare(grade,4.0)==0){
            gradeLevel="ausreichend";
        }else{
            gradeLevel="mangelhaft";
        }

        return gradeLevel;
    }
    public String[] studentsWithGrade(double grade){
        boolean comparedToAllGrades=false;
        String[] studentsWithGrade=new String[students.length];
        int i=0;
        while(i<students.length){
            if(grades[i]==grade){
                studentsWithGrade[i]=students[i];
            }
            i++;
        }
        studentsWithGrade=removeNullStrings(studentsWithGrade);
        return studentsWithGrade;
    }
    public void addStudent(String name) {
        boolean full = true;
        for (int i = 0; i < students.length && full; i++) {
            if (students[i] == null) {
                full = false;
                students[i] = name;
            }
        }
        if (full) {
            System.out.println("Keine weiteren Prüfungsplätze vorhanden");
        }
    }

    public void setStudentGrade(String name, double grade){
        boolean set = false;
        for(int i=0;i<students.length&&!set;i++){
                if (students[i]!=null&&students[i].equals(name)) {
                    grades[i] = grade;
                    set = true;
                }
        }
        if(!set){
            System.out.println("Kein Student mit diesem Namen gefunden");
        }
    }



    public int getExamNumber() {
        return examNumber;
    }

    public void setExamNumber(int examNumber) {
        this.examNumber = examNumber;
    }

    public void printStudents(){
        for(String student:students){
            if(student!=null){
                System.out.println(student);
            }
        }
    }
}
