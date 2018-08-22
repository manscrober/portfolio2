import java.util.Arrays;

public class Exam {
    private int examNumber;
    private String[] students;
    private float[] grades;

    public Exam(int examNumber, int studentCount) {
        this.examNumber = examNumber;
        this.students = new String[studentCount];
        this.grades=new float[students.length];
    }

    public float meanGrade(){

        return sumOfArray(grades)/nonNullElementCount(grades);
    }
    public float bestGrade(){
        float bestGrade = 5.0f;
        float[] gradesWithoutNulls=removeNullFloats(grades);
        for(float grade:gradesWithoutNulls){
            if(Double.compare(grade,bestGrade)==-1){
                bestGrade=grade;
            }
        }
        return bestGrade;
    }

    private float sumOfArray(float[] arr){
        float sum=0;
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
    private int nonNullElementCount(float[] arr){
        int count=0;
        for(float element:arr){
            if(element!=0){
                count++;
            }
        }
        return count;
    }
    private float[] removeNullFloats(float[] floats){
        float[] nonNullFloats=new float[nonNullElementCount(floats)];
        int elementsAdded=0;
        for(int i=0;i<floats.length&&nonNullFloats!=null;i++){
            if(floats[i]!=0){
                if(elementsAdded<nonNullFloats.length&&nonNullFloats!=null) {
                    nonNullFloats[elementsAdded] = floats[i];
                    elementsAdded++;
                }else{
                    nonNullFloats=null;
                }

            }
        }
        return nonNullFloats;
    }
    private String[] removeNullStrings(String[] strings){
        String[] nonNullStrings=new String[nonNullElementCount(strings)];
        int elementsAdded=0;
        for(int i=0;i<strings.length&&nonNullStrings!=null;i++){
            if(strings[i]!=null){
                if(elementsAdded<nonNullStrings.length&&nonNullStrings!=null) {
                    nonNullStrings[elementsAdded] = strings[i];
                    elementsAdded++;
                }else{
                    nonNullStrings=null;
                }

            }
        }
        return nonNullStrings;
    }
    public void bestStudents(){
        float bestgrade=bestGrade();
        String[] bestStudents=new String[students.length];
        for(int i=0;i<grades.length;i++){
            if(grades[i]==bestgrade){
                bestStudents[i]=students[i];
            }
        }
        bestStudents=removeNullStrings(bestStudents);
        for(String student:bestStudents){
            System.out.print(student +" ");
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
    private String convertToGradeLevelString(float grade){
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
    public String[] studentsWithGrade(float grade){
        boolean comparedToAllGrades=false;
        String[] studentsWithGrade=new String[students.length];
        int i=0;
        while(i<students.length){
            if(grades[i]==grade){
                studentsWithGrade[i]=students[i];
            }
        }
        studentsWithGrade=removeNullStrings(studentsWithGrade);
        return studentsWithGrade;
    }
    public void addStudent(String name) {
        boolean full = true;
        for (int i = 0; i < students.length && full == true; i++) {
            if (students[i] == null) {
                full = false;
                students[i] = name;
            }
        }
        if (full == true) {
            System.out.println("Keine weiteren Prüfungsplätze vorhanden");
        }
    }

    public void setStudentGrade(String name, float grade){
        boolean set = false;
        for(int i=0;i<students.length&&set==false;i++){
                if (students[i]!=null&&students[i].equals(name)) {
                    grades[i] = grade;
                    set = true;
                }

        }
        if(set==false){
            System.out.println("Kein Student mit diesem Namen gefunden");
        }
    }



    public int getExamNumber() {
        return examNumber;
    }



    public void printStudents(){
        for(String i:students){
            System.out.println(i);
        }
    }
    public void setExamNumber(int examNumber) {
        this.examNumber = examNumber;
    }
}
