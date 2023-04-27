Requirements: Build a Task Management System that was defined by the following business needs:
* A supervisor can define/schedule tasks for certain members of her team
* Tasks have a name, due date, instructions, a list of assigned personnel, etc.
* Once the supervisor publishes a task all assigned personnel can see it on their dashboard
* Any assigned personnel can complete a task by entering a completion date/time and a completion comment
* On my personnel tasks dashboard I see tasks sorted by due date. Overdue tasks are specially marked
* The supervisor can see the list of all her team members. She can also see filtered lists of tasks (by team member or task status, etc.)
* The supervisor can cancel or table published tasks.

Models:
 * user
   * supervisor
     * has assigned team members
   * team member
     * has assigned tasks
 * task
   * status
   * due date
   * name
   * instructions
   * assigned team members
 * team
   * has single supervisor and list of team members
 * comment
   * written by one team member
   * has some value
   * date created
 * supervisor dashboard (might be a view)
   * see list of her team members
   * see all tasks and can filter them
 * teamMember dashboard (might be a view)
   * teamMember sees all tasks assigned to him
   * sorted by due date
   * overdue tasks are specially marked

Actions:
  * create task, complete task, assign task, cancel task, table task
  * list my tasks
  * filter tasks
  * sort tasks

What to do:
 * separate commands from queries
   * commands
     * create task
     * assign task
     * publish task ???
     * complete task
     * cancel task
     * table task
   * queries
     * get all tasks assigned to team member
     * get supervisor's team members
     * filter and sort tasks
