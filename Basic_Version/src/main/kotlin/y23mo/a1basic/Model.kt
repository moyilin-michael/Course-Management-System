package y23mo.a1basic

import javafx.geometry.Insets
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority
import javafx.scene.layout.VBox
import kotlin.math.roundToInt

class Model {
    // Status of the status bar
    private var average = 0.0;
    private var courses = 0;
    private var failed = 0;

    // Status of first row of the toolbar
    private var sort = "";
    private var filter = "All courses";
    private var wd = true;

    private var courseList = mutableListOf<CourseEntry>(); // All the courses recorded
    private var displayEntry = mutableListOf<CourseEntry>(); // All the courses displayed

    // All the views
    var averageView:Average? = null;
    var coursesView:CourseTaken? = null;
    var failedView:CourseFailed? = null;
    var scrollView:ScrollView? = null;

    fun getAverage():Double {
        return average;
    }

    fun getTaken():Int {
        return courses;
    }

    fun getFailed():Int {
        return failed;
    }

    // sort displayEntry based on current sorting method
    private fun sort() {
        if (displayEntry.isEmpty() || sort == "") {
            return;
        }
        else if (sort == "Course code(alphabetically)") {
            displayEntry = displayEntry.sortedBy { it.getIndex() }.toMutableList();
        }
        else if (sort == "Term(earlier to recent)") {
            displayEntry = displayEntry.sortedBy {
                if (it.getTerm() == "F20") "a" + it.getTerm()
                else if (it.getTerm() == "W21") "b" + it.getTerm()
                else if (it.getTerm() == "S21") "c" + it.getTerm()
                else if (it.getTerm() == "F21") "d" + it.getTerm()
                else if (it.getTerm() == "W22") "e" + it.getTerm()
                else if (it.getTerm() == "S22") "f" + it.getTerm()
                else if (it.getTerm() == "F22") "g" + it.getTerm()
                else if (it.getTerm() == "W23") "h" + it.getTerm()
                else "i" + it.getTerm()
            }.toMutableList();
        }
        else if (sort == "Grade(in ascending order)") {
            displayEntry = displayEntry.sortedBy {
                if (it.getGrade() == "WD")  it.getNeg1()
                else it.getGrade().toInt()
            }.toMutableList();
        }
        else if (sort == "Grade(in descending order)") {
            displayEntry = displayEntry.sortedByDescending {
                if (it.getGrade() == "WD")  it.getNeg1()
                else it.getGrade().toInt()
            }.toMutableList();
        }
    }

    // Piazza Question @90
    // filter displayEntry based on current filtering method
    private fun filter() {
        if (displayEntry.isEmpty() || filter == "All courses") {
            return;
        }
        else if (filter == "CS courses only") {
            displayEntry.retainAll { it.getIndex().substring(0, 2.coerceAtMost(it.getIndex().length)) == "CS" };
        }
        else if (filter == "MATH courses only") {
            displayEntry.retainAll { it.getIndex().substring(0, 4.coerceAtMost(it.getIndex().length)) == "MATH" ||
                    it.getIndex().substring(0, 4.coerceAtMost(it.getIndex().length)) == "STAT" ||
                    it.getIndex().substring(0, 2.coerceAtMost(it.getIndex().length)) == "CO"};
        }
        else if (filter == "Other courses") {
            displayEntry.removeAll { it.getIndex().substring(0, 2.coerceAtMost(it.getIndex().length)) == "CS" };
            displayEntry.removeAll { it.getIndex().substring(0, 4.coerceAtMost(it.getIndex().length)) == "MATH" };
            displayEntry.removeAll { it.getIndex().substring(0, 4.coerceAtMost(it.getIndex().length)) == "STAT" };
            displayEntry.removeAll { it.getIndex().substring(0, 2.coerceAtMost(it.getIndex().length)) == "CO" };
        }
    }

    // Remove all WD'ed courses in displayEntry
    private fun removeWD() {
        displayEntry.removeAll { it.getGrade() == "WD" };
    }

    // Regenerate displayEntry based on current sorting, filtering, and WD option
    private fun displayGen() {
        displayEntry.clear();
        displayEntry.addAll(courseList);
        sort();
        filter();
        if (!wd) {
            removeWD();
        }
    }

    // Re-calculate the status bar data based on displayEntry
    private fun calcStatus() {
        average = 0.0;
        courses = 0;
        failed = 0;
        displayEntry.forEach {
            if (it.getGrade() != "WD") {
                average += it.getGrade().toInt();
                courses++;
                if (it.getGrade().toInt() in 0..49) {
                    failed++;
                }
            }
        };
        if (courses == 0) {
            average = 0.0;
            return;
        }
        else {
            average /= courses;
            average = (average * 100.0).roundToInt() / 100.0;
        }
    }

    // Update views to new data and new displayEntry
    private fun viewsDeploy() {
        val content = VBox().apply {
            displayEntry.forEach() {
                children.add(it);
                VBox.setMargin(it, Insets(3.0));
            }
            spacing = 10.0;
        }
        scrollView?.content = content;
        averageView?.update();
        coursesView?.update();
        failedView?.update();
    }

    // Change sorting method, re-sort, and update views
    fun sortBy(s:String) {
        sort = s;
        sort();
        viewsDeploy();
    }

    // Change filtering method, re-generate displayGen and status bar data, and update views
    fun filterBy(s:String) {
        filter = s;
        displayGen();
        calcStatus();
        viewsDeploy();
    }

    // Change WD option, re-generate displayGen, and update views
    fun check() {
        wd = true;
        displayGen();
        viewsDeploy();
    }

    // Change WD option, remove WD'ed courses, and update views
    fun uncheck() {
        wd = false;
        removeWD();
        viewsDeploy();
    }

    // Add a new class to record if the new class has a unique course code
    fun addClass(ls: MutableList<String>) {
        if (courseList.find {it.getIndex() == ls[0]} != null) {
            return;
        }
        courseList.add(CourseEntry(this, ls[0], ls[1], ls[2], ls[3]));
        displayGen();
        calcStatus();
        viewsDeploy();
    }

    // Delete a class from record if exists
    fun deleteClass(index: String) {
        val entry = courseList.find {it.getIndex() == index};
        if (entry != null) {
            courseList.remove(entry);
            displayGen();
            calcStatus();
            viewsDeploy();
        }
    }

    // Update a class's information from record if exists
    fun updateClass(index: String, title: String, term: String, grade: String) {
        val entry = courseList.find {it.getIndex() == index};
        if (entry != null) {
            val id = courseList.indexOf(entry);
            courseList[id].setTitle(title);
            courseList[id].setTerm(term);
            courseList[id].setGrade(grade);
            courseList[id].changeColor();
            displayGen();
            calcStatus();
            viewsDeploy();
        }
    }
}