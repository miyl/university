package dk.kea.university.models;

/**
 * Class that holds Course attributes.
 * @Author Tariq & Marcus
 */

public class Course {


    private String name_da;
    private String name_en;
    private int semester;
    private String class_code;
    private String study_programme;
    private String mandatory_or_elective;
    private int ects;
    private String course_language;
    private int min_students;
    private int max_students;
    private int expected_students;
    private String prerequisities;
    private String learning_outcome;
    private String content;
    private String exam_form;

    public Course(String name_da, String name_en, int semester, String class_code, String study_programme, String mandatory_or_elective, int ects, String course_language, int min_students, int max_students, int expected_students, String prerequisities, String learning_outcome, String content, String exam_form) {
        this.name_da = name_da;
        this.name_en = name_en;
        this.semester = semester;
        this.class_code = class_code;
        this.study_programme = study_programme;
        this.mandatory_or_elective = mandatory_or_elective;
        this.ects = ects;
        this.course_language = course_language;
        this.min_students = min_students;
        this.max_students = max_students;
        this.expected_students = expected_students;
        this.prerequisities = prerequisities;
        this.learning_outcome = learning_outcome;
        this.content = content;
        this.exam_form = exam_form;
    }

    public String getName_da() {
        return name_da;
    }

    public void setName_da(String name_da) {
        this.name_da = name_da;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getClass_code() {
        return class_code;
    }

    public void setClass_code(String class_code) {
        this.class_code = class_code;
    }

    public String getStudy_programme() {
        return study_programme;
    }

    public void setStudy_programme(String study_programme) {
        this.study_programme = study_programme;
    }

    public String getMandatory_or_elective() {
        return mandatory_or_elective;
    }

    public void setMandatory_or_elective(String mandatory_or_elective) {
        this.mandatory_or_elective = mandatory_or_elective;
    }

    public int getEcts() {
        return ects;
    }

    public void setEcts(int ects) {
        this.ects = ects;
    }

    public String getCourse_language() {
        return course_language;
    }

    public void setCourse_language(String course_language) {
        this.course_language = course_language;
    }

    public int getMin_students() {
        return min_students;
    }

    public void setMin_students(int min_students) {
        this.min_students = min_students;
    }

    public int getMax_students() {
        return max_students;
    }

    public void setMax_students(int max_students) {
        this.max_students = max_students;
    }

    public int getExpected_students() {
        return expected_students;
    }

    public void setExpected_students(int expected_students) {
        this.expected_students = expected_students;
    }

    public String getPrerequisities() {
        return prerequisities;
    }

    public void setPrerequisities(String prerequisities) {
        this.prerequisities = prerequisities;
    }

    public String getLearning_outcome() {
        return learning_outcome;
    }

    public void setLearning_outcome(String learning_outcome) {
        this.learning_outcome = learning_outcome;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExam_form() {
        return exam_form;
    }

    public void setExam_form(String exam_form) {
        this.exam_form = exam_form;
    }
}
