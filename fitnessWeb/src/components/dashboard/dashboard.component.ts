import {
  Component,
  ElementRef,
  ViewChild,
  Inject,
  PLATFORM_ID,
} from '@angular/core';
import { isPlatformBrowser } from '@angular/common';
import { SharedModule } from '../../app/shared/shared.module';
import { UserService } from '../../app/service/user.service';
import Chart, { CategoryScale } from 'chart.js/auto';

Chart.register(CategoryScale);

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [SharedModule],
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss'], // 修正为 styleUrls
})
export class DashboardComponent {
  statsData: any;
  workouts: any;
  activities: any;

  @ViewChild('workoutLineChart') private workoutLineChartRef: ElementRef;
  @ViewChild('activityLineChart') private activityLineChartRef: ElementRef;

  constructor(
    private userService: UserService,
    @Inject(PLATFORM_ID) private platformId: Object
  ) {}

  ngOnInit() {
    this.getStats();
  }

  ngAfterViewInit() {
    // 确保代码只在浏览器环境中执行
    if (isPlatformBrowser(this.platformId)) {
      this.getGraphStats();
    }
  }

  getGraphStats() {
    this.userService.getGraphStats().subscribe((res) => {
      this.workouts = res.workouts;
      this.activities = res.activities;
      console.log(this.workouts, this.activities);

      // 确保在浏览器中渲染图表
      if (this.workoutLineChartRef && this.activityLineChartRef) {
        this.createWorkoutChart();
        this.createActivityChart();
      }
    });
  }

  createWorkoutChart() {
    const workCtx = this.workoutLineChartRef.nativeElement.getContext('2d');
    new Chart(workCtx, {
      type: 'bar',
      data: {
        labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
        datasets: [
          {
            label: '# of Votes',
            data: [12, 19, 3, 5, 2, 3],
            borderWidth: 1,
          },
        ],
      },
      options: {
        scales: {
          y: {
            beginAtZero: true,
          },
        },
      },
    });
  }

  createActivityChart() {
    const activitiesCtx =
      this.activityLineChartRef.nativeElement.getContext('2d');
    new Chart(activitiesCtx, {
      type: 'line', // Use a line chart for activities
      data: {
        labels: ['January', 'February', 'March', 'April', 'May', 'June'],
        datasets: [
          {
            label: 'Activity data',
            data: [3, 2, 3, 5, 1, 4],
            borderWidth: 1,
          },
        ],
      },
      options: {
        scales: {
          y: {
            beginAtZero: true,
          },
        },
      },
    });
  }

  getStats() {
    this.userService.getStats().subscribe((res) => {
      console.log(res);
      this.statsData = res;
    });
  }
}
