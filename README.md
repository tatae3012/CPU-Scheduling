# CPU Scheduling and Page Replacement Algorithms

## 1. CPU Scheduling Algorithms

### Overview 

The following CPU scheduling algorithms are implemented using Java:<br/>

  a. FCFS<br/>
  b. Preemptive SJF<br/>
  c. Non-preemptive SJF<br/>
  d. Preemptive Priority (lower the integer, higher the priority)<br/>
  e. Non-Preemptive Priority (lower the integer, higher the priority)<br/>
  f. Round Robin<br/>
  
The input screen contains no. of processes (<=6), arrival time, burst time, priority, time quantum (for RoundRobin), checkboxes for algorithm selection and button for computation.<br/>
The output screen contains the Gantt chart, waiting time and turnaround time.

### Input Ex

  <table>
    <tr>
     <td><img src="/ScreenShots/1.jpg"></td>
    </tr>
  </table>
  
### Output Ex

  <table>
    <tr>
     <td><img src="/ScreenShots/2.jpg"></td>
    </tr>
  </table>

## 2. Page Replacement Algorithms

### Overview 

The following Page Replacement algorithms are implemented and their performances compared using Java:<br/>

a. First In First Out (FIFO)<br/>
b. Optimal Page Replacement<br/>
c. Least Recently Used (LRU)<br/>

The number of page faults are calculated by taking different number of frames (3,4,5,6 and 7 in the examples below). 

### Examples

  <table>
    <tr>
     <td><img src="/ScreenShots/3.jpg"></td>
    </tr>
  </table>
  
  <table>
    <tr>
     <td><img src="/ScreenShots/4.jpg"></td>
    </tr>
  </table>  
  
  <table>
    <tr>
     <td><img src="/ScreenShots/5.jpg"></td>
    </tr>
  </table>
  
  <table>
    <tr>
     <td><img src="/ScreenShots/6.jpg"></td>
    </tr>
  </table>  
  
  <table>
    <tr>
     <td><img src="/ScreenShots/7.jpg"></td>
    </tr>
  </table>  
  
  ## TO DOs
  
  * Improve the user interface.
  * You can contribute by adding more system algorithms.
