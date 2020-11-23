package t1123;

/**
 * @Author: zlatanlong
 * @Date: 2020/11/23 8:08
 */
public class Student {

    private Integer score;

    public Student(Integer score) {
        this.score = score;
    }

    public static void isScoreValid(Student student) {
        if (student.score > 100) {
            throw new ScoreExceedsMaxValue();
        }
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public static void main(String[] args) {
        int count = 15000;
        int max = 150, min = 1;
        Student[] students = new Student[count];

        for (int i = 0; i < count; i++) {
            students[i] = new Student((int) (Math.random() * (max - min) + min));
        }

        int sum = 0, errSum = 0, noErrCount = 0;

        for (int i = 0; i < count; i++) {
            try {
                Student.isScoreValid(students[i]);
                noErrCount++;
                sum += students[i].getScore();
                System.out.println("学生分数正常 - " + students[i].getScore());
            } catch (Exception e) {
                errSum += students[i].getScore();
                if (e instanceof ScoreExceedsMaxValue) {
                    System.out.println(e.getMessage() + " - " + students[i].getScore());
                }
            }
        }

        System.out.println("---------统计完毕----------");
        System.out.println("正常人数: " + noErrCount + "; 平均分: " + sum / noErrCount);
        System.out.println("异常人数: " + (count - noErrCount) + "; 平均分: " + errSum / noErrCount);

    }
}


class ScoreExceedsMaxValue extends RuntimeException {

    private final static String ERR_INFO = "超过100分";

    public ScoreExceedsMaxValue() {
        this(ERR_INFO);
    }

    public ScoreExceedsMaxValue(String message) {
        super(message);
    }
}