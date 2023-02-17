# App Description
    Author: Yilin Mo
 
    ## Setup
    * Windows 10
    * IntelliJ IDEA 2022.3.2 (Community Edition)
    * kotlin.jvm 1.7.20
    * Java SDK 17.0.6 (temurin)

## Basic Portion
*The application opens as a window with initial size 800 by 600 units. The layout is “responsive” between the initial size and full screen.

*There is a toolbar at the top of the window, a status bar at the bottom, and the main content in between (we will call this the course list from now on).

*The toolbar consists of two rows: the top one for controlling the content of the course list and the bottom one for adding a new course to the course list.

*The top row of the toolbar consists of three horizontally laid out sections: one for sorting, one for filtering, and one for including withdrawn (WD’ed) courses.

*In the Sort by-section, the user can select between one of four sorting options:

    *by course code (alphabetically)
    *by term (earlier to recent)
    *by grade (in ascending order)
    *grade (in descending order).
*In the Filter by-section, the user can select between one of four filter options:

    *all courses, i.e., no filters
    *CS courses only
    *MATH courses only (which includes MATH, STAT, and CO courses)
    *other courses, which includes all other courses.
*Last, user can select to in- or exclude WD’ed courses.

*The bottom row of the toolbar consists of the following horizontally laid out UI elements:

    *one text field that holds the course code (filling out is mandatory)
    *one text field holds the course name (filling out is optional)
    *one choice box that holds the term in which the course was taken (filling out is mandatory)
    *one text field that holds the received grade, which must either be within the range [0, ..., 100] or WD (filling out is mandatory)
    *one button that creates the new course if all mandatory information is given. The new course then appears on the course list.
*The course list contains a scrollable list of courses.

*Each course entry consists of a single row and displays (in order) the course code (read-only), the course name (editable), the term the course was taken (editable), the received course grade (editable), and an update and a delete button. By default, the update button is disabled.

*The background color for each course entry depends on the grade:

    *for WD’ed courses: DARKSLATEGRAY
    *for failed courses, i.e., grades between [0, ..., 50): LIGHTCORAL
    *for courses with grades between [50, ..., 60): LIGHTBLUE
    *for courses with grades between [60, ..., 91): LIGHTGREEN
    *for courses with grades between [91, ..., 96): SILVER
    *for courses with grades between [96, ..., 100]: GOLD
*Changing any of the editable values enables the update button. Clicking on the update button makes the edits permanent and disables the update button.

*Clicking on the delete button permanently deletes the course and removes it from the course list.

*Any change to the sorting order affects the course list in that the course list will be (re-) sorted by the criterion selected in the sorting option.

*Any change to the filter affects the course list in that only courses that pass the filter are displayed, sorted according to the selected sorted option.

*Any change to the filter also affects the status bar since the displayed information only considers the currently displayed courses.

*In- or excluding WD’ed courses affects the course list in that WD’ed courses are in- or excluded and sorted by the criterion selected in the sorting option (see above).

*In- or excluding WD’ed courses affects the status bar in that it considers or disregards them in the displayed information.

*The status bar contains 3 pieces of information:

    *the course average of the currently displayed courses
    *the count of the currently displayed (added Jan 29:) “taken” courses
    *the count of the currently displayed failed courses
 
## Enhancement 
I added a new sorting method: 
* Users can choose to sort displayed courses by course name alphabetically.
I added a data field in the status bar: 
* Users can see the highest score obtained in displayed courses.
* WD'ed courses do not count, so if all displayed courses have grade WD, this field will display 0.
